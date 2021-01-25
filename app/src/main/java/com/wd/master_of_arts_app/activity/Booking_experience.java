package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.BookingExperience;
import com.wd.master_of_arts_app.bean.Logistics;
import com.wd.master_of_arts_app.contreater.BookingExperienceContreanter;
import com.wd.master_of_arts_app.contreater.ViewLogisticsConreater;
import com.wd.master_of_arts_app.preanter.BookingPreanter;
import com.wd.master_of_arts_app.preanter.ViewLogisticsPreanter;


public class Booking_experience extends BaseActivity implements BookingExperienceContreanter.IView {


    private EditText et_name, et_phone;
    private Button bt;
    private ImageView imv_retu;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_booking_experience;
    }

    @Override
    protected BasePreantert initModel() {
        return new BookingPreanter(this);
    }

    @Override
    protected void initView() {
        et_name = findViewById(R.id.book_name);
        et_phone = findViewById(R.id.book_phone);
        bt = findViewById(R.id.bt_receive);
        imv_retu = findViewById(R.id.imv_retu);
    }

    @Override
    protected void initData() {
        imv_retu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = et_name.getText().toString();
                String string1 = et_phone.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    Toast.makeText(getApplicationContext(), "姓名和手机号不允许为空", Toast.LENGTH_SHORT).show();
                } else if(  TextUtils.isEmpty(string1)) {
                    Toast.makeText(getApplicationContext(), "姓名和手机号不允许为空", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    BasePreantert basePreantert = getmPreantert();
                    if (basePreantert instanceof BookingExperienceContreanter.IPreanter) {

                        ((BookingExperienceContreanter.IPreanter) basePreantert).OnBookingSuccess(token1, string1, string, 2);
                    }
                }

            }
        });
    }


    @Override
    public void OnBooking(BookingExperience bookingExperience) {
        int code = bookingExperience.getCode();
        String msg = bookingExperience.getMsg();
        if (code == 1) {
            new AlertDialog.Builder(Booking_experience.this).setTitle("领取成功")
                    .setMessage("我们会尽快安排助教老师与您联系")
                    .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(Booking_experience.this, "领取" + msg, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).show();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
