package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 14:34
 */
public class SampleReels {
    /**
     * code : 1
     * msg : 成功
     * data : {"course_name":"童童创想班A","list":[{"imglist":"work/5fe45a82b5ad89607.png","name":"wrwrer","comment_time":"2021-01-10 14:32:46"},{"imglist":null,"name":"问问","comment_time":"2021-01-10 14:32:24"},{"imglist":"work/5fe45a82b5ad89607.png","name":"喂喂喂","comment_time":"2021-01-10 14:32:10"},{"imglist":null,"name":"454564","comment_time":"2021-01-10 14:31:58"},{"imglist":null,"name":"到我的","comment_time":"0000-00-00 00:00:00"}]}
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
         * course_name : 童童创想班A
         * list : [{"imglist":"work/5fe45a82b5ad89607.png","name":"wrwrer","comment_time":"2021-01-10 14:32:46"},{"imglist":null,"name":"问问","comment_time":"2021-01-10 14:32:24"},{"imglist":"work/5fe45a82b5ad89607.png","name":"喂喂喂","comment_time":"2021-01-10 14:32:10"},{"imglist":null,"name":"454564","comment_time":"2021-01-10 14:31:58"},{"imglist":null,"name":"到我的","comment_time":"0000-00-00 00:00:00"}]
         */

        private String course_name;
        private List<ListBean> list;

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * imglist : work/5fe45a82b5ad89607.png
             * name : wrwrer
             * comment_time : 2021-01-10 14:32:46
             */

            private String imglist;
            private String name;
            private String comment_time;

            public String getImglist() {
                return imglist;
            }

            public void setImglist(String imglist) {
                this.imglist = imglist;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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
