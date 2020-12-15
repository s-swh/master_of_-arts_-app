package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.wd.master_of_arts_app.fragment.releasefragment.Voice;
import com.wd.master_of_arts_app.fragment.releasefragment.Written_Words;
import com.wd.master_of_arts_app.wechatpictures.PhotoPickerActivity;
import com.wd.master_of_arts_app.wechatpictures.PhotoPickerIntent;
import com.wd.master_of_arts_app.wechatpictures.PhotoPreviewActivity;
import com.wd.master_of_arts_app.wechatpictures.PhotoPreviewIntent;
import com.wd.master_of_arts_app.wechatpictures.SelectModel;

import org.json.JSONArray;

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
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();

    private GridView gridView;
    private GridAdapter gridAdapter;
    private TextView tv_click;
    private EditText textView;
    private String TAG =MainActivity.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected int getLayoutId() {

        return R.layout.activity_publishing_works;
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    Log.d(TAG, "数量："+list.size());
                    loadAdpater(list);
                    break;
                // 预览
                case REQUEST_PREVIEW_CODE:
                    ArrayList<String> ListExtra = data.getStringArrayListExtra(PhotoPreviewActivity.EXTRA_RESULT);
                    loadAdpater(ListExtra);
                    break;
            }
        }
    }
    private void loadAdpater(ArrayList<String> paths){
        if (imagePaths!=null&& imagePaths.size()>0){
            imagePaths.clear();
        }
        if (paths.contains("paizhao")){
            paths.remove("paizhao");
        }
        paths.add("paizhao");
        imagePaths.addAll(paths);
        gridAdapter  = new GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);
        try{
            JSONArray obj = new JSONArray(imagePaths);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private class GridAdapter extends BaseAdapter {
        private ArrayList<String> listUrls;
        private LayoutInflater inflater;
        public GridAdapter(ArrayList<String> listUrls) {
            this.listUrls = listUrls;
            if(listUrls.size() == 7){
                listUrls.remove(listUrls.size()-1);
            }
            inflater = LayoutInflater.from(Publishing_works_Activity.this);
        }

        public int getCount(){
            return  listUrls.size();
        }
        @Override
        public String getItem(int position) {
            return listUrls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item, parent,false);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            final String path=listUrls.get(position);
            if (path.equals("paizhao")){
                holder.image.setImageResource(R.mipmap.find_add_img);
            }else {
                Glide.with(Publishing_works_Activity.this)
                        .load(path)
                        .placeholder(R.mipmap.default_error)
                        .error(R.mipmap.default_error)
                        .centerCrop()

                        .into(holder.image);
            }
            return convertView;
        }
        class ViewHolder {
            ImageView image;
        }
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
        vp.setOffscreenPageLimit(1);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected void initData() {
        gridView = (GridView) findViewById(R.id.gridView);

        int cols = getResources().getDisplayMetrics().widthPixels / getResources().getDisplayMetrics().densityDpi;
        cols = cols < 3 ? 3 : cols;
        gridView.setNumColumns(cols);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String imgs = (String) parent.getItemAtPosition(position);
                if ("paizhao".equals(imgs) ){
                    PhotoPickerIntent intent = new PhotoPickerIntent(Publishing_works_Activity.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                }else{
                    Toast.makeText(Publishing_works_Activity.this,"1"+position,Toast.LENGTH_SHORT).show();
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(Publishing_works_Activity.this);
                    intent.setCurrentItem(position);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                }
            }
        });
        imagePaths.add("paizhao");
        gridAdapter = new GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);
      /*  tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });*/
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
  /*  @Override
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
                        default:break;
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
                    default:break;
                }
                break;
                default:break;
        }
    }*/
}
