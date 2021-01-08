package com.wd.master_of_arts_app.activity.myactivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.TimePickerView;


import com.google.gson.Gson;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Login_interface;
import com.wd.master_of_arts_app.activity.Privacy_policy;
import com.wd.master_of_arts_app.activity.User_agreement;
import com.wd.master_of_arts_app.activity.Verification_code_login;
import com.wd.master_of_arts_app.activity.modify_password;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.bean.UploadPictures;
import com.wd.master_of_arts_app.contreater.MyContreater;
import com.wd.master_of_arts_app.customview.SwitchButton;
import com.wd.master_of_arts_app.preanter.MyPreanter;
import com.wd.master_of_arts_app.utils.DataCleanManager;

import com.wd.master_of_arts_app.utils.FileUtils;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;


/**
 * 设置
 */
public class SetUp extends BaseActivity implements View.OnClickListener, MyContreater.IView {

    private TimePickerView pvTime;
    private TextView tv_data;
    private PopupWindow popupBigPhoto;
    private TextView cancel;
    private TextView determine;
    private TextView tv_userName;
    private EditText et;
    private ImageView vo;

    private TextView hc;
    private Button bt;
    private RelativeLayout rv;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyPreanter(this);
    }

    String totalCacheSize = null;

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * 获取缓存大小
         */
        String totalCacheSize = null;
        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        hc.setText(totalCacheSize);
    }

    @Override
    protected void initView() {
        bt = findViewById(R.id.signout);
        hc = findViewById(R.id.hc);
        rv = findViewById(R.id.souhuo);
        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetUp.this, Harvest_Address.class);
                startActivity(intent);
            }
        });
        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        hc.setText(totalCacheSize);
        RelativeLayout bt = findViewById(R.id.cloet);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(SetUp.this)
                        .setTitle("清除缓存")
                        .setMessage("是否确认清除缓存")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //清除缓存的方法
                                boolean b = DataCleanManager.clearAllCache(getApplicationContext());
                                if (b) {
                                    hc.setText("0M");
                                }
                                Toast.makeText(getApplicationContext(), "清除成功", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
     /*    vo = findViewById(R.id.Upload_Avatar);
       RelativeLayout rc = findViewById(R.id.rc);
    rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PictureSelector
                        .create(SetUp.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(true, 200, 200, 1, 1);

            }
        });*/
      /*  tv_data = findViewById(R.id.tt_date);
        tv_userName = findViewById(R.id.suser_userName);
        //默认开关为开
        SwitchButton switchButton = findViewById(R.id.ischecked);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchButton.setChecked(true);
            }
        });*/
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                if (pictureBean.isCut()) {
                    SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = sp.getString("token", "");
                    Uri parse = Uri.parse(pictureBean.getPath());
                    vo.setImageURI(parse);
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
                                    Toast.makeText(SetUp.this, msg, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    String message = e.getMessage();
                                    Toast.makeText(SetUp.this, message, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        }
    }*/


    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @OnClick(R.id.update_pwd)
    public void setUpdate() {
        Intent intent = new Intent(getApplicationContext(), modify_password.class);
        startActivity(intent);

    }

    /*@OnClick(R.id.date)
    public void Data() {
        //初始化时间选择器
        initTimePicker();
        pvTime.show();//显示时间选择器
    }*/

  /*  @OnClick(R.id.user_name)
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
    }*/
/*
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
    }*/

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePreantert basePreantert = getmPreantert();
                if(basePreantert instanceof MyContreater.IPreanter){
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    ((MyContreater.IPreanter) basePreantert).SignOutSuccess(token1);
                }
            }
        });
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
    public void OnPrivacy_policy() {
        startActivity(new Intent(getApplicationContext(), Privacy_policy.class));
    }

    @Override
    public void OnSignOut(SignOut signOut) {
        int code = signOut.getCode();
        if(code==1){
            startActivity(new Intent(SetUp.this, Login_interface.class));
            finish();
        }
        SharedPreferences code1 = getSharedPreferences("code", MODE_PRIVATE);
        SharedPreferences.Editor edit = code1.edit();
        int i=0;
        edit.putInt("code",i);
        edit.commit();
        String msg = signOut.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        DataCleanManager.clearAllCache(this);
    }
}
