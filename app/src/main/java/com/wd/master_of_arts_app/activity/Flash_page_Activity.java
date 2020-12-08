package com.wd.master_of_arts_app.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.wd.master_of_arts_app.R;

public class Flash_page_Activity extends AppCompatActivity {
    int i=1;
   @SuppressLint("HandlerLeak")
   private Handler handler=new Handler(){
       @Override
       public void handleMessage(@NonNull Message msg) {
           super.handleMessage(msg);
        if(i==1){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);

            startActivity(intent);
            finish();
        }
       }
   };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_page_);
        handler.sendEmptyMessageDelayed(1,1000);
    }
}
