package com.wd.master_of_arts_app.utils;

import com.wd.master_of_arts_app.base.RetrievePassword;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.bean.UploadPictures;
import com.wd.master_of_arts_app.bean.UploadWorks;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 10:22
 */
public interface Api {

    // 获取短信验证码  http://test.54artist.com/wap/Sms/send
    @POST("wap/Sms/send")
    @FormUrlEncoded
    Observable<CodeBean> getCodeBean(@Field("phone") String phone);

    // 短信验证码登录http://test.54artist.com/wap/UserAccount/loginByCode
    @POST("wap/UserAccount/loginByCode")
    @FormUrlEncoded
    Observable<SMSLogin> getSmsLogin(@Field("phone") String phone, @Field("code") String code);

    // 账号密码登录 http://test.54artist.com/wap/UserAccount/login
    @POST("wap/UserAccount/login")
    @FormUrlEncoded
    Observable<AccountLogin> getAccount(@Field("account") String account, @Field("pwd") String pwd);

    // 编辑头像 http://test.54artist.com/wap/User/editAvatar
    @Multipart
    @POST("wap/User/editAvatar")
    Observable<UploadPictures> upImg(@Part("token") RequestBody token, @Part("FunName") RequestBody funName, @Part("path") RequestBody path, @Part("appfile") RequestBody appfile, @Part MultipartBody.Part file);

    // 作品上传 http://test.54artist.com/wap/HomeWork/add
    @POST("wap/HomeWork/add")
    @FormUrlEncoded @Multipart
    Observable<UploadWorks> getUploadWorks(@Field("token") String token,@Field("course_unit_id")int course_unit_id,@Field("name") String name,@Field("content")String content,@Part("imglist") RequestBody imglist);

    // 轮播图 http://test.54artist.com/wap/Banner/getList
    @POST("wap/Banner/getList")
    @FormUrlEncoded
    Observable<Beanner> getBeanner(@Field("cat_id") int cat_id);

    // 课程列表接口  //http://test.54artist.com/wap/CourseTime/getList
    @POST("wap/CourseTime/getList")
    @FormUrlEncoded
    Observable<CourseList>getCourseList(@Field("cat_id")String cat_id,@Field("is_top")String is_top,@Field("age")String age,@Field("p")int p,@Field("per")int per);

    // 年龄段列表接口 //http://test.54artist.com/wap/Age/getList
    @POST("wap/Age/getList")
    Observable<AgeInterface>getAge();

    //找回密码  http://test.54artist.com/wap/UserAccount/findPwdByPhone
    @POST("wap/UserAccount/findPwdByPhone")
    @FormUrlEncoded
    Observable<RetrievePassword>getRetrievePassword(@Field("phone")String phone,@Field("code")String code,@Field("pwd")String pwd);

    //退出 http://test.54artist.com/wap/User/loginout
    @POST("wap/User/loginout")
    @FormUrlEncoded
    Observable<SignOut>getSignOut(@Field("token")String token);

    //添加订单 http://test.54artist.com/wap/ConsigneeAddress/add
    @POST("wap/ConsigneeAddress/add")
    @FormUrlEncoded
    Observable<HarvestAddress>getHarvestAddress(@Field("token")String token,@Field("province")String province,@Field("city")String city,@Field("county")String county,@Field("detail_address")String detail_address,@Field("company")String company,@Field("consignee")String consignee,@Field("contact_number")String contact_number,@Field("postcode")String postcode,@Field("is_default")String is_default);

    //查看收获地址列表  http://test.54artist.com/wap/ConsigneeAddress/getList
    @POST("wap/ConsigneeAddress/getList")
    @FormUrlEncoded
    Observable<ViewHarvestAddress>getViewHarvest(@Field("token")String token);

    //删除收获地址  http://test.54artist.com/wap/ConsigneeAddress/del
    @POST("wap/ConsigneeAddress/del")
    @FormUrlEncoded
    Observable<DeleteHarvestAddress>getDelete(@Field("token")String token,@Field("address_id")String address_id);

    //获取用户信息接口  http://test.54artist.com/wap/User/getMsg
    @POST("wap/User/getMsg")
    @FormUrlEncoded
    Observable<UserInformation>getUser(@Field("token")String token);
}
