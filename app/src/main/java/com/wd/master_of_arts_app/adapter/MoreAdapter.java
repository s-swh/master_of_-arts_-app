package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.CommBean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 16:18
 */
public class MoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<CommBean.DataBean.ListBean> beanList;

    public MoreAdapter(Context context, List<CommBean.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =   View.inflate(context, R.layout.moreimgitem, null);
        return  new MoreViewHorder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommBean.DataBean.ListBean listBean = beanList.get(position);
        String img = listBean.getImg();
        Glide.with(context).load(img).into(((MoreViewHorder)holder).iv);
        String title = listBean.getTitle();
        ((MoreViewHorder) holder).tv.setText(title);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    class MoreViewHorder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public MoreViewHorder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv_name);
        }
    }
}
