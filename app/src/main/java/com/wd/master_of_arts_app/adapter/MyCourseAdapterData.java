package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;

import java.util.List;

/**
 * @author 时文豪
 * @description:  我的课程详情适配器
 * @date :2020/12/29 10:28
 */
public class MyCourseAdapterData extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<MyCourseDetailsBean.DataBean.UnitListBean> beanList;

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
        ((MyCourseDataViewHorder)holder).tv.setText(date);
        ((MyCourseDataViewHorder) holder).num.setText(sort_num+"");
        ((MyCourseDataViewHorder) holder).name.setText(unit_name);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    class MyCourseDataViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv,num,name,myzu,myhf;

        public MyCourseDataViewHorder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.zrdate);
            num=    itemView.findViewById(R.id.ort_num);
             name=   itemView.findViewById(R.id.unit_name);
            myzu=    itemView.findViewById(R.id.myzy);
              myhf=  itemView.findViewById(R.id.myhf);
        }
    }
}
