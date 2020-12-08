package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Privacy_policyBean;
import com.wd.master_of_arts_app.bean.User_agreement;
import com.wd.master_of_arts_app.contreater.My_Contract;
import com.wd.master_of_arts_app.preanter.My_Preanter;

import butterknife.OnClick;

public class Privacy_policy extends BaseActivity  implements My_Contract.IView {


    private TextView til,lable,conut;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_privacy_policy;
    }

    @Override
    protected BasePreantert initModel() {
        return new My_Preanter(this);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }
    @Override
    protected void initView() {
        til = findViewById(R.id.titbt);
        lable = findViewById(R.id.lable);
        conut = findViewById(R.id.conut);
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof My_Contract.IPranter){
            ((My_Contract.IPranter)basePreantert).OnPolicySuccess(3);
        }
    }

    @Override
    protected void initData() {

    }
    //TODO 用户协议
    @Override
    public void OnUser_agreement(User_agreement user_agreement) {

    }
    //TODO 隐私政策
    @Override
    public void Privacy_policy(Privacy_policyBean privacyPolicyBean) {
        Privacy_policyBean.DataBean data = privacyPolicyBean.getData();
        Privacy_policyBean.DataBean.ArticleMsgBean articleMsg = data.getArticleMsg();
        String title = articleMsg.getTitle();
        til.setText(title);
        String content = articleMsg.getContent();
        String s = Html.fromHtml(content).toString();
        String keywords = articleMsg.getKeywords();
        lable.setText(keywords);
        conut.setText(s);
    }
}
