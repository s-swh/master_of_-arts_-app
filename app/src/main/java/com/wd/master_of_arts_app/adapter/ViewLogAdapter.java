package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.Logistics;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 9:43
 */
public class ViewLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<Logistics.DataBean.LogisticsMsgBean.ListBean> beanList;

    public ViewLogAdapter(Context context, List<Logistics.DataBean.LogisticsMsgBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.viewlogitem, null);
        return new ViewLogViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Logistics.DataBean.LogisticsMsgBean.ListBean listBean = beanList.get(position);
        String datetime = listBean.getDatetime();
        String remark = listBean.getRemark();
        String zone = listBean.getZone();
        ((ViewLogViewHorder)holder).date.setText(datetime);
        ((ViewLogViewHorder) holder).address.setText(remark);
        ((ViewLogViewHorder) holder).zone.setText(zone);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    class ViewLogViewHorder extends RecyclerView.ViewHolder {

        private final TextView date,address,zone;

        public ViewLogViewHorder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.viewitem_date);
           address= itemView.findViewById(R.id.viewitem_address);
          zone=  itemView.findViewById(R.id.viewitem_zone);
        }
    }
}
