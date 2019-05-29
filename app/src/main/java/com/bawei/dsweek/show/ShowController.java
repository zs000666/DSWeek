package com.bawei.dsweek.show;

import com.bawei.dsweek.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public interface ShowController {

     public interface ShowModel{
         void https(String url, HttpUtils.CallBack back);
     }
     public interface ShowView{
         void showL(String url);
         void showD(String data);
     }
     public interface ShowPresenter{
         void attch(ShowView view);
         void pttch();
         void showM(String url);
         void showB(String data);
     }
}
