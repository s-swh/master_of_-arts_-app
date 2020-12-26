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
 * @date :2020/12/26 10:42
 */
public class PopServiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    CourseDetails.DataBean bean;

    public PopServiceAdapter(Context context, CourseDetails.DataBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.popserviceitem, null);
        return new PopViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<CourseDetails.DataBean.ServiceBean> service = bean.getService();
        CourseDetails.DataBean.ServiceBean serviceBean = service.get(position);
        String service1 = serviceBean.getService();
        String description = serviceBean.getDescription();
        ((PopViewHorder) holder).ttu.setText(description);
        ((PopViewHorder) holder).zk.setText(service1);
        String icon = serviceBean.getIcon();
        Glide.with(context).load(icon).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).error(R.mipmap.ic_launcher_round).into(((PopViewHorder) holder).iv);
    }

    @Override
    public int getItemCount() {
        return bean.getService().size();
    }

    class PopViewHorder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView zk;
        private final TextView ttu;

        public PopViewHorder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.phot_img);
            zk = itemView.findViewById(R.id.zhekou);
            ttu = itemView.findViewById(R.id.tt_u);
        }
    }
}
