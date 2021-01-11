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
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.SampleReels;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 14:45
 */
public class SampleReelsAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    Context context;
    List<SampleReels.DataBean.ListBean> list;
    private ItemOnClick click1;

    public SampleReelsAdapter(Context context, List<SampleReels.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.sampleitem, null);
        return new SampleReelsViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        SampleReels.DataBean.ListBean listBean = list.get(position);
        String comment_time = listBean.getComment_time();
        String name = listBean.getName();
        String imglist = listBean.getImglist();
        ((SampleReelsViewHorder) holder).date.setText(comment_time);
        ((SampleReelsViewHorder) holder).date.setText(100 + (position % 3) * 30);
        ((SampleReelsViewHorder) holder).name.setText(name);
        ((SampleReelsViewHorder) holder).name.setHeight(100 + (position % 3) * 30);
        ((SampleReelsViewHorder) holder).iv.setMaxHeight(100 + (position % 2) * 10);
        String url = "http://qiniu.54artist.com/" + imglist;
        Glide.with(context).load(url).error(R.drawable.ic_launcher_background).into(((SampleReelsViewHorder) holder).iv);
        ((SampleReelsViewHorder) holder).sample_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click1.OnClick(url);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void OnItemClick(ItemOnClick click) {
        click1 = click;
    }

    public interface ItemOnClick {
        void OnClick(String href);
    }

    class SampleReelsViewHorder extends XRecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView name;
        private final TextView date;
        private final LinearLayout sample_iv;

        public SampleReelsViewHorder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.sampl_iv);
            name = itemView.findViewById(R.id.sampl_name);
            date = itemView.findViewById(R.id.sampl_date);
            sample_iv = itemView.findViewById(R.id.sample_iv);
        }
    }
}
