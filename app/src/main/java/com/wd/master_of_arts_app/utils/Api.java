package com.wd.master_of_arts_app.utils;

import com.wd.master_of_arts_app.bean.Beanner_Bean;
import com.wd.master_of_arts_app.bean.Privacy_policyBean;
import com.wd.master_of_arts_app.bean.User_agreement;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 10:22
 */
public interface Api {
    //http://app.54artist.com/index.php/wap/Banner/getList    参数为 cat_id=2  field=*   轮播图
    @POST("index.php/wap/Banner/getList")
    @FormUrlEncoded
    Observable<Beanner_Bean> getBeanner(@Field("cat_id")int cat_id, @Field("field")String field);
    /**
     *     TODO: 设置页面用户协议网络请求
     *     TODO:http://app.54artist.com/index.php/wap/Article/getMsg   参数 article_id  2为用户注册协议
     */
    @POST("index.php/wap/Article/getMsg")
    @FormUrlEncoded
    Observable<User_agreement>getUser_agreement(@Field("article_id")int article_id);
    /**
     * TODo: 设置页面隐私政策
     */
    @POST("index.php/wap/Article/getMsg")
    @FormUrlEncoded
    Observable<Privacy_policyBean>getPolicyBean(@Field("article_id")int article_id);
}
