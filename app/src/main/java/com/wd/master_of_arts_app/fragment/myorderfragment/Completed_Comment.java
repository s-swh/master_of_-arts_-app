package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Completed_Comment extends BaseFragment implements OrderContreater.IView {
    private ImageView iv;
    private EditText us;
    private RecyclerView rec_rv;
    private String s;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_completed__comment;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView(View inflate) {
        iv = inflate.findViewById(R.id.cloat);
        us = inflate.findViewById(R.id.username);
        rec_rv = inflate.findViewById(R.id.cancel_rv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        us.setText("");
            }
        });
    }



    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof OrderContreater.IPreanter){
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            SharedPreferences addid = App.getContext().getSharedPreferences("addid", Context.MODE_PRIVATE);
            int id = addid.getInt("id", 0);
            ((OrderContreater.IPreanter) basePreantert).OnCancelSuccess(token1,id+"");
        }
    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {

    }

    @Override
    public void OnCancel(CancellationOfOrder cancellationOfOrder) {

    }
}
