package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.ArticleDetailsActivity;
import com.wd.master_of_arts_app.activity.CommonwealClass;
import com.wd.master_of_arts_app.activity.FindHref;
import com.wd.master_of_arts_app.activity.GiveActivity;
import com.wd.master_of_arts_app.activity.ImageActivity;
import com.wd.master_of_arts_app.activity.MoreImgActivity;
import com.wd.master_of_arts_app.adapter.FindAdapter;
import com.wd.master_of_arts_app.adapter.MyVideoAdapter;
import com.wd.master_of_arts_app.adapter.SelectedAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.preanter.ArticlePreanter;

import java.util.List;

/**
 * @author 时文豪
 * @description: 发现模块
 * @date :2020/12/3 11:05
 */
public class Find_page extends BaseFragment implements ArticleListContreater.IView {

    private RecyclerView rec, rv_gre_1, rv_gre_2;
    private RelativeLayout find_gd, find_mfgd, find_hyh;
    private int cat_id;

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
        rv_gre_1 = view.findViewById(R.id.rv_gre_1);
        rv_gre_2 = view.findViewById(R.id.rv_gre_2);
        find_gd = view.findViewById(R.id.find_gd);
        find_mfgd = view.findViewById(R.id.find_mfgd);
        find_hyh = view.findViewById(R.id.find_hyh);

    }

    @Override
    protected void initData() {
        find_gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GiveActivity.class);

                startActivity(intent);
            }
        });
        find_hyh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        if(!token1.isEmpty()){
            BasePreantert basePreantert = getmPreanter();
            if (basePreantert instanceof ArticleListContreater.IPreanter) {

                ((ArticleListContreater.IPreanter) basePreantert).OnArticleSuccess(token1);
            }
        }else{
            BasePreantert basePreantert = getmPreanter();
            if (basePreantert instanceof ArticleListContreater.IPreanter) {
                ((ArticleListContreater.IPreanter) basePreantert).OnArticleSuccess("");
            }
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rec.setLayoutManager(gridLayoutManager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        rv_gre_1.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 2);
        rv_gre_2.setLayoutManager(gridLayoutManager2);
        find_mfgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CommonwealClass.class);

                startActivity(intent);
            }
        });

    }


    @Override
    public void OnArticle(ArticleList articleList) {
        ArticleList.DataBean data = articleList.getData();
        if(data.getMy_video().size()==0){
            find_gd.setVisibility(View.GONE);
        }

            cat_id = data.getFree_video().get(0).getCat_id();
            List<ArticleList.DataBean.FreeVideoBean> free_video = data.getFree_video();
            FindAdapter findAdapter = new FindAdapter(getActivity(), free_video);
            findAdapter.OnClick(new FindAdapter.OnClickHref() {
                @Override
                public void OnClick(String href,String name) {
                    Intent intent = new Intent(getActivity(), FindHref.class);
                    intent.putExtra("href", href);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            });
            rec.setAdapter(findAdapter);
            List<ArticleList.DataBean.MyVideoBean> my_video = data.getMy_video();
            MyVideoAdapter myVideoAdapter = new MyVideoAdapter(getActivity(), my_video);
            myVideoAdapter.OnMyClicked(new MyVideoAdapter.OnMyClick() {
                @Override
                public void Myclick(String href,String name) {
                    Intent intent = new Intent(getActivity(), FindHref.class);
                    intent.putExtra("href", href);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            });
            rv_gre_2.setAdapter(myVideoAdapter);
            List<ArticleList.DataBean.SelectedWorksBean> selected_works = data.getSelected_works();
            SelectedAdapter selectedAdapter = new SelectedAdapter(getActivity(), selected_works);
            selectedAdapter.SetOnClick(new SelectedAdapter.ImageOnClick() {
                @Override
                public void OnClickImage(int id) {
                    Intent intent = new Intent(getActivity(), ArticleDetailsActivity.class);
                    intent.putExtra("article_id",id);

                    startActivity(intent);
                }
            });

            rv_gre_1.setAdapter(selectedAdapter);


    }

    @Override
    public void OnCommon(CommBean commBean) {

    }

    @Override
    public void OnArti(ArticleDetails articleDetails) {

    }
}
