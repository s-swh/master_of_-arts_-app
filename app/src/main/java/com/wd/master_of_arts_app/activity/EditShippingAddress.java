package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

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
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class EditShippingAddress extends BaseActivity implements HarvestAddressContreater.IView {
    public String trim2;
    public String trim1;
    public String trim;

    @BindView(R.id.oncDestruction)
    ImageView oncDestruction;

    TextView delete;

    EditText etName;

    EditText etPne;

    TextView txtvw;


    EditText etJd;

    CheckBox check;

    Button butAdd;

    public RelativeLayout mAddress;
    public int idc1;
    public String province;
    public String city;
    public String county;
    public String detail_address;
    public String consignee;
    public String contact_number;
    public String is_default;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_shipping_address;
    }

    @Override
    protected BasePreantert initModel() {
        return new HarvestAddressPreanter(this);
    }

    @Override
    protected void initView() {
        etName = findViewById(R.id.et_name);
        etPne = findViewById(R.id.et_pne);
        txtvw = findViewById(R.id.txtvw);
        etJd = findViewById(R.id.et_jd);
        check = findViewById(R.id.check1);
        mAddress = findViewById(R.id.harvestarea);
        delete = findViewById(R.id.Delete);
        butAdd = findViewById(R.id.but_add);
        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectAddress();
            }


        });
    }

    private void selectAddress() {

        CityPicker cityPicker = new CityPicker.Builder(EditShippingAddress.this)

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

                txtvw.setText(province.trim() + city.trim() + district.trim());

            }

        });

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        idc1 = intent.getIntExtra("idc1", 0);
        province = intent.getStringExtra("province");
        city = intent.getStringExtra("city");
        county = intent.getStringExtra("county");
        detail_address = intent.getStringExtra("detail_address");
        consignee = intent.getStringExtra("consignee");
        contact_number = intent.getStringExtra("contact_number");
        is_default = intent.getStringExtra("is_default");
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        String token = sp.getString("token", "");
        etName.setText(consignee);
        etPne.setText(contact_number);
        txtvw.setText(province + city + county);
        etJd.setText(detail_address);
        if (is_default.equals("Y")) {
            check.setChecked(true);
        } else {
            check.setChecked(false);
        }
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof HarvestAddressContreater.IPreanter) {
                    ((HarvestAddressContreater.IPreanter) basePreantert).DeleteHarvestSuccess(token, idc1 + "");
                }
            }
        });
        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initt();
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof HarvestAddressContreater.IPreanter) {
                    String name = etName.getText().toString();
                    String phone = etPne.getText().toString();

                    String s;
                    if (check.isChecked()) {
                        s = "Y";
                    } else {
                        s = "N";
                    }
                    String jd = etJd.getText().toString();
                    String j, p, g; //定义三个字符串
                    if (trim == null) {  //通过省的字符串进行判断 如果省为空那么就走else方法进行赋值  如果省不为空那么就是把之前的省市区不改变
                        j = province;
                        p = city;
                        g = county;
                    } else {
                        j = trim;
                        p = trim1;
                        g = trim2;
                    }

                    ((HarvestAddressContreater.IPreanter) basePreantert).UpdateSuccess(token, idc1, j, p, g, jd, name, phone, s);
                }
            }


        });
    }


    @Override
    public void AddHarverst(HarvestAddress harvestAddress) {

    }

    @Override
    public void ViewHarvestAddress(ViewHarvestAddress viewHarvestAddress) {

    }

    //删除
    @Override
    public void DeleteHarvest(DeleteHarvestAddress deleteHarvestAddress) {
        String msg = deleteHarvestAddress.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    //修改
    @Override
    public void Update(UpdateShipping updateShipping) {
        String msg = updateShipping.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }
    private void initt() {

    }
    @Override
    public void SelectBean(SeleteBean seleteBean) {

    }

    @OnClick(R.id.oncDestruction)
    public void Vie(){
        finish();
    }
}
