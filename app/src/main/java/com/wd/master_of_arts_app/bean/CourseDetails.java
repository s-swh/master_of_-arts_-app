package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/21 14:07
 */
public class CourseDetails {


    /**
     * code : 1
     * msg : 成功
     * data : {"course_time_id":248,"course_id":69,"course_name":"青苗大师班","icon":"http://qiniu.54artist.com/5fed74375c46a3453.jpeg","age":"9-11：青苗大师班","is_send":"Y","content":"<p><img src=\"http://test.54artist.com/public/upload/ueditor/image/20210105/1609830178828039.jpg\" title=\"1609830178828039.jpg\" alt=\"青苗课程详情.jpg\"/><\/p>","old_price":"0.01","price":"0.01","mark":[{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}],"service":[{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}],"teacher_name":"殷老师","teacher_avatar":"http://qiniu.54artist.com/5ff7c55361d5a7625.jpg","time_detail":"每周二，周三，周四，周五，周六10:00上课","job_num":"YDJTL003","is_tag":"Y","unit_count":48,"first_class_time":"10:00:00","first_class_date":"2021-01-19","is_begin":"Y","course_sale_count":3,"class_sale_count":0,"comment_list":[{"id":18,"order_id":312,"course_id":69,"user_id":51,"score":5,"content":"飞红袖添香吐谷浑风格","comment_time":"2021-01-14 20:46:12","user_avatar":"http://test.54artist.com/public/upload/user/avatar/20210115/2e5e5401e0b9b6d73443ac7e40df40c8.jpg","user_nickname":" 这首歌"},{"id":15,"order_id":312,"course_id":69,"user_id":51,"score":5,"content":"大概凤凰图腾","comment_time":"2021-01-14 17:38:05","user_avatar":"http://test.54artist.com/public/upload/user/avatar/20210115/2e5e5401e0b9b6d73443ac7e40df40c8.jpg","user_nickname":" 这首歌"}]}
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
         * course_time_id : 248
         * course_id : 69
         * course_name : 青苗大师班
         * icon : http://qiniu.54artist.com/5fed74375c46a3453.jpeg
         * age : 9-11：青苗大师班
         * is_send : Y
         * content : <p><img src="http://test.54artist.com/public/upload/ueditor/image/20210105/1609830178828039.jpg" title="1609830178828039.jpg" alt="青苗课程详情.jpg"/></p>
         * old_price : 0.01
         * price : 0.01
         * mark : [{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}]
         * service : [{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}]
         * teacher_name : 殷老师
         * teacher_avatar : http://qiniu.54artist.com/5ff7c55361d5a7625.jpg
         * time_detail : 每周二，周三，周四，周五，周六10:00上课
         * job_num : YDJTL003
         * is_tag : Y
         * unit_count : 48
         * first_class_time : 10:00:00
         * first_class_date : 2021-01-19
         * is_begin : Y
         * course_sale_count : 3
         * class_sale_count : 0
         * comment_list : [{"id":18,"order_id":312,"course_id":69,"user_id":51,"score":5,"content":"飞红袖添香吐谷浑风格","comment_time":"2021-01-14 20:46:12","user_avatar":"http://test.54artist.com/public/upload/user/avatar/20210115/2e5e5401e0b9b6d73443ac7e40df40c8.jpg","user_nickname":" 这首歌"},{"id":15,"order_id":312,"course_id":69,"user_id":51,"score":5,"content":"大概凤凰图腾","comment_time":"2021-01-14 17:38:05","user_avatar":"http://test.54artist.com/public/upload/user/avatar/20210115/2e5e5401e0b9b6d73443ac7e40df40c8.jpg","user_nickname":" 这首歌"}]
         */

        private int course_time_id;
        private int course_id;
        private String course_name;
        private String icon;
        private String age;
        private String is_send;
        private String content;
        private String old_price;
        private String price;
        private String teacher_name;
        private String teacher_avatar;
        private String time_detail;
        private String job_num;
        private String is_tag;
        private int unit_count;
        private String first_class_time;
        private String first_class_date;
        private String is_begin;
        private int course_sale_count;
        private int class_sale_count;
        private List<MarkBean> mark;
        private List<ServiceBean> service;
        private List<CommentListBean> comment_list;

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

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getIs_send() {
            return is_send;
        }

