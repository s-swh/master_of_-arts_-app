package com.wd.master_of_arts_app.fragment.releasefragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.pm.PackageManager;


import android.net.Uri;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.czt.mp3recorder.MP3Recorder;
import com.lqr.audio.AudioPlayManager;
import com.lqr.audio.AudioRecordManager;
import com.lqr.audio.IAudioPlayListener;
import com.syw.audio.widget.AudioRecordButton;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.io.FileNameSelector;

import java.io.File;
import java.io.FileInputStream;


/**
 * @author 时文豪
 * @description:  录音
 * @date :2020/12/5 10:00
 */
public class Voice extends BaseFragment {
    private final int i = 1;
    //申请录音权限
    private static final int GET_RECODE_AUDIO = 1;

    private static String[] PERMISSION_AUDIO = {
            Manifest.permission.RECORD_AUDIO
    };
    private ImageView iv;
    private Button bt;


    @Override
    protected int getLayoutId() {
        return R.layout.voice;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initView(View inflate) {
        verifyAudioPermissions(getActivity());
        MP3Recorder mRecorder = new MP3Recorder(new File(Environment.getExternalStorageDirectory(), "艺大家.mp3"));

        AudioRecordManager.getInstance(getActivity()).setMaxVoiceDuration(120);
        File mAudioDir = new File(Environment.getExternalStorageDirectory(), "艺大家");
        if (!mAudioDir.exists()) {
            mAudioDir.mkdirs();
        }
        Log.i("xxx", mAudioDir + "");
        AudioRecordManager.getInstance(getActivity()).setAudioSavePath(mAudioDir.getAbsolutePath());


        AudioRecordButton arb = inflate.findViewById(R.id.arb);
        bt = inflate.findViewById(R.id.bt);
        String uri="/sdcard/艺大家/1607394525941temp.voice";

            File file = Environment.getExternalStorageDirectory();
            if(file != null){
                try {
                    File[] files = file.listFiles(new FileNameSelector("voice"));
                    for(int i = 0; i < files.length; i++){
                        Log.i("System.out", files[i].getName());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


            //播放录音
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioPlayManager.getInstance().startPlay(getActivity(), Uri.parse(uri), new IAudioPlayListener() {
                    @Override
                    public void onStart(Uri var1) {
                        //开播
                        Log.i("syw_dl",var1+"");
                        AudioRecordManager.getInstance(getActivity()).startRecord();
                    }

                    @Override
                    public void onStop(Uri var1) {
                        //停播
                    }

                    @Override
                    public void onComplete(Uri var1) {
                        //播完
                        AudioPlayManager.getInstance().stopPlay();
                    }
                });
            }
        });
        //开始录音
        arb.setAudioFinishRecorderListener(new AudioRecordButton.AudioFinishRecorderListener() {

            @Override
            public void onFinished(float seconds, String filePath) {
//停止录音
                AudioRecordManager.getInstance(getActivity()).stopRecord();
                Log.e("syw", "filePath:" + filePath);

            }

            @Override
            public void onNormal() {
//停止录音
                AudioRecordManager.getInstance(getActivity()).stopRecord();

                Log.e("syw", "onNormal:");

            }

            @Override
            public void onRecord() {
                //点击启动
                //开始录音
                AudioRecordManager.getInstance(getActivity()).startRecord();

                Log.e("syw", "onRecord:");

            }

            @Override
            public void onCancel() {
                //上滑删除
                //将要取消录音（参与微信手指上滑）
                AudioRecordManager.getInstance(getActivity()).willCancelRecord();


                Log.e("syw", "onCancel:");

            }

            @Override
            public void onShort() {
//停止录音
                AudioRecordManager.getInstance(getActivity()).stopRecord();
                Log.e("syw", "onShort:");

            }
        });


    }




    /*
     * 申请录音权限*/
    public static void verifyAudioPermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.RECORD_AUDIO);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSION_AUDIO,
                    GET_RECODE_AUDIO);
        }
    }

    @Override
    protected void initData() {

    }
}
