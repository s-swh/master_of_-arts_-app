package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

public class MyHomeWork extends BaseActivity {


    private ImageView iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_home_work;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        iv = findViewById(R.id.mywork);
    }

    @Override
    protected void initData() {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        int myHomeWorkid = intent.getIntExtra("myHomeWorkid", 0);

    }
}
