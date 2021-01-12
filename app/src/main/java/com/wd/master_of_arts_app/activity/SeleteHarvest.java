package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.myactivity.Harvest_Address;
import com.wd.master_of_arts_app.adapter.HarvestAddressAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestID;
import com.wd.master_of_arts_app.bean.SeleteBean;
import com.wd.master_of_arts_app.bean.UpdateShipping;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;
import com.wd.master_of_arts_app.contreater.HarvestAddressContreater;
import com.wd.master_of_arts_app.preanter.HarvestAddressPreanter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.OnClick;

public class SeleteHarvest extends BaseActivity implements HarvestAddressContreater.IView {

    private RecyclerView rv;
    private HarvestAddressAdapter harvestAddressAdapter;
    private TextView tv_name, tv_phone, tv_acce;
    private ImageView lt;
    private LinearLayout add,lllt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selete_harvest;
    }

    @Override
    protected BasePreantert initModel() {
        return new HarvestAddressPreanter(this);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.Harvest_rv);
        tv_name = findViewById(R.id.text_name);
        tv_phone = findViewById(R.id.text_phone);
        tv_acce = findViewById(R.id.text_acceccte);
        lllt = findViewById(R.id.lllt);
        lt = findViewById(R.id.lt);
        add = findViewById(R.id.addres);
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @OnClick({R.id.add_address, R.id.add_addres})
    public void OnAdd_Address(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.add_address:
                startActivity(new Intent(getApplicationContext(), Add_Address.class));
                break;
            case R.id.add_addres:
                startActivity(new Intent(getApplicationContext(), Add_Address.class));
                break;
            default:
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof HarvestAddressContreater.IPreanter) {
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            ((HarvestAddressContreater.IPreanter) basePreantert).ViewHarvestAddressSuccess(token1);
            ((HarvestAddressContreater.IPreanter) basePreantert).OnSelectSucess(token1);
        }
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void AddHarverst(HarvestAddress harvestAddress) {

    }

    //收获地址列表
    @Override
    public void ViewHarvestAddress(ViewHarvestAddress viewHarvestAddress) {
        ViewHarvestAddress.DataBean data = viewHarvestAddress.getData();
        List<ViewHarvestAddress.DataBean.ListBean> list = data.getList();
        harvestAddressAdapter = new HarvestAddressAdapter(getApplicationContext(), list);
        rv.setAdapter(harvestAddressAdapter);
        harvestAddressAdapter.OnId(new HarvestAddressAdapter.OnIdClick() {
            @Override
            public void OnidClick(int id) {

                EventBus.getDefault().postSticky(new HarvestID(id));
                finish();
            }
        });
        harvestAddressAdapter.onclick(new HarvestAddressAdapter.OnCliack() {
            @Override
            public void onclick(ViewHarvestAddress.DataBean.ListBean listBean) {
                int id1c = listBean.getId();
                String province = listBean.getProvince();
                String city = listBean.getCity();
                String county = listBean.getCounty();
                String detail_address = listBean.getDetail_address();
                String consignee = listBean.getConsignee();
                String contact_number = listBean.getContact_number();
                String is_default = listBean.getIs_default();


                Toast.makeText(getApplicationContext(), id1c + "", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), EditShippingAddress.class);
                intent.putExtra("idc1", id1c);
                intent.putExtra("province", province);
                intent.putExtra("city", city);
                intent.putExtra("county", county);
                intent.putExtra("detail_address", detail_address);
                intent.putExtra("consignee", consignee);
                intent.putExtra("contact_number", contact_number);
                intent.putExtra("is_default", is_default);

                startActivity(intent);

            }
        });
    }

    //删除地址
    @Override
    public void DeleteHarvest(DeleteHarvestAddress deleteHarvestAddress) {

    }

    //修改收货地址
    @Override
    public void Update(UpdateShipping updateShipping) {

    }

    @Override
    public void SelectBean(SeleteBean seleteBean) {

        SeleteBean.DataBean data = seleteBean.getData();
        SeleteBean.DataBean.MsgBean msg = data.getMsg();
        String consignee = msg.getConsignee();
        String province = msg.getProvince();
        String city = msg.getCity();
        String county = msg.getCounty();
        int id1c = msg.getId();
        String detail_address = msg.getDetail_address();
        String contact_number = msg.getContact_number();
        String is_default = msg.getIs_default();

            tv_name.setText(consignee);
            tv_phone.setText(contact_number);
            tv_acce.setText(province + "" + city + "" + county + "" + detail_address);
        lllt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = msg.getId();

                EventBus.getDefault().postSticky(new HarvestID(id));
                String sqe = tv_acce.getText().toString();
                EventBus.getDefault().postSticky(sqe);
                SharedPreferences pa = getSharedPreferences("post_acce", MODE_PRIVATE);
                SharedPreferences.Editor edit = pa.edit();
                edit.putInt("pase",id);
                edit.putString("access",sqe);
                edit.commit();
                finish();

            }
        });
            lt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(SeleteHarvest.this, EditShippingAddress.class);
                    intent.putExtra("idc1", id1c);
                    intent.putExtra("province", province);
                    intent.putExtra("city", city);
                    intent.putExtra("county", county);
                    intent.putExtra("detail_address", detail_address);
                    intent.putExtra("consignee", consignee);
                    intent.putExtra("contact_number", contact_number);
                    intent.putExtra("is_default", is_default);

                    startActivity(intent);
                }
            });


    }
}
