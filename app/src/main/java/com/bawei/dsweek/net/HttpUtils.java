package com.bawei.dsweek.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telecom.Call;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class HttpUtils {
     //
     private static HttpUtils httpUtils=new HttpUtils();
     public static HttpUtils getHttp(){
         return httpUtils;
     }
     private HttpUtils(){

     }
     public boolean isNet(Context context){
         ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo info = manager.getActiveNetworkInfo();
         if (info!=null){
             return info.isAvailable();
         }
         return false;
     }
     //Get
     public void doHttpGet(String url, final CallBack callBack){
         StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 callBack.onSuccess(response);
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 callBack.onFail(error.getMessage());
             }
         });
         MyRequest.getQueue().add(request);
     }
     //Post
     public void doHttpPost(String url,String phone,String pwd,CallBack back){
         final Map<String,String>param=new HashMap<>();
         param.put("phone",phone);
         param.put("pwd",pwd);
         StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {

             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         }){
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                 return param;
             }
         };
         MyRequest.getQueue().add(request);
     }
     public interface CallBack{
         void onSuccess(String result);
         void onFail(String msg);
     }
}
