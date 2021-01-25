package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.WatchAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Voideo;
import com.wd.master_of_arts_app.bean.WatchTheReplay;
import com.wd.master_of_arts_app.contreater.WatchThreContreanter;
import com.wd.master_of_arts_app.preanter.WatchThrePreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回播片段
 */
public class WatchTheReplayActivity extends BaseActivity implements WatchThreContreanter.IView {


    private WebView web;
    private String string;
    private RecyclerView xrv;
    private List<String> list;
    private ImageView imv;
    private RelativeLayout rlvt;
    private LinearLayout weba,lllt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_watch_the_replay;
    }

    @Override
    protected BasePreantert initModel() {
        return new WatchThrePreanter(this);
    }

    @Override
    protected void initView() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        web = findViewById(R.id.web);
        weba = findViewById(R.id.weba);
        lllt = findViewById(R.id.lllt);
        xrv = findViewById(R.id.xrv);
        imv = findViewById(R.id.return_fn);
        rlvt = findViewById(R.id.re_huifang);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        xrv.setLayoutManager(linearLayoutManager);
        ImageView tc = findViewById(R.id.tuichu);
        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void ListManage(Voideo voideo) {
        list = new ArrayList<>();
        List list = voideo.getList();
        for (int i = 0; i < list.size(); i++) {
            string = list.get(i).toString();
            this.list.add(string);
        }


    }

    @Override
    protected void initData() {
        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        int meetingId = intent.getIntExtra("meetingId", 0);
        if (list.size() == 1) {
            weba.setVisibility(View.VISIBLE);
            rlvt.setVisibility(View.GONE);
            BasePreantert basePreantert = getmPreantert();
            if (basePreantert instanceof WatchThreContreanter.IPreanter) {
                ((WatchThreContreanter.IPreanter) basePreantert).OnWatSuccess(meetingId + "", string);
            }

        } else {
            weba.setVisibility(View.GONE);
            lllt.setVisibility(View.VISIBLE);
            rlvt.setVisibility(View.VISIBLE);
            WatchAdapter watchAdapter = new WatchAdapter(getApplicationContext(), list);
            watchAdapter.OnItemCk(new WatchAdapter.OnItemClick() {
                @Override
                public void OnClick(String href) {
                    Intent intent1 = new Intent(getApplicationContext(), WatchThreeReplaceActivity.class);
                    SharedPreferences sp = getSharedPreferences("asdasd", MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("href11", href);
                    edit.putInt("meetingIdq", meetingId);
                    edit.commit();

                    startActivity(intent1);
                }
            });
            xrv.setAdapter(watchAdapter);
        }


    }

    @Override
    public void OnWatchThree(WatchTheReplay watchTheReplay) {
        String msg = watchTheReplay.getMsg();

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
