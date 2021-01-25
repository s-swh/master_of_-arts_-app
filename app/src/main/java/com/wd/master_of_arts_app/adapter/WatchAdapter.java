package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.bean.Voideo;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/11 13:08
 */
public class WatchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<String> list;
    private View inflate;
    private OnItemClick click1;

    public WatchAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.watchitem, null);
        return new WatchViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        WatchViewHorder watchViewHorder = new WatchViewHorder(inflate);
        int i=0;

        for (int j = 0; j < list.size(); j++) {
            i+=1;
        }
        String s = list.get(position);
        watchViewHorder.tv.setText("第" + i + "回放");

        watchViewHorder.ive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click1.OnClick(s);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void OnItemCk(OnItemClick click){
        click1 = click;
    }
    public interface OnItemClick{
        void OnClick(String href);
    }
    class WatchViewHorder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final LinearLayout ive;

        public WatchViewHorder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tx_text);
            ive = itemView.findViewById(R.id.ive);
        }
    }
}
