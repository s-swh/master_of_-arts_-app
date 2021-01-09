package com.wd.master_of_arts_app.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.wd.master_of_arts_app.R;

import com.wd.master_of_arts_app.activity.myactivity.SetUp;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.EditUser;
import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.Image;
import com.wd.master_of_arts_app.bean.UploadPictures;
import com.wd.master_of_arts_app.bean.User;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.contreater.UserInformationConreater;
import com.wd.master_of_arts_app.preanter.UserInformartionPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Address;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class PersonalDataActivity extends BaseActivity implements View.OnClickListener, UserInformationConreater.IView {

    private TimePickerView pvTime;
    private TextView tt_date,dq;
    private ImageView iv;
    private LinearLayout address;
    private EditText et_name;
    private CheckBox nan, nv;
    private int sex;
    private String province, city, district;
    private Button bt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_data;
    }

    @Override
    protected BasePreantert initModel() {
        return new UserInformartionPreanter(this);
    }

    @Override
    protected void initView() {
        tt_date = findViewById(R.id.tt_date);
        address = findViewById(R.id.Address);
        dq = findViewById(R.id.dq);
        et_name = findViewById(R.id.up_name);
        iv = findViewById(R.id.iv_img);
        nan = findViewById(R.id.nan);
        nv = findViewById(R.id.nv);
        bt = findViewById(R.id.upde);
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void Image(Image image) {
        String img = image.getImg();
        Glide.with(getApplicationContext()).load(img).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).error(R.mipmap.ic_launcher_round).into(iv);
    }



    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void se(User user) {
        String name = user.getName();
        et_name.setText(name);
        int sex = user.getSex();
        if (sex == 1) {
            nan.isChecked();
        } else if (sex == 2) {
            nv.isChecked();
        }
        String date = user.getDate();
        tt_date.setText(date);
        String detail_address = user.getDetail_address();
        dq.setText(detail_address);
        String editname = et_name.getText().toString();
        String editdate = tt_date.getText().toString();
        String editaddress = dq.getText().toString();
        EventBus.getDefault().postSticky(new EditUser(editname,editdate,editaddress));
    }

    @Override
    protected void initData() {
        SharedPreferences s1p = getSharedPreferences("address", MODE_PRIVATE);
        String s1c = s1p.getString("acacsadasd", "");
        dq.setText(s1c);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if (basePreantert instanceof UserInformationConreater.IPreanter) {
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    String name = et_name.getText().toString();
                    String date = tt_date.getText().toString();
                    ((UserInformationConreater.IPreanter) basePreantert).EditUserSuccess(token1, name, sex, date, province, city, district);
                }
            }
        });
       address.setOnClickListener(this);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(PersonalDataActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });
        if (nan.isChecked()) {
            sex = 1;
        } else if (nv.isChecked()) {
            sex = 2;
        } else {
            sex = 0;
        }
    }

    @OnClick(R.id.date)
    public void Data() {
        //初始化时间选择器
        initTimePicker();
        pvTime.show();//显示时间选择器
    }

    private void initTimePicker() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1900, 1, 1);//起始时间
        Calendar endDate = Calendar.getInstance();
        endDate.set(2099, 12, 31);//结束时间
        pvTime = new TimePickerView.Builder(PersonalDataActivity.this,
                new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //选中事件回调
                        //mTvMyBirthday 这个组件就是个TextView用来显示日期 如2020-09-08
                        tt_date.setText(getTimes(date));
                    }
                })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();
    }

    private String getTimes(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                if (pictureBean.isCut()) {
                    SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = sp.getString("token", "");
                    Uri parse = Uri.parse(pictureBean.getPath());
                    iv.setImageURI(parse);
                    RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                    RequestBody path = RequestBody.create(null, "/uploadNews");
                    String path1 = pictureBean.getPath();
                    RequestBody appfile = RequestBody.create(null, path1);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), token1);
                    String fileName = path1;
                    File file = new File(path1);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
                    MultipartBody.Part body = MultipartBody.Part.createFormData("avatar", fileName, requestFile);
                    NetUtils.getInstance().getApi().upImg(requestBody, funName, path, appfile, body)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<UploadPictures>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(UploadPictures responseBody) {
                                    String msg = responseBody.getMsg();
                                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    String message = e.getMessage();
                                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        }
    }

    @OnClick(R.id.recfh)
    public void fanhui() {
        finish();
    }

    @Override
    public void onClick(View view) {
        selectAddress();

    }

    private void selectAddress() {

        CityPicker cityPicker = new CityPicker.Builder(PersonalDataActivity.this)

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

                province = citySelected[0];


                //城市

                city = citySelected[1];

                //区县（如果设定了两级联动，那么该项返回空）

                district = citySelected[2];

                //邮编

                String code = citySelected[3];

                //为TextView赋值
                    String sc=province.trim() + city.trim() + district.trim();
                SharedPreferences sp = getSharedPreferences("address", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("acacsadasd", sc);
                edit.commit();
               dq.setText(sc);

            }

        });

    }

    @Override
    public void OnUserInfor(UserInformation userInformation) {

    }

    //编辑用户资料
    @Override
    public void OnEditUser(EditUserInformation editUserInformation) {
        String msg = editUserInformation.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        if (editUserInformation.getCode() == 1) {
            finish();
        }
    }
}
