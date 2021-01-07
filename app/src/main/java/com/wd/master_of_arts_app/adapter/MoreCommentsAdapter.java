package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.MoreComm;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 9:04
 */
public class MoreCommentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<MoreComm.DataBean.ListBean> beanList;

    public MoreCommentsAdapter(Context context, List<MoreComm.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.morecommentsitem, null);
        return new MoreCommentsViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MoreComm.DataBean.ListBean listBean = beanList.get(position);
        String content = listBean.getContent();
        String comment_time = listBean.getComment_time();
        String user_nickname = listBean.getUser_nickname();
        String user_avatar = listBean.getUser_avatar();
        ((MoreCommentsViewHorder)holder).more_content.setText(content);
        ((MoreCommentsViewHorder) holder).more_time.setText(comment_time);
        ((MoreCommentsViewHorder) holder).more_name.setText(user_nickname);
        Glide.with(context).load(user_avatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).error(R.mipmap.ic_launcher_round).into(((MoreCommentsViewHorder)holder).more_iv);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    class MoreCommentsViewHorder extends RecyclerView.ViewHolder {

        private final ImageView more_iv;
        private final TextView more_name,more_time,more_content;

        public MoreCommentsViewHorder(@NonNull View itemView) {
            super(itemView);
            more_iv = itemView.findViewById(R.id.more_iv);
            more_name = itemView.findViewById(R.id.more_name);
           more_time= itemView.findViewById(R.id.more_time);
          more_content=  itemView.findViewById(R.id.more_content);
        }
    }
}
