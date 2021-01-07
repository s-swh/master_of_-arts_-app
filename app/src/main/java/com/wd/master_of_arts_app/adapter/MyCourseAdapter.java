package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.CourseDetailsActivity;
import com.wd.master_of_arts_app.activity.myactivity.MyCourseDetails;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.bean.MyCurse;

import java.util.List;

/**
 * @author 时文豪
 * @description: 课程列表适配器
 * @date :2020/12/28 11:24
 */
public class MyCourseAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    Context context;
    List<MyCurse.DataBean.ListBean> list;
    private OnClick click1;

    public MyCourseAdapter(Context context, List<MyCurse.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.mycourseitem, null);
        return new MyCourseViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        MyCurse.DataBean.ListBean listBean = list.get(position);
        String title = listBean.getTitle();
        String time_detail = listBean.getTime_detail();
        String teacher_name = listBean.getTeacher_name();
        ((MyCourseViewHorder) holder).tle.setText(title);

        ((MyCourseViewHorder) holder).te.setText(time_detail);
        ((MyCourseViewHorder) holder).name.setText(teacher_name);
        String avatar = listBean.getAvatar();
        Glide.with(context).load(avatar).apply(RequestOptions.bitmapTransform(new RoundedCorners(500))).error(R.mipmap.ic_launcher_round).into(((MyCourseViewHorder)holder).iv);
        ((MyCourseViewHorder) holder).Viewcoursedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int course_time_id = listBean.getCourse_time_id();
                int order_id = listBean.getOrder_id();
                click1.OnCliack(course_time_id,order_id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnClick(OnClick click){
        click1 = click;
    }
    public interface OnClick{
        void OnCliack(int id,int order_id);
    }
    class MyCourseViewHorder extends XRecyclerView.ViewHolder {
        private final TextView tle,sort_num , te,name,Viewcoursedetails;
        private final ImageView iv;

        public MyCourseViewHorder(@NonNull View itemView) {
            super(itemView);
            tle = itemView.findViewById(R.id.my_tile);
            sort_num = itemView.findViewById(R.id.sort_num);

            te = itemView.findViewById(R.id.myte);
            iv = itemView.findViewById(R.id.my_iv);
            name = itemView.findViewById(R.id.my_name);
            Viewcoursedetails = itemView.findViewById(R.id.Viewcoursedetails);
        }
    }
}
