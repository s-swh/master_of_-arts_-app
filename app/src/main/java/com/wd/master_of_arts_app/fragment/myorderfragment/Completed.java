package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.OrderListAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import java.util.List;
 // 已完成
public class Completed extends BaseFragment implements OrderContreater.IView {
    private ImageView iv;
    private EditText us;
    private XRecyclerView xr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_completed;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView(View inflate) {
        iv = inflate.findViewById(R.id.cloat);
        us = inflate.findViewById(R.id.username);
        xr = inflate.findViewById(R.id.com_rv);
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
        if (basePreantert instanceof OrderContreater.IPreanter) {
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String i = "2";
            int p = 1;
            int per = 10;
            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, i, p, per);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xr.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {
        OrderList.DataBean data = orderList.getData();
        List<OrderList.DataBean.ListBean> list = data.getList();
        OrderListAdapter orderListAdapter = new OrderListAdapter(getActivity(), list);
        xr.setAdapter(orderListAdapter);
    }

    @Override
    public void OnCancel(CancellationOfOrder cancellationOfOrder) {

    }
}
