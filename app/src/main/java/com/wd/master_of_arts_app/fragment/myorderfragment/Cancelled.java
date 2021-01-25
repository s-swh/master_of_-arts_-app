package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.wd.master_of_arts_app.preanter.OrderPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

// 已取消
public class Cancelled extends BaseFragment implements OrderContreater.IView{

    private ImageView iv;
    private EditText us;
    private XRecyclerView rec_rv;
    private OrderList.DataBean data;
    private OrderListAdapter orderListAdapter;
    int p=1;
    int per=10;
    private LinearLayout llt;
    private LinearLayout rlt;
    List<OrderList.DataBean.ListBean> listBeans=new ArrayList<>();
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
        llt = inflate.findViewById(R.id.llt);
        rlt = inflate.findViewById(R.id.rlt);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                        us.setText("");


            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof OrderContreater.IPreanter){
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String i="4";
            int p=1;
            int per=10;
            if(basePreantert instanceof OrderContreater.IPreanter){
                ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1,i,p,per);
            }

        }
    }
    @Override
    public void onResume() {
        super.onResume();
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof OrderContreater.IPreanter){
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String i="4";
            int p=1;
            int per=10;
            if(basePreantert instanceof OrderContreater.IPreanter){
                ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1,i,p,per);
            }
        }
    }
    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreanter();
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        String i="4";

        if(basePreantert instanceof OrderContreater.IPreanter){

            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1,i,p,per);
        }
        rec_rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                p=1;
                orderListAdapter.Refresh(data.getList());
                ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1,i,p,per);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                rec_rv.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onLoadMore() {

                p++;
                ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1,i,p,per);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rec_rv.setLayoutManager(linearLayoutManager);

        orderListAdapter = new OrderListAdapter(getActivity(), listBeans);
        orderListAdapter.OnClick(new OrderListAdapter.idtet() {
            @Override
            public void OnClick(int id) {
                Intent intent = new Intent(getActivity(), OrderDetails.class);
                intent.putExtra("idddddd",id);

                startActivity(intent);
            }
        });
        rec_rv.setAdapter(orderListAdapter);

    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {
        data = orderList.getData();

        List<OrderList.DataBean.ListBean> list = data.getList();
        listBeans=list;
        orderListAdapter.Load(listBeans);
        if(p==1&&list.size()==0){
            llt.setVisibility(View.GONE);
            rlt.setVisibility(View.VISIBLE);
        }else{

            if(listBeans.size()==0){
                Toast.makeText(getContext(), "没有更多了", Toast.LENGTH_SHORT).show();
            }


            rec_rv.refreshComplete();
            rec_rv.loadMoreComplete();
            orderListAdapter.notifyDataSetChanged();
            orderListAdapter.delete(new OrderListAdapter.itdelete() {
                @Override
                public void Click(int id) {

                    SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    NetUtils.getInstance().getApi().getOrderDelete(token1,id)
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
