package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/23 11:10
 */
public class QiNiuYun {
    /**
     * code : 1
     * msg : 成功
     * data : {"hash":"Fs5Zf8gTp58qgD9TsCDDZEh9LG_V","key":"work/5fdaf20abd1b88519.png"}
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
         * hash : Fs5Zf8gTp58qgD9TsCDDZEh9LG_V
         * key : work/5fdaf20abd1b88519.png
         */

        private String hash;
        private String key;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
