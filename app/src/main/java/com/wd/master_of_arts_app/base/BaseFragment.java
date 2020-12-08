package com.wd.master_of_arts_app.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * @author 时文豪
 * @description: fragment 做基类抽取
 * @date :2020/12/3 10:48
 */
public abstract class BaseFragment <P extends BasePreantert>  extends Fragment implements IBaseView{
    P mPreanter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), getLayoutId(), null);
        mPreanter=initPreantert();
        initView(inflate);
        initData();
        ButterKnife.bind(this,inflate);
        return inflate;

    }



    public P getmPreanter() {
        return mPreanter;
    }

    protected abstract int getLayoutId();

    protected abstract P initPreantert();

    protected abstract void initView(View inflate);

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPreanter!=null){
            mPreanter.datachView();
            mPreanter=null;
        }
    }
}
