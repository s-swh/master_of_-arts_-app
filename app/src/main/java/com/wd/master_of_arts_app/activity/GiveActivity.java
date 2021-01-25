package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.GiveAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.preanter.ArticlePreanter;

import java.util.List;

public class GiveActivity extends BaseActivity implements ArticleListContreater.IView {
    private RecyclerView xrv;
    private ImageView xh;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_give;
    }

    @Override
    protected BasePreantert initModel() {
        return new ArticlePreanter(this);
    }

    @Override
    protected void initView() {
        xh = findViewById(R.id.xh);
        xrv = findViewById(R.id.xrv_rv);
    }

    @Override
    protected void initData() {
        xh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof ArticleListContreater.IPreanter){
            SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
            String token = sp.getString("token", "");
            ((ArticleListContreater.IPreanter) basePreantert).OnCommonSuccess(token,5,1,10);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        xrv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void OnArticle(ArticleList articleList) {

    }

    @Override
    public void OnCommon(CommBean commBean) {
        CommBean.DataBean data = commBean.getData();
        List<CommBean.DataBean.ListBean> list = data.getList();
        GiveAdapter giveAdapter = new GiveAdapter(getApplicationContext(),list);
        giveAdapter.OnClick(new GiveAdapter.OnHrefClick() {
            @Override
            public void OnClick(String href,String title) {
                Intent intent = new Intent(getApplicationContext(),FindHref.class);
                intent.putExtra("href",href);
                intent.putExtra("name",title);
                startActivity(intent);
            }
        });
        xrv.setAdapter(giveAdapter);
    }

    @Override
    public void OnArti(ArticleDetails articleDetails) {

    }
}
