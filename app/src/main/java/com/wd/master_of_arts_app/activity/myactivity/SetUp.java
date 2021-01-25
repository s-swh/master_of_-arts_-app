package com.wd.master_of_arts_app.activity.myactivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bigkoo.pickerview.TimePickerView;


import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Login_interface;
import com.wd.master_of_arts_app.activity.Privacy_policy;
import com.wd.master_of_arts_app.activity.User_agreement;
import com.wd.master_of_arts_app.activity.modify_password;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.contreater.MyContreater;
import com.wd.master_of_arts_app.preanter.MyPreanter;
import com.wd.master_of_arts_app.utils.DataCleanManager;


import butterknife.OnClick;


/**
 * 设置
 */
public class SetUp extends BaseActivity implements View.OnClickListener, MyContreater.IView {

    private TimePickerView pvTime;
    private TextView tv_data;
    private PopupWindow popupBigPhoto;
    private TextView cancel;
    private TextView determine;
    private TextView tv_userName;
    private EditText et;
    private ImageView vo;

    private TextView hc;
    private Button bt;
    private RelativeLayout rv;
    private int sequence;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyPreanter(this);
    }

    String totalCacheSize = null;

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * 获取缓存大小
         */
        String totalCacheSize = null;
        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        hc.setText(totalCacheSize);
    }

    @Override
    protected void initView() {
        bt = findViewById(R.id.signout);
        hc = findViewById(R.id.hc);
        rv = findViewById(R.id.souhuo);
        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetUp.this, Harvest_Address.class);
                startActivity(intent);
            }
        });
        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        hc.setText(totalCacheSize);
        RelativeLayout bt = findViewById(R.id.cloet);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(SetUp.this)
                        .setTitle("清除缓存")
                        .setMessage("是否确认清除缓存")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //清除缓存的方法
                                boolean b = DataCleanManager.clearAllCache(getApplicationContext());
                                if (b) {
                                    hc.setText("0M");
                                }
                                Toast.makeText(getApplicationContext(), "清除成功", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }



    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @OnClick(R.id.update_pwd)
    public void setUpdate() {
        Intent intent = new Intent(getApplicationContext(), modify_password.class);
        startActivity(intent);

    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof MyContreater.IPreanter){
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    ((MyContreater.IPreanter) basePreantert).SignOutSuccess(token1);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.cancel:
                popupBigPhoto.dismiss();
                break;
            case R.id.determine:
                String user_name = et.getText().toString();
                tv_userName.setText(user_name);
                et.setText("");
                popupBigPhoto.dismiss();
                break;
            default:
                break;
        }
    }

    //用户协议
    @OnClick(R.id.User_agreement)
    public void User_agreement() {
        Intent intent = new Intent(getApplicationContext(), User_agreement.class);
        startActivity(intent);
    }

    //隐私政策
    @OnClick(R.id.Privacy_policy)
    public void OnPrivacy_policy() {
        startActivity(new Intent(getApplicationContext(), Privacy_policy.class));
    }

    @Override
    public void OnSignOut(SignOut signOut) {
        int code = signOut.getCode();
        if(code==1){
            SharedPreferences pref =getSharedPreferences("*",MODE_PRIVATE);

            if (pref != null) {

                SharedPreferences.Editor editor = pref.edit();

                editor.clear();

                editor.commit();

            }
            startActivity(new Intent(SetUp.this, Login_interface.class));
            finish();
        }
        SharedPreferences code1 = getSharedPreferences("code", MODE_PRIVATE);
        SharedPreferences.Editor edit = code1.edit();
        int i=0;
        edit.putInt("code",i);
        edit.commit();
        String msg = signOut.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        DataCleanManager.clearAllCache(this);
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        SharedPreferences.Editor edit1 = sp.edit();
        edit1.clear();
        edit1.commit();
        SharedPreferences scp = getSharedPreferences("useridname", MODE_PRIVATE);
        SharedPreferences.Editor edit2 = scp.edit();
        edit2.clear();
        edit2.commit();
    }
}
