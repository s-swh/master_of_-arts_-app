package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
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
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.preanter.OrderPreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OrderComment extends BaseActivity implements OrderContreater.IView {


    private RatingBar rba;
    private String token1;
    private EditText et_context;
    public    int i;
    private Button fub;
    private int j;
    private ImageView return_fn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_comment;
    }

    @Override
    protected BasePreantert initModel() {
        return new OrderPreanter(this);
    }

    @Override
    protected void initView() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        rba = findViewById(R.id.rba);
        et_context = findViewById(R.id.et_context);
        fub = findViewById(R.id.fub);
        return_fn = findViewById(R.id.return_fn);

    }
        @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
        public void id(CommentId commentId){
            j = commentId.getId();
        }
    @Override
    protected void initData() {
        return_fn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rba.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {



            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                i = (int) v;
                Toast.makeText(OrderComment.this, i +"", Toast.LENGTH_SHORT).show();
            }
        });


        fub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof OrderContreater.IPreanter){
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    token1 = token.getString("token", "");
                    String string = et_context.getText().toString();
                    ((OrderContreater.IPreanter) basePreantert).OnCommentSuccess(token1,j,i,string);
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

    }

    @Override
    public void OnOrderdetails(CourseOrderBean orderBean) {

    }

    @Override
    public void OnComment(CommentOrder commentOrder) {
        String msg = commentOrder.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        int code = commentOrder.getCode();
        if(code==1){
            finish();
        }
    }
}
