package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

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
        im.setOnClickListener(new View.OnClickListener() {

            private PopupWindow popupBigPhoto;

            @Override
            public void onClick(View view) {
                View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                if (popupBigPhoto == null) {
                    popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popupBigPhoto.setOutsideTouchable(true);

                }
                if (popupBigPhoto.isShowing()) {
                    popupBigPhoto.dismiss();
                } else {
                    popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                }

                // 设置PopupWindow的背景
                popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);
                LinearLayout llt = view1.findViewById(R.id.dimen);
                ImageView uiv = view1.findViewById(R.id.pop_image);
                llt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
                Glide.with(getApplicationContext()).load(avarat).into(uiv);
            }
        });
    }
}
