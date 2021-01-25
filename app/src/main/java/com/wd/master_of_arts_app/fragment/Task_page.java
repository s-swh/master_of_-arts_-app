package com.wd.master_of_arts_app.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.CourseDetailsActivity;
import com.wd.master_of_arts_app.adapter.AgeInterfaceAdapter;
import com.wd.master_of_arts_app.adapter.CourseAdapter;
import com.wd.master_of_arts_app.adapter.XBaseAdapter;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.customview.CustomLinearLayoutManager;
import com.wd.master_of_arts_app.preanter.CoursePreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.maxwin.view.XListView;

/**
 * @author 时文豪
 * @description: 选课模块
 * @date :2020/12/3 11:04
 */
public class Task_page extends BaseFragment implements CourseContreater.IView {

    List<CourseList.DataBeanX.ListBean.DataBean> arrayList = new ArrayList<>();    //创建集合 存放数据源


    private PopupWindow popupBigPhoto;
    private TextView lt1, lt2, lt3, lt4, lt5, lt6;
    private TextView tv;

    private CourseAdapter courseAdapter;
       List<CourseList.DataBeanX.ListBean.DataBean>  dataBeans=new ArrayList<>();

    private int id;
    private int start_age;
    private String name1;
    private XRecyclerView Xrecycle;
    int i = 1;
    int j = 10;
    private RecyclerView agerv;
    private AgeInterfaceAdapter ageInterfaceAdapter;
    private EditText et_name;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            BasePreantert basePreantert = getmPreanter();
            if (basePreantert instanceof CourseContreater.IPreanter) {
                String string = et_name.getText().toString();
                ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", string, "", 1, j);
                NetUtils.getInstance().getApi().getCourseList("", "", string, "", 1, 500)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CourseList>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(CourseList courseList) {
                                CourseList.DataBeanX data1 = courseList.getData();
                                CourseList.DataBeanX.ListBean list1 = data1.getList();
                                List<CourseList.DataBeanX.ListBean.DataBean> data2 = list1.getData();
                                courseAdapter = new CourseAdapter(getContext(), data2);
                                Xrecycle.setAdapter(courseAdapter);
                                courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
                                    @Override
                                    public void onclick(int id) {
                                        Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                                        intent.putExtra("id", id);
                                        startActivity(intent);
                                    }
                                });

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


            }

        }
    };
    private List<CourseList.DataBeanX.ListBean.DataBean> listData;
    private CourseList.DataBeanX.ListBean list;


    @Override
    protected int getLayoutId() {
        return R.layout.task;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new CoursePreanter(this);
    }

    @Override
    protected void initView(View view) {
        tv = view.findViewById(R.id.tt_opo);

        et_name = view.findViewById(R.id.username);
        Xrecycle = view.findViewById(R.id.Xrecycle);


    }

    @Override
    protected void initData() {

        BasePreantert basePreantert = getmPreanter();
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                handler.removeMessages(0);
                handler.sendEmptyMessageDelayed(0, 1000);
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        if (basePreantert instanceof CourseContreater.IPreanter) {
            ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "", i, j);
        }
        et_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                BasePreantert basePreantert = getmPreanter();
                if (basePreantert instanceof CourseContreater.IPreanter) {
                    String string = et_name.getText().toString();
                    ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", string, "", 1, j);

                    NetUtils.getInstance().getApi().getCourseList("", "", string, "", i, j)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<CourseList>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(CourseList courseList) {
                                    CourseList.DataBeanX data1 = courseList.getData();
                                    CourseList.DataBeanX.ListBean list1 = data1.getList();
                                    List<CourseList.DataBeanX.ListBean.DataBean> data2 = list1.getData();
                                    courseAdapter = new CourseAdapter(getContext(), data2);
                                    Xrecycle.setAdapter(courseAdapter);
                                    courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
                                        @Override
                                        public void onclick(int id) {
                                            Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                                            intent.putExtra("id", id);
                                            startActivity(intent);
                                        }
                                    });

                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });

                }
                return false;
            }
        });

        Xrecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {  //  刷新
                i = 1;
                courseAdapter.Refresh(list.getData());  //刷新
                courseAdapter.Refresh(arrayList);  //刷新
                ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "", i, j);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                Xrecycle.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onLoadMore() {  //  下载
                i++;

                ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "", i, j);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        Xrecycle.setLayoutManager(linearLayoutManager);
        courseAdapter = new CourseAdapter(getActivity(), arrayList);
        courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
            @Override
            public void onclick(int id) {

            }
        });
        Xrecycle.setAdapter(courseAdapter);

    }

    // 课程列表
    @Override
    public void OnCourse(CourseList courseList) {
        CourseList.DataBeanX data = courseList.getData();
        list = data.getList();
        listData = list.getData();
        courseAdapter.notifyDataSetChanged();
        arrayList = listData;
        if (arrayList.size() == 0) {
            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();

        } else {

            courseAdapter.LoadMore(arrayList);  //加载

        }
        courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
            @Override
            public void onclick(int id) {
                Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        Xrecycle.refreshComplete();
        Xrecycle.loadMoreComplete();
        courseAdapter.notifyDataSetChanged();

    }

    //弹框
    @OnClick(R.id.vve)
    public void popwindow() {
        View view = getLayoutInflater().inflate(R.layout.preview, null);
        agerv = view.findViewById(R.id.age_rv);
        LinearLayout deim = view.findViewById(R.id.deim);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        agerv.setLayoutManager(linearLayoutManager);
        if (popupBigPhoto == null) {
            popupBigPhoto = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
            popupBigPhoto.setOutsideTouchable(true);
            popupBigPhoto.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        }
        if (popupBigPhoto.isShowing()) {
            popupBigPhoto.dismiss();
        } else {
            popupBigPhoto.showAtLocation(view, Gravity.TOP, 0, 0);
        }
        // 设置PopupWindow是否能响应外部点击事件
        popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
        popupBigPhoto.setTouchable(true);
        deim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupBigPhoto.dismiss();
            }
        });
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof CourseContreater.IPreanter) {
            ((CourseContreater.IPreanter) basePreantert).OnAgeSuccess();
        }

    }


    //年龄
    @Override
    public void onAgeInterface(AgeInterface ageInterface) {
        AgeInterface.DataBean data = ageInterface.getData();


        List<AgeInterface.DataBean.ListBean> list = data.getList();
        ageInterfaceAdapter = new AgeInterfaceAdapter(getActivity(), list);
        agerv.setAdapter(ageInterfaceAdapter);

        ageInterfaceAdapter.Coallack(new AgeInterfaceAdapter.Coallack() {
            @Override
            public void setOnClick(AgeInterface.DataBean.ListBean listBean) {
                String short_name = listBean.getShort_name();
                tv.setText(short_name);
                id = listBean.getId();
                start_age = listBean.getStart_age();
                name1 = listBean.getName();
                popupBigPhoto.dismiss();

                NetUtils.getInstance().getApi().getCourseList("", "", "", "" + id, 1, j)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CourseList>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(CourseList courseList) {
                                CourseList.DataBeanX data = courseList.getData();
                                CourseList.DataBeanX.ListBean list1 = data.getList();
                                List<CourseList.DataBeanX.ListBean.DataBean> data1 = list1.getData();
                                BasePreantert basePreantert = getmPreanter();
                                if(data1.size()==0){
                                    ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", ""+id, 1, j);
                                }
                                courseAdapter = new CourseAdapter(getContext(), data1);
                                courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
                                    @Override
                                    public void onclick(int id) {
                                        Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                                        intent.putExtra("id", id);
                                        startActivity(intent);
                                    }
                                });
                                Xrecycle.setAdapter(courseAdapter);

                                courseAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });


    }

    //课程详情
    @Override
    public void OnCourse(CourseDetails courseDetails) {

    }
}
