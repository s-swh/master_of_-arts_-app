package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 14:26
 */
public class CommBean {
    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"article_id":11,"cat_id":4,"title":"【免费】旋转木马","author":"","keywords":"","description":"","content":"<p><img src=\"/public/upload/ueditor/image/20201228/1609155558512881.jpg\" title=\"1609155558512881.jpg\" alt=\"758bb95152f2c5083bcc7e2a27814e43.jpg\"/><\/p>","pubtime":"2020-12-31 13:46:13","img":"http://qiniu.54artist.com/5fed65a5d13a03112.jpg","bigimg":"","file":"","clicknum":106,"href":"http://qiniu.54artist.com/xzmm.mp4","imglist":["/public/upload/ueditor/image/20201228/1609155558512881.jpg"]},{"article_id":10,"cat_id":4,"title":"【免费】小草莓成熟了","author":"","keywords":"","description":"","content":null,"pubtime":"2020-12-31 13:47:06","img":"http://qiniu.54artist.com/5fed65daa90fc5522.jpg","bigimg":"","file":"","clicknum":55,"href":"http://qiniu.54artist.com/xcm.mp4","imglist":[]},{"article_id":13,"cat_id":4,"title":"【免费】会生气的河豚","author":"","keywords":"","description":"","content":null,"pubtime":"2020-12-31 13:47:32","img":"http://qiniu.54artist.com/5fed65f4bb5a65630.jpg","bigimg":"","file":"","clicknum":43,"href":"http://qiniu.54artist.com/hsqdht.mp4","imglist":[]},{"article_id":25,"cat_id":4,"title":"【免费课程】胡桃夹子","author":"","keywords":"","description":"","content":null,"pubtime":"2020-12-31 13:47:45","img":"http://qiniu.54artist.com/5fed66016a3cd4665.jpg","bigimg":"","file":"","clicknum":6,"href":"http://qiniu.54artist.com/htjz.mp4","imglist":[]},{"article_id":12,"cat_id":4,"title":"【免费】切开的水果蔬菜","author":"","keywords":"","description":"","content":null,"pubtime":"2020-12-31 13:47:57","img":"http://qiniu.54artist.com/5fed660dc60185390.jpg","bigimg":"","file":"","clicknum":31,"href":"http://qiniu.54artist.com/sgsc.mp4","imglist":[]}]}
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
             * article_id : 11
             * cat_id : 4
             * title : 【免费】旋转木马
             * author :
             * keywords :
             * description :
             * content : <p><img src="/public/upload/ueditor/image/20201228/1609155558512881.jpg" title="1609155558512881.jpg" alt="758bb95152f2c5083bcc7e2a27814e43.jpg"/></p>
             * pubtime : 2020-12-31 13:46:13
             * img : http://qiniu.54artist.com/5fed65a5d13a03112.jpg
             * bigimg :
             * file :
             * clicknum : 106
             * href : http://qiniu.54artist.com/xzmm.mp4
             * imglist : ["/public/upload/ueditor/image/20201228/1609155558512881.jpg"]
             */

            private int article_id;
            private int cat_id;
            private String title;
            private String author;
            private String keywords;
            private String description;
            private String content;
            private String pubtime;
            private String img;
            private String bigimg;
            private String file;
            private int clicknum;
            private String href;
            private List<String> imglist;

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

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getPubtime() {
                return pubtime;
            }

            public void setPubtime(String pubtime) {
                this.pubtime = pubtime;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getBigimg() {
                return bigimg;
            }

            public void setBigimg(String bigimg) {
                this.bigimg = bigimg;
            }

            public String getFile() {
                return file;
            }

            public void setFile(String file) {
                this.file = file;
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

            public List<String> getImglist() {
                return imglist;
            }

            public void setImglist(List<String> imglist) {
                this.imglist = imglist;
            }
        }
    }
}
