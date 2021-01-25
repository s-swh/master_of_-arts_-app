package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.Image;

import cn.jzvd.JzvdStd;

public class MoreHref extends AppCompatActivity {

    private JzvdStd jz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_href);
        jz = findViewById(R.id.jzv);
     TextView tvitle = findViewById(R.id.tvitle);
     ImageView imavt = findViewById(R.id.imavt);
     imavt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             finish();
         }
     });
        Intent intent = getIntent();
        String href_tow = intent.getStringExtra("href_tow");
        String title = intent.getStringExtra("href_title");
        tvitle.setText(title);
        jz.setUp(href_tow, "", JzvdStd.SCREEN_WINDOW_NORMAL);
        jz.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);//去掉黑框
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JzvdStd.releaseAllVideos();//在销毁活动时，关闭饺子视频
    }
}
