package com.wd.master_of_arts_app;

import android.widget.TextView;

import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

public class Sign_in_Activity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in_;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }


    @Override
    protected void initView() {
     TextView t= findViewById(R.id.tv_number);

    }

    @Override
    protected void initData() {

    }

}
