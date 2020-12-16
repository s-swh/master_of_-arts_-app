package com.wd.master_of_arts_app.activity;


import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

/**
 * TODO
 * 用户协议
 */
public class User_agreement extends BaseActivity {

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
        return null;

    }

    @Override
    protected void initView() {

        tv = findViewById(R.id.titbt);
        label = findViewById(R.id.label);
        conte = findViewById(R.id.conte);
    }

    @Override
    protected void initData() {

    }


}
