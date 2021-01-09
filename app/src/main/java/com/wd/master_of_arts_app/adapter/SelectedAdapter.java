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


/**
 * @author 时文豪
 * @description:
 * @date :2020/12/23 10:33
 */
public class SelectedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context; List<ArticleList.DataBean.SelectedWorksBean> list;
    private ImageOnClick imageOnClick;

    public SelectedAdapter(Context context, List<ArticleList.DataBean.SelectedWorksBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.selecteditem, null);
        return new SelectedViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArticleList.DataBean.SelectedWorksBean selectedWorksBean = list.get(position);
        String img = selectedWorksBean.getImg();
        Glide.with(context).load(img).into(((SelectedViewHorder)holder).jc);
        String title = selectedWorksBean.getTitle();
        ((SelectedViewHorder)holder).tv.setText(title);
        ((SelectedViewHorder)holder).jc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageOnClick.OnClickImage(img);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void SetOnClick(ImageOnClick onClick){
        imageOnClick = onClick;
    }
    public interface ImageOnClick{
        void OnClickImage(String href);
    }
    class SelectedViewHorder extends RecyclerView.ViewHolder {
        private final ImageView jc;
        private final TextView tv;
        public SelectedViewHorder(@NonNull View itemView) {
            super(itemView);
            jc = itemView.findViewById(R.id.jc);
            tv = itemView.findViewById(R.id.tv_tit);
        }
    }
}
