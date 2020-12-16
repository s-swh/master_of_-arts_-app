package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

public class Login_interface extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private Button bt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_interface;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        bt = findViewById(R.id.bt_login);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Verification_code_login.class);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.jr)
    public void jinru() {
        Intent intent = new Intent(Login_interface.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void initData() {

    }
}
