package com.wd.master_of_arts_app.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.IdNumber;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SignUpNow extends BaseActivity implements OrderContreater.IView {


    private int course_id;
    private int course_time_id;
    private Button bt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_up_now;
    }

    @Override
    protected BasePreantert initModel() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        bt = findViewById(R.id.but_zf);
    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof OrderContreater.IPreanter){
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    ((OrderContreater.IPreanter) basePreantert).OnPruchaseSuccess(token1, course_id, course_time_id);
                }
            }
        });

    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void IdNum(IdNumber idNumber){
        course_id = idNumber.getCourse_id();
        course_time_id = idNumber.getCourse_time_id();

    }
    @Override
    public void OnPurchase(Purchase purchase) {
        String msg = purchase.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if(purchase.getCode()==1){
            finish();
        }
    }
}
