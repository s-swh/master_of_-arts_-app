package com.wd.master_of_arts_app.base;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/3 12:26
 */
public class CourseChecking {


    /**
     * code : 1
     * msg : 成功
     * data : [{"unit_name":"神奇的豆芽","date":"2021-02-02","start_time":"17:30:00","end_time":"18:30:00","course_time_id":228,"course_id":71,"order_id":53,"sort_num":1,"teacher_name":"谭老师","avatar":"http://qiniu.54artist.com/5feae974db33d7868.jpg"}]
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
         * unit_name : 神奇的豆芽
         * date : 2021-02-02
         * start_time : 17:30:00
         * end_time : 18:30:00
         * course_time_id : 228
         * course_id : 71
         * order_id : 53
         * sort_num : 1
         * teacher_name : 谭老师
         * avatar : http://qiniu.54artist.com/5feae974db33d7868.jpg
         */

        private String unit_name;
        private String date;
        private String start_time;
        private String end_time;
        private int course_time_id;
        private int course_id;
        private int order_id;
        private int sort_num;
        private String teacher_name;
        private String avatar;

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

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getCourse_time_id() {
            return course_time_id;
        }

        public void setCourse_time_id(int course_time_id) {
            this.course_time_id = course_time_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getSort_num() {
            return sort_num;
        }

        public void setSort_num(int sort_num) {
            this.sort_num = sort_num;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
