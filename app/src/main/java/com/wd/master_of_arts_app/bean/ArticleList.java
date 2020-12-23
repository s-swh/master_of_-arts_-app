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
     * data : {"free_video":[{"article_id":11,"cat_id":4,"title":"【免费】旋转木马","img":"article/20201110/6a43ae682252f3dad85a93a369ac7088.jpg","clicknum":106,"href":"http://qiniu.54artist.com/xzmm.mp4","pubtime":"2020-11-10 23:19:51"},{"article_id":10,"cat_id":4,"title":"【免费】小草莓成熟了","img":"article/20201110/99ba345b8aac48eb2a2497a07a969fbb.jpg","clicknum":55,"href":"http://qiniu.54artist.com/xcm.mp4","pubtime":"2020-11-10 23:10:21"},{"article_id":13,"cat_id":4,"title":"【免费】会生气的河豚","img":"article/20201110/4f935d2dd1ee14e041d75fa7cc621356.jpg","clicknum":43,"href":"http://qiniu.54artist.com/hsqdht.mp4","pubtime":"2020-11-10 23:12:11"},{"article_id":12,"cat_id":4,"title":"【免费】切开的水果蔬菜","img":"article/20201110/0b9b4a333e4d9fb08d16a4bbd8608219.jpg","clicknum":31,"href":"http://qiniu.54artist.com/sgsc.mp4","pubtime":"2020-11-10 23:15:28"}],"selected_works":[{"article_id":7,"cat_id":3,"title":"甜甜石榴","img":"article/20201110/f32b9dbbc30d74591edf1c1bebcc40a5.jpeg","clicknum":39,"href":"","pubtime":"2020-11-10 23:39:23"},{"article_id":8,"cat_id":3,"title":"时间的速度","img":"article/20201110/db094c56d7092d3107b5ecef5b832b3e.jpg","clicknum":35,"href":"","pubtime":"2020-11-10 23:39:11"},{"article_id":9,"cat_id":3,"title":"魔幻街景","img":"article/20201110/c95d450831c19fac6f2a780d503d8b7e.jpg","clicknum":65,"href":"","pubtime":"2020-11-10 23:38:53"},{"article_id":26,"cat_id":3,"title":"动物证件照","img":"article/20201110/cf0b50611f1174cd71db15caf2cac406.jpg","clicknum":12,"href":"","pubtime":"2020-11-10 23:21:46"}],"my_video":[{"course_name":"童童创想班A","course_id":76,"video":[[{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/htjz.mp4","img":null,"title":"童童A课程测试","clicknum":0,"article_id":29,"pubtime":"0000-00-00 00:00:00","cat_id":5},{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/hsqdht.mp4","img":null,"title":"童童A课程测试2","clicknum":0,"article_id":30,"pubtime":"0000-00-00 00:00:00","cat_id":5}]]},{"course_name":"童童创想班B","course_id":79,"video":[[{"course_name":"童童创想班B","href":"http://qiniu.54artist.com/xcm.mp4","img":null,"title":"童童B课程","clicknum":0,"article_id":31,"pubtime":"0000-00-00 00:00:00","cat_id":5}]]}]}
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
             * img : article/20201110/6a43ae682252f3dad85a93a369ac7088.jpg
             * clicknum : 106
             * href : http://qiniu.54artist.com/xzmm.mp4
             * pubtime : 2020-11-10 23:19:51
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
             * img : article/20201110/f32b9dbbc30d74591edf1c1bebcc40a5.jpeg
             * clicknum : 39
             * href :
             * pubtime : 2020-11-10 23:39:23
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
             * course_id : 76
             * video : [[{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/htjz.mp4","img":null,"title":"童童A课程测试","clicknum":0,"article_id":29,"pubtime":"0000-00-00 00:00:00","cat_id":5},{"course_name":"童童创想班A","href":"http://qiniu.54artist.com/hsqdht.mp4","img":null,"title":"童童A课程测试2","clicknum":0,"article_id":30,"pubtime":"0000-00-00 00:00:00","cat_id":5}]]
             */

            private String course_name;
            private int course_id;
            private List<List<VideoBean>> video;

            public String getCourse_name() {
                return course_name;
            }

            public void setCourse_name(String course_name) {
                this.course_name = course_name;
            }

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
            }

            public List<List<VideoBean>> getVideo() {
                return video;
            }

            public void setVideo(List<List<VideoBean>> video) {
                this.video = video;
            }

            public static class VideoBean {
                /**
                 * course_name : 童童创想班A
                 * href : http://qiniu.54artist.com/htjz.mp4
                 * img : null
                 * title : 童童A课程测试
                 * clicknum : 0
                 * article_id : 29
                 * pubtime : 0000-00-00 00:00:00
                 * cat_id : 5
                 */

                private String course_name;
                private String href;
                private Object img;
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

                public Object getImg() {
                    return img;
                }

                public void setImg(Object img) {
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
}
