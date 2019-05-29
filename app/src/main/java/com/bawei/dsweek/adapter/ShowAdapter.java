package com.bawei.dsweek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bawei.dsweek.R;
import com.bawei.dsweek.bean.BeanS;
import com.bawei.dsweek.holder.HolderM;
import com.bawei.dsweek.holder.HolderP;
import com.bawei.dsweek.holder.HolderR;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class ShowAdapter extends RecyclerView.Adapter {
     private BeanS.ResultBean list;
     private Context context;
     private int MISS=0;
     private int PZSH=1;
     private int RXXP=2;

    public ShowAdapter(BeanS.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater linear= LayoutInflater.from(context);
        switch (i){
            case 0:
                return new HolderM(linear.inflate(R.layout.item_mlss_layout,viewGroup,false));
            case 1:
                return new HolderP(linear.inflate(R.layout.item_pzsh_layout,viewGroup,false));
            case 2:
                return new HolderR(linear.inflate(R.layout.item_rxxp_layout,viewGroup,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)){
            case 0:
                ((HolderM)viewHolder).rvm.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
                MissAdapter adapter=new MissAdapter(list,context);
                ((HolderM)viewHolder).rvm.setAdapter(adapter);
                break;
            case 1:
                RecyclerView rvp=viewHolder.itemView.findViewById(R.id.rvp);
                rvp.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

                break;
            case 2:
                RecyclerView rvr=viewHolder.itemView.findViewById(R.id.rvr);
                rvr.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return MISS;
            case 1:
                return PZSH;
            case 2:
                return RXXP;
        }
        return super.getItemViewType(position);
    }
}
