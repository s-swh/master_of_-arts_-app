package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.DetailsOfWorks;
import com.wd.master_of_arts_app.activity.Publishing_works_Activity;
import com.wd.master_of_arts_app.adapter.WorksAdapter;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.preanter.WorksPreanter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.OnClick;

/**
 * @author 时文豪
 * @description:  拍照办公
 * @date :2020/12/3 10:54
 */
public class Take_photos extends BaseFragment implements worksContreanter.IVew {
    public static final int CAMERA_REQ_CODE = 111;
    private LinearLayout lt;
    private XRecyclerView xrv;
    int i=1;
    int j=10;
    private WorksAdapter worksAdapter;
    private List<ListOfWorks.DataBean.ListBean> list;
    private ListOfWorks.DataBean data;

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
        lt = view.findViewById(R.id.vigono);
        xrv = view.findViewById(R.id.works_rv);
    }
     //发布作品
    @OnClick({R.id.photograph})
    public void photograph(){

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
            default:break;
        }
    }



    @Override
    protected void initData() {
        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                i=1;
                xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                i++;

                xrv.loadMoreComplete();
            }
        });
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof worksContreanter.IPreanter){
            SharedPreferences token = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
            String token1 = token.getString("token", "");

            ((worksContreanter.IPreanter) basePreantert).OnWorksSuccess(token1,"",i,j);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xrv.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void OnWorks(ListOfWorks listOfWorks) {
        int code = listOfWorks.getCode();
        if(code==1){
            lt.setVisibility(View.GONE);
            xrv.setVisibility(View.VISIBLE);
        }else{
            xrv.setVisibility(View.GONE);
        }
        data = listOfWorks.getData();

        if(data!=null){
            list = data.getList();
            worksAdapter = new WorksAdapter(getActivity(), list);
            worksAdapter.OnClickWorks(new WorksAdapter.OnClickWorks() {
                @Override
                public void click(int id) {
                    Toast.makeText(getActivity(), ""+id, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), DetailsOfWorks.class);
                    intent.putExtra("work_id",id);
                    startActivity(intent);

                }
            });
            xrv.setAdapter(worksAdapter);
        }



    }

    @Override
    public void OnDetailsWorks(DetailsOfWorksBean worksBean) {

    }
}
