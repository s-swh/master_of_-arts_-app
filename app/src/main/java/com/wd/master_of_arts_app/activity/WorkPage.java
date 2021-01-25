package com.wd.master_of_arts_app.activity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.HomeWorkBean;
import com.wd.master_of_arts_app.contreater.MyWorkContreanter;
import com.wd.master_of_arts_app.customview.Img;
import com.wd.master_of_arts_app.preanter.MyWorkPreanter;
import com.wd.master_of_arts_app.voice.MediaManager;

import java.io.IOException;

/**
 * 作业详情
 */
public class WorkPage extends BaseActivity implements MyWorkContreanter.IView {

    private TextView work_name, work_time, tv_content, tv_etch_content, teacher_time, tv_no;
    private ImageView iv_vove1, iv_vove2, iv_vove3, work_iv1, iv_voive1, tv_return, image_1, image_2, image_3, work_iv2, work_iv3, iv_voive2, iv_voive3;
    private LinearLayout lsdp;
    private LinearLayout yyjs;
    private LinearLayout zpgs;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_page;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyWorkPreanter(this);
    }

    @Override
    protected void initView() {
        work_name = findViewById(R.id.work_name);
        work_time = findViewById(R.id.work_time);
        tv_content = findViewById(R.id.tv_content);
        iv_vove1 = findViewById(R.id.iv_vove1);
        iv_vove2 = findViewById(R.id.iv_vove2);
        iv_vove3 = findViewById(R.id.iv_vove3);
        work_iv1 = findViewById(R.id.work_iv1);
        tv_etch_content = findViewById(R.id.tv_etch_content);
        teacher_time = findViewById(R.id.teacher_time);
        iv_voive1 = findViewById(R.id.iv_voive1);
        tv_no = findViewById(R.id.tv_no);
        tv_return = findViewById(R.id.tv_return);
        image_1 = findViewById(R.id.image_1);
        image_2 = findViewById(R.id.image_2);
        image_3 = findViewById(R.id.image_3);
        lsdp = findViewById(R.id.lsdp);

        work_iv2 = findViewById(R.id.work_iv2);
        work_iv3 = findViewById(R.id.work_iv3);
        iv_voive2 = findViewById(R.id.iv_voive2);
        iv_voive3 = findViewById(R.id.iv_voive3);
        yyjs = findViewById(R.id.yyjs);
        zpgs = findViewById(R.id.zpgs);
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof MyWorkContreanter.IPreanter) {
            Intent intent = getIntent();
            int homework_idcid = intent.getIntExtra("homework_idcid", 0);
            ((MyWorkContreanter.IPreanter) basePreantert).OnWorkSuccess(homework_idcid);

        }
        tv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void OnMyWork(HomeWorkBean workBean) {
        HomeWorkBean.DataBean data = workBean.getData();

        HomeWorkBean.DataBean.WorkMsgBean workMsg = data.getWorkMsg();
        String name = workMsg.getName();
        String create_time = workMsg.getCreate_time();
        String content = workMsg.getContent();
        String voice = workMsg.getVoice();
        String imglist = workMsg.getImglist();
        Gson gson = new Gson();
        if(!content.isEmpty()){
            zpgs.setVisibility(View.VISIBLE);
        }else{
            zpgs.setVisibility(View.GONE);
        }
        if(!voice.isEmpty()){
            yyjs.setVisibility(View.VISIBLE);
            if(!voice.isEmpty()){
                Gson gson1 = new Gson();
                String[] strings1 = gson1.fromJson(voice, String[].class);
                if (strings1.length == 1) {

                    iv_vove1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.i("strings1",strings1[0]+"123");
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                }
                            });
                        }
                    });
                    iv_vove2.setVisibility(View.GONE);
                    iv_vove3.setVisibility(View.GONE);
                } else if (strings1.length == 2) {

                    iv_vove1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });

                    iv_vove2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[1], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });
                    iv_vove3.setVisibility(View.GONE);

                } else if (strings1.length == 3) {
                    iv_vove1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });

                    iv_vove2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[1], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });

                    iv_vove3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[2], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });
                }
            }

            iv_voive1.setVisibility(View.GONE);
            iv_voive2.setVisibility(View.GONE);
            iv_voive3.setVisibility(View.GONE);


        }
        String[] strings = gson.fromJson(imglist, String[].class);
        if (strings.length == 1) {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(image_1);
            image_1.setOnClickListener(new View.OnClickListener() {
                private PopupWindow popupBigPhoto;

                @Override
                public void onClick(View view) {

                    View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                    if (popupBigPhoto == null) {
                        popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                        popupBigPhoto.setOutsideTouchable(true);

                    }
                    if (popupBigPhoto.isShowing()) {
                        popupBigPhoto.dismiss();
                    } else {
                        popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                    }

                    // 设置PopupWindow的背景
                    popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                    popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                    popupBigPhoto.setTouchable(true);
                    ImageView llt = view1.findViewById(R.id.dimen);
                    Img uiv = view1.findViewById(R.id.pop_image);
                    llt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    uiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(uiv);
                }
            });
            image_2.setVisibility(View.GONE);
            image_3.setVisibility(View.GONE);
        } else if (strings.length == 2) {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(image_1);
            image_1.setOnClickListener(new View.OnClickListener() {
                private PopupWindow popupBigPhoto;

                @Override
                public void onClick(View view) {

                    View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                    if (popupBigPhoto == null) {
                        popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                        popupBigPhoto.setOutsideTouchable(true);

                    }
                    if (popupBigPhoto.isShowing()) {
                        popupBigPhoto.dismiss();
                    } else {
                        popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                    }

                    // 设置PopupWindow的背景
                    popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                    popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                    popupBigPhoto.setTouchable(true);
                    ImageView llt = view1.findViewById(R.id.dimen);
                    Img uiv = view1.findViewById(R.id.pop_image);
                    llt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    uiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(uiv);
                }
            });
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[1]).into(image_2);
            image_2.setOnClickListener(new View.OnClickListener() {
                private PopupWindow popupBigPhoto;

                @Override
                public void onClick(View view) {

                    View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                    if (popupBigPhoto == null) {
                        popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                        popupBigPhoto.setOutsideTouchable(true);

                    }
                    if (popupBigPhoto.isShowing()) {
                        popupBigPhoto.dismiss();
                    } else {
                        popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                    }

                    // 设置PopupWindow的背景
                    popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                    popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                    popupBigPhoto.setTouchable(true);
                    ImageView llt = view1.findViewById(R.id.dimen);
                    Img uiv = view1.findViewById(R.id.pop_image);
                    llt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    uiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[1]).into(uiv);
                }
            });
            image_3.setVisibility(View.GONE);
        } else if (strings.length == 3) {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(image_1);
            image_1.setOnClickListener(new View.OnClickListener() {
                private PopupWindow popupBigPhoto;

                @Override
                public void onClick(View view) {

                    View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                    if (popupBigPhoto == null) {
                        popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                        popupBigPhoto.setOutsideTouchable(true);

                    }
                    if (popupBigPhoto.isShowing()) {
                        popupBigPhoto.dismiss();
                    } else {
                        popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                    }

                    // 设置PopupWindow的背景
                    popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                    popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                    popupBigPhoto.setTouchable(true);
                    ImageView llt = view1.findViewById(R.id.dimen);
                    Img uiv = view1.findViewById(R.id.pop_image);
                    llt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    uiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(uiv);
                }
            });
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[1]).into(image_2);
            image_2.setOnClickListener(new View.OnClickListener() {
                private PopupWindow popupBigPhoto;

                @Override
                public void onClick(View view) {

                    View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                    if (popupBigPhoto == null) {
                        popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                        popupBigPhoto.setOutsideTouchable(true);

                    }
                    if (popupBigPhoto.isShowing()) {
                        popupBigPhoto.dismiss();
                    } else {
                        popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                    }

                    // 设置PopupWindow的背景
                    popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                    popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                    popupBigPhoto.setTouchable(true);
                    ImageView llt = view1.findViewById(R.id.dimen);
                    Img uiv = view1.findViewById(R.id.pop_image);
                    llt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    uiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[1]).into(uiv);
                }
            });
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[2]).into(image_3);
            image_3.setOnClickListener(new View.OnClickListener() {
                private PopupWindow popupBigPhoto;

                @Override
                public void onClick(View view) {

                    View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                    if (popupBigPhoto == null) {
                        popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                        popupBigPhoto.setOutsideTouchable(true);

                    }
                    if (popupBigPhoto.isShowing()) {
                        popupBigPhoto.dismiss();
                    } else {
                        popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                    }

                    // 设置PopupWindow的背景
                    popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                    popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                    popupBigPhoto.setTouchable(true);
                    ImageView llt = view1.findViewById(R.id.dimen);
                    Img uiv = view1.findViewById(R.id.pop_image);
                    llt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    uiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupBigPhoto.dismiss();
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[2]).into(uiv);
                }
            });
        }


        String teacher_content = workMsg.getTeacher_content();
        String teacher_imglist = workMsg.getTeacher_imglist();
        String comment_time = workMsg.getComment_time();
        String teacher_voice = workMsg.getTeacher_voice();
        String is_comment = workMsg.getIs_comment();
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (is_comment.equals("N")) {
            tv_no.setText("未评论");
            lsdp.setVisibility(View.GONE);


        } else if (is_comment.equals("Y")) {
            tv_no.setText("已评论");
            lsdp.setVisibility(View.VISIBLE);
            if (!teacher_imglist.isEmpty()) {
                Gson gson2 = new Gson();
                String[] strings2 = gson2.fromJson(teacher_imglist, String[].class);
                if (strings2.length == 1) {
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(work_iv1);
                    work_iv1.setOnClickListener(new View.OnClickListener() {
                        private PopupWindow popupBigPhoto;

                        @Override
                        public void onClick(View view) {

                            View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                            if (popupBigPhoto == null) {
                                popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                                popupBigPhoto.setOutsideTouchable(true);

                            }
                            if (popupBigPhoto.isShowing()) {
                                popupBigPhoto.dismiss();
                            } else {
                                popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                            }

                            // 设置PopupWindow的背景
                            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                            popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                            popupBigPhoto.setTouchable(true);
                            ImageView llt = view1.findViewById(R.id.dimen);
                            Img uiv = view1.findViewById(R.id.pop_image);
                            llt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            uiv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(uiv);
                        }
                    });
                    work_iv2.setVisibility(View.GONE);
                    work_iv3.setVisibility(View.GONE);
                } else if (strings2.length == 2) {
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(work_iv1);
                    work_iv1.setOnClickListener(new View.OnClickListener() {
                        private PopupWindow popupBigPhoto;

                        @Override
                        public void onClick(View view) {

                            View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                            if (popupBigPhoto == null) {
                                popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                                popupBigPhoto.setOutsideTouchable(true);

                            }
                            if (popupBigPhoto.isShowing()) {
                                popupBigPhoto.dismiss();
                            } else {
                                popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                            }

                            // 设置PopupWindow的背景
                            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                            popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                            popupBigPhoto.setTouchable(true);
                            ImageView llt = view1.findViewById(R.id.dimen);
                            Img uiv = view1.findViewById(R.id.pop_image);
                            llt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            uiv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(uiv);
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[1]).into(work_iv2);
                    work_iv2.setOnClickListener(new View.OnClickListener() {
                        private PopupWindow popupBigPhoto;

                        @Override
                        public void onClick(View view) {

                            View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                            if (popupBigPhoto == null) {
                                popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                                popupBigPhoto.setOutsideTouchable(true);

                            }
                            if (popupBigPhoto.isShowing()) {
                                popupBigPhoto.dismiss();
                            } else {
                                popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                            }

                            // 设置PopupWindow的背景
                            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                            popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                            popupBigPhoto.setTouchable(true);
                            ImageView llt = view1.findViewById(R.id.dimen);
                            Img uiv = view1.findViewById(R.id.pop_image);
                            llt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            uiv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(uiv);
                        }
                    });
                    work_iv3.setVisibility(View.GONE);
                } else if (strings2.length == 3) {
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(work_iv1);
                    work_iv1.setOnClickListener(new View.OnClickListener() {
                        private PopupWindow popupBigPhoto;

                        @Override
                        public void onClick(View view) {

                            View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                            if (popupBigPhoto == null) {
                                popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                                popupBigPhoto.setOutsideTouchable(true);

                            }
                            if (popupBigPhoto.isShowing()) {
                                popupBigPhoto.dismiss();
                            } else {
                                popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                            }

                            // 设置PopupWindow的背景
                            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                            popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                            popupBigPhoto.setTouchable(true);
                            ImageView llt = view1.findViewById(R.id.dimen);
                            Img uiv = view1.findViewById(R.id.pop_image);
                            llt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            uiv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(uiv);
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[1]).into(work_iv2);
                    work_iv2.setOnClickListener(new View.OnClickListener() {
                        private PopupWindow popupBigPhoto;

                        @Override
                        public void onClick(View view) {

                            View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                            if (popupBigPhoto == null) {
                                popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                                popupBigPhoto.setOutsideTouchable(true);

                            }
                            if (popupBigPhoto.isShowing()) {
                                popupBigPhoto.dismiss();
                            } else {
                                popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                            }

                            // 设置PopupWindow的背景
                            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                            popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                            popupBigPhoto.setTouchable(true);
                            ImageView llt = view1.findViewById(R.id.dimen);
                            Img uiv = view1.findViewById(R.id.pop_image);
                            llt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            uiv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(uiv);
                        }
                    });
                    Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[2]).into(work_iv3);
                    work_iv3.setOnClickListener(new View.OnClickListener() {
                        private PopupWindow popupBigPhoto;

                        @Override
                        public void onClick(View view) {

                            View view1 = getLayoutInflater().inflate(R.layout.popimg, null);
                            if (popupBigPhoto == null) {
                                popupBigPhoto = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                                popupBigPhoto.setOutsideTouchable(true);

                            }
                            if (popupBigPhoto.isShowing()) {
                                popupBigPhoto.dismiss();
                            } else {
                                popupBigPhoto.showAtLocation(view1, Gravity.TOP, 0, 0);
                            }

                            // 设置PopupWindow的背景
                            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
// 设置PopupWindow是否能响应外部点击事件
                            popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                            popupBigPhoto.setTouchable(true);
                            ImageView llt = view1.findViewById(R.id.dimen);
                            Img uiv = view1.findViewById(R.id.pop_image);
                            llt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            uiv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    popupBigPhoto.dismiss();
                                }
                            });
                            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[0]).into(uiv);
                        }
                    });
                }
            } else {
                work_iv1.setVisibility(View.GONE);
                work_iv2.setVisibility(View.GONE);
                work_iv3.setVisibility(View.GONE);
            }

            if (!teacher_voice.isEmpty()) {
                Gson gson3 = new Gson();
                String[] strings3 = gson3.fromJson(teacher_voice, String[].class);
                if (strings3.length == 1) {
                    iv_voive2.setVisibility(View.GONE);
                    iv_voive3.setVisibility(View.GONE);
                    iv_voive1.setVisibility(View.VISIBLE);
                    iv_voive1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings3[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });

                } else if (strings3.length == 2) {
                    iv_voive3.setVisibility(View.GONE);
                    iv_voive1.setVisibility(View.VISIBLE);
                    iv_voive2.setVisibility(View.VISIBLE);
                    iv_voive1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings3[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });
                    iv_voive2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings3[1], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });
                } else if (strings3.length == 3) {
                    iv_voive1.setVisibility(View.VISIBLE);
                    iv_voive2.setVisibility(View.VISIBLE);
                    iv_voive3.setVisibility(View.VISIBLE);
                    iv_voive1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings3[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });
                    iv_voive2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings3[1], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });
                    iv_voive3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings3[2], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });
                }

            } else {
                iv_voive1.setVisibility(View.GONE);
                iv_voive2.setVisibility(View.GONE);
                iv_voive3.setVisibility(View.GONE);
            }

        }


        work_name.setText("作品名称：" + name);
        work_time.setText("发布时间：" + create_time);
        tv_content.setText(content);
        tv_etch_content.setText(teacher_content);
        teacher_time.setText("点评时间：" + comment_time);




    if(!voice.isEmpty()){
            Gson gson1 = new Gson();
            String[] strings1 = gson1.fromJson(voice, String[].class);
            if (strings1.length == 1) {
                iv_vove2.setVisibility(View.GONE);
                iv_vove3.setVisibility(View.GONE);
                iv_vove1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });
                    }
                });

            } else if (strings1.length == 2) {
                iv_vove3.setVisibility(View.GONE);
                iv_vove1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });
                    }
                });

                iv_vove2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaManager.playSound("http://qiniu.54artist.com/" + strings1[1], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });
                    }
                });

            } else if (strings1.length == 3) {
                iv_vove1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });
                    }
                });

                iv_vove2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaManager.playSound("http://qiniu.54artist.com/" + strings1[1], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });
                    }
                });

                iv_vove3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaManager.playSound("http://qiniu.54artist.com/" + strings1[2], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });
                    }
                });
            }
        }else{
            iv_voive1.setVisibility(View.GONE);
            iv_voive2.setVisibility(View.GONE);
            iv_voive3.setVisibility(View.GONE);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaManager.release();
    }
}
