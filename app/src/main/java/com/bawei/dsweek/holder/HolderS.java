package com.bawei.dsweek.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dsweek.R;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class HolderS extends RecyclerView.ViewHolder{

    public final ImageView img;
    public final TextView name;
    public final TextView price;

    public HolderS(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
    }
}
