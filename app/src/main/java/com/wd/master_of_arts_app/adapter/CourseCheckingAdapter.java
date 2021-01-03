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
import com.wd.master_of_arts_app.base.CourseChecking;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/3 12:37
 */
public class CourseCheckingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<CourseChecking.DataBean> list;
    private MyCourseAdapter.OnClick click1;
    public CourseCheckingAdapter(Context context, List<CourseChecking.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.coursecheckingitem, null);
        return new CourseCheckingViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseChecking.DataBean dataBean = list.get(position);
        String unit_name = dataBean.getUnit_name();
        String date = dataBean.getDate();
        String start_time = dataBean.getStart_time();
        String end_time = dataBean.getEnd_time();
        String teacher_name = dataBean.getTeacher_name();
        String avatar = dataBean.getAvatar();
        ((CourseCheckingViewHorder)holder).title.setText(start_time+"-"+end_time+"\t\t"+date);
        ((CourseCheckingViewHorder) holder).my_te.setText(unit_name);

        int sort_num = dataBean.getSort_num();
        ((CourseCheckingViewHorder) holder).sort_num.setText("第"+sort_num+"课");
        ((CourseCheckingViewHorder) holder).tv_name.setText(teacher_name);
        Glide.with(context).load(avatar).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(((CourseCheckingViewHorder)holder).iv);
        ((CourseCheckingViewHorder) holder).tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int course_time_id = dataBean.getCourse_time_id();
                int order_id = dataBean.getOrder_id();
                click1.OnCliack(course_time_id,order_id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnClick(MyCourseAdapter.OnClick click){
        click1 = click;
    }
    public interface OnClick{
        void OnCliack(int id,int order_id);
    }
    class CourseCheckingViewHorder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView title;
        private final TextView my_te ;
        private final TextView tv_name;
        private final TextView tv,sort_num;

        public CourseCheckingViewHorder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.my_tile);
            my_te = itemView.findViewById(R.id.myte);

            iv = itemView.findViewById(R.id.my_iv);
            tv_name = itemView.findViewById(R.id.my_name);
            tv = itemView.findViewById(R.id.Viewcoursedetails);
            sort_num = itemView.findViewById(R.id.sort_num);
        }
    }
}
