package com.wd.master_of_arts_app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;


import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import com.wd.master_of_arts_app.bean.QiNiuYun;
import com.wd.master_of_arts_app.bean.TakePhotosAndComment;
import com.wd.master_of_arts_app.fragment.releasefragment.Voice;
import com.wd.master_of_arts_app.fragment.releasefragment.Written_Words;

import com.wd.master_of_arts_app.utils.NetUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;


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


public class Publishing_works_Activity extends BaseActivity  {


    private TabLayout tb;
    private ViewPager vp;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tbs = new ArrayList<>();
    private Intent intent;

    private EditText textView;
    private MultipartBody.Part body;

    private EditText et_user;
    private List<String> keys = new ArrayList<>();
    private String[] str;
    private String accc;
    private String content1;

    private int j = 0;
    private ImageView im1, im2, im3;

    private String path1;
    private String path2;
    private String path3;
    private String url1, url2, url3;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected int getLayoutId() {

        return R.layout.activity_publishing_works;
    }


    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

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

        im1 = findViewById(R.id.imv_ig1);
        im2 = findViewById(R.id.imv_ig2);
        im3 = findViewById(R.id.imv_ig3);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(Publishing_works_Activity.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(false, 200, 200, 1, 1);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(Publishing_works_Activity.this, 2)
                        .selectPicture(false, 200, 200, 1, 1);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(Publishing_works_Activity.this, 3)
                        .selectPicture(false, 200, 200, 1, 1);
            }
        });
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        initData();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                im3.setVisibility(View.GONE);
                path1 = pictureBean.getPath();
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getApplication().getResources().getDisplayMetrics());
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, getApplication().getResources().getDisplayMetrics());
                Glide.with(getApplicationContext()).load(path1).placeholder(R.mipmap.icon_tx).override(width,height).into(im1);

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

                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getApplication().getResources().getDisplayMetrics());
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, getApplication().getResources().getDisplayMetrics());
                Glide.with(getApplicationContext()).load(path2).placeholder(R.mipmap.icon_tx).override(width,height).into(im2);
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

                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getApplication().getResources().getDisplayMetrics());
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, getApplication().getResources().getDisplayMetrics());
                Glide.with(getApplicationContext()).load(path3).placeholder(R.mipmap.icon_tx).override(width,height).into(im3);
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

    @SuppressLint("HandlerLeak")
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

            if (!string.isEmpty()) {
                SharedPreferences et = getSharedPreferences("et", MODE_PRIVATE);
                String string1 = et.getString("striasdasdasng", "");
                SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
                String ke = sp.getString("ke", "");
                Log.d("xxxxxxxxx", ke);
                NetUtils.getInstance().getApi().getTakePhotos(token1, string, string1, accc, ke)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<TakePhotosAndComment>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(TakePhotosAndComment takePhotosAndComment) {
                                String msg = takePhotosAndComment.getMsg();
                                SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
                                SharedPreferences.Editor edit1 = sp.edit();
                                edit1.clear();
                                edit1.commit();
                                int code = takePhotosAndComment.getCode();
                                if (code == 1) {
                                    finish();

                                }
                                SharedPreferences et1 = getSharedPreferences("et", MODE_PRIVATE);
                                SharedPreferences.Editor edit = et1.edit();
                                edit.putString("striasdasdasng", "");
                                edit.commit();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else{
                Toast.makeText(this, "请填写作品名称", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "请上传作品", Toast.LENGTH_SHORT).show();
        }


    }

}