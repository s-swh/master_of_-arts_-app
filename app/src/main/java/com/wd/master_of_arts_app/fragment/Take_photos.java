package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.DetailsOfWorks;
import com.wd.master_of_arts_app.activity.Login_interface;
import com.wd.master_of_arts_app.activity.Publishing_works_Activity;
import com.wd.master_of_arts_app.activity.Verification_code_login;
import com.wd.master_of_arts_app.adapter.WorksAdapter;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.preanter.WorksPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description: 拍照办公
 * @date :2020/12/3 10:54
 */
public class Take_photos extends BaseFragment implements worksContreanter.IVew {
    public static final int CAMERA_REQ_CODE = 111;
    private RelativeLayout lyt;
    private XRecyclerView xrv;
    private LinearLayout wdl;
    int i = 1;
    int j = 10;
    private WorksAdapter worksAdapter;
    private List<ListOfWorks.DataBean.ListBean> list;
    private ListOfWorks.DataBean data;
    private ListOfWorks.DataBean.ListBean listBean;
    private List<ListOfWorks.DataBean.ListBean> listBeanList = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.take_photos;
    }


    @Override
    protected BasePreantert initPreantert() {
        return new WorksPreanter(this);
    }

    @Override
    protected void initView(View view) {

        xrv = view.findViewById(R.id.works_rv);
        lyt = view.findViewById(R.id.lyt);
        wdl = view.findViewById(R.id.wdl);


    }

    //发布作品

    @OnClick({R.id.photograph1})
    public void photograph1() {

        Intent intent = new Intent(getActivity(), Publishing_works_Activity.class);
        startActivity(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQ_CODE: {
                // 如果请求被拒绝，那么通常grantResults数组为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 申请成功，进行相应操作
                } else {
                    // 申请失败，可以继续向用户解释。

                    Toast.makeText(getActivity(), "没有相机权限,您可能无法使用相机", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            default:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreanter();
        SharedPreferences token = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        if (!token1.isEmpty()) {
            wdl.setVisibility(View.GONE);
            if (basePreantert instanceof worksContreanter.IPreanter) {
                ((worksContreanter.IPreanter) basePreantert).OnWorksSuccess(token1, "", i, j);
            }

            wdl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Publishing_works_Activity.class);
                    startActivity(intent);
                }
            });
        } else {
            wdl.setVisibility(View.VISIBLE);
            wdl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Login_interface.class);
                    startActivity(intent);
                }
            });
        }

        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                i = 1;
                worksAdapter.Refresh(data.getList());
                if (basePreantert instanceof worksContreanter.IPreanter) {
                    ((worksContreanter.IPreanter) basePreantert).OnWorksSuccess(token1, "", i, j);
                }
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
                xrv.setLayoutManager(linearLayoutManager1);
            }

            @Override
            public void onLoadMore() {
                i++;
                if (basePreantert instanceof worksContreanter.IPreanter) {
                    ((worksContreanter.IPreanter) basePreantert).OnWorksSuccess(token1, "", i, j);
                }

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xrv.setLayoutManager(linearLayoutManager);
        worksAdapter = new WorksAdapter(getActivity(), listBeanList);
        xrv.setAdapter(worksAdapter);

        worksAdapter.OnClickWorks(new WorksAdapter.OnClickWorks() {
            @Override
            public void click(int id) {
                Intent intent = new Intent(getActivity(), DetailsOfWorks.class);
                intent.putExtra("work_id", id);
                startActivity(intent);
            }
        });
    }


    @Override
    public void OnWorks(ListOfWorks listOfWorks) {
        wdl.setVisibility(View.GONE);
        int code = listOfWorks.getCode();
        data = listOfWorks.getData();
        list = data.getList();
        listBeanList = list;

        worksAdapter.LoadMore(listBeanList);
        if (i == 1 && list.size() == 0) {
            wdl.setVisibility(View.VISIBLE);
        }


        xrv.loadMoreComplete();
        xrv.refreshComplete();


        worksAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnDetailsWorks(DetailsOfWorksBean worksBean) {

    }
}
