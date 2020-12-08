package com.wd.master_of_arts_app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.User_agreement;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

public class Verification_code_login extends BaseActivity implements View.OnClickListener {

    private TextView tv_swit, tv_swi1t, xy, ys;
    private LinearLayout let, let_2;
    private ImageView re1, re2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in_;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initView() {
        tv_swit = findViewById(R.id.s_switch);
        tv_swi1t = findViewById(R.id.s_switch1);
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
}
