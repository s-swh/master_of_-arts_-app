package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.CommBean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 16:49
 */
public class GiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<CommBean.DataBean.ListBean> beanList;
    private OnHrefClick hrefClick;

    public GiveAdapter(Context context, List<CommBean.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.giveitem, null);
        return new GiveViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommBean.DataBean.ListBean listBean = beanList.get(position);
        String img = listBean.getImg();
        Glide.with(context).load(img).into(((GiveViewHorder)holder).iv);

        String title = listBean.getTitle();
        ((GiveViewHorder) holder).tv_name.setText(title);
        ((GiveViewHorder)holder).iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String href = listBean.getHref();
                hrefClick.OnClick(href);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    public void OnClick(OnHrefClick click){
        hrefClick = click;
    }
    public interface OnHrefClick{
        void OnClick(String href);
    }
    class GiveViewHorder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv_name;

        public GiveViewHorder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.text_1);
        }
    }
}
