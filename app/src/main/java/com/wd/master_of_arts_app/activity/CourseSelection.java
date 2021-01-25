package com.wd.master_of_arts_app.activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.AgeInterfaceAdapter;
import com.wd.master_of_arts_app.adapter.CourseAdapter;

import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
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

import static com.wd.master_of_arts_app.base.App.getContext;

public class CourseSelection extends BaseActivity implements CourseContreater.IView {

    private PopupWindow popupBigPhoto;
    private TextView lt1, lt2, lt3, lt4, lt5, lt6;
    private TextView tv;
    private XRecyclerView rv;
    private CourseAdapter courseAdapter;
    private List<CourseList.DataBeanX.ListBean.DataBean> arrayList = new ArrayList<>();
    private List<CourseList.DataBeanX.ListBean.DataBean> data1;

    private int id;
    private int start_age;
    private List<CourseList.DataBeanX.ListBean.DataBean> dataBeans;
    private CourseList.DataBeanX.ListBean list;

    private String name1;
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
            BasePreantert basePreantert = getmPreantert();
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
                                CourseAdapter courseAdapter = new CourseAdapter(getApplicationContext(), data2);
                                rv.setAdapter(courseAdapter);
                                courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
                                    @Override
                                    public void onclick(int id) {
                                        Intent intent = new Intent(getApplicationContext(), CourseDetailsActivity.class);
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
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(linearLayoutManager);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_courction;
    }

    @Override
    protected BasePreantert initModel() {
        return new CoursePreanter(this);
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tt_opo);


        et_name = findViewById(R.id.username);
        rv = findViewById(R.id.xrev);


        ImageView selete_iv = findViewById(R.id.selete_iv);
        selete_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();


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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);

        if (basePreantert instanceof CourseContreater.IPreanter) {
            ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "" , i, j);
        }
        rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                i = 1;
                courseAdapter.Refresh(list.getData());
                ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "", i, j);
            }

            @Override
            public void onLoadMore() {
                i++;
                ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "", i, j);
            }
        });
        courseAdapter = new CourseAdapter(getApplicationContext(), arrayList);
        rv.setAdapter(courseAdapter);
    }

    //弹框
    @OnClick(R.id.vve)
    public void popwindow() {
        View view = getLayoutInflater().inflate(R.layout.preview, null);
        agerv = view.findViewById(R.id.age_rv);
        LinearLayout deim = view.findViewById(R.id.deim);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
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
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof CourseContreater.IPreanter) {
            ((CourseContreater.IPreanter) basePreantert).OnAgeSuccess();
        }

    }

    // 课程列表
    @Override
    public void OnCourse(CourseList courseList) {
        CourseList.DataBeanX data = courseList.getData();
        list = data.getList();
        dataBeans = list.getData();
        arrayList = dataBeans;
        if (arrayList.size() == 0) {
            Toast.makeText(getApplicationContext(), "没有更多了", Toast.LENGTH_SHORT).show();
        }
        courseAdapter.LoadMore(arrayList);
        courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
            @Override
            public void onclick(int id) {
                Intent intent = new Intent(getApplicationContext(), CourseDetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        rv.refreshComplete();
        rv.loadMoreComplete();
        courseAdapter.notifyDataSetChanged();
    }

    //年龄
    @Override
    public void onAgeInterface(AgeInterface ageInterface) {
        AgeInterface.DataBean data = ageInterface.getData();
        List<AgeInterface.DataBean.ListBean> list = data.getList();
        ageInterfaceAdapter = new AgeInterfaceAdapter(getApplicationContext(), list);
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
                BasePreantert basePreantert = getmPreantert();

                NetUtils.getInstance().getApi().getCourseList("", "", "", "" + id, i, 500)
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
                                CourseAdapter courseAdapter = new CourseAdapter(getContext(), data2);
                                rv.setAdapter(courseAdapter);
                                if(data2.size()==0){
                                    ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("", "", "", "" + id, i, j);
                                }
                                courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
                                    @Override
                                    public void onclick(int id) {
                                        Intent intent = new Intent(getApplicationContext(), CourseDetailsActivity.class);
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
        });
    }

    //课程详情
    @Override
    public void OnCourse(CourseDetails courseDetails) {

    }
}
