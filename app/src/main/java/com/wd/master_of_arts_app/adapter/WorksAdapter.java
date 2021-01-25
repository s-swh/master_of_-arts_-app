package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.customview.Img;
import com.wd.master_of_arts_app.fragment.Take_photos;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/25 14:01
 */
public class WorksAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    Context context;
    List<ListOfWorks.DataBean.ListBean> list;
    private OnClickWorks clickWorks1;
    private String string1;
    private String string2;


    public WorksAdapter(Context context, List<ListOfWorks.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public void Refresh(List<ListOfWorks.DataBean.ListBean> listitem) {
      list.clear();
    }

    public void LoadMore(List<ListOfWorks.DataBean.ListBean> listtem) {
         list.addAll(listtem);
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
        ((WorksViewHorder) holder).tt.setText(name);
        String substring = create_time.substring(5, 10);
        ((WorksViewHorder) holder).tv.setText(substring);
        String imglist = listBean.getImglist();
        String is_comment = listBean.getIs_comment();
        if (is_comment.equals("Y")) {
            ((WorksViewHorder) holder).ydp.setVisibility(View.VISIBLE);
            ((WorksViewHorder) holder).wdp.setVisibility(View.GONE);

        } else if (is_comment.equals("N")) {
            ((WorksViewHorder) holder).wdp.setVisibility(View.VISIBLE);
            ((WorksViewHorder) holder).ydp.setVisibility(View.GONE);

        }
        Log.i("imglistxxx", imglist);

        Gson gson = new Gson();
        String[] strings = gson.fromJson(imglist, String[].class);
        for (int i = 0; i < strings.length; i++) {
            if (strings.length == 3) {
                Glide.with(context).load("http://qiniu.54artist.com/" + strings[0]).into(((WorksViewHorder) holder).img1);
                Glide.with(context).load("http://qiniu.54artist.com/" + strings[1]).into(((WorksViewHorder) holder).img2);
                Glide.with(context).load("http://qiniu.54artist.com/" + strings[2]).into(((WorksViewHorder) holder).img3);


            } else if (strings.length == 2) {
                Glide.with(context).load("http://qiniu.54artist.com/" + strings[0]).into(((WorksViewHorder) holder).img1);
                Glide.with(context).load("http://qiniu.54artist.com/" + strings[1]).into(((WorksViewHorder) holder).img2);
                ((WorksViewHorder) holder).img3.setVisibility(View.GONE);


            } else if (strings.length == 1) {
                Glide.with(context).load("http://qiniu.54artist.com/" + strings[0]).into(((WorksViewHorder) holder).img1);
                ((WorksViewHorder) holder).img2.setVisibility(View.GONE);
                ((WorksViewHorder) holder).img3.setVisibility(View.GONE);

            }
        }


        ((WorksViewHorder) holder).et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int work_id = listBean.getWork_id();
                if (work_id != 0) {
                    clickWorks1.click(work_id);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null ? 0:list.size();
    }

    public void OnClickWorks(OnClickWorks clickWorks) {
        clickWorks1 = clickWorks;
    }

    public interface OnClickWorks {
        void click(int id);
    }

    class WorksViewHorder extends RecyclerView.ViewHolder {

        private final ImageView img1, img2, img3, wdp, ydp;
        private final TextView tv;
        private final TextView tt;
        private final LinearLayout et;

        public WorksViewHorder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.image_1);
            img2 = itemView.findViewById(R.id.image_2);
            img3 = itemView.findViewById(R.id.image_3);
            tv = itemView.findViewById(R.id.work_data);
            tt = itemView.findViewById(R.id.work_txt);
            et = itemView.findViewById(R.id.Detailsofworks);
            wdp = itemView.findViewById(R.id.wdp);
            ydp = itemView.findViewById(R.id.ydp);


        }
    }
}
