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
     * data : {"status":4,"button":"提交作业","unit_id":310,"unit_name":"植物写生（上）","date":"2021-01-05","time":"13:30:00","teacher":"殷老师","avatar":"http://qiniu.54artist.com/5feae941b92875871.jpg","class_id":""}
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
         * status : 4
         * button : 提交作业
         * unit_id : 310
         * unit_name : 植物写生（上）
         * date : 2021-01-05
         * time : 13:30:00
         * teacher : 殷老师
         * avatar : http://qiniu.54artist.com/5feae941b92875871.jpg
         * class_id :
         */

        private int status;
        private String button;
        private int unit_id;
        private String unit_name;
        private String date;
        private String time;
        private String teacher;
        private String avatar;
        private String class_id;

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

        public String getClass_id() {
            return class_id;
        }

        public void setClass_id(String class_id) {
            this.class_id = class_id;
        }
    }
}
