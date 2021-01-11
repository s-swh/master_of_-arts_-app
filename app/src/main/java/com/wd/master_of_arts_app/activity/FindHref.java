package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        String name = intent.getStringExtra("name");
        jz = findViewById(R.id.jz);
      ImageView  finsun = findViewById(R.id.finsun);
      TextView tname = findViewById(R.id.tname);
        tname.setText(name);
        finsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        jz.setUp(href,"",JzvdStd.SCREEN_WINDOW_NORMAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Jzvd.releaseAllVideos();
    }
}
