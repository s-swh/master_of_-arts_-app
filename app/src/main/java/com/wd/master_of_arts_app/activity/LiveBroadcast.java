package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.LiveBoradCast;
import com.wd.master_of_arts_app.bean.UserId;
import com.wd.master_of_arts_app.contreater.LiveBoradcastContreanter;
import com.wd.master_of_arts_app.preanter.LiveBoraCastPreanter;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import cn.plaso.data.LiveClassConfig;


import cn.plaso.upime.ClassConfig;
import cn.plaso.upime.ILiveClassListener;
import cn.plaso.upime.IResourceCallback;
import cn.plaso.upime.IResourceProvider;
import cn.plaso.upime.SignCallback;
import cn.plaso.upime.StyleUpime;
import cn.plaso.upime.UpimeBoard;

public class LiveBroadcast extends BaseActivity implements LiveBoradcastContreanter.IView {


    private int  used;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_live_broadcast;
    }

    @Override
    protected BasePreantert initModel() {
        return new LiveBoraCastPreanter(this);
    }

    @Override
    protected void initView() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void OnUserName(UserId userId){
        used = userId.getUsed();
        name = userId.getName();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int classid = intent.getIntExtra("classid",0);
        String unit_ssname = intent.getStringExtra("unit_ssname");
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof LiveBoradcastContreanter.IPreanter) {

            ((LiveBoradcastContreanter.IPreanter) basePreantert).OnLiveBoradSuccess("listener", "private", "video", ""+classid, name, used+"", unit_ssname);
        }

    }

    @Override
    public void OnLiveBorad(LiveBoradCast liveBoradCast) {
        LiveBoradCast.DataBean data = liveBoradCast.getData();
        int code = liveBoradCast.getCode();

        String live_url = data.getLive_url();
        ClassConfig config = new ClassConfig();
        config.classURL = live_url;
        config.features |= (ClassConfig.VIDEO_MARK | ClassConfig.RED_PACKET);

        IResourceProvider resProvider = new IResourceProvider() {
            @Override
            public boolean supportResourceCenter() {

                return true;
            }

            @Override
            public void showResourceCenter() {
                // 启动定制化的资料中心Activity
            }

            @Override
            public void dismissResourceCenter() {
                // 关闭资料中心
            }


            @Override
            public void getExtFileName(Object extFileId, IResourceCallback callback) {


            }

            @Override
            public boolean signQuery(Map query, SignCallback cb) {

                // 签名后异步调用 cb.onSignCompleted(signature)
                return true;
            }
        };

        StyleUpime styleUpime = StyleUpime.create(this, "ydjwx", resProvider);
        styleUpime.launchLiveClass(config, new ILiveClassListener() {
            @Override
            public void onLiveClassReady(UpimeBoard upime) {
                // 获得UpimeBoard对象，可用于资料中心的资料插入等操作
            }

            @Override
            public void onExited(int exitCode) {

                Toast.makeText(LiveBroadcast.this, "退出直播", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        if(code==1){
            finish();
        }
    }


}
