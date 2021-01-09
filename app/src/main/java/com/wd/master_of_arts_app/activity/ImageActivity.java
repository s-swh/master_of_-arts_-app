package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
       ImageView vv =findViewById(R.id.icv);
        Intent intent = getIntent();
        String stringhref = intent.getStringExtra("Stringhref");
        Glide.with(getApplicationContext()).load(stringhref).into(vv);
    }
}
