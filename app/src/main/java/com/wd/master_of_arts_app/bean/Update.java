package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/21 23:23
 */
public class Update {
    /**
     * code : 1
     * msg : 成功
     * data : {"id":1,"anzhuo_num":2,"ios_num":2,"ios_link":"","anzhuo_link":"","create_time":"2021-01-16 17:14:39"}
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
         * id : 1
         * anzhuo_num : 2
         * ios_num : 2
         * ios_link :
         * anzhuo_link :
         * create_time : 2021-01-16 17:14:39
         */

        private int id;
        private int anzhuo_num;
        private int ios_num;
        private String ios_link;
        private String anzhuo_link;
        private String create_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAnzhuo_num() {
            return anzhuo_num;
        }

        public void setAnzhuo_num(int anzhuo_num) {
            this.anzhuo_num = anzhuo_num;
        }

        public int getIos_num() {
            return ios_num;
        }

        public void setIos_num(int ios_num) {
            this.ios_num = ios_num;
        }

        public String getIos_link() {
            return ios_link;
        }

        public void setIos_link(String ios_link) {
            this.ios_link = ios_link;
        }

        public String getAnzhuo_link() {
            return anzhuo_link;
        }

        public void setAnzhuo_link(String anzhuo_link) {
            this.anzhuo_link = anzhuo_link;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
