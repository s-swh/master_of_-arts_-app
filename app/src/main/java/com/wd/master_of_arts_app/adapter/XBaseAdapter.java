package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.CourseList;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/20 23:46
 */
public class XBaseAdapter<T> extends BaseAdapter {

    Context context; List<CourseList.DataBeanX.ListBean.DataBean> list;
    private ViewHorder viewHorder;
    private OnIdOnClick click;

    public XBaseAdapter(Context context, List<CourseList.DataBeanX.ListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    public void Refresh(List<CourseList.DataBeanX.ListBean.DataBean> temlist){   //下拉刷新
        this.list.clear();
        this.list.addAll(temlist);
    }
    public void LoadMore(List<CourseList.DataBeanX.ListBean.DataBean> telist){  //上拉加载

        this.list.addAll(telist);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
            return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(view==null){


            view = inflater.inflate(R.layout.baseitem, null);

            viewHorder = new ViewHorder();
         viewHorder.text_title=   view.findViewById(R.id.text_title);
            viewHorder.classhour=   view.findViewById(R.id.classhour);
            viewHorder.teacher=  view.findViewById(R.id.teacher);
            viewHorder.moneyone=  view.findViewById(R.id.moneyone);
            viewHorder.moneytow= view.findViewById(R.id.moneytow);
            viewHorder.attend=  view.findViewById(R.id.attend);
            viewHorder.imv=   view.findViewById(R.id.imv);
            viewHorder.ltv=   view.findViewById(R.id.ltv);
            view.setTag(viewHorder);
        }else{
            Object tag = view.getTag();
        }
        CourseList.DataBeanX.ListBean.DataBean dataBean = list.get(i);
        String course_name = dataBean.getCourse_name();
        viewHorder.text_title.setText(course_name);
        int unit_count = dataBean.getUnit_count();
        viewHorder.classhour.setText(unit_count+"课时");
        String teacher_name = dataBean.getTeacher_name();
        viewHorder.teacher.setText("任课老师："+teacher_name);
        String price = dataBean.getPrice();
        viewHorder.moneyone.setText("￥"+price);
        String old_price = dataBean.getOld_price();
        viewHorder.moneytow.setText("￥"+old_price);
        Object time_detail = dataBean.getTime_detail();
        viewHorder.attend.setText(time_detail+"");
        String teacher_avatar = dataBean.getTeacher_avatar();
        int id = dataBean.getId();

        Glide.with(context).load(teacher_avatar).error(R.mipmap.icon_lstx).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHorder.imv);
        viewHorder.ltv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            click.OnClick(id);
            }
        });
        return view;
    }
    public interface OnIdOnClick{
        void OnClick(int id);
    }
    public void OnClick(OnIdOnClick onIdOnClick){
        click = onIdOnClick;
    }
    class ViewHorder{
        TextView text_title;//班级名称
        TextView classhour;//课时
        TextView teacher;//任课老师
        TextView moneyone;//现价
        TextView moneytow;//原价
        TextView attend;//上课时间
        ImageView imv;//头像
        LinearLayout ltv;//点击事件
    }
}
