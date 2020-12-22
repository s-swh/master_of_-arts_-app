package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.FindAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.preanter.ArticlePreanter;

import java.util.List;

/**
 * @author 时文豪
 * @description: 发现模块
 * @date :2020/12/3 11:05
 */
public class Find_page extends BaseFragment implements ArticleListContreater.IView {

    private RecyclerView rec;

    @Override
    protected int getLayoutId() {
        return R.layout.find;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new ArticlePreanter(this);
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rv_gre);
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof ArticleListContreater.IPreanter){
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            ((ArticleListContreater.IPreanter) basePreantert).OnArticleSuccess(token1);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);
        rec.setLayoutManager(gridLayoutManager);
    }
    //发现列表详情
    @Override
    public void OnArticle(ArticleList articleList) {
        ArticleList.DataBean data = articleList.getData();
        List<ArticleList.DataBean.FreeVideoBean> free_video = data.getFree_video();
        FindAdapter findAdapter = new FindAdapter(getActivity(), free_video);
        rec.setAdapter(findAdapter);

    }
}
