package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.preanter.ArticlePreanter;

public class ArticleDetailsActivity extends BaseActivity implements ArticleListContreater.IView {


    private ImageView iv,article_fh;
    private TextView tv,date;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_details;
    }

    @Override
    protected BasePreantert initModel() {
        return new ArticlePreanter(this);
    }

    @Override
    protected void initView() {
        iv = findViewById(R.id.article_iv);
        tv = findViewById(R.id.artice_tv);
        date = findViewById(R.id.artice_date);
        article_fh = findViewById(R.id.article_fh);
        article_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int article_id = intent.getIntExtra("article_id",0);
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof ArticleListContreater.IPreanter){
            ((ArticleListContreater.IPreanter) basePreantert).OnAritSuccess(article_id);
        }
    }

    @Override
    public void OnArticle(ArticleList articleList) {

    }

    @Override
    public void OnCommon(CommBean commBean) {

    }

    @Override
    public void OnArti(ArticleDetails articleDetails) {
        ArticleDetails.DataBean data = articleDetails.getData();
        ArticleDetails.DataBean.ArticleMsgBean articleMsg = data.getArticleMsg();
        String title = articleMsg.getTitle();
        String img = articleMsg.getImg();
        String pubtime = articleMsg.getPubtime();
        Glide.with(getApplicationContext()).load(img).into(iv);
        tv.setText(title);
        date.setText(pubtime);
    }
}
