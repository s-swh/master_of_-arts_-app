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
     * data : {"workMsg":{"work_id":119,"name":"古代古城","imglist":"[\"/20210118/6004e8b6cdf7b3446.jpg\",\"/20210118/6004e8b9c69bd2683.jpg\"]","content":"发神经个可根据轨道交通时间发生过的健身房健身房给大家都根据特困地图订房间供电局的感觉","voice":"[\"/20210117/600438312cc6c3562.amr\"]","create_time":"2021-01-18 09:47:44","is_comment":"Y","c_content":"你是谁呢。你们要","c_imglist":"[\"work//20210118/6004e8fd1fcb99526.png\",\"work//20210118/6004e900eb6702059.png\",\"work//20210118/6004e904c1d3b3060.png\"]","c_voice":"[\"work//20210118/6004e8f8269ae1981.wav\"]","comment_time":"2021-01-18 09:48:53","t_name":"谭老师","t_avatar":"http://qiniu.54artist.com/5ff7c56b8f40e6896.jpg"}}
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
         * workMsg : {"work_id":119,"name":"古代古城","imglist":"[\"/20210118/6004e8b6cdf7b3446.jpg\",\"/20210118/6004e8b9c69bd2683.jpg\"]","content":"发神经个可根据轨道交通时间发生过的健身房健身房给大家都根据特困地图订房间供电局的感觉","voice":"[\"/20210117/600438312cc6c3562.amr\"]","create_time":"2021-01-18 09:47:44","is_comment":"Y","c_content":"你是谁呢。你们要","c_imglist":"[\"work//20210118/6004e8fd1fcb99526.png\",\"work//20210118/6004e900eb6702059.png\",\"work//20210118/6004e904c1d3b3060.png\"]","c_voice":"[\"work//20210118/6004e8f8269ae1981.wav\"]","comment_time":"2021-01-18 09:48:53","t_name":"谭老师","t_avatar":"http://qiniu.54artist.com/5ff7c56b8f40e6896.jpg"}
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
             * work_id : 119
             * name : 古代古城
             * imglist : ["/20210118/6004e8b6cdf7b3446.jpg","/20210118/6004e8b9c69bd2683.jpg"]
             * content : 发神经个可根据轨道交通时间发生过的健身房健身房给大家都根据特困地图订房间供电局的感觉
             * voice : ["/20210117/600438312cc6c3562.amr"]
             * create_time : 2021-01-18 09:47:44
             * is_comment : Y
             * c_content : 你是谁呢。你们要
             * c_imglist : ["work//20210118/6004e8fd1fcb99526.png","work//20210118/6004e900eb6702059.png","work//20210118/6004e904c1d3b3060.png"]
             * c_voice : ["work//20210118/6004e8f8269ae1981.wav"]
             * comment_time : 2021-01-18 09:48:53
             * t_name : 谭老师
             * t_avatar : http://qiniu.54artist.com/5ff7c56b8f40e6896.jpg
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
