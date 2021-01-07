package com.wd.master_of_arts_app.utils;

import com.wd.master_of_arts_app.base.CourseChecking;
import com.wd.master_of_arts_app.base.RetrievePassword;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.ArticleDetails;
import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.BookingExperience;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.bean.HomeWorkBean;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.bean.LiveBoradCast;
import com.wd.master_of_arts_app.bean.Logistics;
import com.wd.master_of_arts_app.bean.MoreComm;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.bean.MyHome;
import com.wd.master_of_arts_app.bean.OrderDelete;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Preview;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.bean.QiNiuYun;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.bean.TakePhotosAndComment;
import com.wd.master_of_arts_app.bean.UpdateShipping;
import com.wd.master_of_arts_app.bean.UploadPictures;
import com.wd.master_of_arts_app.bean.UploadWorks;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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

    // 作品上传 http://test.54artist.com/wap/HomeWork/add   ,@Part("course_unit_id")int course_unit_id,@Part("name") String name,@Part("content")String content
    @POST("wap/HomeWork/add")
    @Multipart
    Observable<UploadWorks> getUploadWorks(@Part("token") RequestBody token, @Part("FunName") RequestBody funName, @Part("path") RequestBody path, @Part("appfile") RequestBody appfile, @Part MultipartBody.Part imglist);

    //作品详情  http://test.54artist.com/wap/Work/getMsg
    @POST("wap/Work/getMsg")
    @FormUrlEncoded
    Observable<DetailsOfWorksBean> getOfWorks(@Field("work_id") int work_id);

    //七牛云 http://test.54artist.com/wap/Qn/upload   http://test.54artist.com/wap/Qn/upload
    @POST("wap/Qn/upload")
    @Multipart
    Observable<QiNiuYun> getQny(@Part("FunName") RequestBody funName, @Part("path") RequestBody path, @Part("appfile") RequestBody appfile, @Part MultipartBody.Part file);

    // 轮播图 http://test.54artist.com/wap/Banner/getList
    @POST("wap/Banner/getList")
    @FormUrlEncoded
    Observable<Beanner> getBeanner(@Field("cat_id") int cat_id);

    // 课程列表接口  //http://test.54artist.com/wap/CourseTime/getList
    @POST("wap/CourseTime/getList")
    @FormUrlEncoded
    Observable<CourseList> getCourseList(@Field("cat_id") String cat_id, @Field("is_top") String is_top, @Field("course_name") String course_name, @Field("age") String age, @Field("p") int p, @Field("per") int per);

    // 年龄段列表接口 http://test.54artist.com/wap/Age/getList
    @POST("wap/Age/getList")
    Observable<AgeInterface> getAge();

    //课程详情接口 http://test.54artist.com/wap/CourseTime/getMsg
    @POST("wap/CourseTime/getMsg")
    @FormUrlEncoded
    Observable<CourseDetails> getCourseDatails(@Field("course_time_id") int course_time_id);

    //文章列表 http://test.54artist.com/wap/Article/discover
    @POST("wap/Article/discover")
    @FormUrlEncoded
    Observable<ArticleList> getArticle(@Field("token") String token);

    //重置密码  http://test.54artist.com/wap/UserAccount/findPwdByPhone
    @POST("wap/UserAccount/findPwdByPhone")
    @FormUrlEncoded
    Observable<RetrievePassword> getRetrievePassword(@Field("phone") String phone, @Field("code") String code, @Field("pwd") String pwd);

    //退出 http://test.54artist.com/wap/User/loginout
    @POST("wap/User/loginout")
    @FormUrlEncoded
    Observable<SignOut> getSignOut(@Field("token") String token);

    //添加订单 http://test.54artist.com/wap/ConsigneeAddress/add
    @POST("wap/ConsigneeAddress/add")
    @FormUrlEncoded
    Observable<HarvestAddress> getHarvestAddress(@Field("token") String token, @Field("province") String province, @Field("city") String city, @Field("county") String county, @Field("detail_address") String detail_address, @Field("company") String company, @Field("consignee") String consignee, @Field("contact_number") String contact_number, @Field("postcode") String postcode, @Field("is_default") String is_default);

    //查看收获地址列表  http://test.54artist.com/wap/ConsigneeAddress/getList
    @POST("wap/ConsigneeAddress/getList")
    @FormUrlEncoded
    Observable<ViewHarvestAddress> getViewHarvest(@Field("token") String token);

    //删除收获地址  http://test.54artist.com/wap/ConsigneeAddress/del
    @POST("wap/ConsigneeAddress/del")
    @FormUrlEncoded
    Observable<DeleteHarvestAddress> getDelete(@Field("token") String token, @Field("address_id") String address_id);

    //修改收货地址  http://test.54artist.com/wap/ConsigneeAddress/edit
    @POST("wap/ConsigneeAddress/edit")
    @FormUrlEncoded
    Observable<UpdateShipping> getUpdate(@Field("token") String token, @Field("address_id") int address_id, @Field("province") String province, @Field("city") String city, @Field("county") String county, @Field("detail_address") String detail_address, @Field("consignee") String consignee, @Field("contact_number") String contact_number, @Field("is_default") String is_default);


    //获取用户信息接口  http://test.54artist.com/wap/User/getMsg
    @POST("wap/User/getMsg")
    @FormUrlEncoded
    Observable<UserInformation> getUser(@Field("token") String token);

    //编辑用户接口  http://test.54artist.com/wap/User/editMsg
    @POST("wap/User/editMsg")
    @FormUrlEncoded
    Observable<EditUserInformation> getEditUser(@Field("token") String token, @Field("nickname") String nickname, @Field("sex") int sex, @Field("birthday") String birthday, @Field("province") String province, @Field("city") String city, @Field("county") String county);

    //拍照点评  http://test.54artist.com/wap/Work/add @Field("token")String token,@Field("name")String name,@Field("content")String content,
    @POST("wap/Work/add")
    @FormUrlEncoded
    Observable<TakePhotosAndComment> getTakePhotos(@Field("token") String token, @Field("name") String namem, @Field("content") String content, @Field("imglist") String imglist, @Field("voicelist") String voicelist);

    // 作品列表接口   http://test.54artist.com/wap/work/getList
    @POST("wap/work/getList")
    @FormUrlEncoded
    Observable<ListOfWorks> getListOf(@Field("token") String token, @Field("is_comment") String is_comment, @Field("p") int p, @Field("per") int per);

    //下单 http://test.54artist.com/wap/CourseOrder/Order
    @POST("wap/CourseOrder/Order")
    @FormUrlEncoded
    Observable<Purchase> getPurchase(@Field("token") String token, @Field("course_id") int course_id, @Field("course_time_id") int course_time_id, @Field("address_id") int address_id);

    //订单列表  http://test.54artist.com/wap/CourseOrder/getList
    @POST("wap/CourseOrder/getList")
    @FormUrlEncoded
    Observable<OrderList> getOrderlist(@Field("token") String token, @Field("status") String status, @Field("p") int p, @Field("per") int per);

    //删除订单 http://test.54artist.com/wap/CourseOrder/del
    @POST("wap/CourseOrder/del")
    @FormUrlEncoded
    Observable<OrderDelete> getOrderDelete(@Field("token") String token, @Field("order_id") int order_id);

    //我的课程  http://test.54artist.com/wap/CourseOrder/getCourse
    @POST("wap/CourseOrder/getCourse")
    @FormUrlEncoded
    Observable<MyCurse> getCurse(@Field("token") String token, @Field("p") int p, @Field("per") int per);

    //取消订单  http://test.54artist.com/wap/CourseOrder/cancel
    @POST("wap/CourseOrder/cancel")
    @FormUrlEncoded
    Observable<CancellationOfOrder> getOfOrder(@Field("token") String token, @Field("order_id") String order_id);

    //我的课程课程详情  http://test.54artist.com/wap/CourseOrder/getMyCourseMsg
    @POST("wap/CourseOrder/getMyCourseMsg")
    @FormUrlEncoded
    Observable<MyCourseDetailsBean> getCourseBean(@Field("token") String token, @Field("order_id") int order_id, @Field("course_time_id") int course_time_id);

    //订单详情 http://test.54artist.com/wap/CourseOrder/getMsg
    @POST("wap/CourseOrder/getMsg")
    @FormUrlEncoded
    Observable<CourseOrderBean> getCourseOrder(@Field("token") String token, @Field("order_id") int order_id);

    //评论    http://test.54artist.com/wap/CourseOrder/comment
    @POST("wap/CourseOrder/comment")
    @FormUrlEncoded
    Observable<CommentOrder> getCommentOrder(@Field("token") String token, @Field("order_id") int order_id, @Field("score") int score, @Field("content") String content);

    //课程表日期接口 http://test.54artist.com/wap/CourseTime/getMyClassDate
    @POST("wap/CourseTime/getMyClassDate")
    @FormUrlEncoded
    Observable<MyClassDate> getMyClass(@Field("token") String token);

    //查看物流   http://test.54artist.com/wap/CourseOrder/getLogisticsMsg
    @POST("wap/CourseOrder/getLogisticsMsg")
    @FormUrlEncoded
    Observable<Logistics> getLogist(@Field("token") String token, @Field("logistics") String logistics, @Field("express_number") String express_number);

    //预约体验  http://test.54artist.com/wap/Message/online
    @POST("wap/Message/online")
    @FormUrlEncoded
    Observable<BookingExperience> getBook(@Field("token") String token, @Field("phone") String phone, @Field("linkman") String linkman, @Field("cat_id") int cat_id);

    //文章列表 http://test.54artist.com/wap/Article/getList
    @POST("wap/Article/getList")
    @FormUrlEncoded
    Observable<CommBean> getCommBean(@Field("cat_id") int cat_id, @Field("p") int p, @Field("per") int per);

    //日历查课 http://test.54artist.com/wap/CourseTime/getMyClassMsg
    @POST("wap/CourseTime/getMyClassMsg")
    @FormUrlEncoded
    Observable<CourseChecking> getCourseChecking(@Field("token") String token, @Field("date") String date);

    //首页 http://test.54artist.com/wap/CourseUnit/getIndex
    @POST("wap/CourseUnit/getIndex")
    @FormUrlEncoded
    Observable<HomePage> getHomePage(@Field("token") String token);

    //获取预习内容接口 http://test.54artist.com/wap/CourseUnit/getPreContent
    @POST("wap/CourseUnit/getPreContent")
    @FormUrlEncoded
    Observable<Preview> getPreview(@Field("token") String token, @Field("unit_id") int unit_id);

    //文章详情  http://test.54artist.com/wap/Article/getMsg
    @POST("wap/Article/getMsg")
    @FormUrlEncoded
    Observable<ArticleDetails> getArti(@Field("article_id") int article_id);

    //我的作业  http://test.54artist.com/wap/HomeWork/add
    @POST("wap/HomeWork/add")
    @FormUrlEncoded
    Observable<MyHome> getMyHome(@Field("token") String token, @Field("course_unit_id") int course_unit_id, @Field("name") String name, @Field("content") String content, @Field("imglist") String imglist, @Field("voicelist") String voicelist);

    //直播  http://test.54artist.com/wap/Plaso/getLiveRoomUrl
    @POST("wap/Plaso/getLiveRoomUrl")
    @FormUrlEncoded
    Observable<LiveBoradCast> getLiveBorad(@Field("userType") String userType, @Field("meetingType") String meetingType, @Field("mediaType") String mediaType, @Field("meetingId") String meetingId, @Field("userName") String userName, @Field("loginName") String loginName, @Field("topic") String topic);

    //作业详情 http://test.54artist.com/wap/HomeWork/getMsg
    @POST("wap/HomeWork/getMsg")
    @FormUrlEncoded
    Observable<HomeWorkBean> getHomeBean(@Field("work_id") int work_id);

    //全部评论 http://test.54artist.com/wap/Course/getCommentList
    @POST("wap/Course/getCommentList")
    @FormUrlEncoded
    Observable<MoreComm>getMore(@Field("course_id")int course_id,@Field("p")int p,@Field("per")int per);
}
