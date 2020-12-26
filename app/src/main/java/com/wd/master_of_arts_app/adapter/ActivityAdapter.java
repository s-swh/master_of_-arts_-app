package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    Context context;
    List<CourseDetails.DataBean.MarkBean> list;
    private cnClick click1;

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
        ((AactivityViewHorder) holder).tv.setText(mark);
        ((AactivityViewHorder) holder).activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click1.OnClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void Click(cnClick click) {
        click1 = click;
    }

    public interface cnClick {
        void OnClick(CourseDetails.DataBean.MarkBean markBeans);
    }

    class AactivityViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final LinearLayout activity;

        public AactivityViewHorder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.ser_txt);
            activity = itemView.findViewById(R.id.activity);
        }
    }
}
