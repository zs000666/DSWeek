package com.bawei.dsweek.show;

import com.bawei.dsweek.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class ShowPresenterImpl implements ShowController.ShowPresenter{
     private ShowController.ShowModel model;
     private ShowController.ShowView views;
    @Override
    public void attch(ShowController.ShowView view) {
        this.views=view;
        model=new ShowModelImpl();
    }

    @Override
    public void pttch() {
        if (views!=null){
            views=null;
        }
        if (model!=null){
            model=null;
        }
    }

    @Override
    public void showM(String url) {
        model.https(url, new HttpUtils.CallBack() {
            @Override
            public void onSuccess(String result) {
                views.showL(result);
            }

            @Override
            public void onFail(String msg) {
                
            }
        });
    }

    @Override
    public void showB(final String data) {
       model.https(data, new HttpUtils.CallBack() {
           @Override
           public void onSuccess(String result) {
               views.showD(result);
           }

           @Override
           public void onFail(String msg) {

           }
       });
    }
}
