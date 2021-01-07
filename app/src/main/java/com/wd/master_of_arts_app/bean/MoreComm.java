package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 8:56
 */
public class MoreComm {
    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"id":12,"order_id":23,"course_id":76,"user_id":54,"score":5,"content":"好","comment_time":"2020-12-29 17:22:02","user_avatar":"http://test.54artist.com/public/upload/user/avatar/20210106/357ff633e7ede44e052886553493291c.jpg","user_nickname":"西柚过具体咸骨粥饭"},{"id":11,"order_id":5,"course_id":76,"user_id":53,"score":5,"content":"好评啊 你好","comment_time":"2020-12-28 10:40:15","user_avatar":"http://test.54artist.com/public/upload/user/avatar/20201222/2e29e417792ff910d01f8c54a737d4eb.jpg","user_nickname":"小明哥"},{"id":10,"order_id":8,"course_id":76,"user_id":32,"score":5,"content":"很棒的课程","comment_time":"2020-11-11 13:58:09","user_avatar":"user/avatar/20201105/fc87cb9fb9d12c633b8f0412ee1c68b7.JPG","user_nickname":"小孩"},{"id":9,"order_id":24,"course_id":76,"user_id":28,"score":5,"content":"给个电话","comment_time":"2020-11-10 14:07:40","user_avatar":"user/avatar/20201013/d3c16419cd461cdeb81c01a1570c5598.jpg","user_nickname":"小学生"},{"id":8,"order_id":16,"course_id":76,"user_id":35,"score":5,"content":"好","comment_time":"2020-11-10 11:04:11","user_avatar":"user/avatar/20201103/a25a9dc2eec85ad40c9d9edbf6a41e3b.JPG","user_nickname":"王小武"}]}
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
             * id : 12
             * order_id : 23
             * course_id : 76
             * user_id : 54
             * score : 5
             * content : 好
             * comment_time : 2020-12-29 17:22:02
             * user_avatar : http://test.54artist.com/public/upload/user/avatar/20210106/357ff633e7ede44e052886553493291c.jpg
             * user_nickname : 西柚过具体咸骨粥饭
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
