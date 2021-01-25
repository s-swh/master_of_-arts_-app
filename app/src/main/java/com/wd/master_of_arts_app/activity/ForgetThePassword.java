package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

public class ForgetThePassword extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_the_password;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

    }
    @OnClick(R.id.fins)
    public void OnClick(){
        finish();
    }
    @Override
    protected void initData() {

    }
}
