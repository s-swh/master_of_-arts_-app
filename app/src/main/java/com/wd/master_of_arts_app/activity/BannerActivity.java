package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.BannerPage;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.contreater.HomePagerCrete;
import com.wd.master_of_arts_app.preanter.HomePreanter;

public class BannerActivity extends BaseActivity implements HomePagerCrete.IVew {

    private WebView web;
    private TextView tv_title;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    protected BasePreantert initModel() {
        return new HomePreanter(this);
    }

    @Override
    protected void initView() {

        web = findViewById(R.id.webview);
      ImageView lbt_iv = findViewById(R.id.lbt_iv);
        tv_title = findViewById(R.id.title_banner);
        lbt_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int bannerId = intent.getIntExtra("BannerId", 0);
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof HomePagerCrete.IPreanter){
            ((HomePagerCrete.IPreanter) basePreantert).OnBannerSuccess(bannerId);
        }



    }

    @Override
    public void BannerSuccess(Beanner beanner) {

    }

    @Override
    public void HomePage(HomePage homePage) {

    }

    @Override
    public void OnBanner(BannerPage bannerPage) {
        BannerPage.DataBean data = bannerPage.getData();
        BannerPage.DataBean.BannerMsgBean bannerMsg = data.getBannerMsg();
        String content = bannerMsg.getContent();
        web.getSettings().setUseWideViewPort(true);
        web.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//适应内容大小
        web.getSettings().setLoadWithOverviewMode(true);

        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);//支持JS
        String js = "<script type=\"text/javascript\">" +
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";
        String title = bannerMsg.getTitle();
        tv_title.setText(title);
        web.loadDataWithBaseURL("",content+js,"text/html","utf-8","");
    }
}
