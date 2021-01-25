package com.wd.master_of_arts_app.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.UploadPictures;
import com.wd.master_of_arts_app.customview.Img;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.plaso.plasoliveclassandroidsdk.R2.id.imageView;

public class AvatarDetails extends AppCompatActivity {

    private ImageView im, ivc;
    private Button but_checked, baocun;
    //长按后显示的 Item
    final String[] items = new String[]{"保存图片"};
    //图片转成Bitmap数组
    final Bitmap[] bitmap = new Bitmap[1];
    private String patch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_details);
        im = findViewById(R.id.imv);
        ivc = findViewById(R.id.ivc);
        but_checked = findViewById(R.id.but_checked);
        baocun = findViewById(R.id.baocun);
        initData();

    }

    private void initData() {
        Intent intent1 = getIntent();
        String avacrat = intent1.getStringExtra("avacrat");
        Glide.with(getApplicationContext()).load(avacrat).error(R.mipmap.icon_tx).into(ivc);
        but_checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PictureSelector
                        .create(AvatarDetails.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String avarat = intent.getStringExtra("avarat");

        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (patch!=null) {

                    SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = sp.getString("token", "");


                    Glide.with(getApplicationContext()).load(patch).into(ivc);

                    RequestBody funName = RequestBody.create(null, "ict_uploadpicture");
                    RequestBody path = RequestBody.create(null, "/uploadNews");
                    String path1 = patch;
                    RequestBody appfile = RequestBody.create(null, path1);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), token1);


                    String fileName = path1;
                    File file = new File(path1);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
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
                                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                                    int code = responseBody.getCode();
                                    if (code == 1) {
                                        EventBus.getDefault().postSticky(patch);
                                        finish();

                                    }

                                }

                                @Override
                                public void onError(Throwable e) {
                                    String message = e.getMessage();
                                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                } else {
                        finish();
                }

            }
        });


    }

    public static void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片 创建文件夹
        File appDir = new File(Environment.getExternalStorageDirectory(), "shy");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        //图片文件名称
        String fileName = "shy_" + System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            Log.e("111", e.getMessage());
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        String path = file.getAbsolutePath();
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), path, fileName, null);
        } catch (FileNotFoundException e) {
            Log.e("333", e.getMessage());
            e.printStackTrace();
        }
        // 最后通知图库更新
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
        Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                if (pictureBean.isCut()) {
                    patch = pictureBean.getPath();
                    Glide.with(getApplicationContext()).load(patch).into(ivc);
                }
            }
        }
    }
}
