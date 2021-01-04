package com.wd.master_of_arts_app.activity;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;


import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.CommonwealClassAdapter;
import com.wd.master_of_arts_app.adapter.FindAdapter;
import com.wd.master_of_arts_app.adapter.SelectedAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.bean.Image;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.preanter.ArticlePreanter;

import java.util.List;

/**
 * 公益课堂
 */
public class CommonwealClass extends BaseActivity implements ArticleListContreater.IView {


    private RecyclerView rv;
    private ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commonweal_class;
    }

    @Override
    protected BasePreantert initModel() {
        return new ArticlePreanter(this);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.Common_rv);
        imageView = findViewById(R.id.comm_return);
    }

    @Override
    protected void initData() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof ArticleListContreater.IPreanter){
            Intent intent = getIntent();
            int catid = intent.getIntExtra("catid", 0);
            ((ArticleListContreater.IPreanter) basePreantert).OnCommonSuccess(catid,1,10);
        }
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getApplicationContext(), 2);

        rv.setLayoutManager(gridLayoutManager1);
    }

    @Override
    public void OnArticle(ArticleList articleList) {


    }

    @Override
    public void OnCommon(CommBean commBean) {
        CommBean.DataBean data = commBean.getData();
        List<CommBean.DataBean.ListBean> list = data.getList();
        CommonwealClassAdapter commonwealClassAdapter = new CommonwealClassAdapter(getApplication(), list);
        commonwealClassAdapter.OnClick(new CommonwealClassAdapter.OnClickIntrHref() {
            @Override
            public void OnClick(String href) {
                Intent intent = new Intent(getApplicationContext(),MoreHref.class);
                intent.putExtra("href_tow",href);
               startActivity(intent);
            }
        });
        rv.setAdapter(commonwealClassAdapter);
    }
}
