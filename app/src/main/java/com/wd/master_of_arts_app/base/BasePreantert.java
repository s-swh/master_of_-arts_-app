package com.wd.master_of_arts_app.base;

import java.lang.ref.WeakReference;

/**
 * @author 时文豪
 * @description: BasePreanter 做我们MVP中的P层处理
 * @date :2020/12/3 10:19
 */
public abstract class BasePreantert <V extends IBaseView> {

    private WeakReference<V> vWeakReference;

    public BasePreantert(V v) {
        vWeakReference = new WeakReference<>(v);// 弱引用 防止我们程序内存泄漏
        initModer();
    }
    public V getView(){
        if(vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }
    protected abstract void initModer();
    protected void datachView(){
        if(vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
}
