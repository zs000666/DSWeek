package com.bawei.dsweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bawei.dsweek.adapter.ShowAdapter;
import com.bawei.dsweek.api.Api;
import com.bawei.dsweek.bean.BeanS;
import com.bawei.dsweek.bean.BeanX;
import com.bawei.dsweek.show.ShowController;
import com.bawei.dsweek.show.ShowPresenterImpl;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ShowController.ShowView {

    private RecyclerView relv;
    private ShowController.ShowPresenter presenter;
    private XBanner xBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        relv = findViewById(R.id.relv);
        xBanner = findViewById(R.id.xbanner);
        relv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        presenter=new ShowPresenterImpl();
        presenter.attch(this);
        presenter.showM(Api.banner_url);
        presenter.showB(Api.data_url);

    }

    @Override
    public void showL(String url) {
        try {
            JSONObject object=new JSONObject(url);
            JSONArray results = object.getJSONArray("results");
            final ArrayList<BeanX>listX=new ArrayList<>();
            for (int i = 0; i <results.length() ; i++) {
                JSONObject obj= (JSONObject) results.get(i);
                String url1 = obj.getString("url");
                listX.add(new BeanX(url1));
            }
            xBanner.setAutoPalyTime(2000);
            xBanner.setBannerData(listX);
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(MainActivity.this).load(listX.get(position).getUrl()).into((ImageView) view);
                }
            });
        } catch (JSONException e) {

        }
    }

    @Override
    public void showD(String data) {
        Gson gson=new Gson();
        BeanS beanS = gson.fromJson(data, BeanS.class);
        BeanS.ResultBean list = beanS.getResult();
        ShowAdapter adapter=new ShowAdapter(list,MainActivity.this);
        relv.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.pttch();
    }
}
