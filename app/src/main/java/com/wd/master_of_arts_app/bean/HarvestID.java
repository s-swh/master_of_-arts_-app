package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 10:26
 */
public class HarvestID {
    public int HarId;
    public String address;

    public HarvestID(int harId, String address) {
        HarId = harId;
        this.address = address;
    }

    public int getHarId() {
        return HarId;
    }

    public void setHarId(int harId) {
        HarId = harId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
