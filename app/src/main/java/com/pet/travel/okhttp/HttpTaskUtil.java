package com.pet.travel.okhttp;

import com.pet.travel.config.ServerConfig;
import com.squareup.okhttp.Request;

import java.io.IOException;

/**
 * Created by kongwei on 2017/3/10.
 */

public class HttpTaskUtil {

    private ResultListener resultListener;

    private HttpTaskUtil mInstance;

    public HttpTaskUtil getInstance() {
        if (mInstance == null) {
            synchronized (HttpTaskUtil.class) {
                if (mInstance == null) {
                    mInstance = new HttpTaskUtil();
                }
            }
        }
        return mInstance;
    }

    public interface ResultListener {
        public void onResponse(String response);

        public void onFailure(Exception e);
    }

    public HttpTaskUtil setResultListener(ResultListener resultListener) {
        this.resultListener = resultListener;
        return this;
    }

    public void QueryDataTask(String url,int pageNum,int pageSize, OkHttpClientManager.StringCallback callback) {
        try {
            OkHttpClientManager.Param pageNumParam = new OkHttpClientManager.Param("pageNum", "" + pageNum);
            OkHttpClientManager.Param pageSizeParam = new OkHttpClientManager.Param("pageSize", "" + pageSize);
            OkHttpClientManager.getInstance()._postAsyn(url, callback != null ? callback : new OkHttpClientManager.StringCallback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    if (resultListener != null)
                        resultListener.onFailure(e);
                }

                @Override
                public void onResponse(String response) {
                    if (resultListener != null)
                        resultListener.onResponse(response);
                }
            }, pageNumParam,pageSizeParam);
        } catch (Exception e) {
            e.printStackTrace();
            if (resultListener != null)
                resultListener.onFailure(e);
        }
    }

    public void QueryPetServiceTask(int type, OkHttpClientManager.StringCallback callback) {
        try {
            OkHttpClientManager.Param param = new OkHttpClientManager.Param("type", "" + type);
            OkHttpClientManager.getInstance()._postAsyn(ServerConfig.HTTP_SERVICE_QUERY, callback != null ? callback : new OkHttpClientManager.StringCallback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    if (resultListener != null)
                        resultListener.onFailure(e);
                }

                @Override
                public void onResponse(String response) {
                    if (resultListener != null)
                        resultListener.onResponse(response);
                }
            }, param);
        } catch (Exception e) {
            e.printStackTrace();
            if (resultListener != null)
                resultListener.onFailure(e);
        }
    }

    public void LoginTask(String url, String account, String password, OkHttpClientManager.StringCallback callback) {
        try {
            OkHttpClientManager.getInstance()._postAsyn(url, callback,
                    setLocateParam("Account", account),
                    setLocateParam("Password", password));
        } catch (Exception e) {
            e.printStackTrace();
            if (resultListener != null)
                resultListener.onFailure(e);
        }
    }

    public void QueryCustomDataTask(String url, OkHttpClientManager.StringCallback callback) {
        try {
            OkHttpClientManager.getInstance()._getAsyn(url, callback);
        } catch (Exception e) {
            e.printStackTrace();
            if (resultListener != null)
                resultListener.onFailure(e);
        }
    }

    public void QueryCircleRunTask(int pageNum, int pageSize, String account_id) {
        try {
            OkHttpClientManager.Param paramPageNum = new OkHttpClientManager.Param("pageNum", "" + pageNum);
            OkHttpClientManager.Param paramPageSize = new OkHttpClientManager.Param("pageSize", "" + pageSize);
            OkHttpClientManager.Param paramAccountId = new OkHttpClientManager.Param("account_id", account_id);
            OkHttpClientManager.getInstance()._postAsyn(ServerConfig.HTTP_CIRCLE_QUERY, new OkHttpClientManager.StringCallback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    if (resultListener != null)
                        resultListener.onFailure(e);
                }

                @Override
                public void onResponse(String response) {
                    if (resultListener != null)
                        resultListener.onResponse(response);
                }
            }, paramPageNum, paramPageSize, paramAccountId);
        } catch (Exception e) {
            e.printStackTrace();
            if (resultListener != null)
                resultListener.onFailure(e);
        }
    }


    public OkHttpClientManager.Param setLocateParam(String key, String value) {
        OkHttpClientManager.Param param = new OkHttpClientManager.Param(key, value);
        return param;
    }
}
