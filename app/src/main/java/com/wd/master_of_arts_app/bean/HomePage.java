package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/3 15:27
 */
public class HomePage {


    /**
     * code : 1
     * msg : 成功
     * data : {"status":2,"button":"去预习","unit_id":241,"unit_name":"神奇的豆芽","date":"2021-02-02","time":"17:30:00","teacher":"谭老师","avatar":"http://qiniu.54artist.com/5feae974db33d7868.jpg"}
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
         * status : 2
         * button : 去预习
         * unit_id : 241
         * unit_name : 神奇的豆芽
         * date : 2021-02-02
         * time : 17:30:00
         * teacher : 谭老师
         * avatar : http://qiniu.54artist.com/5feae974db33d7868.jpg
         */

        private int status;
        private String button;
        private int unit_id;
        private String unit_name;
        private String date;
        private String time;
        private String teacher;
        private String avatar;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getButton() {
            return button;
        }

        public void setButton(String button) {
            this.button = button;
        }

        public int getUnit_id() {
            return unit_id;
        }

        public void setUnit_id(int unit_id) {
            this.unit_id = unit_id;
        }

        public String getUnit_name() {
            return unit_name;
        }

        public void setUnit_name(String unit_name) {
            this.unit_name = unit_name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
