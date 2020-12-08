package com.wd.master_of_arts_app.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author 时文豪
 * @description:  baseactivity 基类抽取
 * @date :2020/12/3 10:18
 */
public abstract class BaseActivity <P extends BasePreantert> extends AppCompatActivity implements IBaseView {
    P mPreantert;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPreantert=initModel();//Preanter 做处理
        initView();//找控件方式
        initData();
        ButterKnife.bind(this);
    }

    public P getmPreantert() {
        return mPreantert;
    }



    protected abstract int getLayoutId();

    protected abstract P initModel();

    protected abstract void initView();

    protected abstract void initData();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPreantert!=null){
            mPreantert.datachView();
            mPreantert=null;
        }
    }
}