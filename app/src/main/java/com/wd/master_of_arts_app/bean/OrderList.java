package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 8:34
 */
public class OrderList {


    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"id":53,"order_num":"5fed8465e2c3d462","course_id":71,"course_time_id":228,"logistics":"顺丰","express_number":"SF1045519952863","icon":"http://qiniu.54artist.com/5fed7421d639f1353.jpeg","title":"幼幼亲子班","allprice":"3840.00","status":2,"create_time":"2020-12-31 15:57:25","pay_time":null,"time_detail":"每周二","unit_count":48}]}
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
             * id : 53
             * order_num : 5fed8465e2c3d462
             * course_id : 71
             * course_time_id : 228
             * logistics : 顺丰
             * express_number : SF1045519952863
             * icon : http://qiniu.54artist.com/5fed7421d639f1353.jpeg
             * title : 幼幼亲子班
             * allprice : 3840.00
             * status : 2
             * create_time : 2020-12-31 15:57:25
             * pay_time : null
             * time_detail : 每周二
             * unit_count : 48
             */

            private int id;
            private String order_num;
            private int course_id;
            private int course_time_id;
            private String logistics;
            private String express_number;
            private String icon;
            private String title;
            private String allprice;
            private int status;
            private String create_time;
            private Object pay_time;
            private String time_detail;
            private int unit_count;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrder_num() {
                return order_num;
            }

            public void setOrder_num(String order_num) {
                this.order_num = order_num;
            }

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
            }

            public int getCourse_time_id() {
                return course_time_id;
            }

            public void setCourse_time_id(int course_time_id) {
                this.course_time_id = course_time_id;
            }

            public String getLogistics() {
                return logistics;
            }

            public void setLogistics(String logistics) {
                this.logistics = logistics;
            }

            public String getExpress_number() {
                return express_number;
            }

            public void setExpress_number(String express_number) {
                this.express_number = express_number;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAllprice() {
                return allprice;
            }

            public void setAllprice(String allprice) {
                this.allprice = allprice;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getPay_time() {
                return pay_time;
            }

            public void setPay_time(Object pay_time) {
                this.pay_time = pay_time;
            }

            public String getTime_detail() {
                return time_detail;
            }

            public void setTime_detail(String time_detail) {
                this.time_detail = time_detail;
            }

            public int getUnit_count() {
                return unit_count;
            }

            public void setUnit_count(int unit_count) {
                this.unit_count = unit_count;
            }
        }
    }
}
