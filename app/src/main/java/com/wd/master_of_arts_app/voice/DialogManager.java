package com.wd.master_of_arts_app.voice;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;

public class DialogManager {
    private Dialog mDialog;
 
    private ImageView mIcon;
    private ImageView mVoice;
 
    private TextView mLable;
 
    private Context mContext;
 
    public DialogManager(Context context){
        mContext = context;
    }
 
    public void showRecordingDialog(){


        mDialog = new Dialog(mContext, R.style.Theme_AudioDialog);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.dialog,null);
        mDialog.setContentView(view);

        mIcon = view.findViewById(R.id.id_recorder_dialog_icon);
        mVoice = view.findViewById(R.id.id_recorder_dialog_voice);
        mLable = view.findViewById(R.id.id_recorder_dialog_label);

        mDialog.show();

    }
 
    //正在播放时的状态
    public void recording() {
        if (mDialog != null&&mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLable.setVisibility(View.VISIBLE);
 
            mIcon.setImageResource(R.mipmap.qxfs);
            mLable.setText("手指上划，取消发送");
        }
    }
    //想要取消
    public void wantToCancel(){
        if (mDialog != null&&mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);
 
            mIcon.setImageResource(R.mipmap.qxfs);
            mLable.setText("松开手指，取消发送");
        }
    }
    //录音时间太短
    public void tooShort() {
        if (mDialog != null&&mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);
 
            mIcon.setImageResource(R.mipmap.icon_duan);
            mLable.setText("录音时间过短");
        }
    }
    //关闭dialog
    public void dimissDialog(){
        if (mDialog != null&&mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }
 
    /**
     * 通过level更新voice上的图片
     *
     * @param level
     */
    public void updateVoiceLevel(int level){
        if (mDialog != null&&mDialog.isShowing()) {
 
            int resId = mContext.getResources().getIdentifier("v" + level, "drawable", mContext.getPackageName());
            mVoice.setImageResource(resId);
        }
    }
}