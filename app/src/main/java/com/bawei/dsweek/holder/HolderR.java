package com.bawei.dsweek.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.dsweek.R;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class HolderR extends RecyclerView.ViewHolder{

    private final RecyclerView rvr;

    public HolderR(@NonNull View itemView) {
        super(itemView);
        rvr = itemView.findViewById(R.id.rvr);
    }
}
