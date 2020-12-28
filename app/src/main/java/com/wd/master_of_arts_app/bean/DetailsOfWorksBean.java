package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 10:03
 */
public class DetailsOfWorksBean {

    /**
     * code : 1
     * msg : 成功
     * data : {"workMsg":[{"work_id":4,"name":"我的作品","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']","content":"内容","voice":"['5fdb18dccf57d7522.wav','5fdb18e04fc5f7562.wav']","create_time":"2020-12-23 18:33:48","is_comment":"N","c_content":null,"c_imglist":null,"c_voice":null,"comment_time":null,"t_name":null,"t_avatar":null}]}
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
        private List<WorkMsgBean> workMsg;

        public List<WorkMsgBean> getWorkMsg() {
            return workMsg;
        }

        public void setWorkMsg(List<WorkMsgBean> workMsg) {
            this.workMsg = workMsg;
        }

        public static class WorkMsgBean {
            /**
             * work_id : 4
             * name : 我的作品
             * imglist : ['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']
             * content : 内容
             * voice : ['5fdb18dccf57d7522.wav','5fdb18e04fc5f7562.wav']
             * create_time : 2020-12-23 18:33:48
             * is_comment : N
             * c_content : null
             * c_imglist : null
             * c_voice : null
             * comment_time : null
             * t_name : null
             * t_avatar : null
             */

            private int work_id;
            private String name;
            private String imglist;
            private String content;
            private String voice;
            private String create_time;
            private String is_comment;
            private Object c_content;
            private Object c_imglist;
            private Object c_voice;
            private Object comment_time;
            private Object t_name;
            private Object t_avatar;

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

            public Object getC_content() {
                return c_content;
            }

            public void setC_content(Object c_content) {
                this.c_content = c_content;
            }

            public Object getC_imglist() {
                return c_imglist;
            }

            public void setC_imglist(Object c_imglist) {
                this.c_imglist = c_imglist;
            }

            public Object getC_voice() {
                return c_voice;
            }

            public void setC_voice(Object c_voice) {
                this.c_voice = c_voice;
            }

            public Object getComment_time() {
                return comment_time;
            }

            public void setComment_time(Object comment_time) {
                this.comment_time = comment_time;
            }

            public Object getT_name() {
                return t_name;
            }

            public void setT_name(Object t_name) {
                this.t_name = t_name;
            }

            public Object getT_avatar() {
                return t_avatar;
            }

            public void setT_avatar(Object t_avatar) {
                this.t_avatar = t_avatar;
            }
        }
    }
}
