package com.wd.master_of_arts_app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.User_agreement;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.LogIn;
import com.wd.master_of_arts_app.contreater.LoginContract;
import com.wd.master_of_arts_app.preanter.LoginPreanter;

public class Verification_code_login extends BaseActivity implements View.OnClickListener, LoginContract.IView {

    private TextView tv_swit, tv_swi1t, xy, ys;
    private LinearLayout let, let_2;
    private ImageView re1, re2;
    private EditText et_phone1, code;
    private Button but_log, bt_code;
    private Button but;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences yijian = getSharedPreferences("yijian", MODE_PRIVATE);
        int code = yijian.getInt("code", 0);
        if (code == 1) {
            Intent intent = new Intent(Verification_code_login.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in_;
    }

    @Override
    protected BasePreantert initModel() {
        return new LoginPreanter(this);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initView() {
        tv_swit = findViewById(R.id.s_switch);
        tv_swi1t = findViewById(R.id.s_switch1);
        et_phone1 = findViewById(R.id.et_ph1);
        code = findViewById(R.id.code);
        but_log = findViewById(R.id.but_log);
        bt_code = findViewById(R.id.bt_code);
        let = findViewById(R.id.let);
        xy = findViewById(R.id.user_xy);
        ys = findViewById(R.id.user_ys);
        re1 = findViewById(R.id.re1);
        re2 = findViewById(R.id.re2);
        tv_swit.setOnClickListener(this);
        tv_swi1t.setOnClickListener(this);
        let.setOnClickListener(this);
        xy.setOnClickListener(this);
        ys.setOnClickListener(this);
        re1.setOnClickListener(this);
        re2.setOnClickListener(this);
        let_2 = findViewById(R.id.let_2);
    }

    @Override
    protected void initData() {
        initCode();//短信登录
        initPhone();//账号密码登录
    }

    private void initPhone() {
        EditText etphone = findViewById(R.id.et_phone);
        EditText pwd = findViewById(R.id.pwd);
        but = findViewById(R.id.login_log);
        SharedPreferences s = getSharedPreferences("phone", MODE_PRIVATE);
        String phone = s.getString("phone", "");
        etphone.setText(phone);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Verification_code_login.this, "走", Toast.LENGTH_SHORT).show();
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof LoginContract.IPreanter) {
                    String phone = etphone.getText().toString();
                    String pd = pwd.getText().toString();
                    ((LoginContract.IPreanter) basePreantert).OnLogin(phone, pd);
                    SharedPreferences p = getSharedPreferences("phone", MODE_PRIVATE);
                    SharedPreferences.Editor edit = p.edit();
                    edit.putString("phone", phone);
                    edit.putString("pd", pd);
                    edit.commit();


                }
            }


        });

    }

    private void initCode() {
        String phone = et_phone1.getText().toString();
        String code = this.code.getText().toString();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.re1: {
                finish();
            }
            break;
            case R.id.re2: {
                finish();
            }
            break;
            case R.id.s_switch: {
                let.setVisibility(View.GONE);
                let_2.setVisibility(View.VISIBLE);
            }
            break;
            case R.id.s_switch1: {
                let.setVisibility(View.VISIBLE);
                let_2.setVisibility(View.GONE);
            }
            break;
            case R.id.user_xy: {
                startActivity(new Intent(getApplicationContext(), User_agreement.class));
            }
            break;
            case R.id.user_ys: {
                startActivity(new Intent(getApplicationContext(), Privacy_policy.class));
            }
            break;
            case R.id.et_ph1: {
                //电话信息

            }
            break;
            case R.id.code: {
                //验证输入

            }
            break;
            case R.id.bt_code: {
                //验证码按钮

            }
            break;
            case R.id.but_log: {
                //登录

            }
            break;
            default:
                break;
        }
    }

    @Override
    public void OnSuccess(LogIn logIn) {
        String msg = logIn.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        LogIn.DataBean data = logIn.getData();
        String token = data.getToken();
        SharedPreferences sp = getSharedPreferences("into", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("token", token);
        edit.commit();
        int code = logIn.getCode();
        SharedPreferences yijian = getSharedPreferences("yijian", MODE_PRIVATE);
        SharedPreferences.Editor edit1 = yijian.edit();
        edit1.putInt("code", code);
        edit1.commit();
        if (code == 1) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "账号或密码输入错误", Toast.LENGTH_SHORT).show();
        }
    }


}
