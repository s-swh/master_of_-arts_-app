package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.fragment.releasefragment.Voice;
import com.wd.master_of_arts_app.fragment.releasefragment.Written_Words;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.Url;

public class Publishing_works_Activity extends BaseActivity implements View.OnClickListener {


    private static final int PHOTO_FROM_GALLERY = 0;
    private static final int PHOTO_FROM_GALLERY1 = 1;
    private static final int PHOTO_FROM_GALLERY2= 2;
    private LinearLayout lrou1,lrou2,lrou3;
    private ImageView img_1,img_2,img_3;
    private TabLayout tb;
    private ViewPager vp;
    private List<Fragment> fragmentList=new ArrayList<>();
    private List<String> tbs=new ArrayList<>();
    private Intent intent;

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
        lrou1 = findViewById(R.id.lrout1);
        lrou2 = findViewById(R.id.lrout2);
        lrou3 = findViewById(R.id.lrout3);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        tb = findViewById(R.id.tb);
        vp = findViewById(R.id.vp);
        lrou1.setOnClickListener(this);
        lrou2.setOnClickListener(this);
        lrou3.setOnClickListener(this);
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
        vp.setOffscreenPageLimit(2);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected void initData() {

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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        intent = new Intent();
        switch (id){
            case R.id.lrout1:
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO_FROM_GALLERY);

                lrou2.setVisibility(View.VISIBLE);
               // Glide.with(getApplicationContext()).load(R.mipmap.ic_launcher_round).into(img_1);
                break;
            case R.id.lrout2:

                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO_FROM_GALLERY1);
                lrou3.setVisibility(View.VISIBLE);
             //   Glide.with(getApplicationContext()).load(R.mipmap.ic_launcher_round).into(img_2);
                break;
            case R.id.lrout3:
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO_FROM_GALLERY2);
            //    Glide.with(getApplicationContext()).load(R.mipmap.ic_launcher_round).into(img_3);
                break;
                default:break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //第一层switch
        switch (requestCode) {
            case PHOTO_FROM_GALLERY:
                //第二层switch
                switch (resultCode) {
                    case RESULT_OK:
                        if (data != null) {
                            Uri uri = data.getData();
                            img_1.setImageURI(uri);
                        }
                        default:break;

                }
                break;
            case  PHOTO_FROM_GALLERY1 :
                switch (resultCode){
                    case RESULT_OK:
                        if(data!=null){
                            Uri uri=data.getData();
                            img_2.setImageURI(uri);
                        }
                        break;
                }
                break;
            case PHOTO_FROM_GALLERY2:
                switch (resultCode){
                    case RESULT_OK:
                        if(data!=null){
                            Uri uri=data.getData();
                            img_3.setImageURI(uri);
                        }
                        break;
                }
                break;
        }
    }
}
