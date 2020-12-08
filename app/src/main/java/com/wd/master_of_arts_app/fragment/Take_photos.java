package com.wd.master_of_arts_app.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Publishing_works_Activity;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author 时文豪
 * @description:  拍照办公
 * @date :2020/12/3 10:54
 */
public class Take_photos extends BaseFragment {
    public static final int CAMERA_REQ_CODE = 111;

    @Override
    protected int getLayoutId() {
        return R.layout.take_photos;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
    }

    @Override
    protected void initView(View view) {

    }
     //发布作品
    @OnClick({R.id.photograph})
    public void photograph(){

        Intent intent = new Intent(getActivity(), Publishing_works_Activity.class);
        startActivity(intent);
        requestPermission();
    }

    private void requestPermission() {
        // 判断当前Activity是否已经获得了该权限
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            // 如果App的权限申请曾经被用户拒绝过，就需要在这里跟用户做出解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.CAMERA)) {

                Toast.makeText(getActivity(), "请进入设置-应用管理-打开相机权限", Toast.LENGTH_SHORT).show();
            } else {
                // 进行权限请求
                ActivityCompat
                        .requestPermissions(
                                getActivity(),
                                new String[]{Manifest.permission.CAMERA},
                                CAMERA_REQ_CODE);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQ_CODE: {
                // 如果请求被拒绝，那么通常grantResults数组为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 申请成功，进行相应操作
                } else {
                    // 申请失败，可以继续向用户解释。

                    Toast.makeText(getActivity(), "没有相机权限,您可能无法使用相机", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }



    @Override
    protected void initData() {

    }


}
