package com.wd.master_of_arts_app.activity;


import android.text.Html;
import android.text.Spanned;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.utils.NetUtils;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * 用户协议
 */
public class User_agreement extends BaseActivity {

    private TextView tv,label;
    private WebView web;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_agreement;
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected BasePreantert initModel() {
        return null;

    }

    @Override
    protected void initView() {

        tv = findViewById(R.id.titbt);
        label = findViewById(R.id.label);
        web = findViewById(R.id.web);
    }

    @Override
    protected void initData() {
        NetUtils.getInstance().getApi().getArti(2)
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
                        String keywords = articleMsg.getKeywords();
                        String content = articleMsg.getContent();

                        tv.setText(title);
                        label.setText(keywords);
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
                        web.loadDataWithBaseURL("",content,"text/html","utf-8","");

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
