package com.beanu.arad;


import com.beanu.arad.core.IHTTP;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.params.CoreConnectionPNames;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class Http implements IHTTP {

    private static Http instance;
    private static AsyncHttpClient client;

    private Http() {
        client = new AsyncHttpClient();
    }

    public static Http instance() {
        if (instance == null)
            instance = new Http();
        //TODO http拦截器-增加全局错误处理机制
        ((DefaultHttpClient) client.getHttpClient()).addResponseInterceptor(new HttpResponseInterceptor() {
            @Override
            public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {

            }
        });
        // 连接超时
        client.getHttpClient().getParams().setParameter( CoreConnectionPNames.CONNECTION_TIMEOUT, 50000);
        // 请求超时
        client.getHttpClient().getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 50000);

        return instance;
    }

    @Override
    public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    @Override
    public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    @Override
    public void download(String url, BinaryHttpResponseHandler responseHandler) {
        client.get(url, responseHandler);
    }

}
