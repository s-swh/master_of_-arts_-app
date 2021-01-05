package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Preview;
import com.wd.master_of_arts_app.contreater.PreViewContreater;
import com.wd.master_of_arts_app.preanter.PreViewPreanter;

import org.greenrobot.eventbus.EventBus;

public class CoursePreview extends BaseActivity implements PreViewContreater.IView {


    private ImageView igv;
    private TextView munit_name,tv_content;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_course_preview;
    }

    @Override
    protected BasePreantert initModel() {
        return new PreViewPreanter(this);
    }

    @Override
    protected void initView() {
        igv = findViewById(R.id.return_fh);
        munit_name = findViewById(R.id.unit_name);
        tv_content = findViewById(R.id.tv_content);
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof PreViewContreater.IPreanter){
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            Intent intent = getIntent();
            int unit_id = intent.getIntExtra("unit_id_two", 0);
            ((PreViewContreater.IPreanter) basePreantert).OnPreViewSuccess(token1,unit_id);
        }
        igv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void OnPreView(Preview preview) {
        Preview.DataBean data = preview.getData();
        String unit_name = data.getUnit_name();
        String pre_content = data.getPre_content();

        munit_name.setText(unit_name);
        tv_content.setText(pre_content);
    }
}
