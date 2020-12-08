package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

public class Search_Activity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

    }
    public void decote(View view){
        finish();
    }
    @Override
    protected void initData() {

    }
}
