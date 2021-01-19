package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 14:34
 */
public class SampleReels {

    /**
     * code : 1
     * msg : 成功
     * data : http://test.54artist.com/wap/homeWork/share?params=eyJ1aWQiOjUxLCJjb3Vyc2VfdGltZV9pZCI6IjI0MCJ9
     */

    private int code;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
