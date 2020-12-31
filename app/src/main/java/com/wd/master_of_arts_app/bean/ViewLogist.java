package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 9:37
 */
public class ViewLogist {
    public String logistics;
    public String express_number;

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getExpress_number() {
        return express_number;
    }

    public void setExpress_number(String express_number) {
        this.express_number = express_number;
    }

    public ViewLogist(String logistics, String express_number) {
        this.logistics = logistics;
        this.express_number = express_number;
    }
}
