package com.bawei.dsweek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.dsweek.R;
import com.bawei.dsweek.bean.BeanS;
import com.bawei.dsweek.holder.HolderS;
import com.bumptech.glide.Glide;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class MissAdapter extends RecyclerView.Adapter<HolderS> {
    private BeanS.ResultBean list;
    private Context context;

    public MissAdapter(BeanS.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderS onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        return new HolderS(inflater.inflate(R.layout.item_mesult_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderS holderS, int i) {
        holderS.name.setText(list.getMlss().getCommodityList().get(i).getCommodityName());
        holderS.price.setText(list.getMlss().getCommodityList().get(i).getPrice());
        Glide.with(context).load(list.getMlss().getCommodityList().get(i).getMasterPic()).into(holderS.img);
    }

    @Override
    public int getItemCount() {
        return list.getMlss().getCommodityList().size();
    }
}
