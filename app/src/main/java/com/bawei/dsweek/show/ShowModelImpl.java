package com.bawei.dsweek.show;

import com.bawei.dsweek.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class ShowModelImpl implements ShowController.ShowModel{

    private final HttpUtils httpUtils;

    public ShowModelImpl() {
        httpUtils = HttpUtils.getHttp();
    }

    @Override
    public void https(String url, HttpUtils.CallBack back) {
        httpUtils.doHttpGet(url,back);
    }
}
