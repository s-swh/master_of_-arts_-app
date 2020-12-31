package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/21 15:07
 */
public class ArticleList {


    /**
     * code : 1
     * msg : 成功
     * data : {"free_video":[{"article_id":11,"cat_id":4,"title":"【免费】旋转木马","img":"http://qiniu.54artist.com/5fed65a5d13a03112.jpg","clicknum":106,"href":"http://qiniu.54artist.com/xzmm.mp4","pubtime":"2020-12-31 13:46:13"},{"article_id":10,"cat_id":4,"title":"【免费】小草莓成熟了","img":"http://qiniu.54artist.com/5fed65daa90fc5522.jpg","clicknum":55,"href":"http://qiniu.54artist.com/xcm.mp4","pubtime":"2020-12-31 13:47:06"},{"article_id":13,"cat_id":4,"title":"【免费】会生气的河豚","img":"http://qiniu.54artist.com/5fed65f4bb5a65630.jpg","clicknum":43,"href":"http://qiniu.54artist.com/hsqdht.mp4","pubtime":"2020-12-31 13:47:32"},{"article_id":12,"cat_id":4,"title":"【免费】切开的水果蔬菜","img":"http://qiniu.54artist.com/5fed660dc60185390.jpg","clicknum":31,"href":"http://qiniu.54artist.com/sgsc.mp4","pubtime":"2020-12-31 13:47:57"}],"selected_works":[{"article_id":7,"cat_id":3,"title":"甜甜石榴","img":"http://qiniu.54artist.com/5fed3903ad6c62003.PNG","clicknum":39,"href":"","pubtime":"2020-12-31 10:35:48"},{"article_id":8,"cat_id":3,"title":"时间的速度","img":"http://qiniu.54artist.com/5fed391aac6f37223.PNG","clicknum":35,"href":"","pubtime":"2020-12-31 10:36:21"},{"article_id":27,"cat_id":3,"title":"秋葵","img":"http://qiniu.54artist.com/5fed394dd62174677.PNG","clicknum":4,"href":"","pubtime":"2020-12-31 10:37:07"},{"article_id":34,"cat_id":3,"title":"爱爬树的蜥蜴","img":"http://qiniu.54artist.com/5fed39858d10f4943.png","clicknum":0,"href":"","pubtime":"2020-12-31 10:37:57"}],"my_video":[{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/xcm.mp4","img":"http://qiniu.54artist.com/5fed6d692e4ca5533.jpg","title":"童童创想班A","clicknum":0,"article_id":29,"pubtime":"2020-12-31 14:19:21","cat_id":5},{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/hsqdht.mp4","img":"http://qiniu.54artist.com/5fed6d46ceda67208.jpg","title":"童童创想班A","clicknum":0,"article_id":30,"pubtime":"2020-12-31 14:18:57","cat_id":5},{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/htjz.mp4","img":"http://qiniu.54artist.com/5fed6d371a5295044.jpg","title":"童童创想班A","clicknum":0,"article_id":37,"pubtime":"2020-12-31 14:18:31","cat_id":5},{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/sgsc.mp4","img":"http://qiniu.54artist.com/5fed6d06c355c6447.jpg","title":"童童创想班A","clicknum":0,"article_id":38,"pubtime":"2020-12-31 14:17:42","cat_id":5}]}
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
        private List<FreeVideoBean> free_video;
        private List<SelectedWorksBean> selected_works;
        private List<MyVideoBean> my_video;

        public List<FreeVideoBean> getFree_video() {
            return free_video;
        }

        public void setFree_video(List<FreeVideoBean> free_video) {
            this.free_video = free_video;
        }

        public List<SelectedWorksBean> getSelected_works() {
            return selected_works;
        }

        public void setSelected_works(List<SelectedWorksBean> selected_works) {
            this.selected_works = selected_works;
        }

        public List<MyVideoBean> getMy_video() {
            return my_video;
        }

        public void setMy_video(List<MyVideoBean> my_video) {
            this.my_video = my_video;
        }

        public static class FreeVideoBean {
            /**
             * article_id : 11
             * cat_id : 4
             * title : 【免费】旋转木马
             * img : http://qiniu.54artist.com/5fed65a5d13a03112.jpg
             * clicknum : 106
             * href : http://qiniu.54artist.com/xzmm.mp4
             * pubtime : 2020-12-31 13:46:13
             */

            private int article_id;
            private int cat_id;
            private String title;
            private String img;
            private int clicknum;
            private String href;
            private String pubtime;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getClicknum() {
                return clicknum;
            }

            public void setClicknum(int clicknum) {
                this.clicknum = clicknum;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getPubtime() {
                return pubtime;
            }

            public void setPubtime(String pubtime) {
                this.pubtime = pubtime;
            }
        }

        public static class SelectedWorksBean {
            /**
             * article_id : 7
             * cat_id : 3
             * title : 甜甜石榴
             * img : http://qiniu.54artist.com/5fed3903ad6c62003.PNG
             * clicknum : 39
             * href :
             * pubtime : 2020-12-31 10:35:48
             */

            private int article_id;
            private int cat_id;
            private String title;
            private String img;
            private int clicknum;
            private String href;
            private String pubtime;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getClicknum() {
                return clicknum;
            }

            public void setClicknum(int clicknum) {
                this.clicknum = clicknum;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getPubtime() {
                return pubtime;
            }

            public void setPubtime(String pubtime) {
                this.pubtime = pubtime;
            }
        }

        public static class MyVideoBean {
            /**
             * course_name : 童童创想班A
             * href : http://qiniu.54artist.com/xcm.mp4
             * img : http://qiniu.54artist.com/5fed6d692e4ca5533.jpg
             * title : 童童创想班A
             * clicknum : 0
             * article_id : 29
             * pubtime : 2020-12-31 14:19:21
             * cat_id : 5
             */

            private String course_name;
            private String href;
            private String img;
            private String title;
            private int clicknum;
            private int article_id;
            private String pubtime;
            private int cat_id;

            public String getCourse_name() {
                return course_name;
            }

            public void setCourse_name(String course_name) {
                this.course_name = course_name;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getClicknum() {
                return clicknum;
            }

            public void setClicknum(int clicknum) {
                this.clicknum = clicknum;
            }

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getPubtime() {
                return pubtime;
            }

            public void setPubtime(String pubtime) {
                this.pubtime = pubtime;
            }

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }
        }
    }
}
