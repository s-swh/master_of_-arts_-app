package com.wd.master_of_arts_app.activity.myactivity;


import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.bigkoo.pickerview.TimePickerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Privacy_policy;
import com.wd.master_of_arts_app.activity.User_agreement;
import com.wd.master_of_arts_app.activity.modify_password;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.customview.SwitchButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置
 */
public class SetUp extends BaseActivity implements View.OnClickListener {

    private TimePickerView pvTime;
    private TextView tv_data;
    private PopupWindow popupBigPhoto;
    private TextView cancel;
    private TextView determine;
    private TextView tv_userName;
    private EditText et;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        tv_data = findViewById(R.id.tt_date);
        tv_userName = findViewById(R.id.suser_userName);
        //默认开关为开
        SwitchButton switchButton = findViewById(R.id.ischecked);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchButton.setChecked(true);
            }
        });
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @OnClick(R.id.update_pwd)
    public void setUpdate() {
        Intent intent = new Intent(getApplicationContext(), modify_password.class);
        startActivity(intent);

    }

    @OnClick(R.id.date)
    public void Data() {
        //初始化时间选择器
        initTimePicker();
        pvTime.show();//显示时间选择器
    }

    @OnClick(R.id.user_name)
    public void setUser() {
        View view = getLayoutInflater().inflate(R.layout.user_name, null);
        if (popupBigPhoto == null) {
            popupBigPhoto = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
            popupBigPhoto.setOutsideTouchable(true);

        }
        if (popupBigPhoto.isShowing()) {
            popupBigPhoto.dismiss();
        } else {
            popupBigPhoto.showAtLocation(view, Gravity.TOP, 0, 0);
        }
        cancel = view.findViewById(R.id.cancel);
        determine = view.findViewById(R.id.determine);
        et = view.findViewById(R.id.et_ttName);
        cancel.setOnClickListener(this);
        determine.setOnClickListener(this);
    }

    private void initTimePicker() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1900, 1, 1);//起始时间
        Calendar endDate = Calendar.getInstance();
        endDate.set(2099, 12, 31);//结束时间
        pvTime = new TimePickerView.Builder(SetUp.this,
                new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //选中事件回调
                        //mTvMyBirthday 这个组件就是个TextView用来显示日期 如2020-09-08
                        tv_data.setText(getTimes(date));
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
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.cancel:
                popupBigPhoto.dismiss();
                break;
            case R.id.determine:
                String user_name = et.getText().toString();
                tv_userName.setText(user_name);
                et.setText("");
                popupBigPhoto.dismiss();
                break;
            default:
                break;
        }
    }

    //用户协议
    @OnClick(R.id.User_agreement)
    public void User_agreement() {
        Intent intent = new Intent(getApplicationContext(), User_agreement.class);
        startActivity(intent);
    }
    //隐私政策
    @OnClick(R.id.Privacy_policy)
    public void OnPrivacy_policy(){
        startActivity(new Intent(getApplicationContext(), Privacy_policy.class));
    }
}
