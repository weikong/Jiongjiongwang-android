package com.pet.travel.okhttp;

/**
 * Created by kongwei on 2017/3/10.
 */

public class HttpTaskUtil {

    private ResultListener resultListener;

    private HttpTaskUtil mInstance;

//    public HttpTaskUtil getInstance() {
//        if (mInstance == null) {
//            synchronized (HttpTaskUtil.class) {
//                if (mInstance == null) {
//                    mInstance = new HttpTaskUtil();
//                }
//            }
//        }
//        return mInstance;
//    }

    public interface ResultListener {
        public void onResponse(String response);

        public void onFailure(Exception e);
    }

    public HttpTaskUtil setResultListener(ResultListener resultListener) {
        this.resultListener = resultListener;
        return this;
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


    public OkHttpClientManager.Param setLocateParam(String key, String value) {
        OkHttpClientManager.Param param = new OkHttpClientManager.Param(key, value);
        return param;
    }
}
