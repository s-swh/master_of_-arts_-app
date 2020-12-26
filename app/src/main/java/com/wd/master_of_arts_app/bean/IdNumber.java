package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/26 16:39
 */
public class IdNumber {
    public int course_id;
    public int course_time_id;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getCourse_time_id() {
        return course_time_id;
    }

    public void setCourse_time_id(int course_time_id) {
        this.course_time_id = course_time_id;
    }

    public IdNumber(int course_id, int course_time_id) {
        this.course_id = course_id;
        this.course_time_id = course_time_id;
    }
}
