package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/25 13:41
 */
public class ListOfWorks {
    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"work_id":10,"user_id":53,"unit_id":0,"name":"测试","imglist":"['5fdb18cfc54512291.png']","content":null,"voice":null,"create_time":"2020-12-24 14:54:58","is_comment":"N"},{"work_id":9,"user_id":53,"unit_id":0,"name":"测试","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png']","content":null,"voice":null,"create_time":"2020-12-24 14:54:45","is_comment":"N"},{"work_id":8,"user_id":53,"unit_id":0,"name":"测试","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']","content":null,"voice":null,"create_time":"2020-12-24 14:54:30","is_comment":"N"},{"work_id":7,"user_id":53,"unit_id":0,"name":"测试","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']","content":null,"voice":null,"create_time":"2020-12-24 14:54:27","is_comment":"N"},{"work_id":6,"user_id":53,"unit_id":0,"name":"测试","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']","content":null,"voice":null,"create_time":"2020-12-24 14:54:23","is_comment":"N"},{"work_id":5,"user_id":53,"unit_id":0,"name":"测试","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']","content":null,"voice":null,"create_time":"2020-12-24 14:54:18","is_comment":"N"},{"work_id":4,"user_id":53,"unit_id":0,"name":"我的作品","imglist":"['5fdb18cfc54512291.png','5fdb18d55c4854290.png','5fdb18dad012b2906.png']","content":"内容","voice":"['5fdb18dccf57d7522.wav','5fdb18e04fc5f7562.wav']","create_time":"2020-12-23 18:33:48","is_comment":"N"},{"work_id":1,"user_id":53,"unit_id":0,"name":"作品名字","imglist":"[\"work/1605175422427.png\", \"work/1605175423480.png\"]","content":null,"voice":null,"create_time":"2020-12-16 16:02:12","is_comment":"N"}]}
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
             * work_id : 10
             * user_id : 53
             * unit_id : 0
             * name : 测试
             * imglist : ['5fdb18cfc54512291.png']
             * content : null
             * voice : null
             * create_time : 2020-12-24 14:54:58
             * is_comment : N
             */

            private int work_id;
            private int user_id;
            private int unit_id;
            private String name;
            private String imglist;
            private String content;
            private String voice;
            private String create_time;
            private String is_comment;

            public int getWork_id() {
                return work_id;
            }

            public void setWork_id(int work_id) {
                this.work_id = work_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getUnit_id() {
                return unit_id;
            }

            public void setUnit_id(int unit_id) {
                this.unit_id = unit_id;
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
        }
    }
}
