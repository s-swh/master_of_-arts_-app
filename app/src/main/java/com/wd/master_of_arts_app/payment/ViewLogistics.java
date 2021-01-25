package com.wd.master_of_arts_app.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.ViewLogAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Logistics;
import com.wd.master_of_arts_app.bean.ViewLogist;
import com.wd.master_of_arts_app.contreater.ViewLogisticsConreater;
import com.wd.master_of_arts_app.preanter.ViewLogisticsPreanter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ViewLogistics extends BaseActivity implements ViewLogisticsConreater.IView {


    private RecyclerView rv;
    private TextView carrierCompany,Num;
    private ImageView view_return;
    private LinearLayout wsj;
    private String logistics;
    private String express_number;
    private LinearLayout view_gone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_logistics;
    }

    @Override
    protected BasePreantert initModel() {
        return new ViewLogisticsPreanter(this);
    }

    @Override
    protected void initView() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        rv = findViewById(R.id.view_recy);
        carrierCompany = findViewById(R.id.CarrierCompany);
        Num = findViewById(R.id.ExpressNumber);
        wsj = findViewById(R.id.wsj);
        view_return = findViewById(R.id.view_return);
        view_gone = findViewById(R.id.view_gone);
        view_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void ViewLogist(ViewLogist logist){
        logistics = logist.getLogistics();
        express_number = logist.getExpress_number();



    }
    @Override
    protected void initData() {
        SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
        String token1 = token.getString("token", "");
        BasePreantert basePreantert = getmPreantert();
        if(!logistics.isEmpty()&&!express_number.isEmpty()){
            if(basePreantert instanceof ViewLogisticsConreater.IPreanter){
                ((ViewLogisticsConreater.IPreanter) basePreantert).OnViewLoginsticsSuccess(token1, express_number,logistics);
            }
        }else{
            wsj.setVisibility(View.VISIBLE);
            view_gone.setVisibility(View.GONE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void OnViewLogistics(Logistics logistics) {
        if(logistics.getData()!=null){
        Logistics.DataBean data = logistics.getData();

                Logistics.DataBean.LogisticsMsgBean logisticsMsg = data.getLogisticsMsg();

                String company = logisticsMsg.getCompany();
                String no = logisticsMsg.getNo();
                carrierCompany.setText(company);
                Num.setText(no);
                List<Logistics.DataBean.LogisticsMsgBean.ListBean> list = logisticsMsg.getList();
                ViewLogAdapter viewLogAdapter = new ViewLogAdapter(getApplicationContext(), list);
                rv.setAdapter(viewLogAdapter);
            }else{
                String msg = logistics.getMsg();
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }





    }
}
