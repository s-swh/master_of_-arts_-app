package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;

import java.util.List;

/**
 * @author 时文豪
 * @description:  课程适配器
 * @date :2020/12/18 15:37
 */
public class CourseAdapter  extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    Context context; List<CourseList.DataBeanX.ListBean.DataBean> list;
    private OnIdClick onIdClick;

    public CourseAdapter(Context context, List<CourseList.DataBeanX.ListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    public void Refresh( List<CourseList.DataBeanX.ListBean.DataBean> list){
      list.addAll(this.list);
        notifyDataSetChanged();
    }
    public void LoadMore(List<CourseList.DataBeanX.ListBean.DataBean> list){
        this.list.addAll(this.list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.courseitem, null);
        return new CourseViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseList.DataBeanX.ListBean.DataBean dataBean1 = list.get(position);

        String course_name = dataBean1.getCourse_name();
        String teacher_name = dataBean1.getTeacher_name();
        String old_price = dataBean1.getOld_price();
        String price = dataBean1.getPrice();
        int unit_count = dataBean1.getUnit_count();
        Object time_detail = dataBean1.getTime_detail();
        String teacher_avatar = dataBean1.getTeacher_avatar();
        ((CourseViewHorder)holder).moneyone.setText(price);//现在价格
        ((CourseViewHorder) holder).moneytow.setText(old_price);//之前价格
        ((CourseViewHorder) holder).text_title.setText(course_name);//班
        ((CourseViewHorder) holder).teacher.setText("任课老师："+teacher_name);//任课老师
        ((CourseViewHorder) holder).classhour.setText("课时："+unit_count);//课时
        ((CourseViewHorder) holder).attend.setText(time_detail+"");
        Glide.with(context).load(teacher_avatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).error(R.mipmap.ic_launcher_round).into(((CourseViewHorder)holder).vv);
        ((CourseViewHorder)holder).ltv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = dataBean1.getId();

                onIdClick.onclick(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void OnIdClick(OnIdClick click){
        onIdClick = click;
    }
    public interface OnIdClick{
        void onclick(int id);
    }
    class CourseViewHorder extends XRecyclerView.ViewHolder {

        private final TextView text_title,moneyone,moneytow,teacher,classhour,attend;
        private final ImageView vv;
        private final LinearLayout ltv;

        public CourseViewHorder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            moneyone=itemView.findViewById(R.id.moneyone);
            moneytow=itemView.findViewById(R.id.moneytow);
            teacher=itemView.findViewById(R.id.teacher);
            classhour=itemView.findViewById(R.id.classhour);
            attend=itemView.findViewById(R.id.attend);
            vv = itemView.findViewById(R.id.imv);
            ltv = itemView.findViewById(R.id.ltv);
        }
    }
}
