package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    Context context;CourseDetails.DataBean bean;
    private OnService service1;
    public ServiceActivity(Context context, CourseDetails.DataBean bean) {
        this.context = context;
        this.bean = bean;
    }
  /*  Context context; List<CourseDetails.DataBean.ServiceBean> list;


    public ServiceActivity(Context context, List<CourseDetails.DataBean.ServiceBean> list) {
        this.context = context;
        this.list = list;
    }*/

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.serviceitem, null);
        return new ServiceViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<CourseDetails.DataBean.ServiceBean> service2 = bean.getService();
        CourseDetails.DataBean.ServiceBean serviceBean = service2.get(position);
        String service3 = serviceBean.getService();
    //    String service = serviceBean.getService();
        ((ServiceViewHorder)holder).t.setText(service3+" ");
        ((ServiceViewHorder)holder).ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service1.OnCliakc(bean.getService().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.getService().size();
    }
    public void OnClicked(OnService service){
        service1 = service;
    }
    public interface OnService{
        void OnCliakc(CourseDetails.DataBean.ServiceBean dataBean);
    }
  class  ServiceViewHorder extends RecyclerView.ViewHolder {

      private final TextView t;
      private final LinearLayout ft;

      public ServiceViewHorder(@NonNull View itemView) {
          super(itemView);
          t = itemView.findViewById(R.id.ser_txt);
          ft = itemView.findViewById(R.id.fw);
      }
  }
}
