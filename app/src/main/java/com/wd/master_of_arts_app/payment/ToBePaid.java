package com.wd.master_of_arts_app.payment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chinaums.pppay.unify.UnifyPayPlugin;
import com.chinaums.pppay.unify.UnifyPayRequest;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.OrderDetails;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentId;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.bean.QuZhiFu;
import com.wd.master_of_arts_app.bean.QuZhiFuWeChat;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

// todo  付款功能
public class ToBePaid extends BaseActivity implements OrderContreater.IView {
    private TextView tv_pcty,tv_address,tv_namenumber,tv_detailstitle,tv_allprice,tv_create_time,tv_teacher_name,tv_mark,tv_order_num,tv_create,tv_pay_price,tv_allpricec;
    private RelativeLayout success,fail,shost;
    private Button ckwl,qpj;
    private ImageView dingdan_finsh;
    private int idddddd;
    private String token1;
    private int i;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_to_be_paid2;
    }

    @Override
    protected BasePreantert initModel() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView() {
        tv_pcty = findViewById(R.id.tv_Provinceandcity);
        tv_address = findViewById(R.id.tv_address);
        tv_namenumber = findViewById(R.id.tv_namenumber);
        tv_detailstitle = findViewById(R.id.tv_detailstitle);
        tv_allprice = findViewById(R.id.tv_allprice);
        tv_create_time = findViewById(R.id.tv_create_time);
        tv_teacher_name = findViewById(R.id.tv_teacher_name);
        tv_mark = findViewById(R.id.tv_mark);
        success = findViewById(R.id.success);
        fail = findViewById(R.id.fail);
        tv_order_num = findViewById(R.id.tv_order_num);
        tv_create = findViewById(R.id.tv_create_time);
        tv_pay_price = findViewById(R.id.tv_pay_price);
        tv_allpricec = findViewById(R.id.tv_allpricec);
        shost = findViewById(R.id.shost);
        ckwl = findViewById(R.id.ckwl);
        qpj = findViewById(R.id.qpj);
        dingdan_finsh = findViewById(R.id.dingdan_finsh);
    }

    @Override
    protected void initData() {

        dingdan_finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof OrderContreater.IPreanter){
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            token1 = token.getString("token", "");
            Intent intent = getIntent();
            idddddd = intent.getIntExtra("idddddd", 0);
            EventBus.getDefault().postSticky(new CommentId(idddddd));
            ((OrderContreater.IPreanter) basePreantert).OnOrderdetailsSuccess(token1, idddddd);
        }
        qpj.setOnClickListener(new View.OnClickListener() {

            private PopupWindow popupBigPhoto;

            @Override
            public void onClick(View view) {
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
                        BasePreantert basePreantert = getmPreantert();
                        if (basePreantert instanceof OrderContreater.IPreanter) {
                            SharedPreferences token = App.getContext().getSharedPreferences("token", MODE_PRIVATE);
                            String token1 = token.getString("token", "");
                            if (i == 2) {

                                NetUtils.getInstance().getApi().getquzhifuzhifubao(token1, idddddd, i)
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
                                NetUtils.getInstance().getApi().getquzhifuweixin(token1, idddddd, i)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Observer<QuZhiFuWeChat>() {
                                            @Override
                                            public void onSubscribe(Disposable d) {

                                            }

                                            @Override
                                            public void onNext(QuZhiFuWeChat quZhiFuWeChat) {
                                                //微信
                                                 /*   QuZhiFu.PayInfoBean payInfo = quZhiFu.getPayInfo();
                                                    QuZhiFu.PayInfoBean.AppPayRequestBean appPayRequest = payInfo.getAppPayRequest();
                                                    String packageX = appPayRequest.getPackageX();

                                                    String appid = appPayRequest.getAppid();
                                                    String sign = appPayRequest.getSign();
                                                    String partnerid = appPayRequest.getPartnerid();
                                                    String prepayid = appPayRequest.getPrepayid();
                                                    String noncestr = appPayRequest.getNoncestr();
                                                    String timestamp = appPayRequest.getTimestamp();
                                                    JSONObject jsonObject = new JSONObject();
                                                    try {
                                                        jsonObject.put("package", packageX);
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
                                                    payWX(jsonObject.toString());*/


                                            }


                                            @Override
                                            public void onError(Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {

                                            }
                                        });
                            } else {
                                Toast.makeText(getApplicationContext(), "请选择微信支付或支付宝支付", Toast.LENGTH_SHORT).show();
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
        ckwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof OrderContreater.IPreanter){
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    Intent intent = getIntent();
                    int idddddd = intent.getIntExtra("idddddd", 0);
                    EventBus.getDefault().postSticky(new CommentId(idddddd));
                    ((OrderContreater.IPreanter) basePreantert).OnCancelSuccess(token1,idddddd+"");
                }
            }
        });
    }

    @Override
    public void OnPurchase(Purchase purchase) {

    }

    @Override
    public void OnOrderList(OrderList orderList) {

    }

    @Override
    public void OnCancel(CancellationOfOrder cancellationOfOrder) {
        String msg = cancellationOfOrder.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        int code = cancellationOfOrder.getCode();
        if(code==1){
            finish();
        }
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
        UnifyPayPlugin.getInstance(getApplicationContext()).sendPayRequest(msg);
    }

    private void payWX(String url) {
        UnifyPayRequest msg = new UnifyPayRequest();
        msg.payChannel = UnifyPayRequest.CHANNEL_WEIXIN;
        msg.payData = url;
        Log.d("ddebug", "payWX ===> " + msg.payData);
        UnifyPayPlugin.getInstance(getApplicationContext()).sendPayRequest(msg);
    }
    @Override
    public void OnOrderdetails(CourseOrderBean orderBean) {
        CourseOrderBean.DataBean data = orderBean.getData();
        CourseOrderBean.DataBean.OrderMsgBean orderMsg = data.getOrderMsg();

        int status = orderMsg.getStatus();

        String province = orderMsg.getProvince();
        String city = orderMsg.getCity();
        String county = orderMsg.getCounty();
        String address = orderMsg.getAddress();
        tv_pcty.setText(province+city+city);
        tv_address.setText(address);
        String consignee = orderMsg.getConsignee();
        String contact_number = orderMsg.getContact_number();
        String title = orderMsg.getTitle();
        tv_detailstitle.setText(title);
        String allprice = orderMsg.getAllprice();
        tv_namenumber.setText(consignee+contact_number);
        tv_allprice.setText(allprice);
        String create_time = orderMsg.getCreate_time();
        tv_create_time.setText(create_time);
        CourseOrderBean.DataBean.OrderMsgBean.CourseDetailBean course_detail = orderMsg.getCourse_detail();

        String first_class_time = course_detail.getFirst_class_time();
        String first_class_date = course_detail.getFirst_class_date();
        tv_teacher_name.setText(first_class_date+first_class_time);
        List<CourseOrderBean.DataBean.OrderMsgBean.CourseDetailBean.MarkBean> mark = course_detail.getMark();
        String mark1 = mark.get(0).getMark();
        tv_mark.setText(mark1);
        String order_num = orderMsg.getOrder_num();
        tv_order_num.setText("订单号："+order_num);
        String create_time1 = orderMsg.getCreate_time();
        tv_create.setText(create_time1);
        String pay_price = orderMsg.getPay_price();
        tv_pay_price.setText(pay_price);
        tv_allpricec.setText(allprice);

    }

    @Override
    public void OnComment(CommentOrder commentOrder) {

    }
}
