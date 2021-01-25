package com.wd.master_of_arts_app.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.wd.master_of_arts_app.R;


import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.EditUser;
import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.Image;

import com.wd.master_of_arts_app.bean.User;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.contreater.UserInformationConreater;
import com.wd.master_of_arts_app.preanter.UserInformartionPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PersonalDataActivity extends BaseActivity implements View.OnClickListener, UserInformationConreater.IView {

    private TimePickerView pvTime;
    private TextView tt_date, dq;
    private ImageView iv;
    private LinearLayout address;
    private EditText et_name;

    private int sex=1;

    private String province, city, district;
    private Button bt;
    private String name;

    private String avatar;
    private String date;
    private String detail_address;
    private LinearLayout llt;
    private String img;
    private LinearLayout lt_man;
    private LinearLayout lt_wuman;
    private ImageView many, wumany;
    private ImageView mann, wumann;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_data;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        initData();
    }

    @Override
    protected BasePreantert initModel() {
        return new UserInformartionPreanter(this);
    }

    @Override
    protected void initView() {
                if(EventBus.getDefault().isRegistered(this)) {
                    EventBus.getDefault().register(this);
                }
        tt_date = findViewById(R.id.tt_date);
        address = findViewById(R.id.Address);
        dq = findViewById(R.id.dq);
        et_name = findViewById(R.id.up_name);
        iv = findViewById(R.id.iv_img);
        lt_man = findViewById(R.id.man);
        lt_wuman = findViewById(R.id.wuman);
        many = findViewById(R.id.many);
        mann = findViewById(R.id.mann);
        wumany = findViewById(R.id.wumany);
        wumann = findViewById(R.id.wumann);

        bt = findViewById(R.id.upde);

        llt = findViewById(R.id.llt);
        Intent intent = getIntent();
        sex = intent.getIntExtra("sex", 0);

        if (sex == 1) {
            many.setVisibility(View.VISIBLE);
            mann.setVisibility(View.GONE);
            wumany.setVisibility(View.GONE);
            wumann.setVisibility(View.VISIBLE);
        } else if (sex == 2) {
            wumany.setVisibility(View.VISIBLE);
            wumann.setVisibility(View.GONE);
            many.setVisibility(View.GONE);
            mann.setVisibility(View.VISIBLE);
        }

        lt_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                many.setVisibility(View.VISIBLE);//男人选中
                mann.setVisibility(View.GONE);

                wumany.setVisibility(View.GONE);//女人未选中
                wumann.setVisibility(View.VISIBLE);
                sex = 1;
            }
        });
        lt_wuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wumany.setVisibility(View.VISIBLE);//女人选中
                wumann.setVisibility(View.GONE);
                many.setVisibility(View.GONE);
                mann.setVisibility(View.VISIBLE);//男人未选中
                sex = 2;
            }
        });

        et_name.setText(name);
        tt_date.setText(date);

    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void Image(Image image) {
        img = image.getImg();

    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void se(User user) {
        name = user.getName();

        date = user.getDate();

        detail_address = user.getDetail_address();

        String editname = et_name.getText().toString();
        String editdate = tt_date.getText().toString();
        String editaddress = dq.getText().toString();
        EventBus.getDefault().postSticky(new EditUser(editname, editdate, editaddress));
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void initData() {
        SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
        String token1 = token.getString("token", "");
        NetUtils.getInstance().getApi().getUser(token1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInformation>() {


                    private String detail_address;

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInformation userInformation) {
                        UserInformation.DataBean data = userInformation.getData();
                        UserInformation.DataBean.UserDetailBean user_detail = data.getUser_detail();
                        avatar = user_detail.getAvatar();
                        Glide.with(getApplicationContext()).load(avatar).error(R.mipmap.icon_tx).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv);
                        String birthday = user_detail.getBirthday();
                        String nickname = user_detail.getNickname();
                        et_name.setText(nickname);
                        tt_date.setText(birthday);
                        detail_address = user_detail.getProvince();
                     String   detail_address1 = user_detail.getCity();
                        String  detail_address2 = user_detail.getCounty();
                        String add=detail_address+detail_address1+detail_address2;
                        if(!add.isEmpty()){
                            dq.setText(add);
                        }else{
                            dq.setText("");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        llt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AvatarDetails.class);
                intent.putExtra("avarat", img);
                intent.putExtra("avacrat", avatar);
                startActivity(intent);

            }
        });
      //  Glide.with(getApplicationContext()).load(img).apply(RequestOptions.bitmapTransform(new CircleCrop())).error(R.mipmap.icon_tx).into(iv);
        SharedPreferences s1p = getSharedPreferences("address", MODE_PRIVATE);
        String s1c = s1p.getString("acacsadasd", "");

        SharedPreferences address = getSharedPreferences("address", MODE_PRIVATE);
        SharedPreferences.Editor edit = address.edit();
        edit.clear();
        edit.commit();
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
        this.address.setOnClickListener(this);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AvatarDetails.class);
                intent.putExtra("avarat", img);
                intent.putExtra("avacrat", avatar);
                startActivity(intent);

            }
        });

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
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy");//设置日期格式
        SimpleDateFormat df2 = new SimpleDateFormat("MM");//设置日期格式
        SimpleDateFormat df3 = new SimpleDateFormat("dd");//设置日期格式
        String format = df1.format(new Date());
        String format1 = df2.format(new Date());
        String format2 = df3.format(new Date());
        int year= Integer.parseInt(format);
        int mm= Integer.parseInt(format1);
        int dd= Integer.parseInt(format2);
        Calendar endDate = Calendar.getInstance();
        endDate.set(year, mm-1, dd);//结束时间
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
               String sc = province.trim() + city.trim() + district.trim();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
