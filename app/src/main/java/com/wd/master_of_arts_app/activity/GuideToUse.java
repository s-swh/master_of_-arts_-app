package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GuideToUse extends BaseActivity {


    private ImageView to_iv;
    private TextView tv_title;
    private WebView web;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide_to_use;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        to_iv = findViewById(R.id.to_iv);
        tv_title = findViewById(R.id.to_title);
        web = findViewById(R.id.to_web);
    }

    @Override
    protected void initData() {
        to_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        NetUtils.getInstance().getApi().getArti(40)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleDetails>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArticleDetails articleDetails) {
                        ArticleDetails.DataBean data = articleDetails.getData();
                        ArticleDetails.DataBean.ArticleMsgBean articleMsg = data.getArticleMsg();
                        String title = articleMsg.getTitle();
                        tv_title.setText(title);
                        String content = articleMsg.getContent();
                        web.getSettings().setUseWideViewPort(true);
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
                        web.loadDataWithBaseURL("",content+js,"text/html","utf-8","");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
