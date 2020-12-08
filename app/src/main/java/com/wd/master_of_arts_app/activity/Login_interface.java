package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

public class Login_interface extends BaseActivity {


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

    @Override
    protected void initData() {

    }
}
