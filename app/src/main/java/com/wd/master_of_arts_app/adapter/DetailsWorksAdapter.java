package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;

import java.io.IOException;
import java.util.List;

/**
 * @author 时文豪
 * @description:  作品详情
 * @date :2020/12/28 10:16
 */
public class DetailsWorksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<DetailsOfWorksBean.DataBean.WorkMsgBean> list;

    public DetailsWorksAdapter(Context context, List<DetailsOfWorksBean.DataBean.WorkMsgBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.detailsworksitem, null);
        return new DetailsWorksViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DetailsOfWorksBean.DataBean.WorkMsgBean workMsgBean = list.get(position);
        String name = workMsgBean.getName();//名称
        String content = workMsgBean.getContent();//内容
        String imglist = workMsgBean.getImglist();//图片
        String create_time = workMsgBean.getCreate_time();//时间

        ((DetailsWorksViewHorder)holder).tv_title.setText(name);
        ((DetailsWorksViewHorder) holder).tv_date.setText(create_time);
        ((DetailsWorksViewHorder) holder).tv_gu.setText(content);
        String voice = workMsgBean.getVoice();
        if(voice==null){
            ((DetailsWorksViewHorder) holder).bton.setVisibility(View.GONE);
        }else{
            Glide.with(context).load("http://qiniu.54artist.com/"+imglist).into(((DetailsWorksViewHorder)holder).iv);
            ((DetailsWorksViewHorder) holder).bton.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View view) {
                    MediaPlayer   mediaPlayer = new MediaPlayer();

                    try {
                        mediaPlayer.setDataSource("http://qiniu.54artist.com/"+voice);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class DetailsWorksViewHorder extends RecyclerView.ViewHolder {
        private final TextView tv_title,tv_date,tv_gu;
        private final ImageView iv;
        private final Button bton;


        public DetailsWorksViewHorder(@NonNull View itemView) {
            super(itemView);
           tv_title= itemView.findViewById(R.id.tv_title);
          tv_date=   itemView.findViewById(R.id.tv_date);
            iv = itemView.findViewById(R.id.igv_iv);
          tv_gu=  itemView.findViewById(R.id.tv_gu);
            bton = itemView.findViewById(R.id.bton);


        }
    }
}
