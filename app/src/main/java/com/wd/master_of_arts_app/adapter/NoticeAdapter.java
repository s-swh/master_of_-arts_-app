package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.NoticeBean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 15:24
 */
public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;List<NoticeBean.DataBeanX.ListBean.DataBean> list;
    private OnClick click1;

    public NoticeAdapter(Context context, List<NoticeBean.DataBeanX.ListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.noticeitem, null);
        return new NoticeViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NoticeBean.DataBeanX.ListBean.DataBean dataBean = list.get(position);
        String title = dataBean.getTitle();
        String create_time = dataBean.getCreate_time();
        String content = dataBean.getContent();
        ((NoticeViewHorder)holder).tv_title.setText(title);
        ((NoticeViewHorder) holder).tv_date.setText(create_time);
        String des = dataBean.getDes();
        ((NoticeViewHorder) holder).tv_content.setText(des);
        String is_read = dataBean.getIs_read();
        if(is_read.equals("N")){
            ((NoticeViewHorder) holder).notice_img.setVisibility(View.VISIBLE);
        }else if(is_read.equals("Y")){
            ((NoticeViewHorder) holder).notice_img.setVisibility(View.GONE);
        }
        ((NoticeViewHorder) holder).notice_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = dataBean.getId();
                click1.OnClick(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void OnSetItem(OnClick click){
        click1 = click;
    }
    public interface OnClick{
        void OnClick(int id);
    }
    class NoticeViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv_title,tv_date,tv_content;
        private final ImageView notice_img;
        private final LinearLayout notice_time;
        public NoticeViewHorder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.notice_title);
            tv_date = itemView.findViewById(R.id.notice_date);
            tv_content = itemView.findViewById(R.id.notice_content);
            notice_img = itemView.findViewById(R.id.notice_img);
            notice_time = itemView.findViewById(R.id.notice_time);
        }
    }
}
