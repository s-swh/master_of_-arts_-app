package com.wd.master_of_arts_app.activity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.HomeWorkBean;
import com.wd.master_of_arts_app.contreater.MyWorkContreanter;
import com.wd.master_of_arts_app.preanter.MyWorkPreanter;

import java.io.IOException;

/**
 * 作业详情
 */
public class WorkPage extends BaseActivity implements MyWorkContreanter.IView {

    private TextView work_name, work_time, tv_content, tv_etch_content, teacher_time, tv_no;
    private ImageView iv_voive, work_iv, iv_voive1, tv_return, work_one;
    private LinearLayout lsdp;
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_page;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyWorkPreanter(this);
    }

    @Override
    protected void initView() {
        work_name = findViewById(R.id.work_name);
        work_time = findViewById(R.id.work_time);
        tv_content = findViewById(R.id.tv_content);
        iv_voive = findViewById(R.id.iv_voive);
        work_iv = findViewById(R.id.work_iv);
        tv_etch_content = findViewById(R.id.tv_etch_content);
        teacher_time = findViewById(R.id.teacher_time);
        iv_voive1 = findViewById(R.id.iv_voive1);
        tv_no = findViewById(R.id.tv_no);
        tv_return = findViewById(R.id.tv_return);
        work_one = findViewById(R.id.work_one);
        lsdp = findViewById(R.id.lsdp);
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof MyWorkContreanter.IPreanter) {
            Intent intent = getIntent();
            int homework_idcid = intent.getIntExtra("homework_idcid", 0);
            ((MyWorkContreanter.IPreanter) basePreantert).OnWorkSuccess(homework_idcid);

        }
        tv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        work_one.setOnClickListener(new View.OnClickListener() {

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
                Glide.with(getApplicationContext()).load(url).into(uiv);
            }
        });
    }

    @Override
    public void OnMyWork(HomeWorkBean workBean) {
        HomeWorkBean.DataBean data = workBean.getData();

        HomeWorkBean.DataBean.WorkMsgBean workMsg = data.getWorkMsg();
        String name = workMsg.getName();
        String create_time = workMsg.getCreate_time();
        String content = workMsg.getContent();
        String voice = workMsg.getVoice();
        String imglist = workMsg.getImglist();
        Glide.with(WorkPage.this).load("http://qiniu.54artist.com/" + imglist).into(work_one);

        String teacher_content = workMsg.getTeacher_content();
        String teacher_imglist = workMsg.getTeacher_imglist();
        String comment_time = workMsg.getComment_time();
        String teacher_voice = workMsg.getTeacher_voice();
        String is_comment = workMsg.getIs_comment();

        if (is_comment.equals("N")) {
            tv_no.setText("未评论");
        } else if (is_comment.equals("Y")) {
            tv_no.setText("已评论");
            lsdp.setVisibility(View.VISIBLE);
        }
        work_name.setText(name);
        work_time.setText("发布时间" + create_time);
        tv_content.setText(content);
        tv_etch_content.setText(teacher_content);
        teacher_time.setText("点评时间：" + comment_time);
        MediaPlayer mediaPlayer = new MediaPlayer();
        url = "http://qiniu.54artist.com/"+imglist;
        Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + teacher_imglist).into(work_iv);
        work_iv.setOnClickListener(new View.OnClickListener() {

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
                Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + teacher_imglist).into(uiv);
            }
        });
        if (teacher_voice == null) {
            iv_voive1.setVisibility(View.GONE);
        } else {
            iv_voive1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        mediaPlayer.setDataSource("http://qiniu.54artist.com/" + teacher_voice);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (voice == null) {
            iv_voive.setVisibility(View.GONE);
        } else {
            iv_voive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        mediaPlayer.setDataSource("http://qiniu.54artist.com/" + voice);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
