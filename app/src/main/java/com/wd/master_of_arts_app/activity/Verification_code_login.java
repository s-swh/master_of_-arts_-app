package com.wd.master_of_arts_app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.contreater.LoginContreater;
import com.wd.master_of_arts_app.preanter.LoginPreanter;

public class Verification_code_login extends BaseActivity implements View.OnClickListener, LoginContreater.IView {

    private TextView tv_swit, tv_swi1t, xy, ys;
    private LinearLayout let, let_2;
    private ImageView re1, re2;
    private EditText et_phone1, code;
    private Button but_log, bt_code;
    private Button but;
    private String etp;
    private String code1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
       EditText one= findViewById(R.id.et_phone);
       EditText pwd= findViewById(R.id.pwd);
      Button bt= findViewById(R.id.login_log);
      //todo 账号密码登录
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = one.getText().toString();
                String string1 = pwd.getText().toString();
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof LoginContreater.IPreanter){
                    ((LoginContreater.IPreanter) basePreantert).OnAccout(string,string1);
                }
            }
        });
        // todo 短信登录
      bt_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    BasePreantert basePreantert = getmPreantert();
                    if (basePreantert instanceof LoginContreater.IPreanter) {
                        String string = et_phone1.getText().toString();
                        ((LoginContreater.IPreanter) basePreantert).OnCode(string);
                    }
            }
        });
        but_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            BasePreantert basePreantert=getmPreantert();
            if(basePreantert instanceof LoginContreater.IPreanter){
                String string = et_phone1.getText().toString();
                String string1 = code.getText().toString();
                ((LoginContreater.IPreanter) basePreantert).OnLoginSuccess(string,string1);
            }
            }
        });
        let_2 = findViewById(R.id.let_2);
    }

    @Override
    protected void initData() {



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
            default:
                break;
        }
    }


    @Override
    public void OnCodeSuccess(CodeBean codeBean) {

        String msg = codeBean.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnCodeLogin(SMSLogin smsLogin) {
        SMSLogin.DataBean data = smsLogin.getData();
        String token = data.getToken();
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("token",token);
        edit.commit();
        String msg = smsLogin.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        int code = smsLogin.getCode();
        if(code==1){
            startActivity(new Intent(Verification_code_login.this,MainActivity.class));
            finish();
        }else{
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    //todo  账号密码登录
    @Override
    public void OnAccoutLogin(AccountLogin accountLogin) {
        int code = accountLogin.getCode();
        String msg = accountLogin.getMsg();
        if(code==1){
            startActivity(new Intent(Verification_code_login.this,MainActivity.class));
            finish();
        }else{
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        AccountLogin.DataBean data = accountLogin.getData();
        String token = data.getToken();
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("token",token);
        edit.commit();
    }
}
