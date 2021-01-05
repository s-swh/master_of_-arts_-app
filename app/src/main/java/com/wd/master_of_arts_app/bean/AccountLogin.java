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
     * data : {"uid":54,"user_name":"18803652019","group_id":1,"token":"475fd038a9c1a96a2de10a9f39cf9643"}
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
         * user_name : 18803652019
         * group_id : 1
         * token : 475fd038a9c1a96a2de10a9f39cf9643
         */

        private int uid;
        private String user_name;
        private int group_id;
        private String token;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
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
