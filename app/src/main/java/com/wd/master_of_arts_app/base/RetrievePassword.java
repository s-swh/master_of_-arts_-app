package com.wd.master_of_arts_app.base;

/**
 * @author 时文豪
 * @description:  找回密码
 * @date :2020/12/19 10:59
 */
public class RetrievePassword {
    /**
     * code : 1
     * msg : 找回密码成功,请使用新密码登陆
     */

    private int code;
    private String msg;

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
}
