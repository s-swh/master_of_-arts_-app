package com.wd.master_of_arts_app.fragment.myorderfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chinaums.pppay.unify.UnifyPayPlugin;
import com.chinaums.pppay.unify.UnifyPayRequest;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
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
import com.wd.master_of_arts_app.bean.QuZhiFu;
import com.wd.master_of_arts_app.bean.QuZhiFuWeChat;
import com.wd.master_of_arts_app.bean.ViewLogist;
import com.wd.master_of_arts_app.bean.WeixinOrder;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.payment.SignUpNow;
import com.wd.master_of_arts_app.payment.ViewLogistics;
import com.wd.master_of_arts_app.preanter.OrderPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

/**
 * 全部
 */
@SuppressWarnings("ALL")
public class Whole extends BaseFragment implements OrderContreater.IView {

    private int i = 2;  //支付宝支付
    private ImageView iv;
    private EditText us;
    private XRecyclerView xrv;
    private int p = 1;
    private int per = 10;
    private OrderListAdapter orderListAdapter;
    private OrderList.DataBean data;
    private List<OrderList.DataBean.ListBean> list;
    private int j;
    private LinearLayout llt;
    private LinearLayout rlt;
    private List<OrderList.DataBean.ListBean> listBeans = new ArrayList<>();

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

    }


    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreanter();
        SharedPreferences token = App.getContext().getSharedPreferences("token", MODE_PRIVATE);
        String token1 = token.getString("token", "");


        if (basePreantert instanceof OrderContreater.IPreanter) {
            ((OrderContreater.IPreanter) basePreantert).OrderSuccess(token1, "", p, per);
        }
        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                p = 1;
                orderListAdapter.Refresh(data.getList());
                BasePreantert basePreantert1 = getmPreanter();

                if (basePreantert1 instanceof OrderContreater.IPreanter) {
                    ((OrderContreater.IPreanter) basePreantert1).OrderSuccess(token1, "", p, per);
                }


                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                xrv.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onLoadMore() {
                p++;
                BasePreantert basePreantert1 = getmPreanter();
                if (basePreantert1 instanceof OrderContreater.IPreanter) {
                    ((OrderContreater.IPreanter) basePreantert1).OrderSuccess(token1, "", p, per);
                }
            }
        });
        xrv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xrv.setLayoutManager(linearLayoutManager);
        orderListAdapter = new OrderListAdapter(getActivity(), listBeans);
        xrv.setAdapter(orderListAdapter);

    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {
        data = orderList.getData();
        list = data.getList();
        listBeans = list;
        orderListAdapter.Load(listBeans);
        if (p == 1 && list.size() == 0) {
            llt.setVisibility(View.GONE);
            rlt.setVisibility(View.VISIBLE);

        }



        xrv.refreshComplete();
        xrv.loadMoreComplete();

        orderListAdapter.notifyDataSetChanged();

        orderListAdapter.OnCkQzf(new OrderListAdapter.OnClickQZF() {

            private PopupWindow popupBigPhoto;

            @Override
            public void OnClickQZF(int id, String allprice) {
                View inflate = getLayoutInflater().inflate(R.layout.qzf, null);
                if (popupBigPhoto == null) {
                    popupBigPhoto = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popupBigPhoto.setOutsideTouchable(true);

                }
                if (popupBigPhoto.isShowing()) {
                    popupBigPhoto.dismiss();
                } else {
                    popupBigPhoto.showAtLocation(inflate, Gravity.TOP, 0, 0);
                }
// 设置PopupWindow的背景
                popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);
                LinearLayout weixinzhifu = inflate.findViewById(R.id.weixinzhifu);
                LinearLayout zhifubaozhifu = inflate.findViewById(R.id.zhifubaozhifu);
                ImageView y = inflate.findViewById(R.id.y);
                ImageView n = inflate.findViewById(R.id.n);
                ImageView c = inflate.findViewById(R.id.c);
                ImageView b = inflate.findViewById(R.id.b);
                LinearLayout but = inflate.findViewById(R.id.but);
                TextView tv_money = inflate.findViewById(R.id.tv_money);
                tv_money.setText(allprice);
                RelativeLayout id_delete = inflate.findViewById(R.id.id_delete);
                id_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
                SharedPreferences sp = App.getContext().getSharedPreferences("post_acce", MODE_PRIVATE);
                int pase = sp.getInt("pase", 0);
                String access = sp.getString("access", "");

                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                        BasePreantert basePreantert = getmPreanter();
                        if (basePreantert instanceof OrderContreater.IPreanter) {
                            SharedPreferences token = App.getContext().getSharedPreferences("token", MODE_PRIVATE);
                            String token1 = token.getString("token", "");
                            if (i == 2) {

                                NetUtils.getInstance().getApi().getquzhifuzhifubao(token1, id, i)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Observer<QuZhiFu>() {
                                            @Override
                                            public void onSubscribe(Disposable d) {

                                            }

                                            @Override
                                            public void onNext(QuZhiFu quZhiFu) {


                                                QuZhiFu.PayInfoBean payInfo = quZhiFu.getPayInfo();

                                                QuZhiFu.PayInfoBean.AppPayRequestBean appPayRequest = payInfo.getAppPayRequest();
                                                String miniuser = appPayRequest.getMsgType();
                                                String qrCode = appPayRequest.getQrCode();
                                                JSONObject array_test = new JSONObject();
                                                try {
                                                    array_test.put("miniuser", miniuser);
                                                    array_test.put("qrCode", qrCode);

                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                //支付宝支付
                                                payAliPay(array_test.toString());
                                                int code = quZhiFu.getCode();

                                            }


                                            @Override
                                            public void onError(Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {

                                            }
                                        });
                            } else if (i == 1) {
                                NetUtils.getInstance().getApi().getquzhifuweixin(token1, id, i)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Observer<QuZhiFuWeChat>() {
                                            @Override
                                            public void onSubscribe(Disposable d) {

                                            }

                                            @Override
                                            public void onNext(QuZhiFuWeChat quZhiFuWeChat) {
                                                //微信
                                                QuZhiFuWeChat.PayInfoBean payInfo = quZhiFuWeChat.getPayInfo();
                                                QuZhiFuWeChat.PayInfoBean.AppPayRequestBean appPayRequest = payInfo.getAppPayRequest();
                                                if (appPayRequest != null) {

                                                    String miniuser = appPayRequest.getMiniuser();
                                                    String packageX = appPayRequest.getPackageX();
                                                    String minipath = appPayRequest.getMinipath();
                                                    String appid = appPayRequest.getAppid();
                                                    String sign = appPayRequest.getSign();
                                                    String partnerid = appPayRequest.getPartnerid();
                                                    String prepayid = appPayRequest.getPrepayid();
                                                    String noncestr = appPayRequest.getNoncestr();
                                                    String timestamp = appPayRequest.getTimestamp();
                                                    JSONObject jsonObject = new JSONObject();
                                                    try {
                                                        jsonObject.put("miniuser", miniuser);
                                                        jsonObject.put("package", packageX);
                                                        jsonObject.put("minipath", minipath);
                                                        jsonObject.put("appid", appid);
                                                        jsonObject.put("sign", sign);
                                                        jsonObject.put("partnerid", partnerid);
                                                        jsonObject.put("prepayid", prepayid);
                                                        jsonObject.put("noncestr", noncestr);
                                                        jsonObject.put("timestamp", timestamp);
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }

                                                    //微信支付
                                                    payWX(jsonObject.toString());
                                                } else {
                                                    String msg = quZhiFuWeChat.getMsg();
                                                    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                                                }


                                            }


                                            @Override
                                            public void onError(Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {

                                            }
                                        });
                            } else {
                                Toast.makeText(getContext(), "请选择微信支付或支付宝支付", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
                zhifubaozhifu.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        n.setVisibility(View.GONE);
                        y.setVisibility(View.VISIBLE);
                        b.setVisibility(View.GONE);
                        c.setVisibility(View.VISIBLE);
                        i = 2;

                    }
                });

                weixinzhifu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        b.setVisibility(View.VISIBLE);
                        c.setVisibility(View.GONE);
                        n.setVisibility(View.VISIBLE);
                        y.setVisibility(View.GONE);
                        i = 1;

                    }
                });


            }
        });
        orderListAdapter.OnClickwl(new OrderListAdapter.Ckwl() {
            @Override
            public void OnClick(String d, String w) {
                Intent intent = new Intent(getActivity(), ViewLogistics.class);
                startActivity(intent);

                EventBus.getDefault().postSticky(new ViewLogist(d, w));
            }
        });
        orderListAdapter.OnClick(new OrderListAdapter.idtet() {


            @Override
            public void OnClick(int id) {
                j = id;
                Intent intent = new Intent(getActivity(), OrderDetails.class);
                intent.putExtra("idddddd", id);

                startActivity(intent);
            }
        });
        orderListAdapter.delete(new OrderListAdapter.itdelete() {
            @Override
            public void Click(int id) {

                SharedPreferences token = App.getContext().getSharedPreferences("token", MODE_PRIVATE);
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

    /**
     * 支付宝支付
     *
     * @param url
     */
    private void payAliPay(String url) {
        UnifyPayRequest msg = new UnifyPayRequest();
        msg.payChannel = UnifyPayRequest.CHANNEL_ALIPAY;
        msg.payData = url;
        UnifyPayPlugin.getInstance(getActivity()).sendPayRequest(msg);
    }

    private void payWX(String url) {
        UnifyPayRequest msg = new UnifyPayRequest();
        msg.payChannel = UnifyPayRequest.CHANNEL_WEIXIN;
        msg.payData = url;
        Log.d("ddebug", "payWX ===> " + msg.payData);
        UnifyPayPlugin.getInstance(getActivity()).sendPayRequest(msg);
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
