package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;

public class To_be_paid extends BaseFragment {

    private ImageView iv;
    private EditText us;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_to_be_paid;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
    }

    @Override
    protected void initView(View inflate) {
        iv = inflate.findViewById(R.id.cloat);
        us = inflate.findViewById(R.id.username);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        us.setText("");

            }
        });
    }

    @Override
    protected void initData() {

    }
}
