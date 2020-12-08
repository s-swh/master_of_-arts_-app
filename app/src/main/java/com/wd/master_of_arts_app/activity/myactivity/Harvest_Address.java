package com.wd.master_of_arts_app.activity.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Add_Address;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

/**
 * 收获地址
 */
public class Harvest_Address extends BaseActivity {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_harvest__address;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @OnClick({R.id.add_address,R.id.add_addres})
    public void OnAdd_Address(View view){
        int id = view.getId();
        switch (id){
            case R.id.add_address:  startActivity(new Intent(getApplicationContext(), Add_Address.class));    break;
            case R.id.add_addres:  startActivity(new Intent(getApplicationContext(), Add_Address.class));    break;
            default:break;
        }

    }
    @Override
    protected void initData() {

    }
}
