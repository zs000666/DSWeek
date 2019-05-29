package com.bawei.dsweek.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class BeanX extends SimpleBannerInfo {
     private String url;

    public BeanX(String url) {
        this.url = url;
    }

    public BeanX() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BeanX{" +
                "url='" + url + '\'' +
                '}';
    }

    @Override
    public Object getXBannerUrl() {
        return url;
    }
}
