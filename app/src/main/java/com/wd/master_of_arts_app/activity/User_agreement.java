package com.wd.master_of_arts_app.activity;

import androidx.recyclerview.widget.LinearLayoutManager;


import android.text.Html;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Privacy_policyBean;
import com.wd.master_of_arts_app.contreater.My_Contract;
import com.wd.master_of_arts_app.preanter.My_Preanter;

import butterknife.OnClick;

/**
 * TODO
 * 用户协议
 */
public class User_agreement extends BaseActivity implements My_Contract.IView {

    private TextView tv,label,conte;

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
        return new My_Preanter(this);
    }

    @Override
    protected void initView() {

        tv = findViewById(R.id.titbt);
        label = findViewById(R.id.label);
        conte = findViewById(R.id.conte);
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof My_Contract.IPranter){
            ((My_Contract.IPranter)basePreantert).OnUser_success(2);
        }

    }

    @Override
    public void OnUser_agreement(com.wd.master_of_arts_app.bean.User_agreement user_agreement) {
        com.wd.master_of_arts_app.bean.User_agreement.DataBean data = user_agreement.getData();
        com.wd.master_of_arts_app.bean.User_agreement.DataBean.ArticleMsgBean articleMsg = data.getArticleMsg();
        String title = articleMsg.getTitle();
        String content = articleMsg.getContent();
        String s = Html.fromHtml(content).toString();
        String keywords = articleMsg.getKeywords();
        tv.setText(title);
        label.setText(keywords);
        conte.setText(s);
    }

    @Override
    public void Privacy_policy(Privacy_policyBean privacyPolicyBean) {

    }
}
