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
import com.wd.master_of_arts_app.bean.ViewLogist;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.payment.ViewLogistics;
import com.wd.master_of_arts_app.preanter.OrderPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 全部
 */
@SuppressWarnings("ALL")
public class Whole extends BaseFragment implements OrderContreater.IView {


    private ImageView iv;
    private EditText us;
    private XRecyclerView xrv;
    private int p;
    private int per;
    private OrderListAdapter orderListAdapter;
    private OrderList.DataBean data;
    private List<OrderList.DataBean.ListBean> list;
    private int j;
    private LinearLayout llt;
    private RelativeLayout rlt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_whole;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView(View inflate) {
        iv = inflate.findViewById(R.id.cloat);
        us = inflate.findViewById(R.id.username);
        xrv = inflate.findViewById(R.id.order_xrv);
        llt = inflate.findViewById(R.id.llt);
        rlt = inflate.findViewById(R.id.rlt);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xrv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof OrderContreater.IPreanter) {
            SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");

            per = 10;
            xrv.setLoadingMoreEnabled(true);
            xrv.setPullRefreshEnabled(true);
            xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    p = 1;
                    ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, "", p, per);
                    orderListAdapter.Refresh(data.getList());
                    xrv.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    p++;
                    orderListAdapter.Load(data.getList());
                    xrv.loadMoreComplete();
                }
            });

            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, "", p, per);

        }
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        us.setText("");
                    }
                }).start();
            }
        });
    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {
        data = orderList.getData();
        list = data.getList();
        if (list.size() == 0) {
            llt.setVisibility(View.GONE);
            rlt.setVisibility(View.VISIBLE);
        } else {
            orderListAdapter = new OrderListAdapter(getActivity(), this.list);


            orderListAdapter.OnClickwl(new OrderListAdapter.Ckwl() {
                @Override
                public void OnClick(OrderList.DataBean.ListBean listBean) {
                    Intent intent = new Intent(getActivity(), ViewLogistics.class);
                    String express_number = listBean.getExpress_number();
                    String logistics = listBean.getLogistics();

                    startActivity(intent);
                    EventBus.getDefault().postSticky(new ViewLogist(logistics, express_number));
                }
            });
            orderListAdapter.OnClick(new OrderListAdapter.idtet() {


                @Override
                public void OnClick(int id) {
                    j = id;
                    Intent intent = new Intent(getActivity(), OrderDetails.class);
                    intent.putExtra("idddddd", id);
                    Toast.makeText(getActivity(), id + "", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            xrv.setAdapter(orderListAdapter);
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
