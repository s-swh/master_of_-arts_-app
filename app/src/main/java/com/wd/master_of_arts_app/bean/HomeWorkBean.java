package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/6 11:16
 */
public class HomeWorkBean {


    /**
     * code : 1
     * msg : 成功
     * data : {"workMsg":{"name":"DHA K咋","imglist":"5ff50a1c06f8d6235.jpg","voice":"5ff50a2f447447556.amr","content":"睡觉啊卡较好的哈哈哈","is_comment":"N","create_time":"2021-01-06 08:54:16","teacher_imglist":null,"teacher_voice":null,"teacher_content":null,"comment_time":null}}
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
         * workMsg : {"name":"DHA K咋","imglist":"5ff50a1c06f8d6235.jpg","voice":"5ff50a2f447447556.amr","content":"睡觉啊卡较好的哈哈哈","is_comment":"N","create_time":"2021-01-06 08:54:16","teacher_imglist":null,"teacher_voice":null,"teacher_content":null,"comment_time":null}
         */

        private WorkMsgBean workMsg;

        public WorkMsgBean getWorkMsg() {
            return workMsg;
        }

        public void setWorkMsg(WorkMsgBean workMsg) {
            this.workMsg = workMsg;
        }

        public static class WorkMsgBean {
            /**
             * name : DHA K咋
             * imglist : 5ff50a1c06f8d6235.jpg
             * voice : 5ff50a2f447447556.amr
             * content : 睡觉啊卡较好的哈哈哈
             * is_comment : N
             * create_time : 2021-01-06 08:54:16
             * teacher_imglist : null
             * teacher_voice : null
             * teacher_content : null
             * comment_time : null
             */

            private String name;
            private String imglist;
            private String voice;
            private String content;
            private String is_comment;
            private String create_time;
            private String teacher_imglist;
            private String teacher_voice;
            private String teacher_content;
            private String comment_time;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImglist() {
                return imglist;
            }

            public void setImglist(String imglist) {
                this.imglist = imglist;
            }

            public String getVoice() {
                return voice;
            }

            public void setVoice(String voice) {
                this.voice = voice;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getIs_comment() {
                return is_comment;
            }

            public void setIs_comment(String is_comment) {
                this.is_comment = is_comment;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getTeacher_imglist() {
                return teacher_imglist;
            }

            public void setTeacher_imglist(String teacher_imglist) {
                this.teacher_imglist = teacher_imglist;
            }

            public String getTeacher_voice() {
                return teacher_voice;
            }

            public void setTeacher_voice(String teacher_voice) {
                this.teacher_voice = teacher_voice;
            }

            public String getTeacher_content() {
                return teacher_content;
            }

            public void setTeacher_content(String teacher_content) {
                this.teacher_content = teacher_content;
            }

            public String getComment_time() {
                return comment_time;
            }

            public void setComment_time(String comment_time) {
                this.comment_time = comment_time;
            }
        }
    }
}
