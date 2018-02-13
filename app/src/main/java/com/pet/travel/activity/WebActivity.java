package com.pet.travel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;
import com.pet.travel.view.action.ActionBarJiongView;

public class WebActivity extends BaseUIActivity {

    private ActionBarJiongView actionBar;
    private WebView webView;
    private String url = "http://mp.weixin.qq.com/mp/homepage?__biz=MjM5MDIyNTg2NQ==&hid=2&sn=36308dd34fd52747fc5088aac8aa1474#wechat_redirect";

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, WebActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
//        url = getIntent().getStringExtra("url");
        actionBar = (ActionBarJiongView)findViewById(R.id.action_bar);
        initWebView();
    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
//设置渲染的优先级
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
// 开启 DOM storage API 功能
        webSettings.setDomStorageEnabled(true);
//开启 database storage API 功能
        webSettings.setDatabaseEnabled(true);
//        String cacheDirPath = getFilesDir().getAbsolutePath() + APP_CACAHE_DIRNAME;
////设置数据库缓存路径
//        webSettings.setDatabasePath(cacheDirPath);
////设置  Application Caches 缓存目录
//        webSettings.setAppCachePath(cacheDirPath);
//开启 Application Caches 功能
        webSettings.setAppCacheEnabled(true);

        webSettings.setLoadWithOverviewMode(true);
//设置WebView支持JavaScript
        webSettings.setJavaScriptEnabled(true);
//设置可以访问文件
        webSettings.setAllowFileAccess(true);
//设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.requestFocus();
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //设置网页在webview控件中打开,false在浏览器中打开
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                actionBar.setTvTitle(view.getTitle());
            }
        });
        webView.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
