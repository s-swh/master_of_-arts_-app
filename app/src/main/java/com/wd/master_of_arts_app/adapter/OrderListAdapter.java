package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.bean.OrderDelete;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.ViewLogist;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 8:50
 */
public class OrderListAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    Context context; List<OrderList.DataBean.ListBean> beanList;
    private OrderListAdapter.itdelete itdelete;
    private idtet idtet1;
    private Ckwl ckwl1;

    public OrderListAdapter(Context context, List<OrderList.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }
    public void Refresh(List<OrderList.DataBean.ListBean> beanList){

        notifyDataSetChanged();
    }
    public void Load( List<OrderList.DataBean.ListBean> beanList){
        this.beanList.addAll(beanList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.orderlistitem, null);
        return new OrderListViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        OrderList.DataBean.ListBean listBean = beanList.get(position);
        String order_num = listBean.getOrder_num();
        String title = listBean.getTitle();
        String allprice = listBean.getAllprice();
        String time_detail = listBean.getTime_detail();
        String create_time = listBean.getCreate_time();
        int unit_count = listBean.getUnit_count();
        ((OrderListViewHorder)holder).tv_number.setText("订单号："+order_num);
        ((OrderListViewHorder) holder).tv_title.setText(title);
        ((OrderListViewHorder) holder).tv_date1.setText("课程章节:"+unit_count);
        ((OrderListViewHorder) holder).tv_date2.setText("上课时间:"+time_detail+create_time);
        ((OrderListViewHorder) holder).tv_money.setText(allprice);
            ((OrderListViewHorder) holder).lt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = listBean.getId();
                    idtet1.OnClick(id);
                }
            });
        int status = listBean.getStatus();
        if(status==1){
            ((OrderListViewHorder) holder).bt_order.setText("去支付");
            //   ((OrderListViewHorder) holder).order_qxdd.setVisibility(View.VISIBLE);
        }else if(status==2){
            ((OrderListViewHorder) holder).bt_order.setText("已付款");
          ((OrderListViewHorder) holder).order_ckwl.setVisibility(View.VISIBLE);
            ((OrderListViewHorder) holder).order_ckwl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ckwl1.OnClick(beanList.get(position));
                }
            });

        }else if(status==4){
            ((OrderListViewHorder) holder).bt_order.setText("已取消");
        }
        String icon = listBean.getIcon();
        Glide.with(context).load(icon).error(R.mipmap.ic_launcher_round).into(((OrderListViewHorder)holder).tv_iv);
        ((OrderListViewHorder) holder).iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = listBean.getId();
                itdelete.Click(id);
            }
        });

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    public void delete(itdelete cet){
        itdelete = cet;
    }
    public interface itdelete{
        void Click(int id);
    }
    public void OnClick(idtet idtet){
        idtet1 = idtet;
    }
    public interface idtet{
        void OnClick(int id);
    }
    public void OnClickwl(Ckwl ckwl){
        ckwl1 = ckwl;
    }
    public interface Ckwl{
        void OnClick(OrderList.DataBean.ListBean  listBean);
    }
    class OrderListViewHorder extends XRecyclerView.ViewHolder {

        private final TextView tv_number,tv_title,tv_date1,tv_date2,tv_money,order_ckwl,order_qxdd;
        private final ImageView tv_iv,iv_delete;
        private final  TextView bt_order;
        private final LinearLayout lt;

        public OrderListViewHorder(@NonNull View itemView) {
            super(itemView);
            tv_number = itemView.findViewById(R.id.order_number);
            tv_iv = itemView.findViewById(R.id.order_iv);
           tv_title=   itemView.findViewById(R.id.order_title);
           tv_date1=   itemView.findViewById(R.id.order_date1);
           tv_date2=   itemView.findViewById(R.id.order_date2);
          iv_delete=    itemView.findViewById(R.id.order_delete);
          tv_money=    itemView.findViewById(R.id.order_money);
           bt_order= itemView.findViewById(R.id.order_but);
            lt = itemView.findViewById(R.id.precode);
            order_ckwl = itemView.findViewById(R.id.order_ckwl);
            order_qxdd = itemView.findViewById(R.id.order_qxdd);
        }
    }
}
