package com.wd.master_of_arts_app.activity;

import androidx.annotation.Nullable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import com.wd.master_of_arts_app.bean.SampleReels;
import com.wd.master_of_arts_app.contreater.SampleReelsContreanter;
import com.wd.master_of_arts_app.preanter.SamplePreanter;

import butterknife.OnClick;

public class SampleReelsActivity extends BaseActivity implements SampleReelsContreanter.IView {


    private ImageView weixinfenxiang;

    private LinearLayout zpj, reels;
    private IWXAPI api;
    private static final String APP_ID = "wxb7192893995d3c8b";
    private WebView web;
    private String data;

    // IWXAPI 是第三方app和微信通信的openApi接口


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(APP_ID);

        //建议动态监听微信启动广播进行注册到微信
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // 将该app注册到微信
                api.registerApp(SampleReelsActivity.APP_ID);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sample_reels;
    }


    @OnClick(R.id.oncDest1ruction)
    public void onDestruti1on() {
        finish();
    }

    @Override
    protected BasePreantert initModel() {
        return new SamplePreanter(this);
    }

    @Override
    protected void initView() {


        reels = findViewById(R.id.reels);
        web = findViewById(R.id.webc);
        weixinfenxiang = findViewById(R.id.weixinfenxiang);
        zpj = findViewById(R.id.zpj);

    }

    @Override
    protected void initData() {

        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof SampleReelsContreanter.IPreanter) {
            SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
            String token = sp.getString("token", "");
            Intent intent = getIntent();
            int course_time_id111 = intent.getIntExtra("course_time_id111", 0);
            ((SampleReelsContreanter.IPreanter) basePreantert).SampleRessleSuccess(token, course_time_id111);
        }


        weixinfenxiang.setOnClickListener(new View.OnClickListener() {

            private RelativeLayout dimensfinsqx, weixinhaoyou, weixinpengyouquan, dimensfins;
            private PopupWindow popupBigPhoto;

            @Override
            public void onClick(View view) {

                View inflate = getLayoutInflater().inflate(R.layout.fenxiangitem, null);


                if (popupBigPhoto == null) {
                    popupBigPhoto = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popupBigPhoto.setOutsideTouchable(true);

                }
                if (popupBigPhoto.isShowing()) {
                    popupBigPhoto.dismiss();
                } else {
                    popupBigPhoto.showAtLocation(inflate, Gravity.TOP, 0, 0);
                }
// 设置PopupWindow的背景
                popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);

                dimensfinsqx = inflate.findViewById(R.id.dimensfinsqx);
                weixinhaoyou = inflate.findViewById(R.id.weixinhaoyou);
                weixinpengyouquan = inflate.findViewById(R.id.weixinpengyouquan);
                dimensfins = inflate.findViewById(R.id.dimensfins);
                //分享到微信好友
                weixinhaoyou.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        WXWebpageObject webpage = new WXWebpageObject();
                        webpage.webpageUrl = data;

//用 WXWebpageObject 对象初始化一个 WXMediaMessage 对象
                        WXMediaMessage msg = new WXMediaMessage(webpage);
                        msg.title = "艺大家桃李 ";
                        msg.description = "艺大家";
                        Bitmap thumbBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_action_discard);
                        //msg.thumbData = Util.bmpToByteArray(thumbBmp, true);


//构造一个Req
                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        //   req.transaction = buildTransaction("webpage");
                        req.message = msg;
                        req.scene = 0;
                        req.userOpenId = "1";

//调用api接口，发送数据到微信
                        api.sendReq(req);

                    }
                });
                //分享到朋友圈
                weixinpengyouquan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        WXWebpageObject webpage = new WXWebpageObject();
                        webpage.webpageUrl = data;

//用 WXWebpageObject 对象初始化一个 WXMediaMessage 对象
                        WXMediaMessage msg = new WXMediaMessage(webpage);
                        msg.title = "艺大家桃李 ";
                        msg.description = "艺大家";
                        Bitmap thumbBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_action_discard);
                        //msg.thumbData = Util.bmpToByteArray(thumbBmp, true);


//构造一个Req
                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        //   req.transaction = buildTransaction("webpage");
                        req.message = msg;
                        req.scene = 1;
                        req.userOpenId = "1";

//调用api接口，发送数据到微信
                        api.sendReq(req);

                    }
                });
                //点击空白
                dimensfinsqx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
                //取消
                dimensfins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public void OnSampleRessle(SampleReels sampleReels) {

        data = sampleReels.getData();
        if (data.isEmpty()) {
            weixinfenxiang.setVisibility(View.GONE);
            zpj.setVisibility(View.VISIBLE);
        } else {
            web.loadUrl(data);
            WebSettings settings = web.getSettings();
            settings.setJavaScriptEnabled(true);
        }

    }
}
