package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;

public class AvatarDetails extends AppCompatActivity {

    private ImageView im,ivc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_details);
        im = findViewById(R.id.imv);
        ivc=  findViewById(R.id.ivc);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String avarat = intent.getStringExtra("avarat");
        Glide.with(getApplicationContext()).load(avarat).into(ivc);
    }
}
