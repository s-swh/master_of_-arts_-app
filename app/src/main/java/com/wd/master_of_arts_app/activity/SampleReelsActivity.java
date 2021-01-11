package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.SampleReelsAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.SampleReels;
import com.wd.master_of_arts_app.contreater.SampleReelsContreanter;
import com.wd.master_of_arts_app.preanter.SamplePreanter;

import java.util.List;

import butterknife.OnClick;

public class SampleReelsActivity extends BaseActivity implements SampleReelsContreanter.IView {


    private RecyclerView xrv;
    private TextView title_tv;
    private ImageView reels;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sample_reels;
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @Override
    protected BasePreantert initModel() {
        return new SamplePreanter(this);
    }

    @Override
    protected void initView() {
        xrv = findViewById(R.id.xrev_rv);
        title_tv = findViewById(R.id.title_tv);
        reels = findViewById(R.id.reels);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String titlet = intent.getStringExtra("titlet");
        String teacher_namea = intent.getStringExtra("teacher_namea");
       // title_tv.setText(titlet + "(" + teacher_namea + ")");
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof SampleReelsContreanter.IPreanter) {
            SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
            String token = sp.getString("token", "");
            ((SampleReelsContreanter.IPreanter) basePreantert).SampleRessleSuccess(token, 225);
        }
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        xrv.setLayoutManager(layoutManager);
    }

    @Override
    public void OnSampleRessle(SampleReels sampleReels) {
        SampleReels.DataBean data = sampleReels.getData();
        List<SampleReels.DataBean.ListBean> list = data.getList();
        if(list.size()==0){
            reels.setVisibility(View.VISIBLE);
        }else{
            SampleReelsAdapter sampleReelsAdapter = new SampleReelsAdapter(getApplicationContext(), list);
            sampleReelsAdapter.OnItemClick(new SampleReelsAdapter.ItemOnClick() {

                private PopupWindow popupBigPhoto;

                @Override
                public void OnClick(String href) {
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
                    Glide.with(getApplicationContext()).load(href).into(uiv);
                }
            });
            xrv.setAdapter(sampleReelsAdapter);
        }

    }
}
