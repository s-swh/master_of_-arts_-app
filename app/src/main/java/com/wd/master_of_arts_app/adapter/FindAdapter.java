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
import com.wd.master_of_arts_app.bean.ArticleList;
import java.util.List;

import cn.jzvd.JzvdStd;

/**
 * @author 时文豪
 * @description:  免费课适配器
 * @date :2020/12/21 15:19
 */
public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context; List<ArticleList.DataBean.FreeVideoBean> list;
    private OnClickHref clickHref;

    public FindAdapter(Context context, List<ArticleList.DataBean.FreeVideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.finditem, null);
        return new FindViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ArticleList.DataBean.FreeVideoBean freeVideoBean = list.get(position);
        String href = freeVideoBean.getHref();
        String title = freeVideoBean.getTitle();
        String img = freeVideoBean.getImg();
        Glide.with(context).load(img).into(((FindViewHorder)holder).jc);

        ((FindViewHorder) holder).tv.setText(title);
        ((FindViewHorder)holder).jc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHref.OnClick(href,title);
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    public void OnClick(OnClickHref href){
        clickHref = href;
    }
    public interface OnClickHref{
        void OnClick(String href,String name);
    }
    class FindViewHorder extends RecyclerView.ViewHolder {

        private final ImageView jc;
        private final TextView tv;

        public FindViewHorder(@NonNull View itemView) {
            super(itemView);
            jc = itemView.findViewById(R.id.jc);
            tv = itemView.findViewById(R.id.tv_tit);
        }
    }
}
