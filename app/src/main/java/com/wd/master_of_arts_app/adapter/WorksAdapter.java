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
    private OnClickWorks clickWorks1;

    public WorksAdapter(Context context, List<ListOfWorks.DataBean.ListBean> list) {
        this.context=context;
        this.list=list;
    }
    public void Refresh(List<ListOfWorks.DataBean.ListBean> list){
        this.list=list;
        notifyDataSetChanged();
    }
    public void LoadMore(List<ListOfWorks.DataBean.ListBean> list){
        list=this.list;
        notifyDataSetChanged();
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
        ((WorksViewHorder)holder).et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int work_id = listBean.getWork_id();
                clickWorks1.click(work_id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void OnClickWorks(OnClickWorks clickWorks){
        clickWorks1 = clickWorks;
    }
    public interface OnClickWorks{
        void click(int id);
    }
    class WorksViewHorder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;
        private final TextView tt;
        private final LinearLayout et;

        public WorksViewHorder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.work_img);
            tv = itemView.findViewById(R.id.work_data);
            tt = itemView.findViewById(R.id.work_txt);
            et = itemView.findViewById(R.id.Detailsofworks);

        }
    }
}
