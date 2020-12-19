package com.wd.master_of_arts_app.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.MyEventBus;
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
    @Subscribe(sticky = true,threadMode = ThreadMode.ASYNC)
    public void SetPhone(MyEventBus myEventBus){
        String phone = myEventBus.getPhone();
        Log.e("xx",phone+"phone");
        set_phone.setText(phone);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().unregister(this);
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
