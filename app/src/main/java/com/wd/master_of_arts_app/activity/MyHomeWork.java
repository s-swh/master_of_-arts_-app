package com.wd.master_of_arts_app.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.MyHome;
import com.wd.master_of_arts_app.bean.QiNiuYun;
import com.wd.master_of_arts_app.bean.TakePhotosAndComment;
import com.wd.master_of_arts_app.fragment.releasefragment.Voice;
import com.wd.master_of_arts_app.fragment.releasefragment.Written_Words;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MyHomeWork extends BaseActivity implements View.OnClickListener {
    private String key;
    private String path;
    private TabLayout tb;
    private ViewPager vp;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tbs = new ArrayList<>();
    private Intent intent;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private List<String> keys = new ArrayList<>();
    private GridView gridView;

    private TextView tv_click;
    private EditText textView;
    private MultipartBody.Part body;

    private EditText et_user;

    private String[] str;
    private String accc;
    private String content1;
    private ImageView im1, im2, im3;
    private int j = 0;
    private int j1;
    private String path1;
    private String path2;
    private String path3;
    private String url1,url2,url3;
    private String use;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected int getLayoutId() {

        return R.layout.activity_my_home_work;
    }




    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        im1 = findViewById(R.id.imv_ig1);
        im2 = findViewById(R.id.imv_ig2);
        im3 = findViewById(R.id.imv_ig3);
        tb = findViewById(R.id.tb);
        vp = findViewById(R.id.vp);
        et_user = findViewById(R.id.et_username);
        Voice voice = new Voice();
        Written_Words written_words = new Written_Words();
        fragmentList.add(voice);
        fragmentList.add(written_words);
        tbs.add("语音介绍");
        tbs.add("文字介绍");
        tb.addTab(tb.newTab().setTag(tbs.get(0)));
        tb.addTab(tb.newTab().setTag(tbs.get(1)));
        tb.setupWithViewPager(vp);
        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager());
        vp.setAdapter(myViewPager);
        vp.setOffscreenPageLimit(1);
        im1.setOnClickListener(this);
        im2.setOnClickListener(this);
        im3.setOnClickListener(this);
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @Override
    protected void initData() {
        im2.setVisibility(View.GONE);
        im3.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.imv_ig1: {
                PictureSelector
                        .create(MyHomeWork.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(false, 200, 200, 1, 1);

            }
            break;
            case R.id.imv_ig2: {
                PictureSelector
                        .create(MyHomeWork.this, 2)
                        .selectPicture(false, 200, 200, 1, 1);


            }
            break;
            case R.id.imv_ig3: {
                PictureSelector
                        .create(MyHomeWork.this, 3)
                        .selectPicture(false, 200, 200, 1, 1);

            }
            break;
            default:
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                im3.setVisibility(View.GONE);
                path1 = pictureBean.getPath();
                Glide.with(getApplicationContext()).load(path1).into(im1);

                im1.setVisibility(View.VISIBLE);
                im2.setVisibility(View.VISIBLE);
                im3.setVisibility(View.GONE);
                if(path1!=null){
                    RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                    RequestBody path1 = RequestBody.create(null, "/uploadNews");

                    String pat = this.path1;
                    File file = new File(pat);
                    RequestBody appfile = RequestBody.create(null, pat);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                    body = MultipartBody.Part.createFormData("file", pat, requestFile);
                    NetUtils.getInstance().getApi().getQny(funName, path1, appfile, body)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<QiNiuYun>() {


                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(QiNiuYun qiNiuYun) {
                                    String msg = qiNiuYun.getMsg();

                                    QiNiuYun.DataBean data = qiNiuYun.getData();
                                    String key = data.getKey();
                                    url1=key;
                                }

                                @Override
                                public void onError(Throwable e) {
                                    String message = e.getMessage();
                                    Toast.makeText(MyHomeWork.this, message, Toast.LENGTH_SHORT).show();
                                    Log.e("acacac", message);
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }



            }
        }
        if (requestCode == 2) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);

                path2 = pictureBean.getPath();
                Glide.with(getApplicationContext()).load(path2).into(im2);
                im1.setVisibility(View.VISIBLE);
                im2.setVisibility(View.VISIBLE);
                im3.setVisibility(View.VISIBLE);
                if(path2!=null){
                    RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                    RequestBody path1 = RequestBody.create(null, "/uploadNews");

                    String pat = this.path2;
                    File file = new File(pat);
                    RequestBody appfile = RequestBody.create(null, pat);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                    body = MultipartBody.Part.createFormData("file", pat, requestFile);
                    NetUtils.getInstance().getApi().getQny(funName, path1, appfile, body)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<QiNiuYun>() {


                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(QiNiuYun qiNiuYun) {
                                    String msg = qiNiuYun.getMsg();

                                    QiNiuYun.DataBean data = qiNiuYun.getData();
                                    String key = data.getKey();
                                    url2=key;
                                }

                                @Override
                                public void onError(Throwable e) {
                                    String message = e.getMessage();
                                    Toast.makeText(MyHomeWork.this, message, Toast.LENGTH_SHORT).show();
                                    Log.e("acacac", message);
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }



            }
        }
        if (requestCode == 3) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);

                path3 = pictureBean.getPath();
                Glide.with(getApplicationContext()).load(path3).into(im3);
                im1.setVisibility(View.VISIBLE);
                im2.setVisibility(View.VISIBLE);
                im3.setVisibility(View.VISIBLE);

                if(path3!=null){
                    RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                    RequestBody path1 = RequestBody.create(null, "/uploadNews");

                    String pat = this.path3;
                    File file = new File(pat);
                    RequestBody appfile = RequestBody.create(null, pat);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                    body = MultipartBody.Part.createFormData("file", pat, requestFile);
                    NetUtils.getInstance().getApi().getQny(funName, path1, appfile, body)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<QiNiuYun>() {


                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(QiNiuYun qiNiuYun) {
                                    String msg = qiNiuYun.getMsg();

                                    QiNiuYun.DataBean data = qiNiuYun.getData();
                                    String key = data.getKey();
                                    url3=key;
                                }

                                @Override
                                public void onError(Throwable e) {
                                    String message = e.getMessage();
                                    Toast.makeText(MyHomeWork.this, message, Toast.LENGTH_SHORT).show();
                                    Log.e("acacac", message);
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }


            }
        }
    }
    class MyViewPager extends FragmentPagerAdapter {
        public MyViewPager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tbs.get(position);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void Post(String key){
        use = key;
    }
    @OnClick(R.id.bt)
    public void OnBt(View view) {

        if(url1!=null){
            keys.add(url1);
            if (path2 != null) {

                keys.add(url2);
            }
            if (path3 != null) {
                keys.add(url3);
            }

            accc = "[\"";

            for (int i = 0; i < keys.size(); i++) {
                Log.i("xxxxkeys", keys.get(i));
                accc += keys.get(i) + "\",\"";
            }
            accc = accc.substring(0, accc.length() - 2) + "]";

            Log.i("-------------", accc);

            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            String string = et_user.getText().toString();
            if(!string.isEmpty()){
                SharedPreferences et = getSharedPreferences("et", MODE_PRIVATE);
                String string1 = et.getString("striasdasdasng", "");
                SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
                String ke = sp.getString("ke", "");
                Log.i("xxxxke",ke);
                Log.d("xxxxxxxxx", ke);
                Intent intent = getIntent();
                int icqd = intent.getIntExtra("icqd", 0);
                int myHomeWorkid = intent.getIntExtra("myHomeWorkid", 0);
                int homework_idcid = intent.getIntExtra("homework_idcid", 0);

                int itemonr_id = intent.getIntExtra("itemonr_id", 0);
                NetUtils.getInstance().getApi().getMyHome(token1,myHomeWorkid,itemonr_id+"",string,string1,accc,use)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<MyHome>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(MyHome myHome) {
                                String msg = myHome.getMsg();
                                SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
                                SharedPreferences.Editor edit1 = sp.edit();
                                edit1.clear();
                                edit1.commit();
                                int code = myHome.getCode();
                                if(code==1){
                                    finish();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else{
                Toast.makeText(this, "请输入作品名称", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "请上传作品", Toast.LENGTH_SHORT).show();
        }



    }


}
