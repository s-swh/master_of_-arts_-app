package com.wd.master_of_arts_app.bean;

public   class CommentListBean {
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