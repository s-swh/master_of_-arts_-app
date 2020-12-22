package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.model.ArticleModel;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/21 15:14
 */
public class ArticlePreanter extends BasePreantert implements ArticleListContreater.IPreanter {

    private ArticleModel articleModel;

    public ArticlePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        articleModel = new ArticleModel();
    }

    @Override
    public void OnArticleSuccess(String token) {
        articleModel.OnArticleSuccess(token, new ArticleListContreater.IModel.ArticleCoallack() {
            @Override
            public void OnArticle(ArticleList articleList) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof ArticleListContreater.IView){
                    ArticleListContreater.IView view= (ArticleListContreater.IView) iBaseView;
                    view.OnArticle(articleList);
                }
            }
        });
    }
}
