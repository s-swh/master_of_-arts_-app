package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 10:03
 */
public class DetailsOfWorksBean {


    /**
     * code : 1
     * msg : 成功
     * data : {"workMsg":{"work_id":44,"name":"富有风采","imglist":"5ff5269baba894471.jpg","content":"垫付学费预防","voice":"5ff5269b9da658737.amr","create_time":"2021-01-06 10:55:31","is_comment":"N","c_content":"","c_imglist":"","c_voice":"","comment_time":"","t_name":"","t_avatar":""}}
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
         * workMsg : {"work_id":44,"name":"富有风采","imglist":"5ff5269baba894471.jpg","content":"垫付学费预防","voice":"5ff5269b9da658737.amr","create_time":"2021-01-06 10:55:31","is_comment":"N","c_content":"","c_imglist":"","c_voice":"","comment_time":"","t_name":"","t_avatar":""}
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
             * work_id : 44
             * name : 富有风采
             * imglist : 5ff5269baba894471.jpg
             * content : 垫付学费预防
             * voice : 5ff5269b9da658737.amr
             * create_time : 2021-01-06 10:55:31
             * is_comment : N
             * c_content :
             * c_imglist :
             * c_voice :
             * comment_time :
             * t_name :
             * t_avatar :
             */

            private int work_id;
            private String name;
            private String imglist;
            private String content;
            private String voice;
            private String create_time;
            private String is_comment;
            private String c_content;
            private String c_imglist;
            private String c_voice;
            private String comment_time;
            private String t_name;
            private String t_avatar;

            public int getWork_id() {
                return work_id;
            }

            public void setWork_id(int work_id) {
                this.work_id = work_id;
            }

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getVoice() {
                return voice;
            }

            public void setVoice(String voice) {
                this.voice = voice;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getIs_comment() {
                return is_comment;
            }

            public void setIs_comment(String is_comment) {
                this.is_comment = is_comment;
            }

            public String getC_content() {
                return c_content;
            }

            public void setC_content(String c_content) {
                this.c_content = c_content;
            }

            public String getC_imglist() {
                return c_imglist;
            }

            public void setC_imglist(String c_imglist) {
                this.c_imglist = c_imglist;
            }

            public String getC_voice() {
                return c_voice;
            }

            public void setC_voice(String c_voice) {
                this.c_voice = c_voice;
            }

            public String getComment_time() {
                return comment_time;
            }

            public void setComment_time(String comment_time) {
                this.comment_time = comment_time;
            }

            public String getT_name() {
                return t_name;
            }

            public void setT_name(String t_name) {
                this.t_name = t_name;
            }

            public String getT_avatar() {
                return t_avatar;
            }

            public void setT_avatar(String t_avatar) {
                this.t_avatar = t_avatar;
            }
        }
    }
}
