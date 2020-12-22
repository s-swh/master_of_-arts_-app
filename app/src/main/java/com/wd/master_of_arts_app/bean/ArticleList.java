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
     * data : {"free_video":[{"article_id":11,"cat_id":4,"title":"【免费】旋转木马","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":null,"is_show":"Y","is_top":"Y","img":"article/20201110/6a43ae682252f3dad85a93a369ac7088.jpg","bigimg":"","file":"","sort":6,"clicknum":106,"href":"http://qiniu.54artist.com/xzmm.mp4","pubtime":"2020-11-10 23:19:51"},{"article_id":10,"cat_id":4,"title":"【免费】小草莓成熟了","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":null,"is_show":"Y","is_top":"N","img":"article/20201110/99ba345b8aac48eb2a2497a07a969fbb.jpg","bigimg":"","file":"","sort":3,"clicknum":55,"href":"http://qiniu.54artist.com/xcm.mp4","pubtime":"2020-11-10 23:10:21"},{"article_id":13,"cat_id":4,"title":"【免费】会生气的河豚","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":"","is_show":"Y","is_top":"N","img":"article/20201110/4f935d2dd1ee14e041d75fa7cc621356.jpg","bigimg":"","file":"","sort":2,"clicknum":43,"href":"http://qiniu.54artist.com/hsqdht.mp4","pubtime":"2020-11-10 23:12:11"},{"article_id":12,"cat_id":4,"title":"【免费】切开的水果蔬菜","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":null,"is_show":"Y","is_top":"N","img":"article/20201110/0b9b4a333e4d9fb08d16a4bbd8608219.jpg","bigimg":"","file":"","sort":0,"clicknum":31,"href":"http://qiniu.54artist.com/sgsc.mp4","pubtime":"2020-11-10 23:15:28"}],"selected_works":[{"article_id":7,"cat_id":3,"title":"甜甜石榴","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":"<p><img src=\"/public/upload/ueditor/image/20201110/1605021771301921.jpeg\" title=\"1605021771301921.jpeg\" alt=\"6甜甜石榴.jpeg\"/><\/p>","is_show":"Y","is_top":"N","img":"article/20201110/f32b9dbbc30d74591edf1c1bebcc40a5.jpeg","bigimg":"","file":"","sort":0,"clicknum":39,"href":"","pubtime":"2020-11-10 23:39:23"},{"article_id":8,"cat_id":3,"title":"时间的速度","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":"<p><img src=\"/public/upload/ueditor/image/20201110/1605021744927671.jpg\" title=\"1605021744927671.jpg\" alt=\"19时间的速度.jpg\"/><\/p>","is_show":"Y","is_top":"N","img":"article/20201110/db094c56d7092d3107b5ecef5b832b3e.jpg","bigimg":"","file":"","sort":0,"clicknum":35,"href":"","pubtime":"2020-11-10 23:39:11"},{"article_id":9,"cat_id":3,"title":"魔幻街景","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":"<p><img src=\"/public/upload/ueditor/image/20201110/1605021642349731.jpg\" title=\"1605021642349731.jpg\" alt=\"16魔幻街景.jpg\"/><\/p>","is_show":"Y","is_top":"N","img":"article/20201110/c95d450831c19fac6f2a780d503d8b7e.jpg","bigimg":"","file":"","sort":0,"clicknum":65,"href":"","pubtime":"2020-11-10 23:38:53"},{"article_id":26,"cat_id":3,"title":"动物证件照","course_id":null,"title_font_color":"","author":"","keywords":"","description":"","content":"<p><img src=\"/public/upload/ueditor/image/20201110/1605021700474063.jpg\" title=\"1605021700474063.jpg\" alt=\"7动物证件照.jpg\"/><\/p>","is_show":"Y","is_top":"N","img":"article/20201110/cf0b50611f1174cd71db15caf2cac406.jpg","bigimg":"","file":"","sort":0,"clicknum":12,"href":"","pubtime":"2020-11-10 23:21:46"}],"my_video":[]}
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
        private List<?> my_video;

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

        public List<?> getMy_video() {
            return my_video;
        }

        public void setMy_video(List<?> my_video) {
            this.my_video = my_video;
        }

        public static class FreeVideoBean {
            /**
             * article_id : 11
             * cat_id : 4
             * title : 【免费】旋转木马
             * course_id : null
             * title_font_color :
             * author :
             * keywords :
             * description :
             * content : null
             * is_show : Y
             * is_top : Y
             * img : article/20201110/6a43ae682252f3dad85a93a369ac7088.jpg
             * bigimg :
             * file :
             * sort : 6
             * clicknum : 106
             * href : http://qiniu.54artist.com/xzmm.mp4
             * pubtime : 2020-11-10 23:19:51
             */

            private int article_id;
            private int cat_id;
            private String title;
            private Object course_id;
            private String title_font_color;
            private String author;
            private String keywords;
            private String description;
            private Object content;
            private String is_show;
            private String is_top;
            private String img;
            private String bigimg;
            private String file;
            private int sort;
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

            public Object getCourse_id() {
                return course_id;
            }

            public void setCourse_id(Object course_id) {
                this.course_id = course_id;
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

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
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
        }

        public static class SelectedWorksBean {
            /**
             * article_id : 7
             * cat_id : 3
             * title : 甜甜石榴
             * course_id : null
             * title_font_color :
             * author :
             * keywords :
             * description :
             * content : <p><img src="/public/upload/ueditor/image/20201110/1605021771301921.jpeg" title="1605021771301921.jpeg" alt="6甜甜石榴.jpeg"/></p>
             * is_show : Y
             * is_top : N
             * img : article/20201110/f32b9dbbc30d74591edf1c1bebcc40a5.jpeg
             * bigimg :
             * file :
             * sort : 0
             * clicknum : 39
             * href :
             * pubtime : 2020-11-10 23:39:23
             */

            private int article_id;
            private int cat_id;
            private String title;
            private Object course_id;
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

            public Object getCourse_id() {
                return course_id;
            }

            public void setCourse_id(Object course_id) {
                this.course_id = course_id;
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
        }
    }
}
