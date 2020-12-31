package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;

/**
 * @author 时文豪
 * @description:  文章契约类
 * @date :2020/12/21 15:09
 */
public interface ArticleListContreater {
    interface IView extends IBaseView{
        //文章列表
        void OnArticle(ArticleList articleList);
        //文章列表更多
        void OnCommon(CommBean commBean);
    }
    interface IPreanter{
        //文章列表
        void OnArticleSuccess(String token);
        //文章列表更多
        void OnCommonSuccess(int cat_id,int p,int per);
    }
    interface IModel{
        //文章列表
        void OnArticleSuccess(String token,ArticleCoallack coallack);
        interface ArticleCoallack{
            void OnArticle(ArticleList articleList);
        }
        //文章列表更多
        void OnCommonSuccess(int cat_id,int p,int per,OnCommonCoallack commonCoallack);
        interface OnCommonCoallack{
            void OnCommon(CommBean commBean);
        }
    }

}
