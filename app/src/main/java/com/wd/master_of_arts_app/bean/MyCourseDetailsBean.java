package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/29 8:58
 */
public class MyCourseDetailsBean {

    /**
     * code : 1
     * msg : 成功
     * data : {"course_id":69,"course_name":"青苗大师班","icon":"http://qiniu.54artist.com/5fed74375c46a3453.jpeg","time_detail":"每周六，周天","order_id":54,"name":"殷老师","avatar":"http://qiniu.54artist.com/5feae941b92875871.jpg","unit_num":48,"unit_list":[{"unit_id":310,"unit_name":"植物写生（上）","sort_num":1,"date":"2021-01-05","day":6,"start_time":"16:25:00","status":3,"homework_id":6},{"unit_id":311,"unit_name":"植物写生（下）","sort_num":1,"date":"2021-02-07","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":312,"unit_name":"秋葵（上）","sort_num":1,"date":"2021-02-13","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":313,"unit_name":"秋葵（下）","sort_num":1,"date":"2021-02-14","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":314,"unit_name":"舞狮子（上）","sort_num":1,"date":"2021-02-20","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":315,"unit_name":"舞狮子（下）","sort_num":1,"date":"2021-02-21","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":316,"unit_name":"猪笼草（上）","sort_num":1,"date":"2021-02-27","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":317,"unit_name":"猪笼草（下）","sort_num":1,"date":"2021-02-28","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":318,"unit_name":"机械表芯（上）","sort_num":1,"date":"2021-03-06","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":319,"unit_name":"机械表芯（下）","sort_num":1,"date":"2021-03-07","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":320,"unit_name":"蟹将大战（上）","sort_num":1,"date":"2021-03-13","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":321,"unit_name":"蟹将大战（下）","sort_num":1,"date":"2021-03-14","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":322,"unit_name":"动物证件照（上）","sort_num":1,"date":"2021-03-20","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":323,"unit_name":"动物证件照（下）","sort_num":1,"date":"2021-03-21","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":324,"unit_name":"老人线描写生（上）","sort_num":1,"date":"2021-03-27","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":325,"unit_name":"老人线描写生（下）","sort_num":1,"date":"2021-03-28","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":326,"unit_name":"勇敢的猎手（上）","sort_num":1,"date":"2021-04-03","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":327,"unit_name":"勇敢的猎手（下）","sort_num":1,"date":"2021-04-04","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":328,"unit_name":"羊的故事（上）","sort_num":1,"date":"2021-04-10","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":329,"unit_name":"羊的故事（下）","sort_num":1,"date":"2021-04-11","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":330,"unit_name":"切开的水果蔬菜（上）","sort_num":1,"date":"2021-04-17","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":331,"unit_name":"切开的水果蔬菜（下）","sort_num":1,"date":"2021-04-18","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":332,"unit_name":"纸上乐器（上）","sort_num":1,"date":"2021-04-24","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":333,"unit_name":"纸上乐器（下）","sort_num":1,"date":"2021-04-25","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":334,"unit_name":"海鲜大餐（上）","sort_num":1,"date":"2021-05-01","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":335,"unit_name":"海鲜大餐（下）","sort_num":1,"date":"2021-05-02","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":336,"unit_name":"航海游记（上）","sort_num":1,"date":"2021-05-08","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":337,"unit_name":"航海游记（下）","sort_num":1,"date":"2021-05-09","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":338,"unit_name":"购物车（上）","sort_num":1,"date":"2021-05-15","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":339,"unit_name":"购物车（下）","sort_num":1,"date":"2021-05-16","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":340,"unit_name":"半个石膏（上）","sort_num":1,"date":"2021-05-22","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":341,"unit_name":"半个石膏（下）","sort_num":1,"date":"2021-05-23","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":342,"unit_name":"玩伴（上）","sort_num":1,"date":"2021-05-29","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":343,"unit_name":"玩伴（下）","sort_num":1,"date":"2021-05-30","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":344,"unit_name":"美丽的海洋生物（上）","sort_num":1,"date":"2021-06-05","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":345,"unit_name":"美丽的海洋生物（下）","sort_num":1,"date":"2021-06-06","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":346,"unit_name":"美食的诱惑（上）","sort_num":1,"date":"2021-06-12","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":347,"unit_name":"美食的诱惑（下）","sort_num":1,"date":"2021-06-13","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":348,"unit_name":"四季花园（上）","sort_num":1,"date":"2021-06-19","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":349,"unit_name":"四季花园（下）","sort_num":1,"date":"2021-06-20","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":350,"unit_name":"调皮的花栗鼠（上）","sort_num":1,"date":"2021-06-26","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":351,"unit_name":"调皮的花栗鼠（下）","sort_num":1,"date":"2021-06-27","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":352,"unit_name":"昆虫记（上）","sort_num":1,"date":"2021-07-03","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":353,"unit_name":"昆虫记（下）","sort_num":1,"date":"2021-07-04","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":354,"unit_name":"海龟（上）","sort_num":1,"date":"2021-07-10","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":355,"unit_name":"海龟（下）","sort_num":1,"date":"2021-07-11","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":356,"unit_name":"缝纫机时代（上）","sort_num":1,"date":"2021-07-17","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":357,"unit_name":"缝纫机时代（下）","sort_num":1,"date":"2021-07-18","day":0,"start_time":"13:30:00","status":1,"homework_id":0}]}
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
         * course_id : 69
         * course_name : 青苗大师班
         * icon : http://qiniu.54artist.com/5fed74375c46a3453.jpeg
         * time_detail : 每周六，周天
         * order_id : 54
         * name : 殷老师
         * avatar : http://qiniu.54artist.com/5feae941b92875871.jpg
         * unit_num : 48
         * unit_list : [{"unit_id":310,"unit_name":"植物写生（上）","sort_num":1,"date":"2021-01-05","day":6,"start_time":"16:25:00","status":3,"homework_id":6},{"unit_id":311,"unit_name":"植物写生（下）","sort_num":1,"date":"2021-02-07","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":312,"unit_name":"秋葵（上）","sort_num":1,"date":"2021-02-13","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":313,"unit_name":"秋葵（下）","sort_num":1,"date":"2021-02-14","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":314,"unit_name":"舞狮子（上）","sort_num":1,"date":"2021-02-20","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":315,"unit_name":"舞狮子（下）","sort_num":1,"date":"2021-02-21","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":316,"unit_name":"猪笼草（上）","sort_num":1,"date":"2021-02-27","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":317,"unit_name":"猪笼草（下）","sort_num":1,"date":"2021-02-28","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":318,"unit_name":"机械表芯（上）","sort_num":1,"date":"2021-03-06","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":319,"unit_name":"机械表芯（下）","sort_num":1,"date":"2021-03-07","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":320,"unit_name":"蟹将大战（上）","sort_num":1,"date":"2021-03-13","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":321,"unit_name":"蟹将大战（下）","sort_num":1,"date":"2021-03-14","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":322,"unit_name":"动物证件照（上）","sort_num":1,"date":"2021-03-20","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":323,"unit_name":"动物证件照（下）","sort_num":1,"date":"2021-03-21","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":324,"unit_name":"老人线描写生（上）","sort_num":1,"date":"2021-03-27","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":325,"unit_name":"老人线描写生（下）","sort_num":1,"date":"2021-03-28","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":326,"unit_name":"勇敢的猎手（上）","sort_num":1,"date":"2021-04-03","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":327,"unit_name":"勇敢的猎手（下）","sort_num":1,"date":"2021-04-04","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":328,"unit_name":"羊的故事（上）","sort_num":1,"date":"2021-04-10","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":329,"unit_name":"羊的故事（下）","sort_num":1,"date":"2021-04-11","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":330,"unit_name":"切开的水果蔬菜（上）","sort_num":1,"date":"2021-04-17","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":331,"unit_name":"切开的水果蔬菜（下）","sort_num":1,"date":"2021-04-18","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":332,"unit_name":"纸上乐器（上）","sort_num":1,"date":"2021-04-24","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":333,"unit_name":"纸上乐器（下）","sort_num":1,"date":"2021-04-25","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":334,"unit_name":"海鲜大餐（上）","sort_num":1,"date":"2021-05-01","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":335,"unit_name":"海鲜大餐（下）","sort_num":1,"date":"2021-05-02","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":336,"unit_name":"航海游记（上）","sort_num":1,"date":"2021-05-08","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":337,"unit_name":"航海游记（下）","sort_num":1,"date":"2021-05-09","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":338,"unit_name":"购物车（上）","sort_num":1,"date":"2021-05-15","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":339,"unit_name":"购物车（下）","sort_num":1,"date":"2021-05-16","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":340,"unit_name":"半个石膏（上）","sort_num":1,"date":"2021-05-22","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":341,"unit_name":"半个石膏（下）","sort_num":1,"date":"2021-05-23","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":342,"unit_name":"玩伴（上）","sort_num":1,"date":"2021-05-29","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":343,"unit_name":"玩伴（下）","sort_num":1,"date":"2021-05-30","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":344,"unit_name":"美丽的海洋生物（上）","sort_num":1,"date":"2021-06-05","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":345,"unit_name":"美丽的海洋生物（下）","sort_num":1,"date":"2021-06-06","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":346,"unit_name":"美食的诱惑（上）","sort_num":1,"date":"2021-06-12","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":347,"unit_name":"美食的诱惑（下）","sort_num":1,"date":"2021-06-13","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":348,"unit_name":"四季花园（上）","sort_num":1,"date":"2021-06-19","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":349,"unit_name":"四季花园（下）","sort_num":1,"date":"2021-06-20","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":350,"unit_name":"调皮的花栗鼠（上）","sort_num":1,"date":"2021-06-26","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":351,"unit_name":"调皮的花栗鼠（下）","sort_num":1,"date":"2021-06-27","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":352,"unit_name":"昆虫记（上）","sort_num":1,"date":"2021-07-03","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":353,"unit_name":"昆虫记（下）","sort_num":1,"date":"2021-07-04","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":354,"unit_name":"海龟（上）","sort_num":1,"date":"2021-07-10","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":355,"unit_name":"海龟（下）","sort_num":1,"date":"2021-07-11","day":0,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":356,"unit_name":"缝纫机时代（上）","sort_num":1,"date":"2021-07-17","day":6,"start_time":"13:30:00","status":1,"homework_id":0},{"unit_id":357,"unit_name":"缝纫机时代（下）","sort_num":1,"date":"2021-07-18","day":0,"start_time":"13:30:00","status":1,"homework_id":0}]
         */

