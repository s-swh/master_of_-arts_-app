package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.CourseDetailsActivity;
import com.wd.master_of_arts_app.bean.CourseDetails;

import java.util.List;

/**
 * @author 时文豪
 * @description: 课程详情列表评论
 * @date :2020/12/23 9:22
 */
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<CourseDetails.DataBean.CommentListBean> beanList;

    public CommentAdapter(Context context, List<CourseDetails.DataBean.CommentListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.commentitem, null);
        return new CommentViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseDetails.DataBean.CommentListBean commentListBean = beanList.get(position);
        ((CommentViewHorder)holder).it_date.setText(commentListBean.getComment_time());
        ((CommentViewHorder) holder).it_txt.setText(commentListBean.getContent());
        ((CommentViewHorder) holder).it_title.setText(commentListBean.getUser_nickname());
        Glide.with(context).load(commentListBean.getUser_avatar()).apply(RequestOptions.bitmapTransform(new RoundedCorners(200))).error(R.mipmap.ic_launcher_round).into(((CommentViewHorder)holder).it_img);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    class CommentViewHorder extends RecyclerView.ViewHolder {

        private final ImageView it_img;
        private final TextView it_date,it_title,it_txt;

        public CommentViewHorder(@NonNull View itemView) {
            super(itemView);
            it_img = itemView.findViewById(R.id.item_img);
            it_date = itemView.findViewById(R.id.item_date);
          it_title=  itemView.findViewById(R.id.item_title);
         it_txt=   itemView.findViewById(R.id.item_txt);
        }
    }
}
