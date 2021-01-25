package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.AgeInterface;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/19 9:32
 */
public class AgeInterfaceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;List<AgeInterface.DataBean.ListBean> beans;
    private Coallack coallack1;
    private View inflate;

    public AgeInterfaceAdapter(Context context, List<AgeInterface.DataBean.ListBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.ageitem, null);
        return new AgeViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AgeInterface.DataBean.ListBean listBean = beans.get(position);
        String name = listBean.getName();
        ((AgeViewHorder)holder).ol.setText(name);
        ((AgeViewHorder) holder).age_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coallack1.setOnClick(beans.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
    //接口回调
    public void Coallack(Coallack coallack){
        coallack1 = coallack;
    }
    //创建接口
    public interface Coallack{
        void setOnClick(AgeInterface.DataBean.ListBean listBean);
    }
    class AgeViewHorder extends RecyclerView.ViewHolder {

        private final TextView ol;
        private final LinearLayout age_click;

        public AgeViewHorder(@NonNull View itemView) {
            super(itemView);
            ol = itemView.findViewById(R.id.o_1);
            age_click = itemView.findViewById(R.id.age_click);
        }
    }
}
