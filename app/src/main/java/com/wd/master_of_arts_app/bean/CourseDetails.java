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
     * data : {"course_id":76,"course_name":"童童创想班A","icon":"http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg","age":"7-9：童童创想班","is_send":"Y","content":"<p>测试<\/p>","old_price":"5800","price":"5000.00","mark":[{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}],"service":[{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}],"teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","first_class_time":"13:30:00","first_class_date":"2021-01-01","is_begin":"N","course_sale_count":1,"class_sale_count":0,"comment_list":[{"id":10,"order_id":8,"course_id":76,"user_id":32,"score":5,"content":"很棒的课程","comment_time":"2020-11-11 13:58:09","user_avatar":"user/avatar/20201105/fc87cb9fb9d12c633b8f0412ee1c68b7.JPG","user_nickname":"小孩"},{"id":9,"order_id":24,"course_id":76,"user_id":28,"score":5,"content":"给个电话","comment_time":"2020-11-10 14:07:40","user_avatar":"user/avatar/20201013/d3c16419cd461cdeb81c01a1570c5598.jpg","user_nickname":"小学生"}]}
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
         * course_id : 76
         * course_name : 童童创想班A
         * icon : http://test.54artist.com/public/upload/course/20201218/b4087ba74135c2944a3e1e9f74ddd4f9.jpg
         * age : 7-9：童童创想班
         * is_send : Y
         * content : <p>测试</p>
         * old_price : 5800
         * price : 5000.00
         * mark : [{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}]
         * service : [{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}]
         * teacher_name : 孙老师
         * teacher_avatar : http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png
         * time_detail : 每周一、二上课
         * first_class_time : 13:30:00
         * first_class_date : 2021-01-01
         * is_begin : N
         * course_sale_count : 1
         * class_sale_count : 0
         * comment_list : [{"id":10,"order_id":8,"course_id":76,"user_id":32,"score":5,"content":"很棒的课程","comment_time":"2020-11-11 13:58:09","user_avatar":"user/avatar/20201105/fc87cb9fb9d12c633b8f0412ee1c68b7.JPG","user_nickname":"小孩"},{"id":9,"order_id":24,"course_id":76,"user_id":28,"score":5,"content":"给个电话","comment_time":"2020-11-10 14:07:40","user_avatar":"user/avatar/20201013/d3c16419cd461cdeb81c01a1570c5598.jpg","user_nickname":"小学生"}]
         */

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
        private String first_class_time;
        private String first_class_date;
        private String is_begin;
        private int course_sale_count;
        private int class_sale_count;
        private List<MarkBean> mark;
        private List<ServiceBean> service;
        private List<CommentListBean> comment_list;

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
             * icon : course/mark/20200919/6c477e3558925941c7313942ac9f5507.png
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
             * icon : course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png
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
             * id : 10
             * order_id : 8
             * course_id : 76
             * user_id : 32
             * score : 5
             * content : 很棒的课程
             * comment_time : 2020-11-11 13:58:09
             * user_avatar : user/avatar/20201105/fc87cb9fb9d12c633b8f0412ee1c68b7.JPG
             * user_nickname : 小孩
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
