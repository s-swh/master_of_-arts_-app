package com.wd.master_of_arts_app.activity.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

/**
 * 客服中心
 */
public class Customer_Service_Center extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer__service__center;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected void initData() {

    }
}
