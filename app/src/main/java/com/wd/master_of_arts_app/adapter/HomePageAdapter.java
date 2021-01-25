package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.HomePage;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/13 19:44
 */
public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<HomePage.DataBean> list;
    private OnHomeOnClick click;

    public HomePageAdapter(Context context, List<HomePage.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.homeitem, null);
        return new HomePageViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomePage.DataBean dataBean = list.get(position);
        String date = dataBean.getDate();
        String time = dataBean.getTime();
        String unit_name = dataBean.getUnit_name();
        String button = dataBean.getButton();
        String avatar = dataBean.getAvatar();
        String teacher = dataBean.getTeacher();
        ((HomePageViewHorder) holder).left_title.setText(date);
        ((HomePageViewHorder) holder).left_date.setText(time);
        ((HomePageViewHorder) holder).left_tv.setText(unit_name);
        ((HomePageViewHorder) holder).tv_tvv.setText(button);
        String course_name = dataBean.getCourse_name();
        if (!avatar.isEmpty()) {
            Glide.with(context).load(avatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).error(R.mipmap.icon_tx).into(((HomePageViewHorder) holder).home_img);
        }

        if (!course_name.isEmpty()) {
            ((HomePageViewHorder) holder).home_tv.setText(course_name + "\n\t-任课老师-\n\t\t\t" + teacher);
            ((HomePageViewHorder) holder).rlh.setVisibility(View.VISIBLE);
        } else {
            ((HomePageViewHorder) holder).home_tv.setVisibility(View.GONE);
            ((HomePageViewHorder) holder).rlh.setVisibility(View.GONE);
        }

        ((HomePageViewHorder) holder).tv_tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.OnClickItem(list.get(position));
            }
        });
        int sort_num = dataBean.getSort_num();
        if (sort_num == 0) {
            ((HomePageViewHorder) holder).left_sort.setVisibility(View.GONE);
            ((HomePageViewHorder) holder).lh.setVisibility(View.GONE);
        } else {
            ((HomePageViewHorder) holder).lh.setVisibility(View.VISIBLE);
            ((HomePageViewHorder) holder).left_sort.setText("\n" + "第" + sort_num + "课");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void OnClick(OnHomeOnClick onHomeOnClick) {
        click = onHomeOnClick;
    }

    public interface OnHomeOnClick {
        void OnClickItem(HomePage.DataBean dataBean);
    }

    class HomePageViewHorder extends RecyclerView.ViewHolder {

        private final TextView left_title, left_date, left_tv, tv_tvv, home_tv, left_sort;
        private final ImageView home_img;
        private final View lh;
        private final View rlh;

        public HomePageViewHorder(@NonNull View itemView) {
            super(itemView);
            left_title = itemView.findViewById(R.id.left_title);
            left_date = itemView.findViewById(R.id.left_date);
            left_tv = itemView.findViewById(R.id.left_tv);
            tv_tvv = itemView.findViewById(R.id.tv_tvv);
            home_img = itemView.findViewById(R.id.home_img);
            home_tv = itemView.findViewById(R.id.home_tv);
            left_sort = itemView.findViewById(R.id.left_sort);
            lh = itemView.findViewById(R.id.lh);
            rlh = itemView.findViewById(R.id.rlh);
        }
    }
}
