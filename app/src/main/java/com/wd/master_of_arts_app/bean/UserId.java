package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/5 16:43
 */
public class UserId {
    public String used;
    public String name;

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserId(String used, String name) {
        this.used = used;
        this.name = name;
    }
}
