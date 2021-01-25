package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.customview.Img;
import com.wd.master_of_arts_app.preanter.ArticlePreanter;

public class ArticleDetailsActivity extends BaseActivity implements ArticleListContreater.IView {


    private ImageView iv, article_fh;
    private TextView tv, date;

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
        int article_id = intent.getIntExtra("article_id", 0);
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof ArticleListContreater.IPreanter) {
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

 date.setText("作者："+articleMsg.getAuthor());
        iv.setOnClickListener(new View.OnClickListener() {

            private PopupWindow popupBigPhoto;

            @Override
            public void onClick(View view) {
                View view1 = getLayoutInflater().inflate(R.layout.popimgitem, null);
                if (popupBigPhoto == null) {
                    popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popupBigPhoto.setOutsideTouchable(true);

                }
                if (popupBigPhoto.isShowing()) {
                    popupBigPhoto.dismiss();
                } else {
                    popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                }
                // 设置PopupWindow的背景
                popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);
                popupBigPhoto.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1.0f;

                        getWindow().setAttributes(lp);
                    }
                });
                popupBigPhoto.showAtLocation(view1, Gravity.BOTTOM, 0, 0);
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.3f;
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
                // 设置PopupWindow的背景
                popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);

                ImageView uiv = view1.findViewById(R.id.rec);
                uiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
                Glide.with(getApplicationContext()).load(img).into(uiv);
            }
        });
    }
}
