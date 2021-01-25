package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Login_interface;
import com.wd.master_of_arts_app.activity.PersonalDataActivity;
import com.wd.master_of_arts_app.activity.Verification_code_login;
import com.wd.master_of_arts_app.activity.myactivity.Customer_Service_Center;
import com.wd.master_of_arts_app.activity.myactivity.Express_Inquiry;
import com.wd.master_of_arts_app.activity.myactivity.Harvest_Address;
import com.wd.master_of_arts_app.activity.myactivity.My_Collection_of_works;
import com.wd.master_of_arts_app.activity.myactivity.My_Continuation;
import com.wd.master_of_arts_app.activity.myactivity.My_Course;
import com.wd.master_of_arts_app.activity.myactivity.My_order;
import com.wd.master_of_arts_app.activity.myactivity.Notice;
import com.wd.master_of_arts_app.activity.myactivity.SetUp;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.EditUser;
import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.Image;
import com.wd.master_of_arts_app.bean.User;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.contreater.UserInformationConreater;
import com.wd.master_of_arts_app.preanter.UserInformartionPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:我的界面
 * @date :2020/12/3 11:06
 */
public class My_page extends BaseFragment implements View.OnClickListener, UserInformationConreater.IView {

    RelativeLayout myOrder;

    RelativeLayout myCollectionOfWorks;

    RelativeLayout myContinuation;

    RelativeLayout myCourse;

    RelativeLayout expressInquiry;

    RelativeLayout harvestAddress;

    RelativeLayout customerServiceCenter;

    RelativeLayout notice;

    RelativeLayout setup;
    private ImageView iv;
    private String avatar;
    private TextView name1, aage;
    private int sex;
    private ImageView man;
    private ImageView wuman;

    @Override
    protected int getLayoutId() {
        return R.layout.my;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new UserInformartionPreanter(this);
    }

    @Override
    protected void initView(View view) {
        myOrder = view.findViewById(R.id.my_order);
        myCollectionOfWorks = view.findViewById(R.id.my_collection_of_works);
        myContinuation = view.findViewById(R.id.my_continuation);
        myCourse = view.findViewById(R.id.my_course);
        expressInquiry = view.findViewById(R.id.express_inquiry);
        harvestAddress = view.findViewById(R.id.harvest_address);
        customerServiceCenter = view.findViewById(R.id.customer_service_center);
        notice = view.findViewById(R.id.notice);
        setup = view.findViewById(R.id.setup);
        iv = view.findViewById(R.id.my_image);
        name1 = view.findViewById(R.id.my_name);
        aage = view.findViewById(R.id.my_age);
        man = view.findViewById(R.id.man);
        wuman = view.findViewById(R.id.wuman);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void initData() {

        BasePreantert basePreantert = getmPreanter();
        SharedPreferences code = App.getContext().getSharedPreferences("cocde", Context.MODE_PRIVATE);
        int code1 = code.getInt("cocde", 0);
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        if (!token1.isEmpty()) {
            if (basePreantert instanceof UserInformationConreater.IPreanter) {

                ((UserInformationConreater.IPreanter) basePreantert).OnUserSuccess(token1);

            }
        }else if(code1==0){
            Intent intent = new Intent(getActivity(), Login_interface.class);
            startActivity(intent);

        }

        myOrder.setOnClickListener(this);
        myCollectionOfWorks.setOnClickListener(this);
        myContinuation.setOnClickListener(this);
        myCourse.setOnClickListener(this);
        expressInquiry.setOnClickListener(this);
        harvestAddress.setOnClickListener(this);
        customerServiceCenter.setOnClickListener(this);
        notice.setOnClickListener(this);
        setup.setOnClickListener(this);
        iv.setOnClickListener(this);

        SharedPreferences sp = App.getContext().getSharedPreferences("cocde", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("cocde", 1);
        edit.commit();


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.my_order: {
                //我的订单
                Intent intent = new Intent(getActivity(), My_order.class);
                startActivity(intent);
            }
            break;
            case R.id.my_collection_of_works: {
                //我的作品集
                Intent intent = new Intent(getActivity(), My_Collection_of_works.class);
                startActivity(intent);
            }
            break;
            case R.id.my_continuation: {
                //我的续报
                Intent intent = new Intent(getActivity(), My_Continuation.class);
                startActivity(intent);
            }
            break;
            case R.id.my_course: {
                //我的课程
                Intent intent = new Intent(getActivity(), My_Course.class);
                startActivity(intent);
            }
            break;
            case R.id.express_inquiry: {
                //快递查询
                Intent intent = new Intent(getActivity(), Express_Inquiry.class);
                startActivity(intent);
            }
            break;
            case R.id.harvest_address: {
                //收获地址
                Intent intent = new Intent(getActivity(), Harvest_Address.class);
                startActivity(intent);
            }
            break;
            case R.id.customer_service_center: {
                //客服中心
                Intent intent = new Intent(getActivity(), Customer_Service_Center.class);
                startActivity(intent);
            }
            break;
            case R.id.notice: {
                //通知
                Intent intent = new Intent(getActivity(), Notice.class);
                startActivity(intent);
            }
            break;
            case R.id.setup: {
                //设置
                Intent intent = new Intent(getActivity(), SetUp.class);
                startActivity(intent);
            }
            break;
            case R.id.my_image: {
                Intent intent = new Intent(getActivity(), PersonalDataActivity.class);
                intent.putExtra("sex", sex);
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void setUser(EditUser editUser) {
        String name = editUser.getName();
        name1.setText(name);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();

    }

    @Override
    public void OnUserInfor(UserInformation userInformation) {
        UserInformation.DataBean data = userInformation.getData();
        if (data != null) {
            UserInformation.DataBean.UserDetailBean user_detail = data.getUser_detail();
            avatar = user_detail.getAvatar();
            Glide.with(getActivity()).load(avatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).error(R.mipmap.icon_tx).into(iv);
            EventBus.getDefault().postSticky(new Image(avatar));
            String nickname = user_detail.getNickname();
            name1.setText(nickname + "");
            String birthday = user_detail.getBirthday();
            int age = user_detail.getAge();
            aage.setText(age + "岁");
            sex = user_detail.getSex();
            if (sex == 1) {
                man.setVisibility(View.VISIBLE);
                wuman.setVisibility(View.GONE);
            } else if (sex == 2) {
                wuman.setVisibility(View.VISIBLE);
                man.setVisibility(View.GONE);
            } else {
                wuman.setVisibility(View.GONE);
                man.setVisibility(View.GONE);
            }
            String detail_address = user_detail.getDetail_address();

            EventBus.getDefault().postSticky(new User(nickname, birthday, detail_address));
        } else {
            Intent intent = new Intent(getActivity(), Verification_code_login.class);
            startActivity(intent);
        }


    }

    @Override
    public void OnEditUser(EditUserInformation editUserInformation) {

    }
}
