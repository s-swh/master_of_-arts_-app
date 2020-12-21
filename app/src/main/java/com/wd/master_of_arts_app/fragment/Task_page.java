package com.wd.master_of_arts_app.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.CourseDetailsActivity;
import com.wd.master_of_arts_app.adapter.AgeInterfaceAdapter;
import com.wd.master_of_arts_app.adapter.CourseAdapter;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.preanter.CoursePreanter;

import java.util.List;

import butterknife.OnClick;

/**
 * @author 时文豪
 * @description: 选课模块
 * @date :2020/12/3 11:04
 */
public class Task_page extends BaseFragment implements   CourseContreater.IView {

    private PopupWindow popupBigPhoto;
    private TextView lt1,lt2,lt3,lt4,lt5,lt6;
    private TextView tv;
    private XRecyclerView rv;
    private CourseAdapter courseAdapter;
    private List<CourseList.DataBeanX.ListBean.DataBean> data1;
    private CourseList.DataBeanX.ListBean list;
    private int id;
    private int start_age;
    private String name1;
    int i=1;
    int j=10;
    private RecyclerView agerv;
    private AgeInterfaceAdapter ageInterfaceAdapter;

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
        rv = view.findViewById(R.id.course_rv);

    }

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
                i=1;
                courseAdapter.Refresh(list.getData());
      /*          BasePreantert basePreantert = getmPreanter();
                if(basePreantert instanceof CourseContreater.IPreanter){
                    ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("","","","",i,j);
                }*/
                rv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                i++;
                Toast.makeText(getContext(), "上拉加载更多", Toast.LENGTH_SHORT).show();

                courseAdapter.LoadMore(list.getData());

                BasePreantert basePreantert = getmPreanter();
                if(basePreantert instanceof CourseContreater.IPreanter){
                    ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("","","","",i,j);
                }

                rv.loadMoreComplete();
            }
        });
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof CourseContreater.IPreanter){
            ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess("","","","",i,j);
        }

    }
    //弹框
   @OnClick(R.id.tt_opo)
    public void popwindow(){

       View view = getLayoutInflater().inflate(R.layout.preview, null);
       agerv = view.findViewById(R.id.age_rv);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
       agerv.setLayoutManager(linearLayoutManager);
       if (popupBigPhoto == null) {
           popupBigPhoto = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
           popupBigPhoto.setOutsideTouchable(true);
           popupBigPhoto.setBackgroundDrawable(new BitmapDrawable());
           popupBigPhoto.setFocusable(true);
           popupBigPhoto.setOutsideTouchable(true);
           popupBigPhoto.update();
           popupBigPhoto.setContentView(view);

           popupBigPhoto.showAtLocation(view,Gravity.CENTER, 0, 0);

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

       popupBigPhoto.setOutsideTouchable(true);
       popupBigPhoto.setFocusable(true);
       BasePreantert basePreantert = getmPreanter();
       if(basePreantert instanceof CourseContreater.IPreanter){
           ((CourseContreater.IPreanter) basePreantert).OnAgeSuccess();
       }

    }
    //课程列表
    @Override
    public void OnCourse(CourseList courseList) {

        CourseList.DataBeanX data = courseList.getData();
        list = data.getList();
        data1 = list.getData();
        courseAdapter = new CourseAdapter(getActivity(), data1);
        rv.setAdapter(courseAdapter);
        courseAdapter.OnIdClick(new CourseAdapter.OnIdClick() {
            @Override
            public void onclick(int id) {
                Toast.makeText(getContext(), id+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
    //年龄
    @Override
    public void onAgeInterface(AgeInterface ageInterface) {
        AgeInterface.DataBean data = ageInterface.getData();
        List<AgeInterface.DataBean.ListBean> list = data.getList();
        ageInterfaceAdapter = new AgeInterfaceAdapter(getActivity(),list);
        agerv.setAdapter(ageInterfaceAdapter);
        ageInterfaceAdapter.Coallack(new AgeInterfaceAdapter.Coallack() {
            @Override
            public void setOnClick(AgeInterface.DataBean.ListBean listBean) {
                String name = listBean.getName();
                tv.setText(name);
                id = listBean.getId();
                start_age = listBean.getStart_age();
                name1 = listBean.getName();
                popupBigPhoto.dismiss();
                BasePreantert basePreantert = getmPreanter();
                if(basePreantert instanceof CourseContreater.IPreanter){
                    ((CourseContreater.IPreanter) basePreantert).OnCourseSuccess(id+"","",name1,""+start_age,i,j);
                }
            }
        });
    }
    //课程详情
    @Override
    public void OnCourse(CourseDetails courseDetails) {

    }
}
