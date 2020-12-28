package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 15:43
 */
public class DingdanXiangqing {
    public String title;
    public String date;
    public String money;
    public String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public DingdanXiangqing(String title, String date, String money, String img) {
        this.title = title;
        this.date = date;
        this.money = money;
        this.img = img;
    }
}
