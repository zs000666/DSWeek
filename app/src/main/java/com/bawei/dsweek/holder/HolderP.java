package com.bawei.dsweek.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.dsweek.R;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class HolderP extends RecyclerView.ViewHolder{

    private final RecyclerView rvp;

    public HolderP(@NonNull View itemView) {
        super(itemView);
        rvp = itemView.findViewById(R.id.rvp);
    }
}
