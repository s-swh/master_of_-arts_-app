package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/16 9:24
 */
public class AccountLogin {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"uid":54,"group_id":1,"token":"8efaafbbefea87e0d5e4c0206c521232"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 54
         * group_id : 1
         * token : 8efaafbbefea87e0d5e4c0206c521232
         */

        private int uid;
        private int group_id;
        private String token;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getGroup_id() {
            return group_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}