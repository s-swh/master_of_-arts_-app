package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/26 15:30
 */
public class User {
   public String name;
   public String  date;
   public int sex;
   public String detail_address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public User(String name, String date, int sex, String detail_address) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.detail_address = detail_address;
    }
}
