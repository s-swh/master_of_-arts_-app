package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentId;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.bean.ViewLogist;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.payment.ViewLogistics;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
// todo  付款功能
public class OrderDetails extends BaseActivity implements OrderContreater.IView {


    private TextView tv_pcty, tv_address, tv_namenumber, tv_detailstitle, tv_allprice, tv_create_time, tv_teacher_name, tv_mark, tv_order_num, tv_create, tv_pay_price, tv_allpricec, ckwl, qpj;
    private RelativeLayout success, fail, shost, fai2,shost1;
    private ImageView details_return;
    private Button ckwl1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_details;
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
        details_return = findViewById(R.id.details_return);
        fai2 = findViewById(R.id.fai2);
        shost1 = findViewById(R.id.shost1);
        ckwl1 = findViewById(R.id.ckwl1);
    }

    @Override
    protected void initData() {
        ckwl1.setOnClickListener(new View.OnClickListener() {
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
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof OrderContreater.IPreanter) {
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            Intent intent = getIntent();
            int idddddd = intent.getIntExtra("idddddd", 0);
            EventBus.getDefault().postSticky(new CommentId(idddddd));
            ((OrderContreater.IPreanter) basePreantert).OnOrderdetailsSuccess(token1, idddddd);
        }
        ckwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetails.this, ViewLogistics.class);
                startActivity(intent);
            }
        });
        details_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        qpj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetails.this, OrderComment.class);
                startActivity(intent);
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
    }

    @Override
    public void OnOrderdetails(CourseOrderBean orderBean) {
        CourseOrderBean.DataBean data = orderBean.getData();
        CourseOrderBean.DataBean.OrderMsgBean orderMsg = data.getOrderMsg();
        int status = orderMsg.getStatus();
        if (status == 2) {
            success.setVisibility(View.VISIBLE);
            fail.setVisibility(View.GONE);
            fai2.setVisibility(View.GONE);
            shost1.setVisibility(View.GONE);
            shost.setVisibility(View.VISIBLE);
        } else if (status == 3) {
            success.setVisibility(View.VISIBLE);
            fail.setVisibility(View.GONE);
            fai2.setVisibility(View.GONE);
            shost1.setVisibility(View.GONE);
            shost.setVisibility(View.VISIBLE);
        } else if (status == 1) {
            fai2.setVisibility(View.VISIBLE);
            fail.setVisibility(View.GONE);
            shost.setVisibility(View.GONE);
            success.setVisibility(View.GONE);
            shost1.setVisibility(View.VISIBLE);
        } else {
            success.setVisibility(View.GONE);
            shost.setVisibility(View.GONE);
            fail.setVisibility(View.GONE);
            shost1.setVisibility(View.GONE);

        }
        String province = orderMsg.getProvince();
        String logistics = orderMsg.getLogistics();
        String express_number = orderMsg.getExpress_number();
        SharedPreferences express = getSharedPreferences("express", MODE_PRIVATE);
        SharedPreferences.Editor edit = express.edit();
        edit.putString("logistics", logistics);
        edit.putString("express_number", express_number);
        edit.commit();
        EventBus.getDefault().postSticky(new ViewLogist(logistics, express_number));
        String city = orderMsg.getCity();
        String county = orderMsg.getCounty();
        String address = orderMsg.getAddress();
        tv_pcty.setText(province + city + city);
        tv_address.setText(address);
        String consignee = orderMsg.getConsignee();
        String contact_number = orderMsg.getContact_number();
        String title = orderMsg.getTitle();
        tv_detailstitle.setText(title);
        String allprice = orderMsg.getAllprice();
        tv_namenumber.setText(consignee + contact_number);
        tv_allprice.setText(allprice);
        String create_time = orderMsg.getCreate_time();
        tv_create_time.setText(create_time);
        CourseOrderBean.DataBean.OrderMsgBean.CourseDetailBean course_detail = orderMsg.getCourse_detail();

        String first_class_time = course_detail.getFirst_class_time();
        String first_class_date = course_detail.getFirst_class_date();
        tv_teacher_name.setText(first_class_date + first_class_time);
        List<CourseOrderBean.DataBean.OrderMsgBean.CourseDetailBean.MarkBean> mark = course_detail.getMark();
        String mark1 = mark.get(0).getMark();
        tv_mark.setText(mark1);
        String order_num = orderMsg.getOrder_num();
        tv_order_num.setText("订单号：" + order_num);
        String create_time1 = orderMsg.getCreate_time();
        tv_create.setText(create_time1);
        String pay_price = orderMsg.getPay_price();
        tv_pay_price.setText(pay_price);
        tv_allpricec.setText(allprice);
    }

    //评论
    @Override
    public void OnComment(CommentOrder commentOrder) {

    }
}
