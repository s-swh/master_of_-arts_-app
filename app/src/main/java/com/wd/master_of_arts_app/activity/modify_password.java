package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.myactivity.SetUp;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.RetrievePassword;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.contreater.LoginContreater;
import com.wd.master_of_arts_app.preanter.LoginPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class modify_password extends BaseActivity implements LoginContreater.IView {


    private TextView set_phone;
    private EditText code;
    private Button but;
    private Button but_submit;
    private EditText et_ppwd,et_ppwdd;
    private String id;
    private TimeCount timeCount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected BasePreantert initModel() {
        return new LoginPreanter(this);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    class TimeCount extends CountDownTimer {
        public TimeCount(long m, long n) {
            super(m, n);
        }

        @Override
        public void onTick(long l) {
            but.setTextColor(Color.parseColor("#666666"));
            but.setClickable(false);
            but.setText("(" + l / 1000 + ")秒后可重新发送");
            but.setTextSize(12);
        }

        @Override
        public void onFinish() {
            but.setText("重新获取验证码");
            but.setClickable(true);
            but.setTextColor(Color.parseColor("#666666"));
            but.setTextSize(12);
        }
    }
    @Override
    protected void initView() {
        timeCount = new TimeCount(60000,1000);
        SharedPreferences phone = getSharedPreferences("phone", MODE_PRIVATE);
        String string = phone.getString("phone", "");
        set_phone = findViewById(R.id.set_phone);
        set_phone.setText(string);
        code = findViewById(R.id.e_code);
        but = findViewById(R.id.bot_code);
        but_submit = findViewById(R.id.but_submit);
        et_ppwd = findViewById(R.id.et_ppwd);
        et_ppwdd = findViewById(R.id.et_ppwdd);
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void OnPost(String registrationID){
        id = registrationID;
    }
    @Override
    protected void initData() {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCount.start();
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof LoginContreater.IPreanter){
                    String string = set_phone.getText().toString();
                    ((LoginContreater.IPreanter) basePreantert).OnCode(string);
                }
            }
        });
        but_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof LoginContreater.IPreanter){
                    String string = set_phone.getText().toString();
                    String string1 = code.getText().toString();
                    String string2 = et_ppwd.getText().toString();
                    String string3 = et_ppwdd.getText().toString();
                    if(string2.equals(string3)){
                        ((LoginContreater.IPreanter) basePreantert).OnRetrieveSuccess(string,string1,string2);
                    }else{
                        Toast.makeText(modify_password.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void OnCodeSuccess(CodeBean codeBean) {
        String msg = codeBean.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnCodeLogin(SMSLogin smsLogin) {

    }

    @Override
    public void OnAccoutLogin(AccountLogin accountLogin) {

    }

    @Override
    public void OnReturnPwd(RetrievePassword retrievePassword) {
        String msg = retrievePassword.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        int code = retrievePassword.getCode();
        if(code==1){
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            NetUtils.getInstance().getApi().getSignOut(token1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<SignOut>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(SignOut signOut) {
                            int code1 = signOut.getCode();
                            if(code1==1){
                                startActivity(new Intent(getApplicationContext(), Login_interface.class));
                                finish();
                            }
                            SharedPreferences sp = getSharedPreferences("code", MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            int i=0;
                            edit.putInt("code",i);
                            edit.commit();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            finish();
        }

    }
}
