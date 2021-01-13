package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/3 15:27
 */
public class HomePage {


    /**
     * code : 1
     * msg : 成功
     * data : [{"status":2,"button":"去预习","unit_id":358,"unit_name":"我爱洗澡澡","date":"2021-01-18","time":"09:00:00","teacher":"艺老师","avatar":"http://qiniu.54artist.com/5ff7c57b2b0109538.jpg","class_id":0,"course_name":"蒙蒙童画班","course_time_id":0,"homework_id":0}]
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
         * status : 2
         * button : 去预习
         * unit_id : 358
         * unit_name : 我爱洗澡澡
         * date : 2021-01-18
         * time : 09:00:00
         * teacher : 艺老师
         * avatar : http://qiniu.54artist.com/5ff7c57b2b0109538.jpg
         * class_id : 0
         * course_name : 蒙蒙童画班
         * course_time_id : 0
         * homework_id : 0
         */

        private int status;
        private String button;
        private int unit_id;
        private String unit_name;
        private String date;
        private String time;
        private String teacher;
        private String avatar;
        private int class_id;
        private String course_name;
        private int course_time_id;
        private int homework_id;

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

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public int getCourse_time_id() {
            return course_time_id;
        }

        public void setCourse_time_id(int course_time_id) {
            this.course_time_id = course_time_id;
        }

        public int getHomework_id() {
            return homework_id;
        }

        public void setHomework_id(int homework_id) {
            this.homework_id = homework_id;
        }
    }
}
