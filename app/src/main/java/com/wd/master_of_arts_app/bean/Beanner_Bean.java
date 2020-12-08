package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 17:06
 */
public class Beanner_Bean {


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

        public static class ListBean   {
            /**
             * id : 13
             * cat_id : 2
             * title : 艺大家桃李
             * img : banner/20200814/a2c492104247e0e36d831fa13255d936.png
             * detail_img : banner/20201111/decc0816224a762e3a5fa03e3fcdae45.png
             * color :
             * href :
             * sort : 0
             * is_show : Y
             * create_time : 2020-11-11 10:23:45
             * type : 2
             * type_value :
             */

            private int id;
            private int cat_id;
            private String title;
            private String img;
            private String detail_img;
            private String color;
            private String href;
            private int sort;
            private String is_show;
            private String create_time;
            private String type;
            private String type_value;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getDetail_img() {
                return detail_img;
            }

            public void setDetail_img(String detail_img) {
                this.detail_img = detail_img;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
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
        }
    }
}
