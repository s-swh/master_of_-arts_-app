package com.wd.master_of_arts_app.payment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.chinaums.pppay.unify.UnifyPayPlugin;
import com.chinaums.pppay.unify.UnifyPayRequest;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.SeleteHarvest;
import com.wd.master_of_arts_app.activity.myactivity.Harvest_Address;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.DingdanXiangqing;
import com.wd.master_of_arts_app.bean.HarvestID;
import com.wd.master_of_arts_app.bean.IdNumber;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.bean.SeleteBean;
import com.wd.master_of_arts_app.bean.WeixinOrder;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignUpNow extends BaseActivity implements OrderContreater.IView {




    private int course_id;
    private int course_time_id;
    private RelativeLayout bt;
    private TextView dd_title, dd_date, dd_money, dd_zfmoney, zhifuMoney;
    private ImageView dd_img, y, n, c, b;
    private String date;
    private String img;
    private String money;
    private String title;
    private TextView tv;
    private LinearLayout zhifubaozhifu, weixinzhifu,llte;
    private int harId;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_up_now;
    }

    @Override
    protected BasePreantert initModel() {

        return new OrderPreanter(this);
    }

    @Override
    protected void initView() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        bt = findViewById(R.id.but_zf);
        dd_title = findViewById(R.id.dd_title);
        dd_date = findViewById(R.id.dd_date);
        dd_money = findViewById(R.id.dd_money);
        dd_img = findViewById(R.id.dd_img);
        dd_zfmoney = findViewById(R.id.dd_zfmoney);
        tv = findViewById(R.id.SelectDelivery);
        zhifuMoney = findViewById(R.id.zhifuMoney);
        zhifubaozhifu = findViewById(R.id.zhifubaozhifu);
        weixinzhifu = findViewById(R.id.weixinzhifu);
        llte = findViewById(R.id.llte);
        y = findViewById(R.id.y);
        n = findViewById(R.id.n);
        c = findViewById(R.id.c);
        b = findViewById(R.id.b);

        llte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SeleteHarvest.class);
                startActivity(intent);

            }


        });




    }



    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Id(HarvestID harvestID) {
        harId = harvestID.getHarId();
        String address = harvestID.getAddress();
        tv.setText(address);
    }

    private int i=2;

    @Override
    protected void initData() {

//默认填写收货地址
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        String token = sp.getString("token", "");
        NetUtils.getInstance().getApi().getSelect(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeleteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SeleteBean seleteBean) {

                        SeleteBean.DataBean data = seleteBean.getData();
                        SeleteBean.DataBean.MsgBean msg = data.getMsg();
                        String province = msg.getProvince();
                        String city = msg.getCity();
                        String county = msg.getCounty();
                        String detail_address = msg.getDetail_address();
                        tv.setText(province+city+county+detail_address);
                        int id = msg.getId();
                        harId=id;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

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
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof OrderContreater.IPreanter) {
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    if (i == 2) {

                        NetUtils.getInstance().getApi().getPurchase(token1, course_id, course_time_id, harId, i)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<Purchase>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Purchase purchase) {
                                        String msg1 = purchase.getMsg();


                                        String msg = purchase.getMsg();
                                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                                        Purchase.DataBean data = purchase.getData();
                                        if (data != null) {
                                            String order_id = data.getOrder_id();
                                            EventBus.getDefault().post(order_id);
                                            String order_num = data.getOrder_num();
                                            //String pay_price = data.getPay_price();
                                            String title = data.getTitle();
                                            String pay_price = data.getPrice();

                                            Purchase.PayInfoBean payInfo = purchase.getPayInfo();
                                            if(payInfo!=null){
                                                Purchase.PayInfoBean.AppPayRequestBean appPayRequest = payInfo.getAppPayRequest();

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
                                            }else{
                                                Toast.makeText(SignUpNow.this, msg1, Toast.LENGTH_SHORT).show();
                                            }



                                        }

                                        if (purchase.getCode() == 1) {
                                            finish();
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    } else if (i == 1) {
                        NetUtils.getInstance().getApi().getPurchaseWeiXin(token1, course_id, course_time_id, harId, i)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<WeixinOrder>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(WeixinOrder weixinOrder) {
                                        WeixinOrder.DataBean data = weixinOrder.getData();
                                        if(data!=null){
                                            WeixinOrder.PayInfoBean payInfo = weixinOrder.getPayInfo();

                                            if(payInfo!=null){
                                                WeixinOrder.PayInfoBean.AppPayRequestBean appPayRequest = payInfo.getAppPayRequest();
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
                                                    jsonObject.put("miniuser",miniuser);
                                                    jsonObject.put("package",packageX);
                                                    jsonObject.put("minipath",minipath);
                                                    jsonObject.put("appid",appid);
                                                    jsonObject.put("sign",sign);
                                                    jsonObject.put("partnerid",partnerid);
                                                    jsonObject.put("prepayid",prepayid);
                                                    jsonObject.put("noncestr",noncestr);
                                                    jsonObject.put("timestamp",timestamp);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                //微信支付
                                                payWX(jsonObject.toString());


                                                if (weixinOrder.getCode() == 1) {
                                                    finish();
                                                }
                                            }else{
                                                String msg = weixinOrder.getMsg();
                                                Toast.makeText(SignUpNow.this, msg, Toast.LENGTH_SHORT).show();
                                            }

                                        }else{
                                            String msg = weixinOrder.getMsg();
                                            Toast.makeText(SignUpNow.this, msg, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(SignUpNow.this, "请选择微信支付或支付宝支付", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        dd_title.setText(title);
        dd_date.setText("上课时间："+date);
        Log.i("xxcz", date);
        dd_money.setText(money);
        Glide.with(getApplicationContext()).load(img).into(dd_img);
        dd_zfmoney.setText("￥" + money);
        zhifuMoney.setText("￥" + money);

    }
    private void payWX(String url){
        UnifyPayRequest msg = new UnifyPayRequest();
        msg.payChannel = UnifyPayRequest.CHANNEL_WEIXIN;
        msg.payData = url;
        Log.d("ddebug","payWX ===> " + msg.payData);
        UnifyPayPlugin.getInstance(this).sendPayRequest(msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void IdNum(IdNumber idNumber) {
        course_id = idNumber.getCourse_id();
        course_time_id = idNumber.getCourse_time_id();

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Omdet(DingdanXiangqing dingdanXiangqing) {
        date = dingdanXiangqing.getDate();
        img = dingdanXiangqing.getImg();
        money = dingdanXiangqing.getMoney();
        title = dingdanXiangqing.getTitle();

    }

    @OnClick(R.id.deltfinsh)
    public void onclick() {
        finish();
    }

    @Override
    public void OnPurchase(Purchase purchase) {

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
        UnifyPayPlugin.getInstance(this).sendPayRequest(msg);
    }

    @Override
    public void OnOrderList(OrderList orderList) {

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

    private void showMsgDialog(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog dialog = new AlertDialog.Builder(SignUpNow.this).setMessage(msg).
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }

    public void toast(String click) {
        Toast.makeText(this, click, Toast.LENGTH_SHORT).show();

    }

}
