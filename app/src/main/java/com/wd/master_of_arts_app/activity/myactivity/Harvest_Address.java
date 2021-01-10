package com.wd.master_of_arts_app.activity.myactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Add_Address;
import com.wd.master_of_arts_app.activity.EditShippingAddress;
import com.wd.master_of_arts_app.adapter.HarvestAddressAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestID;
import com.wd.master_of_arts_app.bean.UpdateShipping;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;
import com.wd.master_of_arts_app.contreater.HarvestAddressContreater;
import com.wd.master_of_arts_app.preanter.HarvestAddressPreanter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.OnClick;

/**
 * 收获地址
 */
public class Harvest_Address extends BaseActivity implements HarvestAddressContreater.IView{


    private RecyclerView rv;
    private HarvestAddressAdapter harvestAddressAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_harvest__address;
    }

    @Override
    protected BasePreantert initModel() {
        return new HarvestAddressPreanter(this);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.Harvest_rv);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @OnClick({R.id.add_address,R.id.add_addres})
    public void OnAdd_Address(View view){
        int id = view.getId();
        switch (id){
            case R.id.add_address:  startActivity(new Intent(getApplicationContext(), Add_Address.class));    break;
            case R.id.add_addres:  startActivity(new Intent(getApplicationContext(), Add_Address.class));    break;
            default:break;
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
        if(basePreantert instanceof HarvestAddressContreater.IPreanter){
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            ((HarvestAddressContreater.IPreanter) basePreantert).ViewHarvestAddressSuccess(token1);
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


                Toast.makeText(Harvest_Address.this, id1c+"", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Harvest_Address.this, EditShippingAddress.class);
                intent.putExtra("idc1",id1c);
                intent.putExtra("province",province);
                intent.putExtra("city",city);
                intent.putExtra("county",county);
                intent.putExtra("detail_address",detail_address);
                intent.putExtra("consignee",consignee);
                intent.putExtra("contact_number",contact_number);
                intent.putExtra("is_default",is_default);

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
}
