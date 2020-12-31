package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.ArticleList;

import java.util.List;

import cn.jzvd.JzvdStd;


/**
 * @author 时文豪
 * @description:
 * @date :2020/12/23 15:48
 */
public class MyVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<ArticleList.DataBean.MyVideoBean> list;

    public MyVideoAdapter(Context context, List<ArticleList.DataBean.MyVideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.myitem, null);
        return new MyViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArticleList.DataBean.MyVideoBean myVideoBean = list.get(position);
        String href = myVideoBean.getHref();
        String title = myVideoBean.getTitle();
        ((MyViewHorder) holder).tv.setText(title);
        ((MyViewHorder) holder).jc.setUp(href,"",JzvdStd.SCREEN_WINDOW_NORMAL);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHorder extends RecyclerView.ViewHolder {
        private final JzvdStd jc;
        private final TextView tv;
        public MyViewHorder(@NonNull View itemView) {
            super(itemView);
            jc = itemView.findViewById(R.id.jc);
            tv = itemView.findViewById(R.id.tv_tit);
        }
    }
}
