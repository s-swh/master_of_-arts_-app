package com.wd.master_of_arts_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.wd.master_of_arts_app.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String imglist;
    private OnImageOnClick onImageOnClick;
    private String[] strings = new String[]{};



    public ImageAdapter(Context context, String imglist) {
        this.context = context;
        this.imglist = imglist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.imageitem, null);
        return new ImageViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

       /* String[] split = imglist.split("\\[");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("\\]");
            for (int j = 0; j < split1.length; j++) {
                String[] split2 = split1[j].split("\"");
                for (int k = 0; k < split2.length; k++) {
                    String[] split3 = split2[k].split(",");
                    for (int l = 0; l < split3.length; l++) {
                        Toast.makeText(context, split3[l]+"", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }*/

        Gson gson = new Gson();
        strings = gson.fromJson(imglist, String[].class);
        for (int i = 0; i < strings.length; i++) {
            Log.i("xxxstrs",strings[i]);
            Glide.with(context).load("http://qiniu.54artist.com/" + strings[i]).error(R.mipmap.ic_launcher_round).into(((ImageViewHorder) holder).imv);
        }



      ((ImageViewHorder) holder).llt_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageOnClick.OnClick();
            }
        });
    }

    @Override
    public int getItemCount() {

        return imglist.length();
    }

    public void OnClick(OnImageOnClick onClick) {
        onImageOnClick = onClick;
    }

    public interface OnImageOnClick {
        void OnClick();
    }


    class ImageViewHorder extends RecyclerView.ViewHolder {

        private final ImageView imv;
        private final LinearLayout llt_img;

        public ImageViewHorder(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.image_item);
            llt_img = itemView.findViewById(R.id.llt_img);
        }
    }
}