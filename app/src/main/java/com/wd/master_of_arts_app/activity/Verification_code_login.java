package com.wd.master_of_arts_app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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
import com.wd.master_of_arts_app.base.RetrievePassword;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.bean.UserId;
import com.wd.master_of_arts_app.contreater.LoginContreater;
import com.wd.master_of_arts_app.preanter.LoginPreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.jpush.android.api.JPushInterface;

public class Verification_code_login extends BaseActivity implements View.OnClickListener, LoginContreater.IView {

    private TextView tv_swit, tv_swi1t, xy, ys1;
    private LinearLayout let, let_2;
    private ImageView re1, re2;
    private EditText et_phone1, code;
    private Button but_log, bt_code;
    private Button but;
    private String etp;
    private String code1;
    private TimeCount time;
    private String id;
    private String registrationID;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in_;
    }

    @Override
    protected BasePreantert initModel() {

        return new LoginPreanter(this);
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long m, long n) {
            super(m, n);
        }

        @Override
        public void onTick(long l) {

            bt_code.setClickable(false);
            bt_code.setText("(" + l / 1000 + ")秒后可重新发送");
        }

        @Override
        public void onFinish() {
            bt_code.setText("重新获取验证码");
            bt_code.setClickable(true);

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void OnPost(String registrationID) {
        id = registrationID;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initView() {

        registrationID = JPushInterface.getRegistrationID(this);

        time = new TimeCount(60000, 1000);
        tv_swit = findViewById(R.id.s_switch);
        tv_swi1t = findViewById(R.id.s_switch1);
        et_phone1 = findViewById(R.id.et_ph1);
        code = findViewById(R.id.code);
        but_log = findViewById(R.id.but_log);
        bt_code = findViewById(R.id.bt_code);
        let = findViewById(R.id.let);
        xy = findViewById(R.id.user_xy);
        ys1 = findViewById(R.id.user_ys);
        re1 = findViewById(R.id.re1);
        re2 = findViewById(R.id.re2);
        TextView yh = findViewById(R.id.denglyh);
        TextView ys = findViewById(R.id.denglys);
        tv_swit.setOnClickListener(this);
        tv_swi1t.setOnClickListener(this);
        let.setOnClickListener(this);
        xy.setOnClickListener(this);
        ys.setOnClickListener(this);
        re1.setOnClickListener(this);
        re2.setOnClickListener(this);
        yh.setOnClickListener(this);
        ys1.setOnClickListener(this);
        EditText one = findViewById(R.id.et_phone);
        EditText pwd = findViewById(R.id.pwd);
        Button bt = findViewById(R.id.login_log);
        SharedPreferences sp = getSharedPreferences("phone", MODE_PRIVATE);
        String phone = sp.getString("phone", "");
        et_phone1.setText(phone);
        one.setText(phone);
        // 账号密码登录

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = one.getText().toString();
                SharedPreferences sp = getSharedPreferences("phone", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("phone", string);
                edit.commit();
                String string1 = pwd.getText().toString();
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof LoginContreater.IPreanter) {
                    if (!string.isEmpty() && !string1.isEmpty()) {
                        ((LoginContreater.IPreanter) basePreantert).OnAccout(string, string1, registrationID);

                    } else {
                        Toast.makeText(Verification_code_login.this, "账号或密码不允许为空", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        //  短信获取
        String string = et_phone1.getText().toString();
        if (!string.isEmpty()) {
            bt_code.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    BasePreantert basePreantert = getmPreantert();
                    if (basePreantert instanceof LoginContreater.IPreanter) {
                        String string = et_phone1.getText().toString();
                        if (!string.isEmpty()) {
                            ((LoginContreater.IPreanter) basePreantert).OnCode(string);
                            time.start();
                        } else {
                            Toast.makeText(Verification_code_login.this, "请输入手机号", Toast.LENGTH_SHORT).show();

                        }

                    }
                }
            });
        }

        // 短信登录
        but_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof LoginContreater.IPreanter) {
                    String string = et_phone1.getText().toString();
                    String string1 = code.getText().toString();
                    SharedPreferences sp = getSharedPreferences("phone", MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("phone", string);
                    edit.commit();
                    if (!string.isEmpty() && !string1.isEmpty()) {
                        ((LoginContreater.IPreanter) basePreantert).OnLoginSuccess(string, string1, registrationID);
                    } else {
                        Toast.makeText(Verification_code_login.this, "账号或验证码不允许为空", Toast.LENGTH_SHORT).show();
                    }

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
            case R.id.denglyh:{
                startActivity(new Intent(getApplicationContext(), User_agreement.class));
            }break;
            case R.id.denglys:{
                startActivity(new Intent(getApplicationContext(), Privacy_policy.class));
            }break;
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

        String msg = smsLogin.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        int code = smsLogin.getCode();
        if (code == 1) {
            SMSLogin.DataBean data = smsLogin.getData();
            String token = data.getToken();
            SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("token", token);
            edit.commit();
            SharedPreferences sp1 = getSharedPreferences("code", MODE_PRIVATE);
            SharedPreferences.Editor edit1 = sp1.edit();
            edit1.putInt("code", code);
            edit1.commit();
            String uid = data.getUid();
            EventBus.getDefault().postSticky(uid);
            startActivity(new Intent(Verification_code_login.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

    }

    //  账号密码登录
    @Override
    public void OnAccoutLogin(AccountLogin accountLogin) {
        int code = accountLogin.getCode();
        String msg = accountLogin.getMsg();
        if (code == 1) {
            AccountLogin.DataBean data = accountLogin.getData();
            String token = data.getToken();
            SharedPreferences spa = getSharedPreferences("token", MODE_PRIVATE);
            SharedPreferences.Editor edit = spa.edit();
            edit.putString("token", token);
            edit.commit();
            SharedPreferences sp = getSharedPreferences("code", MODE_PRIVATE);
            SharedPreferences.Editor edit1 = sp.edit();
            edit1.putInt("code", code);
            edit1.commit();
            startActivity(new Intent(Verification_code_login.this, MainActivity.class));
            finish();
            int uid = data.getUid();
            String nickname = data.getNickname();

            EventBus.getDefault().postSticky(uid);
            EventBus.getDefault().postSticky(new UserId(uid, nickname));
            SharedPreferences scp = getSharedPreferences("useridname", MODE_PRIVATE);
            SharedPreferences.Editor edit2 = scp.edit();
            edit2.putInt("uid",uid);
            edit2.putString("nickname",nickname);
            edit2.commit();

        } else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void OnReturnPwd(RetrievePassword retrievePassword) {

    }
}
