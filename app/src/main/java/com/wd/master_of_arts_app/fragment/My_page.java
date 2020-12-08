package com.wd.master_of_arts_app.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.myactivity.Customer_Service_Center;
import com.wd.master_of_arts_app.activity.myactivity.Express_Inquiry;
import com.wd.master_of_arts_app.activity.myactivity.Harvest_Address;
import com.wd.master_of_arts_app.activity.myactivity.My_Collection_of_works;
import com.wd.master_of_arts_app.activity.myactivity.My_Continuation;
import com.wd.master_of_arts_app.activity.myactivity.My_Course;
import com.wd.master_of_arts_app.activity.myactivity.My_order;
import com.wd.master_of_arts_app.activity.myactivity.Notice;
import com.wd.master_of_arts_app.activity.myactivity.SetUp;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.BindView;

/**
 * @author 时文豪
 * @description:我的界面
 * @date :2020/12/3 11:06
 */
public class My_page extends BaseFragment implements View.OnClickListener {

    RelativeLayout myOrder;

    RelativeLayout myCollectionOfWorks;

    RelativeLayout myContinuation;

    RelativeLayout myCourse;

    RelativeLayout expressInquiry;

    RelativeLayout harvestAddress;

    RelativeLayout customerServiceCenter;

    RelativeLayout notice;

    RelativeLayout setup;

    @Override
    protected int getLayoutId() {
        return R.layout.my;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
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
    }

    @Override
    protected void initData() {
        myOrder.setOnClickListener(this);
        myCollectionOfWorks.setOnClickListener(this);
        myContinuation.setOnClickListener(this);
        myCourse.setOnClickListener(this);
        expressInquiry.setOnClickListener(this);
        harvestAddress.setOnClickListener(this);
        customerServiceCenter.setOnClickListener(this);
        notice.setOnClickListener(this);
        setup.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
