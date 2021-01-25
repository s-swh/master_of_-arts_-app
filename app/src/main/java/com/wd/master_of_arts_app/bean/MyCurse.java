package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 11:11
 */
public class MyCurse {

    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"course_id":76,"course_time_id":213,"order_id":23,"icon":"http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg","title":"童童创想班A","time_detail":"每周一、二上课","teacher_id":2,"teacher_name":"谭老师","avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","unit_num":24},{"course_id":76,"course_time_id":213,"icon":"http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg","title":"童童创想班A","time_detail":"每周一、二上课","teacher_id":2,"teacher_name":"谭老师","avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png"},{"course_id":76,"course_time_id":213,"icon":"http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg","title":"童童创想班A","time_detail":"每周一、二上课","teacher_id":2,"teacher_name":"谭老师","avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png"},{"course_id":76,"course_time_id":213,"icon":"http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg","title":"童童创想班A","time_detail":"每周一、二上课","teacher_id":2,"teacher_name":"谭老师","avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * course_id : 76
             * course_time_id : 213
             * order_id : 23
             * icon : http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg
             * title : 童童创想班A
             * time_detail : 每周一、二上课
             * teacher_id : 2
             * teacher_name : 谭老师
             * avatar : http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png
             * unit_num : 24
             */

            private int course_id;
            private int course_time_id;
            private int order_id;
            private String icon;
            private String title;
            private String time_detail;
            private int teacher_id;
            private String teacher_name;
            private String avatar;
            private int unit_num;

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

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime_detail() {
                return time_detail;
            }

            public void setTime_detail(String time_detail) {
                this.time_detail = time_detail;
            }

            public int getTeacher_id() {
                return teacher_id;
            }

            public void setTeacher_id(int teacher_id) {
                this.teacher_id = teacher_id;
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

            public int getUnit_num() {
                return unit_num;
            }

            public void setUnit_num(int unit_num) {
                this.unit_num = unit_num;
            }
        }
    }
}
