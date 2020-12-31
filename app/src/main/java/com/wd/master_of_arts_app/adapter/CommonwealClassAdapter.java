package com.wd.master_of_arts_app.adapter;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;

import java.util.List;

import cn.jzvd.JzvdStd;


/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 13:43
 */
public class CommonwealClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<CommBean.DataBean.ListBean> beanList;

    public CommonwealClassAdapter(Context context, List<CommBean.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.commitem, null);
        return new CommonwealViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommBean.DataBean.ListBean listBean = beanList.get(position);
        String href = listBean.getHref();
        String title = listBean.getTitle();
        try {
           // ((CommonwealViewHorder)holder).jc.setUp(href, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

        }catch (Exception e){
            e.printStackTrace();
        }


        ((CommonwealViewHorder) holder).tv.setText(title);
        ((CommonwealViewHorder) holder).v.setVideoURI(Uri.parse(href));
        ((CommonwealViewHorder) holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((CommonwealViewHorder) holder).v.start();
            }
        });
        //((CommonwealViewHorder)holder).jc.setUp(href,"",JzvdStd.SCREEN_WINDOW_NORMAL);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    class CommonwealViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv;

       // private final JzvdStd jc;
        private final VideoView v;


        public CommonwealViewHorder(@NonNull View itemView) {
            super(itemView);
            v = itemView.findViewById(R.id.videocontroller1);
         // jc = itemView.findViewById(R.id.videocontroller1);

            tv = itemView.findViewById(R.id.tv_tit);
        }
    }
}
