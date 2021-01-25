package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.OnClick;

/**
 * @author 时文豪
 * @description: 查看收获列表
 * @date :2020/12/19 14:35
 */
public class HarvestAddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ViewHarvestAddress.DataBean.ListBean> list;
    private OnCliack cliack1;
    private OnIdClick onIdClick1;

    public HarvestAddressAdapter(Context context, List<ViewHarvestAddress.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.harvestaddressitem, null);
        return new HarvestViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String consignee = list.get(position).getConsignee();
        String province = list.get(position).getProvince();
        String city = list.get(position).getCity();
        String county = list.get(position).getCounty();
        int id = list.get(position).getId();
        String detail_address = list.get(position).getDetail_address();
        String contact_number = list.get(position).getContact_number();
        ((HarvestViewHorder) holder).tv_name.setText(consignee);
        ((HarvestViewHorder) holder).tv_phone.setText(contact_number);
        ((HarvestViewHorder) holder).tv_acce.setText(province + "" + city + "" + county + "" + detail_address);
        ((HarvestViewHorder) holder).lt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliack1.onclick(list.get(position));
            }
        });
        String is_default = list.get(position).getIs_default();
        if(is_default.equals("Y")){
            ((HarvestViewHorder) holder).morendizhi.setVisibility(View.VISIBLE);
            

        }else if(is_default.equals("N")){
            ((HarvestViewHorder) holder).morendizhi.setVisibility(View.GONE);
        }
        ((HarvestViewHorder) holder).add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewHarvestAddress.DataBean.ListBean listBean = list.get(position);
                int id1 = listBean.getId();
              String url=  province + city +  county + detail_address;

                onIdClick1.OnidClick(id1,url);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onclick(OnCliack cliack) {
        cliack1 = cliack;
    }

    public void OnId(OnIdClick onIdClick) {
        onIdClick1 = onIdClick;
    }

    public interface OnCliack {
        void onclick(ViewHarvestAddress.DataBean.ListBean listBean);
    }

    public interface OnIdClick {
        void OnidClick(int id,String accect);
    }

    class HarvestViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv_name, tv_phone, tv_acce,morendizhi;
        private final ImageView lt;
        private final LinearLayout add;

        public HarvestViewHorder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.text_name);
            tv_phone = itemView.findViewById(R.id.text_phone);
            tv_acce = itemView.findViewById(R.id.text_acceccte);
            lt = itemView.findViewById(R.id.lt);
            add = itemView.findViewById(R.id.addres);
            morendizhi = itemView.findViewById(R.id.morendizhi);
        }
    }
}
