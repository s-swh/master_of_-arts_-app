package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;

import java.util.List;

/**
 * @author 时文豪
 * @description: 我的课程详情适配器
 * @date :2020/12/29 10:28
 */
public class MyCourseAdapterData extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<MyCourseDetailsBean.DataBean.UnitListBean> beanList;
    private OnClickZYe zYe;

    public MyCourseAdapterData(Context context, List<MyCourseDetailsBean.DataBean.UnitListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.courseitemdata, null);
        return new MyCourseDataViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyCourseDetailsBean.DataBean.UnitListBean unitListBean = beanList.get(position);
        String date = unitListBean.getDate();
        int sort_num = unitListBean.getSort_num();
        String unit_name = unitListBean.getUnit_name();
        ((MyCourseDataViewHorder) holder).tv.setText(date);
        ((MyCourseDataViewHorder) holder).num.setText("第" + sort_num + "课");
        ((MyCourseDataViewHorder) holder).name.setText(unit_name);
        int unit_id = unitListBean.getUnit_id();
        int homework_id = unitListBean.getHomework_id();
        ((MyCourseDataViewHorder) holder).myzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              zYe.onClickzy(unit_id,homework_id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public void OnClickZYe(OnClickZYe clickZYe){
        zYe = clickZYe;
    }
    public interface OnClickZYe {
        void onClickzy(int id,int cid);
    }

    class MyCourseDataViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv, num, name;
        private RelativeLayout myzu, myhf;

        public MyCourseDataViewHorder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.zrdate);
            num = itemView.findViewById(R.id.ort_num);
            name = itemView.findViewById(R.id.unit_name);
            myzu = itemView.findViewById(R.id.my_zy);
            myhf = itemView.findViewById(R.id.myhf);
        }
    }
}
