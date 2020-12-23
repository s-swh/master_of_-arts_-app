package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.CourseDetailsActivity;
import com.wd.master_of_arts_app.bean.CourseDetails;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/23 10:16
 */
public class ActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<CourseDetails.DataBean.MarkBean> list;

    public ActivityAdapter(Context context, List<CourseDetails.DataBean.MarkBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.activityitem, null);
        return new AactivityViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseDetails.DataBean.MarkBean markBean = list.get(position);
        String mark = markBean.getMark();
        ((AactivityViewHorder)holder).tv.setText(mark);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class AactivityViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public AactivityViewHorder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.ser_txt);
        }
    }
}
