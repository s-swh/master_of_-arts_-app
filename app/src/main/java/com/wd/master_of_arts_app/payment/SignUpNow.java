package com.wd.master_of_arts_app.payment;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.chinaums.pppay.unify.UnifyPayPlugin;
import com.chinaums.pppay.unify.UnifyPayRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.myactivity.Harvest_Address;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.DingdanXiangqing;
import com.wd.master_of_arts_app.bean.IdNumber;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.CoursePreanter;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;

public class SignUpNow extends BaseActivity implements OrderContreater.IView {


    private int course_id;
    private int course_time_id;
    private TextView bt;
    private TextView dd_title, dd_date, dd_money, dd_zfmoney, zhifuMoney;
    private ImageView dd_img, y, n, c, b;
    private String date;
    private String img;
    private String money;
    private String title;
    private TextView tv;
    private LinearLayout zhifubaozhifu, weixinzhifu;

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
        y = findViewById(R.id.y);
        n = findViewById(R.id.n);
        c = findViewById(R.id.c);
        b = findViewById(R.id.b);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Harvest_Address.class);
                startActivity(intent);

            }


        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void String(String string) {
        tv.setText(string);
    }

    @Override
    protected void initData() {
        zhifubaozhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n.setVisibility(View.GONE);
                y.setVisibility(View.VISIBLE);
                b.setVisibility(View.GONE);
                c.setVisibility(View.VISIBLE);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SignUpNow.this, "支付宝支付", Toast.LENGTH_SHORT).show();
                        BasePreantert basePreantert = getmPreantert();
                        if (basePreantert instanceof OrderContreater.IPreanter) {
                            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                            String token1 = token.getString("token", "");
                            SharedPreferences addid = getSharedPreferences("addid", MODE_PRIVATE);
                            int id = addid.getInt("id", 0);
                            ((OrderContreater.IPreanter) basePreantert).OnPruchaseSuccess(token1, course_id, course_time_id, id);

                        }
                    }
                });
            }
        });
        weixinzhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setVisibility(View.VISIBLE);
                c.setVisibility(View.GONE);
                n.setVisibility(View.VISIBLE);
                y.setVisibility(View.GONE);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SignUpNow.this, "微信支付", Toast.LENGTH_SHORT).show();
                        BasePreantert basePreantert = getmPreantert();
                        if (basePreantert instanceof OrderContreater.IPreanter) {
                            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                            String token1 = token.getString("token", "");
                            SharedPreferences addid = getSharedPreferences("addid", MODE_PRIVATE);
                            int id = addid.getInt("id", 0);

                            ((OrderContreater.IPreanter) basePreantert).OnPruchaseSuccess(token1, course_id, course_time_id, id);

                        }
                    }
                });
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpNow.this, "请选择支付宝支付或微信支付", Toast.LENGTH_SHORT).show();
            }
        });
        dd_title.setText(title);
        dd_date.setText(date);
        Log.i("xxcz", date);
        dd_money.setText(money);
        Glide.with(getApplicationContext()).load(img).into(dd_img);
        dd_zfmoney.setText("￥" + money);
        zhifuMoney.setText("￥" + money);

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
        String msg = purchase.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Purchase.DataBean data = purchase.getData();
        if (data != null) {
            String order_id = data.getOrder_id();
            EventBus.getDefault().post(order_id);
            String order_num = data.getOrder_num();
            //String pay_price = data.getPay_price();
            String title = data.getTitle();
            String pay_price = data.getPrice();

            Purchase.PayInfoBean payInfo = purchase.getPayInfo();
            Purchase.PayInfoBean.AppPayRequestBean appPayRequest = payInfo.getAppPayRequest();
            String miniuser = appPayRequest.getMiniuser();
            String msgType = appPayRequest.getMsgType();
            String package1 = appPayRequest.getPackage1();
            String minipath = appPayRequest.getMinipath();
            String appScheme = appPayRequest.getAppScheme();
            String sign = appPayRequest.getSign();
            String prepayid = appPayRequest.getPrepayid();
            String noncestr = appPayRequest.getNoncestr();
            String timestamp = appPayRequest.getTimestamp();
            HashMap<String, String> map = new HashMap<>();
            JSONObject array_test = new JSONObject();
            try {
                array_test.put("miniuser", miniuser);
                array_test.put("msgType", msgType);
                array_test.put("package", package1);
                array_test.put("minipath", minipath);
                array_test.put("appScheme", appScheme);
                array_test.put("sign", sign);
                array_test.put("prepayid", prepayid);
                array_test.put("noncestr", noncestr);
                array_test.put("timestamp", timestamp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            payAliPayMiniPro(array_test.toString());

        }

        if (purchase.getCode() == 1) {
            finish();
        }
    }

    private void payAliPayMiniPro(String url) {
        UnifyPayRequest msg = new UnifyPayRequest();
        msg.payChannel = UnifyPayRequest.CHANNEL_ALIPAY_MINI_PROGRAM;
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
