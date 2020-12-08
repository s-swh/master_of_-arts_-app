package com.wd.master_of_arts_app.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

/**
 * @author 时文豪
 * @description: 选课模块
 * @date :2020/12/3 11:04
 */
public class Task_page extends BaseFragment implements View.OnClickListener {

    private PopupWindow popupBigPhoto;
    private TextView lt1,lt2,lt3,lt4,lt5,lt6;
    private TextView tv;


    @Override
    protected int getLayoutId() {
        return R.layout.task;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
    }

    @Override
    protected void initView(View view) {
        tv = view.findViewById(R.id.tt_opo);


    }

    @Override
    protected void initData() {

    }
    //弹框
   @OnClick(R.id.tt_opo)
    public void popwindow(){
       View view = getLayoutInflater().inflate(R.layout.activity_photo_preview, null);
       lt1 = view.findViewById(R.id.o_1);
       lt2 =  view.findViewById(R.id.o_2);
       lt3 =   view.findViewById(R.id.o_3);
       lt4 =   view.findViewById(R.id.o_4);
       lt5 =  view.findViewById(R.id.o_5);
       lt6 =   view.findViewById(R.id.o_6);

       if (popupBigPhoto == null) {
           popupBigPhoto = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
           popupBigPhoto.setOutsideTouchable(true);

       }
       if (popupBigPhoto.isShowing()) {
           popupBigPhoto.dismiss();
       } else {
           popupBigPhoto.showAtLocation(view, Gravity.TOP, 0, 0);
       }
// 设置PopupWindow的背景
       popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
       popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
       popupBigPhoto.setTouchable(true);
       lt1.setOnClickListener(this);
       lt2.setOnClickListener(this);
       lt3.setOnClickListener(this);
       lt4.setOnClickListener(this);
       lt5.setOnClickListener(this);
       lt6.setOnClickListener(this);
   }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case  R.id.o_1:{
                String s = lt1.getText().toString();
                tv.setText(s);
                popupBigPhoto.dismiss();
            }
                break;
            case  R.id.o_2:{
                String s = lt2.getText().toString();
                tv.setText(s);
                popupBigPhoto.dismiss();
            }
                break;
            case  R.id.o_3:{
                String s = lt3.getText().toString();
                tv.setText(s);
                popupBigPhoto.dismiss();
            }

                break;
            case  R.id.o_4:{
                String s = lt4.getText().toString();
                tv.setText(s);
                popupBigPhoto.dismiss();
            }

                break;
            case  R.id.o_5:{
                String s = lt5.getText().toString();
                tv.setText(s);
                popupBigPhoto.dismiss();
            }

                break;
            case  R.id.o_6:{
                String s = lt6.getText().toString();
                tv.setText(s);
                popupBigPhoto.dismiss();
            }

                break;

            default:
                popupBigPhoto.dismiss();
                break;
        }

    }
}
