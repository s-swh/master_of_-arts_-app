package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.OrderDetails;
import com.wd.master_of_arts_app.adapter.OrderListAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.OrderDelete;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.payment.ToBePaid;
import com.wd.master_of_arts_app.preanter.OrderPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

// 待付款
public class To_be_paid extends BaseFragment implements OrderContreater.IView {

    private ImageView iv;
    private EditText us;
    private XRecyclerView xrv;
    private OrderListAdapter orderListAdapter;
    private int p;
    private int per = 10;
    private OrderList.DataBean data;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_to_be_paid;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView(View inflate) {
        iv = inflate.findViewById(R.id.cloat);
        us = inflate.findViewById(R.id.username);
        xrv = inflate.findViewById(R.id.xrv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                us.setText("");

            }
        });
    }

    @Override
    protected void initData() {


        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                p = 1;
                orderListAdapter.Refresh(data.getList());
                xrv.refreshComplete();
                BasePreantert basePreantert = getmPreanter();
                if (basePreantert instanceof OrderContreater.IPreanter) {
                    SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    String i = "1";

                    ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, i, p, per);
                }
            }

            @Override
            public void onLoadMore() {
                p++;
                xrv.loadMoreComplete();
                orderListAdapter.Refresh(data.getList());

            }
        });
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof OrderContreater.IPreanter) {
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String i = "1";
            int p = 1;
            int per = 10;
            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, i, p, per);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xrv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onPause() {
        super.onPause();
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof OrderContreater.IPreanter) {
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String i = "1";
            int p = 1;
            int per = 10;
            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, i, p, per);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof OrderContreater.IPreanter) {
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String i = "1";
            int p = 1;
            int per = 10;
            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, i, p, per);
        }
    }

    @Override
    public void OnPurchase(Purchase purchase) {


    }


    @Override
    public void OnOrderList(OrderList orderList) {
        data = orderList.getData();
        List<OrderList.DataBean.ListBean> list = data.getList();
        orderListAdapter = new OrderListAdapter(getActivity(), list);
        orderListAdapter.OnClick(new OrderListAdapter.idtet() {
            @Override
            public void OnClick(int id) {
                Intent intent = new Intent(getActivity(), ToBePaid.class);
                intent.putExtra("idddddd", id);
                Toast.makeText(getActivity(), id + "", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        xrv.setAdapter(orderListAdapter);
        initeet();

    }

    private void initeet() {
        orderListAdapter.delete(new OrderListAdapter.itdelete() {
            @Override
            public void Click(int id) {

                SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
                String token1 = token.getString("token", "");
                NetUtils.getInstance().getApi().getOrderDelete(token1, id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<OrderDelete>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(OrderDelete orderDelete) {

                                String msg = orderDelete.getMsg();
                                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                                orderListAdapter.notifyDataSetChanged();

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }

    @Override
    public void OnCancel(CancellationOfOrder cancellationOfOrder) {

    }

    @Override
    public void OnOrderdetails(CourseOrderBean orderBean) {

    }

    @Override
    public void OnComment(CommentOrder commentOrder) {

    }
}
