package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.bean.NoticeDetailsBean;
import com.wd.master_of_arts_app.bean.NoticeNumBer;
import com.wd.master_of_arts_app.contreater.NoticeContreanter;
import com.wd.master_of_arts_app.preanter.NoticePreanter;

public class NoticeDetails extends BaseActivity implements NoticeContreanter.IVew {


    private TextView details_title,details_date;
    private ImageView details_iv;
    private WebView web;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_notice_details;
    }

    @Override
    protected BasePreantert initModel() {
        return new NoticePreanter(this);
    }

    @Override
    protected void initView() {
        details_title = findViewById(R.id.details_title);
        details_date=    findViewById(R.id.details_date);
        web=   findViewById(R.id.web);
        details_iv=   findViewById(R.id.details_iv);
    }

    @Override
    protected void initData() {
        details_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof NoticeContreanter.IPreanter){
            SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
            String token = sp.getString("token", "");
            Intent intent = getIntent();
            int noticeId = intent.getIntExtra("noticeId", 0);
            ((NoticeContreanter.IPreanter) basePreantert).OnNoticeSuccess(token,noticeId);
        }
    }

    @Override
    public void OnNoticeView(NoticeBean noticeBean) {

    }

    @Override
    public void OnNoticeBean(NoticeDetailsBean noticeDetailsBean) {
        NoticeDetailsBean.DataBean data = noticeDetailsBean.getData();
        NoticeDetailsBean.DataBean.NoticeMsgBean noticeMsg = data.getNoticeMsg();
        String content = noticeMsg.getContent();
        String title = noticeMsg.getTitle();
        String create_time = noticeMsg.getCreate_time();
        details_title.setText(title);
        details_date.setText(create_time);
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
    public void OnNoticeNumber(NoticeNumBer noticeNumBer) {

    }
}
