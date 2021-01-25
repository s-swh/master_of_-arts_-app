package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.SeleteBean;
import com.wd.master_of_arts_app.bean.UpdateShipping;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;
import com.wd.master_of_arts_app.contreater.HarvestAddressContreater;
import com.wd.master_of_arts_app.preanter.HarvestAddressPreanter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class Add_Address extends BaseActivity implements View.OnClickListener ,HarvestAddressContreater.IView{


    private RelativeLayout mAddress;
    @BindView(R.id.txtvw)
    TextView tv;
     TextView   tx_tv;
    private EditText et_name, et_pe, et_jd;
    private CheckBox ck;
    private Button but;
    private String trim2;
    private String trim1;
    private String trim;
    private String s;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add__address;
    }

    @Override
    protected BasePreantert initModel() {
        return new HarvestAddressPreanter(this);
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @OnClick(R.id.harvestarea)
    public void OnHavestarea() {
        mAddress = findViewById(R.id.harvestarea);
        mAddress.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        et_name = findViewById(R.id.et_name);
        et_pe = findViewById(R.id.et_pne);
        tx_tv = findViewById(R.id.txtvw);
        et_jd = findViewById(R.id.et_jd);
        ck = findViewById(R.id.check);
        but = findViewById(R.id.but_add);
    }

    @Override
    protected void initData() {

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof HarvestAddressContreater.IPreanter){
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    String jd = et_jd.getText().toString();
                    String name = et_name.getText().toString();
                    String et = et_pe.getText().toString();
                    if(ck.isChecked()){
                        s = "Y";
                    }else{
                        s="N";
                    }
                    ((HarvestAddressContreater.IPreanter) basePreantert).AddHarverstSuccess(token1,trim,trim1,trim2,jd,"",name,et,"",s);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        selectAddress();
    }

    private void selectAddress() {

        CityPicker cityPicker = new CityPicker.Builder(Add_Address.this)

                .textSize(14)

                .title("地址选择")

                .titleBackgroundColor("#FFFFFF")

//                .titleTextColor("#696969")

                .confirTextColor("#696969")

                .cancelTextColor("#696969")

                .province("北京市")

                .city("北京市")

                .district("朝阳区")

                .textColor(Color.parseColor("#000000"))

                .provinceCyclic(true)

                .cityCyclic(false)

                .districtCyclic(false)

                .visibleItemsCount(7)

                .itemPadding(15)

                .onlyShowProvinceAndCity(false)

                .build();

        cityPicker.show();

        //监听方法，获取选择结果

        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {



            @Override

            public void onSelected(String... citySelected) {

                //省份

                String province = citySelected[0];
                trim = province.trim();

                //城市

                String city = citySelected[1];
                trim1 = city.trim();
                //区县（如果设定了两级联动，那么该项返回空）

                String district = citySelected[2];
                trim2 = district.trim();
                //邮编

                String code = citySelected[3];

                //为TextView赋值

                tv.setText(province.trim() + city.trim() + district.trim());

            }

        });

    }
    //添加地址列表
    @Override
    public void AddHarverst(HarvestAddress harvestAddress) {
        HarvestAddress.DataBean data = harvestAddress.getData();
        String id = data.getId();
        int code = harvestAddress.getCode();
        if(code==1){
            finish();
        }else{
            String msg = harvestAddress.getMsg();
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        String msg = harvestAddress.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    //收获地址列表
    @Override
    public void ViewHarvestAddress(ViewHarvestAddress viewHarvestAddress) {

    }
    // 删除
    @Override
    public void DeleteHarvest(DeleteHarvestAddress deleteHarvestAddress) {

    }
    //修改
    @Override
    public void Update(UpdateShipping updateShipping) {

    }

    @Override
    public void SelectBean(SeleteBean seleteBean) {

    }
}
