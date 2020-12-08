package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class Add_Address extends BaseActivity implements View.OnClickListener {


    private RelativeLayout mAddress;
    @BindView(R.id.txtvw)
    TextView tv;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_add__address;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @OnClick(R.id.harvestarea)
    public void OnHavestarea(){
        mAddress=  findViewById(R.id.harvestarea);
        mAddress.setOnClickListener(this);

    }
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

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

                //城市

                String city = citySelected[1];

                //区县（如果设定了两级联动，那么该项返回空）

                String district = citySelected[2];

                //邮编

                String code = citySelected[3];

                //为TextView赋值

                tv.setText(province.trim()+ city.trim()+ district.trim());

            }

        });

    }
}
