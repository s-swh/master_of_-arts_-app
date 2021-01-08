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
import com.wd.master_of_arts_app.fragment.releasefragment.Voice;
import com.wd.master_of_arts_app.fragment.releasefragment.Written_Words;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wd.master_of_arts_app.wechatpictures.PhotoPickerActivity;
import com.wd.master_of_arts_app.wechatpictures.PhotoPickerIntent;
import com.wd.master_of_arts_app.wechatpictures.PhotoPreviewActivity;
import com.wd.master_of_arts_app.wechatpictures.PhotoPreviewIntent;
import com.wd.master_of_arts_app.wechatpictures.SelectModel;

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

public class MyHomeWork extends BaseActivity {
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

    private GridView gridView;
    private MyHomeWork.GridAdapter gridAdapter;
    private TextView tv_click;
    private EditText textView;
    private MultipartBody.Part body;

    private EditText et_user;

    private String[] str;
    private String accc;
    private String content1;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected int getLayoutId() {

        return R.layout.activity_my_home_work;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);

                    loadAdpater(list);
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i);
                        Log.e("xxx", s);
                    }
                    break;
                // 预览
                case REQUEST_PREVIEW_CODE:
                    ArrayList<String> ListExtra = data.getStringArrayListExtra(PhotoPreviewActivity.EXTRA_RESULT);
                    loadAdpater(ListExtra);
                    break;
                default:
                    break;
            }
        }
    }

    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("paizhao")) {
            paths.remove("paizhao");
        }
        paths.add("paizhao");
        imagePaths.addAll(paths);
        gridAdapter = new MyHomeWork.GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);
        try {
            JSONArray obj = new JSONArray(imagePaths);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class GridAdapter extends BaseAdapter {
        private ArrayList<String> listUrls;
        private LayoutInflater inflater;


        public GridAdapter(ArrayList<String> listUrls) {
            this.listUrls = listUrls;
            if (listUrls.size() == 7) {
                listUrls.remove(listUrls.size() - 1);
            }
            inflater = LayoutInflater.from(MyHomeWork.this);
        }

        @Override
        public int getCount() {
            return listUrls.size();
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
            MyHomeWork.GridAdapter.ViewHolder holder = null;
            if (convertView == null) {
                holder = new MyHomeWork.GridAdapter.ViewHolder();
                convertView = inflater.inflate(R.layout.item, parent, false);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);


            } else {
                holder = (MyHomeWork.GridAdapter.ViewHolder) convertView.getTag();
            }

            path = listUrls.get(position);


            if (path.equals("paizhao")) {
                holder.image.setImageResource(R.mipmap.find_add_img);
            } else {
                Glide.with(MyHomeWork.this)
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
        MyHomeWork.MyViewPager myViewPager = new MyHomeWork.MyViewPager(getSupportFragmentManager());
        vp.setAdapter(myViewPager);
        vp.setOffscreenPageLimit(1);
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
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
                if ("paizhao".equals(imgs)) {
                    PhotoPickerIntent intent = new PhotoPickerIntent(MyHomeWork.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(3); // 最多选择照片数量，默认为6
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);


                } else {

                    Toast.makeText(MyHomeWork.this, "1" + position, Toast.LENGTH_SHORT).show();
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(MyHomeWork.this);
                    intent.setCurrentItem(position);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                }
            }
        });
        imagePaths.add("paizhao");
        gridAdapter = new MyHomeWork.GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);
        @SuppressLint("HandlerLeak") Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                RequestBody path1 = RequestBody.create(null, "/uploadNews");
                String pat = path;
                File file = new File(path);
                RequestBody appfile = RequestBody.create(null, pat);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
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
                                Toast.makeText(MyHomeWork.this, msg, Toast.LENGTH_SHORT).show();
                                QiNiuYun.DataBean data = qiNiuYun.getData();
                                String key = data.getKey();
                                str = new String[]{key};

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
        };

        handler.sendEmptyMessageDelayed(1, 10000);

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

    @OnClick(R.id.bt)
    public void OnBt(View view) {
        for (int i = 0; i < str.length; i++) {
            accc = str[i].toString();
            Toast.makeText(this, accc, Toast.LENGTH_SHORT).show();
        }
        Intent intent = getIntent();
        int unit_id_two = intent.getIntExtra("unit_id_two", 0);
        SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
        String token1 = token.getString("token", "");
        String string = et_user.getText().toString();
        SharedPreferences et = getSharedPreferences("et", MODE_PRIVATE);
        String string1 = et.getString("striasdasdasng", "");
        SharedPreferences sp = getSharedPreferences("key", MODE_PRIVATE);
        String ke = sp.getString("ke", "");
        Log.d("xxxxxxxxx", ke);
        NetUtils.getInstance().getApi().getMyHome(token1, unit_id_two, string, string1, accc, ke)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyHome>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyHome myHome) {
                        int code = myHome.getCode();

                        String msg = myHome.getMsg();
                        Toast.makeText(MyHomeWork.this, msg, Toast.LENGTH_SHORT).show();
                        if (code == 1) {
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
    }


}