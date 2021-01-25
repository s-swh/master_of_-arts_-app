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
import com.wd.master_of_arts_app.bean.CourseDetails;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/26 10:53
 */
public class PopActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<CourseDetails.DataBean.MarkBean> list;

    public PopActivityAdapter(Context context, List<CourseDetails.DataBean.MarkBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.popactivityitem, null);
        return new ActivityViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseDetails.DataBean.MarkBean markBean = list.get(position);
        String mark = markBean.getMark();
        String description = markBean.getDescription();
        ((ActivityViewHorder) holder).ttu.setText(description);
        ((ActivityViewHorder) holder).zk.setText(mark);
        String icon = markBean.getIcon();
        Glide.with(context).load(icon).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).error(R.mipmap.ic_launcher_round).into(((ActivityViewHorder) holder).iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ActivityViewHorder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView zk;
        private final TextView ttu;

        public ActivityViewHorder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.phot_img);
            zk = itemView.findViewById(R.id.zhekou);
            ttu = itemView.findViewById(R.id.tt_u);
        }
    }
}
