package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/30 10:56
 */
public class MyClassDate {
    /**
     * code : 1
     * msg : 成功
     * data : [{"date":"2020-12-05"},{"date":"2020-12-12"},{"date":"2020-12-19"},{"date":"2020-12-26"},{"date":"2021-01-02"},{"date":"2021-01-09"},{"date":"2021-01-16"},{"date":"2021-01-23"},{"date":"2021-01-30"},{"date":"2021-02-06"},{"date":"2021-02-13"},{"date":"2021-02-20"},{"date":"2021-02-27"},{"date":"2021-03-06"},{"date":"2021-03-13"},{"date":"2021-03-20"},{"date":"2021-03-27"},{"date":"2021-04-03"},{"date":"2021-04-10"},{"date":"2021-04-17"},{"date":"2021-04-24"},{"date":"2021-05-01"},{"date":"2021-05-15"},{"date":"2021-05-22"},{"date":"2020-12-08"},{"date":"2020-12-10"},{"date":"2020-12-15"},{"date":"2020-12-17"},{"date":"2020-12-22"},{"date":"2020-12-24"},{"date":"2020-12-29"},{"date":"2020-12-31"},{"date":"2021-01-05"},{"date":"2021-01-07"},{"date":"2021-01-12"},{"date":"2021-01-14"},{"date":"2021-01-19"},{"date":"2021-01-21"},{"date":"2021-01-26"},{"date":"2021-01-28"},{"date":"2021-02-02"},{"date":"2021-02-04"},{"date":"2021-02-09"},{"date":"2021-02-11"},{"date":"2021-02-16"},{"date":"2021-02-18"},{"date":"2021-02-23"},{"date":"2021-02-25"},{"date":"2020-12-09"},{"date":"2020-12-16"},{"date":"2020-12-23"},{"date":"2020-12-30"},{"date":"2021-01-06"},{"date":"2021-01-13"},{"date":"2021-01-20"},{"date":"2021-01-27"},{"date":"2021-02-03"},{"date":"2021-02-10"},{"date":"2021-02-17"},{"date":"2021-02-24"},{"date":"2021-03-02"},{"date":"2020-12-13"},{"date":"2020-12-20"},{"date":"2020-12-27"},{"date":"2021-01-03"},{"date":"2021-01-10"},{"date":"2021-01-17"},{"date":"2021-01-24"},{"date":"2021-01-31"},{"date":"2021-02-07"},{"date":"2021-02-14"},{"date":"2021-02-21"},{"date":"2021-02-28"},{"date":"2020-12-14"},{"date":"2020-12-21"},{"date":"2020-12-28"},{"date":"2021-01-04"},{"date":"2021-01-11"},{"date":"2021-01-18"},{"date":"2021-01-25"},{"date":"2021-02-01"},{"date":"2021-02-08"},{"date":"2021-02-15"},{"date":"2021-02-22"},{"date":"2021-03-01"},{"date":"2021-03-03"},{"date":"2020-12-18"},{"date":"2020-12-25"},{"date":"2021-01-01"},{"date":"2021-01-08"},{"date":"2021-01-15"},{"date":"2021-01-22"},{"date":"2021-01-29"},{"date":"2021-02-05"},{"date":"2021-02-12"},{"date":"2021-02-19"},{"date":"2021-02-26"},{"date":"2021-03-05"},{"date":"2021-03-12"},{"date":"2021-03-19"},{"date":"2021-03-26"},{"date":"2021-04-02"},{"date":"2021-04-09"},{"date":"2021-04-16"},{"date":"2021-04-23"},{"date":"2021-04-30"},{"date":"2021-05-07"},{"date":"2021-05-14"},{"date":"2021-05-21"},{"date":"2021-05-28"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * date : 2020-12-05
         */

        private String date;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
