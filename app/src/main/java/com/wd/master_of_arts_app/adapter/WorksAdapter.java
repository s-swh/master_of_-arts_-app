package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.fragment.Take_photos;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/25 14:01
 */
public class WorksAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    Context context; List<ListOfWorks.DataBean.ListBean> list;
    public WorksAdapter(Context context, List<ListOfWorks.DataBean.ListBean> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.worksitem, null);
        return new WorksViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        ListOfWorks.DataBean.ListBean listBean = list.get(position);
        String name = listBean.getName();
        String create_time = listBean.getCreate_time();
        ((WorksViewHorder)holder).tt.setText(name);
        ((WorksViewHorder) holder).tv.setText(create_time);
        String imglist = listBean.getImglist();

        Glide.with(context).load("http://qiniu.54artist.com/"+imglist).into(((WorksViewHorder)holder).img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class WorksViewHorder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;
        private final TextView tt;

        public WorksViewHorder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.work_img);
            tv = itemView.findViewById(R.id.work_data);
            tt = itemView.findViewById(R.id.work_txt);

        }
    }
}
