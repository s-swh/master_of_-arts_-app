package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
// 已取消
public class Cancelled extends BaseFragment implements OrderContreater.IView{

    private ImageView iv;
    private EditText us;
    private RecyclerView rec_rv;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_cancelled;
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
            String i="4";
            int p=1;
            int per=10;
            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1,i,p,per);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rec_rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {
        OrderList.DataBean data = orderList.getData();
        List<OrderList.DataBean.ListBean> list = data.getList();
        OrderListAdapter orderListAdapter = new OrderListAdapter(getActivity(), list);
        rec_rv.setAdapter(orderListAdapter);
    }

    @Override
    public void OnCancel(CancellationOfOrder cancellationOfOrder) {

    }
}
