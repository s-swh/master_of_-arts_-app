package com.wd.master_of_arts_app.activity;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.Image;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.customview.Img;
import com.wd.master_of_arts_app.preanter.WorksPreanter;
import com.wd.master_of_arts_app.voice.MediaManager;

import java.io.IOException;

public class DetailsOfWorks extends BaseActivity implements worksContreanter.IVew {


    private TextView tv_title, tv_date, tv_gu, tv_etch_content, teacher_time, zpgs, yyjs;
    private ListView xrv;
    private ImageView bton1, bton2, bton3;
    private ImageView bt, image_1, image_2, image_3, work_iv1, work_iv2, work_iv3, iv_voive1, iv_voive2, iv_voive3;
    private String imglist;
    private String string2;
    private LinearLayout llt_i;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_works;
    }

    @Override
    protected BasePreantert initModel() {
        return new WorksPreanter(this);
    }

    @Override
    protected void initView() {
        tv_title = findViewById(R.id.tv_title);
        tv_date = findViewById(R.id.tv_date);
        xrv = findViewById(R.id.xrv);

        tv_gu = findViewById(R.id.tv_gu);
        bton1 = findViewById(R.id.bton1);
        bton2 = findViewById(R.id.bton2);
        bton3 = findViewById(R.id.bton3);
        bt = findViewById(R.id.but_return);
        image_1 = findViewById(R.id.image_1);
        image_2 = findViewById(R.id.image_2);
        image_3 = findViewById(R.id.image_3);
        work_iv1 = findViewById(R.id.work_iv1);
        work_iv2 = findViewById(R.id.work_iv2);
        work_iv3 = findViewById(R.id.work_iv3);
        tv_etch_content = findViewById(R.id.tv_etch_content);
        teacher_time = findViewById(R.id.teacher_time);
        iv_voive1 = findViewById(R.id.iv_voive1);
        iv_voive2 = findViewById(R.id.iv_voive2);
        iv_voive3 = findViewById(R.id.iv_voive3);
        llt_i = findViewById(R.id.lsdp);
        zpgs = findViewById(R.id.zpgs);
        yyjs = findViewById(R.id.yyjs);
    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof worksContreanter.IPreanter) {
            Intent intent = getIntent();
            int work_id = intent.getIntExtra("work_id", 0);
            ((worksContreanter.IPreanter) basePreantert).OnDetailsSuccess(work_id);
        }

    }

    @Override
    public void OnWorks(ListOfWorks listOfWorks) {

    }

    @Override
    public void OnDetailsWorks(DetailsOfWorksBean worksBean) {
        //作者作品
        DetailsOfWorksBean.DataBean data1 = worksBean.getData();
        DetailsOfWorksBean.DataBean.WorkMsgBean workMsg = data1.getWorkMsg();

        String name = workMsg.getName();//名称
        String content = workMsg.getContent();//内容
        //图片
        imglist = workMsg.getImglist();
        String create_time = workMsg.getCreate_time();//时间

        tv_title.setText("作品名称：" + name);
        tv_date.setText("发布时间：" + create_time);
        tv_gu.setText(content);
        String voice = workMsg.getVoice();

        Log.i("imglistxxx", imglist);


        if (!content.isEmpty()) {
            zpgs.setVisibility(View.VISIBLE);
        } else {
            zpgs.setVisibility(View.GONE);

        }
        String voice1 = workMsg.getVoice();
        if (!voice1.isEmpty()) {

            yyjs.setVisibility(View.VISIBLE);
        } else {
            yyjs.setVisibility(View.GONE);
        }

        if (imglist.length() == 0) {
            Toast.makeText(this, "上传作品出错无法展示", Toast.LENGTH_SHORT).show();
        }
        String is_comment = workMsg.getIs_comment();
        if (is_comment.equals("N")) {
            llt_i.setVisibility(View.GONE);
        } else if (is_comment.equals("Y")) {
            //点评作品
            llt_i.setVisibility(View.VISIBLE);
            String c_imglist = workMsg.getC_imglist();
            Gson gson2 = new Gson();
            String[] strings2 = gson2.fromJson(c_imglist, String[].class);
            if (strings2.length == 3) {
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
                        Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[1]).into(uiv);
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
                        Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[2]).into(uiv);
                    }
                });
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
                        Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings2[1]).into(uiv);
                    }
                });
                work_iv3.setVisibility(View.GONE);
            } else if (strings2.length == 1) {
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
            }
            String c_content = workMsg.getC_content();
            String comment_time = workMsg.getComment_time();
            tv_etch_content.setText(c_content);
            teacher_time.setText("点评时间：" + comment_time);
            String c_voice = workMsg.getC_voice();
            if (!c_voice.isEmpty()) {
                Gson gson1 = new Gson();
                String[] strings1 = gson1.fromJson(c_voice, String[].class);

                if (strings1.length == 1) {
                    iv_voive2.setVisibility(View.GONE);
                    iv_voive3.setVisibility(View.GONE);
                    iv_voive1.setOnClickListener(new View.OnClickListener() {
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
                    iv_voive3.setVisibility(View.GONE);
                    iv_voive1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });

                        }
                    });
                    iv_voive2.setOnClickListener(new View.OnClickListener() {
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
                    iv_voive1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[0], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });
                    iv_voive2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MediaManager.playSound("http://qiniu.54artist.com/" + strings1[1], new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                }
                            });
                        }
                    });
                    iv_voive3.setOnClickListener(new View.OnClickListener() {
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

        Gson gson = new Gson();
        String[] strings = gson.fromJson(imglist, String[].class);

        if (strings.length == 3) {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(image_1);
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[1]).into(image_2);
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[2]).into(image_3);
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
        } else if (strings.length == 2) {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(image_1);
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[1]).into(image_2);
            image_3.setVisibility(View.GONE);
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

        } else if (strings.length == 1) {
            Glide.with(getApplicationContext()).load("http://qiniu.54artist.com/" + strings[0]).into(image_1);
            image_3.setVisibility(View.GONE);
            image_2.setVisibility(View.GONE);
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
        } else if (strings.length == 0) {
            Toast.makeText(this, "上传作品出错无法展示", Toast.LENGTH_SHORT).show();
        }
        if (!voice.isEmpty()) {
            Gson gson3 = new Gson();
            String[] strings3 = gson3.fromJson(voice, String[].class);
            if (strings3.length == 1) {
                bton2.setVisibility(View.GONE);
                bton3.setVisibility(View.GONE);
                bton1.setVisibility(View.VISIBLE);
                bton1.setOnClickListener(new View.OnClickListener() {

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
                bton3.setVisibility(View.GONE);
                bton2.setVisibility(View.VISIBLE);
                bton1.setVisibility(View.VISIBLE);
                bton1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        MediaManager.playSound("http://qiniu.54artist.com/" + strings3[0], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });

                    }
                });
                bton2.setOnClickListener(new View.OnClickListener() {

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
                bton1.setVisibility(View.VISIBLE);
                bton2.setVisibility(View.VISIBLE);
                bton3.setVisibility(View.VISIBLE);
                bton1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        MediaManager.playSound("http://qiniu.54artist.com/" + strings3[0], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });

                    }
                });
                bton2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        MediaManager.playSound("http://qiniu.54artist.com/" + strings3[1], new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                            }
                        });

                    }
                });
                bton3.setOnClickListener(new View.OnClickListener() {

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
            bton1.setVisibility(View.GONE);
            bton2.setVisibility(View.GONE);
            bton3.setVisibility(View.GONE);
        }


    }

    @Override
    public void onPause() {
        super.onPause();
        MediaManager.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        MediaManager.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MediaManager.release();
    }
}
