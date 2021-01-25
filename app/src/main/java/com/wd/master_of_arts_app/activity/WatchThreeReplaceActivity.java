package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.WatchTheReplay;
import com.wd.master_of_arts_app.contreater.WatchThreContreanter;
import com.wd.master_of_arts_app.preanter.WatchThrePreanter;

/**
 * 回播片段
 */
public class WatchThreeReplaceActivity extends BaseActivity implements WatchThreContreanter.IView {
    private WebView web;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_watch_three_replace;
    }

    @Override
    protected BasePreantert initModel() {
        return new WatchThrePreanter(this);
    }

    @Override
    protected void initView() {
        web = findViewById(R.id.web);
        LinearLayout tuichu = findViewById(R.id.tuichu);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getSharedPreferences("asdasd", MODE_PRIVATE);
        int meetingIdq = sp.getInt("meetingIdq", 0);
        String href11 = sp.getString("href11", "");
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof WatchThreContreanter.IPreanter) {
               ((WatchThreContreanter.IPreanter) basePreantert).OnWatSuccess(meetingIdq+"", href11);
        }
    }

    @Override
    public void OnWatchThree(WatchTheReplay watchTheReplay) {
        String msg = watchTheReplay.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        WatchTheReplay.DataBean data = watchTheReplay.getData();
        String live_url = data.getLive_url();


        WebSettings webSettings = web.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 开启支持视频
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setGeolocationEnabled(true);
        // 开启DOM缓存。
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(getApplicationContext().getCacheDir()
                .getAbsolutePath());
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getCacheDir()
                .getAbsolutePath());
        webSettings.setAppCacheMaxSize(Integer.MAX_VALUE);
        web.requestFocus();
        web.setWebChromeClient(new WebChromeClient() {
        });

        // 覆盖WebView默认通过第三方或者系统浏览器打开网页的行为
        web.setWebViewClient(new WebViewClient() {

            // WebViewClient帮主WebView处理一些页面控制和请求通知
            // 还可以重写很多方法

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub

                // 返回true 控制网页在webview中打开
                // false 则是调用系统浏览器 或者第三方浏览器


                return false;
            }

        });
        web.loadUrl(live_url);
    }

    @Override
    protected void onPause() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            web.onPause(); // 暂停网页中正在播放的视频
        }
        super.onPause();
    }
}
