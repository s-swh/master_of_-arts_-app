package com.wd.master_of_arts_app.payment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.OrderDetails;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentId;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
// todo  付款功能
public class ToBePaid extends BaseActivity implements OrderContreater.IView {
    private TextView tv_pcty,tv_address,tv_namenumber,tv_detailstitle,tv_allprice,tv_create_time,tv_teacher_name,tv_mark,tv_order_num,tv_create,tv_pay_price,tv_allpricec;
    private RelativeLayout success,fail,shost;
    private Button ckwl,qpj;

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
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof OrderContreater.IPreanter){
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            Intent intent = getIntent();
            int idddddd = intent.getIntExtra("idddddd", 0);
            EventBus.getDefault().postSticky(new CommentId(idddddd));
            ((OrderContreater.IPreanter) basePreantert).OnOrderdetailsSuccess(token1,idddddd);
        }
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
