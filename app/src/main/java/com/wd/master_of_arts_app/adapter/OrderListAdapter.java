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
    Context context;
    List<OrderList.DataBean.ListBean> beanList;
    private OrderListAdapter.itdelete itdelete;
    private idtet idtet1;
    private Ckwl ckwl1;
    private OnClickQZF onClickQZF;

    public OrderListAdapter(Context context, List<OrderList.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    public void Refresh(List<OrderList.DataBean.ListBean> beanList) {
        this.beanList.clear();
    }

    public void Load(List<OrderList.DataBean.ListBean> beanList) {
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
        String express_number = listBean.getExpress_number();
        String logistics = listBean.getLogistics();
        ((OrderListViewHorder) holder).tv_number.setText("订单号：" + order_num);
        ((OrderListViewHorder) holder).tv_title.setText(title);
        ((OrderListViewHorder) holder).tv_date1.setText("课程章节：" + unit_count+"课时");
        ((OrderListViewHorder) holder).tv_date2.setText("上课时间：" + time_detail);
        ((OrderListViewHorder) holder).tv_money.setText(allprice);
        ((OrderListViewHorder) holder).lt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = listBean.getId();
                idtet1.OnClick(id);
            }
        });
        int status = listBean.getStatus();
        if (status == 1) {
            ((OrderListViewHorder) holder).iv_delete.setVisibility(View.VISIBLE);
            ((OrderListViewHorder) holder).bt_order.setText("去支付");
            int course_id = listBean.getCourse_id();
            ((OrderListViewHorder) holder).iv_delete.setVisibility(View.GONE);
            int course_time_id = listBean.getCourse_time_id();
            ((OrderListViewHorder) holder).order_ckwl.setVisibility(View.GONE);
            ((OrderListViewHorder) holder).bt_order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = listBean.getId();
                    String allprice1 = listBean.getAllprice();
                    onClickQZF.OnClickQZF(id, allprice1);
                }
            });

        } else if (status == 2) {
            ((OrderListViewHorder) holder).bt_order.setText("已付款");
            ((OrderListViewHorder) holder).iv_delete.setVisibility(View.GONE);


        } else if (status == 4) {
            ((OrderListViewHorder) holder).order_ckwl.setVisibility(View.GONE);
            ((OrderListViewHorder) holder).bt_order.setText("已取消");
            ((OrderListViewHorder) holder).iv_delete.setVisibility(View.VISIBLE);
        }
        String icon = listBean.getIcon();
        Glide.with(context).load(icon).error(R.mipmap.ic_launcher_round).into(((OrderListViewHorder) holder).tv_iv);
        ((OrderListViewHorder) holder).iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = listBean.getId();
                itdelete.Click(id);
            }
        });
        ((OrderListViewHorder) holder).order_ckwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ckwl1.OnClick(express_number, logistics);
            }
        });
    }



    //查看物流
    public void OnClickwl(Ckwl ckwl) {
        ckwl1 = ckwl;
    }

    public interface Ckwl {
        void OnClick(String d, String w);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public void delete(itdelete cet) {
        itdelete = cet;
    }

    public interface itdelete {
        void Click(int id);
    }

    public void OnClick(idtet idtet) {
        idtet1 = idtet;
    }

    public interface idtet {
        void OnClick(int id);
    }


    //去支付
    public void OnCkQzf(OnClickQZF qzf) {
        onClickQZF = qzf;
    }

    public interface OnClickQZF {
        void OnClickQZF(int id, String allprice);
    }

    class OrderListViewHorder extends XRecyclerView.ViewHolder {

        private final TextView tv_number, tv_title, tv_date1, tv_date2, tv_money, order_ckwl, order_qxdd;
        private final ImageView tv_iv, iv_delete;
        private final TextView bt_order;
        private final LinearLayout lt;

        public OrderListViewHorder(@NonNull View itemView) {
            super(itemView);
            tv_number = itemView.findViewById(R.id.order_number);
            tv_iv = itemView.findViewById(R.id.order_iv);
            tv_title = itemView.findViewById(R.id.order_title);
            tv_date1 = itemView.findViewById(R.id.order_date1);
            tv_date2 = itemView.findViewById(R.id.order_date2);
            iv_delete = itemView.findViewById(R.id.order_delete);
            tv_money = itemView.findViewById(R.id.order_money);
            bt_order = itemView.findViewById(R.id.order_but);
            lt = itemView.findViewById(R.id.precode);
            order_ckwl = itemView.findViewById(R.id.order_ckwl);
            order_qxdd = itemView.findViewById(R.id.order_qxdd);
        }
    }
}
