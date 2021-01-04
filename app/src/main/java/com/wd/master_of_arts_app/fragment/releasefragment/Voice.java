package com.wd.master_of_arts_app.fragment.releasefragment;

import android.Manifest;
import android.app.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;


import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.RecorderAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.QiNiuYun;
import com.wd.master_of_arts_app.customview.AudioRecorderButton;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wd.master_of_arts_app.voice.MediaManager;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


/**
 * @author 时文豪
 * @description:  录音
 * @date :2020/12/5 10:00
 */
public class Voice extends BaseFragment {
    private ListView mListView;
    private ArrayAdapter<Recorder> mAdapter;
    private List<Recorder> mDatas =new ArrayList<>();

    private AudioRecorderButton mAudioRecorderButton;
    private View mAnimView;

    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;
    @Override
    protected int getLayoutId() {
        return R.layout.voice;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }

    @Override
    protected void initView(View inflate) {

        mListView =inflate.findViewById(R.id.id_listview);
        mAudioRecorderButton = inflate.findViewById(R.id.id_recorder_button);

        mAudioRecorderButton.setAudioFinishRecorderListener(new AudioRecorderButton.AudioFinishRecorderListener() {

            private MultipartBody.Part body;
            private String filePath1;

            @Override
            public void onFinish(float seconds, String filePath) {
                //每完成一次录音
                Recorder recorder = new Recorder(seconds,filePath);
                mDatas.add(recorder);
                //更新adapter
                mAdapter.notifyDataSetChanged();
                //设置listview 位置
                mListView.setSelection(mDatas.size()-1);
                for (int i = 0; i < mDatas.size(); i++) {
                    filePath1 = mDatas.get(i).getFilePath();
                    Log.d("xxxxxxx", filePath1 +"");
                }
                RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                RequestBody path1 = RequestBody.create(null, "/uploadNews");
                String pat = filePath1;
                File file = new File(filePath1);
                RequestBody appfile = RequestBody.create(null, pat);
                RequestBody requestFile = RequestBody.create(MediaType.parse("voice/amr"), file);
                body = MultipartBody.Part.createFormData("file", pat, requestFile);
                NetUtils.getInstance().getApi().getQny(funName,path1,appfile,body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<QiNiuYun>() {

                            private String[] ke;

                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(QiNiuYun qiNiuYun) {
                                String msg = qiNiuYun.getMsg();
                                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                                QiNiuYun.DataBean data = qiNiuYun.getData();
                                String key = data.getKey();
                                Toast.makeText(getContext(), key, Toast.LENGTH_SHORT).show();

                                SharedPreferences sp = App.getContext().getSharedPreferences("key", Context.MODE_PRIVATE);
                                SharedPreferences.Editor edit = sp.edit();
                                Log.d("key",key);
                                edit.putString("ke", key);
                                edit.commit();
                            }

                            @Override
                            public void onError(Throwable e) {
                                String message = e.getMessage();
                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }






    @Override
    protected void initData() {
        mAdapter = new RecorderAdapter(getActivity(), mDatas);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //如果第一个动画正在运行， 停止第一个播放其他的
                if (mAnimView != null) {
                    mAnimView.setBackgroundResource(R.drawable.ic_launcher_background);
                    mAnimView = null;
                }
                //播放动画
              /*     mAnimView = view.findViewById(R.id.id_recorder_anim);
                   mAnimView.setBackgroundResource(R.mipmap.icon_lvyin);
                      AnimationDrawable animation = (AnimationDrawable) mAnimView.getBackground();
                    animation.start();*/

                //播放音频  完成后改回原来的background
                MediaManager.playSound(mDatas.get(position).filePath, new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
//                        mAnimView.setBackgroundResource(R.drawable.ic_launcher_background);

                    }
                });
            }
        });
    }

    /**
     * 根据生命周期 管理播放录音
     */
    @Override
    public void onPause() {
        super.onPause();
        MediaManager.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        MediaManager.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MediaManager.release();
    }

    //数据类
    public  class Recorder{

      public   float time;
        public String filePath;

        public float getTime() {
            return time;
        }

        public void setTime(float time) {
            this.time = time;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public Recorder(float time, String filePath) {
            super();
            this.time = time;
            this.filePath = filePath;
        }
    }
}
