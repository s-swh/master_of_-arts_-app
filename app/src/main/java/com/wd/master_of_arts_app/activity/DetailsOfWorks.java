package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.preanter.WorksPreanter;

import java.io.IOException;

public class DetailsOfWorks extends BaseActivity implements worksContreanter.IVew {


    private TextView tv_title, tv_date, tv_gu;
    private ImageView iv;
    private Button bton;
    private ImageView bt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_works;
    }

    @Override
    protected BasePreantert initModel() {
        return new WorksPreanter(this);
    }

    @Override
    protected void initView() {
        tv_title = findViewById(R.id.tv_title);
        tv_date = findViewById(R.id.tv_date);
        iv = findViewById(R.id.igv_iv);
        tv_gu = findViewById(R.id.tv_gu);
        bton = findViewById(R.id.bton);
        bt = findViewById(R.id.but_return);
    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof worksContreanter.IPreanter) {
            Intent intent = getIntent();
            int work_id = intent.getIntExtra("work_id", 0);
            ((worksContreanter.IPreanter) basePreantert).OnDetailsSuccess(work_id);
        }
    }

    @Override
    public void OnWorks(ListOfWorks listOfWorks) {

    }

    @Override
    public void OnDetailsWorks(DetailsOfWorksBean worksBean) {
        DetailsOfWorksBean.DataBean data1 = worksBean.getData();
        DetailsOfWorksBean.DataBean.WorkMsgBean workMsg = data1.getWorkMsg();

        String name = workMsg.getName();//名称
        String content = workMsg.getContent();//内容
        String imglist = workMsg.getImglist();//图片
        String create_time = workMsg.getCreate_time();//时间

        tv_title.setText("作品名称："+name);
        tv_date.setText("发布时间："+create_time);
        tv_gu.setText(content);
        String voice = workMsg.getVoice();
        if (voice == null) {
            bton.setVisibility(View.GONE);
        } else {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + imglist).into(iv);
            bton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    MediaPlayer mediaPlayer = new MediaPlayer();

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
