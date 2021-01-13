package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/12 17:57
 */
public class BannerPage {
    /**
     * code : 1
     * msg : 成功
     * data : {"bannerMsg":{"id":20,"img":"http://qiniu.54artist.com/5ffd5d16e43ac3937.jpg","cat_id":2,"title":"测试","content":"<p>测试一下 111<img src=\"/public/upload/ueditor_temp/image/20210112/1610440606530392.png\" title=\"1610440606530392.png\" alt=\"default_avatar.png\"/><\/p>","detail_img":"","sort":14,"is_show":"Y","create_time":"2021-01-12 16:36:47","type":"","type_value":"","href":"","color":""}}
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
         * bannerMsg : {"id":20,"img":"http://qiniu.54artist.com/5ffd5d16e43ac3937.jpg","cat_id":2,"title":"测试","content":"<p>测试一下 111<img src=\"/public/upload/ueditor_temp/image/20210112/1610440606530392.png\" title=\"1610440606530392.png\" alt=\"default_avatar.png\"/><\/p>","detail_img":"","sort":14,"is_show":"Y","create_time":"2021-01-12 16:36:47","type":"","type_value":"","href":"","color":""}
         */

        private BannerMsgBean bannerMsg;

        public BannerMsgBean getBannerMsg() {
            return bannerMsg;
        }

        public void setBannerMsg(BannerMsgBean bannerMsg) {
            this.bannerMsg = bannerMsg;
        }

        public static class BannerMsgBean {
            /**
             * id : 20
             * img : http://qiniu.54artist.com/5ffd5d16e43ac3937.jpg
             * cat_id : 2
             * title : 测试
             * content : <p>测试一下 111<img src="/public/upload/ueditor_temp/image/20210112/1610440606530392.png" title="1610440606530392.png" alt="default_avatar.png"/></p>
             * detail_img :
             * sort : 14
             * is_show : Y
             * create_time : 2021-01-12 16:36:47
             * type :
             * type_value :
             * href :
             * color :
             */

            private int id;
            private String img;
            private int cat_id;
            private String title;
            private String content;
            private String detail_img;
            private int sort;
            private String is_show;
            private String create_time;
            private String type;
            private String type_value;
            private String href;
            private String color;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDetail_img() {
                return detail_img;
            }

            public void setDetail_img(String detail_img) {
                this.detail_img = detail_img;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getIs_show() {
                return is_show;
            }

            public void setIs_show(String is_show) {
                this.is_show = is_show;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType_value() {
                return type_value;
            }

            public void setType_value(String type_value) {
                this.type_value = type_value;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }
        }
    }
}