        private int course_id;
        private String course_name;
        private String icon;
        private String time_detail;
        private int order_id;
        private String name;
        private String avatar;
        private int unit_num;
        private List<UnitListBean> unit_list;

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTime_detail() {
            return time_detail;
        }

        public void setTime_detail(String time_detail) {
            this.time_detail = time_detail;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getUnit_num() {
            return unit_num;
        }

        public void setUnit_num(int unit_num) {
            this.unit_num = unit_num;
        }

        public List<UnitListBean> getUnit_list() {
            return unit_list;
        }

        public void setUnit_list(List<UnitListBean> unit_list) {
            this.unit_list = unit_list;
        }

        public static class UnitListBean {
            /**
             * unit_id : 310
             * unit_name : 植物写生（上）
             * sort_num : 1
             * date : 2021-01-05
             * day : 6
             * start_time : 16:25:00
             * status : 3
             * homework_id : 6
             */

            private int unit_id;
            private String unit_name;
            private int sort_num;
            private String date;
            private int day;
            private String start_time;
            private int status;
            private int homework_id;

            public int getUnit_id() {
                return unit_id;
            }

            public void setUnit_id(int unit_id) {
                this.unit_id = unit_id;
            }

            public String getUnit_name() {
                return unit_name;
            }

            public void setUnit_name(String unit_name) {
                this.unit_name = unit_name;
            }

            public int getSort_num() {
                return sort_num;
            }

            public void setSort_num(int sort_num) {
                this.sort_num = sort_num;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getHomework_id() {
                return homework_id;
            }

            public void setHomework_id(int homework_id) {
                this.homework_id = homework_id;
            }
        }
    }
}
