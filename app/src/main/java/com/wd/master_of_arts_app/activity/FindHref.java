package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wd.master_of_arts_app.R;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class FindHref extends AppCompatActivity {

    private JzvdStd jz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_href);
        Intent intent = getIntent();
        String href = intent.getStringExtra("href");
        jz = findViewById(R.id.jz);
        jz.setUp(href,"",JzvdStd.SCREEN_WINDOW_NORMAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Jzvd.releaseAllVideos();
    }
}
