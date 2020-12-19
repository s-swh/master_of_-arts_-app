package com.wd.master_of_arts_app.adapter;

/**
 * @author 时文豪
 * @description: EventBus 传手机号
 * @date :2020/12/19 10:30
 */
public class MyEventBus  {
    public String phone;

    public MyEventBus(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
