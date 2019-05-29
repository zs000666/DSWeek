package com.bawei.dsweek.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.dsweek.R;


/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class HolderM extends RecyclerView.ViewHolder{

    public final RecyclerView rvm;

    public HolderM(@NonNull View itemView) {
        super(itemView);
        rvm = itemView.findViewById(R.id.rvm);
    }
}
