package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/4 17:07
 */
public class ArticleDetails {
    /**
     * code : 1
     * msg : 成功
     * data : {"articleMsg":{"article_id":25,"cat_id":4,"title":"【免费课程】胡桃夹子","title_font_color":"","author":"","keywords":"","description":"","content":"","is_show":"Y","is_top":"N","img":"article/20201110/6bd1c2b7517b992d8b5fec8fb57f9893.jpg","bigimg":"","file":"","sort":0,"clicknum":5,"href":"http://qiniu.54artist.com/htjz.mp4","pubtime":"2020-11-10 23:12:52","imglist":[]}}
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
         * articleMsg : {"article_id":25,"cat_id":4,"title":"【免费课程】胡桃夹子","title_font_color":"","author":"","keywords":"","description":"","content":"","is_show":"Y","is_top":"N","img":"article/20201110/6bd1c2b7517b992d8b5fec8fb57f9893.jpg","bigimg":"","file":"","sort":0,"clicknum":5,"href":"http://qiniu.54artist.com/htjz.mp4","pubtime":"2020-11-10 23:12:52","imglist":[]}
         */

        private ArticleMsgBean articleMsg;

        public ArticleMsgBean getArticleMsg() {
            return articleMsg;
        }

        public void setArticleMsg(ArticleMsgBean articleMsg) {
            this.articleMsg = articleMsg;
        }

        public static class ArticleMsgBean {
            /**
             * article_id : 25
             * cat_id : 4
             * title : 【免费课程】胡桃夹子
             * title_font_color :
             * author :
             * keywords :
             * description :
             * content :
             * is_show : Y
             * is_top : N
             * img : article/20201110/6bd1c2b7517b992d8b5fec8fb57f9893.jpg
             * bigimg :
             * file :
             * sort : 0
             * clicknum : 5
             * href : http://qiniu.54artist.com/htjz.mp4
             * pubtime : 2020-11-10 23:12:52
             * imglist : []
             */

            private int article_id;
            private int cat_id;
            private String title;
            private String title_font_color;
            private String author;
            private String keywords;
            private String description;
            private String content;
            private String is_show;
            private String is_top;
            private String img;
            private String bigimg;
            private String file;
            private int sort;
            private int clicknum;
            private String href;
            private String pubtime;
            private List<?> imglist;

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

            public String getTitle_font_color() {
                return title_font_color;
            }

            public void setTitle_font_color(String title_font_color) {
                this.title_font_color = title_font_color;
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

            public String getIs_show() {
                return is_show;
            }

            public void setIs_show(String is_show) {
                this.is_show = is_show;
            }

            public String getIs_top() {
                return is_top;
            }

            public void setIs_top(String is_top) {
                this.is_top = is_top;
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

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
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

            public List<?> getImglist() {
                return imglist;
            }

            public void setImglist(List<?> imglist) {
                this.imglist = imglist;
            }
        }
    }
}