        public void setIs_send(String is_send) {
            this.is_send = is_send;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getOld_price() {
            return old_price;
        }

        public void setOld_price(String old_price) {
            this.old_price = old_price;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public String getTeacher_avatar() {
            return teacher_avatar;
        }

        public void setTeacher_avatar(String teacher_avatar) {
            this.teacher_avatar = teacher_avatar;
        }

        public String getTime_detail() {
            return time_detail;
        }

        public void setTime_detail(String time_detail) {
            this.time_detail = time_detail;
        }

        public String getJob_num() {
            return job_num;
        }

        public void setJob_num(String job_num) {
            this.job_num = job_num;
        }

        public String getIs_tag() {
            return is_tag;
        }

        public void setIs_tag(String is_tag) {
            this.is_tag = is_tag;
        }

        public int getUnit_count() {
            return unit_count;
        }

        public void setUnit_count(int unit_count) {
            this.unit_count = unit_count;
        }

        public String getFirst_class_time() {
            return first_class_time;
        }

        public void setFirst_class_time(String first_class_time) {
            this.first_class_time = first_class_time;
        }

        public String getFirst_class_date() {
            return first_class_date;
        }

        public void setFirst_class_date(String first_class_date) {
            this.first_class_date = first_class_date;
        }

        public String getIs_begin() {
            return is_begin;
        }

        public void setIs_begin(String is_begin) {
            this.is_begin = is_begin;
        }

        public int getCourse_sale_count() {
            return course_sale_count;
        }

        public void setCourse_sale_count(int course_sale_count) {
            this.course_sale_count = course_sale_count;
        }

        public int getClass_sale_count() {
            return class_sale_count;
        }

        public void setClass_sale_count(int class_sale_count) {
            this.class_sale_count = class_sale_count;
        }

        public List<MarkBean> getMark() {
            return mark;
        }

        public void setMark(List<MarkBean> mark) {
            this.mark = mark;
        }

        public List<ServiceBean> getService() {
            return service;
        }

        public void setService(List<ServiceBean> service) {
            this.service = service;
        }

        public List<CommentListBean> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<CommentListBean> comment_list) {
            this.comment_list = comment_list;
        }

        public static class MarkBean {
            /**
             * id : 2
             * mark : 配套学习资料
             * description : 根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄
             * icon : http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png
             */

            private int id;
            private String mark;
            private String description;
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class ServiceBean {
            /**
             * id : 1
             * service : 直播授课
             * description : 直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。
             * icon : http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png
             */

            private int id;
            private String service;
            private String description;
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getService() {
                return service;
            }

            public void setService(String service) {
                this.service = service;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class CommentListBean {
            /**
             * id : 18
             * order_id : 312
             * course_id : 69
             * user_id : 51
             * score : 5
             * content : 飞红袖添香吐谷浑风格
             * comment_time : 2021-01-14 20:46:12
             * user_avatar : http://test.54artist.com/public/upload/user/avatar/20210115/2e5e5401e0b9b6d73443ac7e40df40c8.jpg
             * user_nickname :  这首歌
             */

            private int id;
            private int order_id;
            private int course_id;
            private int user_id;
            private int score;
            private String content;
            private String comment_time;
            private String user_avatar;
            private String user_nickname;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getComment_time() {
                return comment_time;
            }

            public void setComment_time(String comment_time) {
                this.comment_time = comment_time;
            }

            public String getUser_avatar() {
                return user_avatar;
            }

            public void setUser_avatar(String user_avatar) {
                this.user_avatar = user_avatar;
            }

            public String getUser_nickname() {
                return user_nickname;
            }

            public void setUser_nickname(String user_nickname) {
                this.user_nickname = user_nickname;
            }
        }
    }
}
