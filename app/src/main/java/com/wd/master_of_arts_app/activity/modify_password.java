package com.wd.master_of_arts_app.activity;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.OnClick;

public class modify_password extends BaseActivity {


    private TextView set_phone;
    private EditText code;
    private Button but;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected void initView() {
        SharedPreferences phone = getSharedPreferences("phone", MODE_PRIVATE);
        String string = phone.getString("phone", "");
        set_phone = findViewById(R.id.set_phone);
        set_phone.setText(string);
        code = findViewById(R.id.e_code);
        but = findViewById(R.id.bot_code);
    }



    @Override
    protected void initData() {
        String string = code.getText().toString();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
