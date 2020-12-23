package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.CourseDetailsActivity;
import com.wd.master_of_arts_app.bean.CourseDetails;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/23 10:03
 */
public class ServiceActivity extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context; List<CourseDetails.DataBean.ServiceBean> list;

    public ServiceActivity(Context context, List<CourseDetails.DataBean.ServiceBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.serviceitem, null);
        return new ServiceViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseDetails.DataBean.ServiceBean serviceBean = list.get(position);
        String service = serviceBean.getService();
        ((ServiceViewHorder)holder).t.setText(service+" ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
  class  ServiceViewHorder extends RecyclerView.ViewHolder {

      private final TextView t;

      public ServiceViewHorder(@NonNull View itemView) {
          super(itemView);
          t = itemView.findViewById(R.id.ser_txt);
      }
  }
}
