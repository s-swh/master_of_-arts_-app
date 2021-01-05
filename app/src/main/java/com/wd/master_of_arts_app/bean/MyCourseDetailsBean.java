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
     * data : {"course_id":71,"course_name":"幼幼亲子班","icon":"http://qiniu.54artist.com/5fed7421d639f1353.jpeg","time_detail":"每周二","order_id":53,"name":"谭老师","avatar":"http://qiniu.54artist.com/5feae974db33d7868.jpg","unit_num":48,"unit_list":[{"unit_id":241,"unit_name":"神奇的豆芽","sort_num":1,"date":"2021-02-02","day":2,"start_time":"17:30:00","status":1},{"unit_id":242,"unit_name":"甜甜的糖葫芦","sort_num":1,"date":"2021-02-09","day":2,"start_time":"17:30:00","status":1},{"unit_id":243,"unit_name":"疯狂毛毛怪","sort_num":1,"date":"2021-02-16","day":2,"start_time":"17:30:00","status":1},{"unit_id":244,"unit_name":"大鲨鱼","sort_num":1,"date":"2021-02-23","day":2,"start_time":"17:30:00","status":1},{"unit_id":245,"unit_name":"爬高的毛毛虫","sort_num":1,"date":"2021-03-02","day":2,"start_time":"17:30:00","status":1},{"unit_id":246,"unit_name":"梦中的雨","sort_num":1,"date":"2021-03-09","day":2,"start_time":"17:30:00","status":1},{"unit_id":247,"unit_name":"卖菠萝","sort_num":1,"date":"2021-03-16","day":2,"start_time":"17:30:00","status":1},{"unit_id":248,"unit_name":"蚂蚁搬西瓜","sort_num":1,"date":"2021-03-23","day":2,"start_time":"17:30:00","status":1},{"unit_id":249,"unit_name":"火山爆发","sort_num":1,"date":"2021-03-30","day":2,"start_time":"17:30:00","status":1},{"unit_id":250,"unit_name":"紫藤花","sort_num":1,"date":"2021-04-06","day":2,"start_time":"17:30:00","status":1},{"unit_id":251,"unit_name":"奶牛哞哞","sort_num":1,"date":"2021-04-13","day":2,"start_time":"17:30:00","status":1},{"unit_id":252,"unit_name":"墨镜大侠","sort_num":1,"date":"2021-04-20","day":2,"start_time":"17:30:00","status":1},{"unit_id":253,"unit_name":"好吃懒做的贼鸥","sort_num":1,"date":"2021-04-27","day":2,"start_time":"17:30:00","status":1},{"unit_id":254,"unit_name":"帝王蟹","sort_num":1,"date":"2021-05-04","day":2,"start_time":"17:30:00","status":1},{"unit_id":255,"unit_name":"卷卷蚊香","sort_num":1,"date":"2021-05-11","day":2,"start_time":"17:30:00","status":1},{"unit_id":256,"unit_name":"流淌的冰淇淋","sort_num":1,"date":"2021-05-18","day":2,"start_time":"17:30:00","status":1},{"unit_id":257,"unit_name":"雾凇","sort_num":1,"date":"2021-05-25","day":2,"start_time":"17:30:00","status":1},{"unit_id":258,"unit_name":"铃兰","sort_num":1,"date":"2021-06-01","day":2,"start_time":"17:30:00","status":1},{"unit_id":259,"unit_name":"小蝌蚪找妈妈","sort_num":1,"date":"2021-06-08","day":2,"start_time":"17:30:00","status":1},{"unit_id":260,"unit_name":"我爱刷牙","sort_num":1,"date":"2021-06-15","day":2,"start_time":"17:30:00","status":1},{"unit_id":261,"unit_name":"兔子宝宝蹦蹦跳","sort_num":1,"date":"2021-06-22","day":2,"start_time":"17:30:00","status":1},{"unit_id":262,"unit_name":"调皮的小毛驴","sort_num":1,"date":"2021-06-29","day":2,"start_time":"17:30:00","status":1},{"unit_id":263,"unit_name":"红眼睛绿眼睛","sort_num":1,"date":"2021-07-06","day":2,"start_time":"17:30:00","status":1},{"unit_id":264,"unit_name":"海象","sort_num":1,"date":"2021-07-13","day":2,"start_time":"17:30:00","status":1},{"unit_id":265,"unit_name":"巨嘴鸟","sort_num":1,"date":"2021-07-20","day":2,"start_time":"17:30:00","status":1},{"unit_id":266,"unit_name":"白桦树的春夏秋冬","sort_num":1,"date":"2021-07-27","day":2,"start_time":"17:30:00","status":1},{"unit_id":288,"unit_name":"甜甜的火龙果","sort_num":1,"date":"2021-08-03","day":2,"start_time":"17:30:00","status":1},{"unit_id":289,"unit_name":"彩色房屋","sort_num":1,"date":"2021-08-10","day":2,"start_time":"17:30:00","status":1},{"unit_id":290,"unit_name":"大象甩鼻子","sort_num":1,"date":"2021-08-17","day":2,"start_time":"17:30:00","status":1},{"unit_id":291,"unit_name":"山魈","sort_num":1,"date":"2021-08-24","day":2,"start_time":"17:30:00","status":1},{"unit_id":292,"unit_name":"小猫钓鱼","sort_num":1,"date":"2021-08-31","day":2,"start_time":"17:30:00","status":1},{"unit_id":293,"unit_name":"豌豆宝宝","sort_num":1,"date":"2021-09-07","day":2,"start_time":"17:30:00","status":1},{"unit_id":294,"unit_name":"水仙花","sort_num":1,"date":"2021-09-14","day":2,"start_time":"17:30:00","status":1},{"unit_id":295,"unit_name":"背着房子去旅行","sort_num":1,"date":"2021-09-21","day":2,"start_time":"17:30:00","status":1},{"unit_id":296,"unit_name":"大白鹅","sort_num":1,"date":"2021-09-28","day":2,"start_time":"17:30:00","status":1},{"unit_id":297,"unit_name":"飞奔吧！足球","sort_num":1,"date":"2021-10-05","day":2,"start_time":"17:30:00","status":1},{"unit_id":298,"unit_name":"荷叶","sort_num":1,"date":"2021-10-12","day":2,"start_time":"17:30:00","status":1},{"unit_id":299,"unit_name":"会跳舞的菊花","sort_num":1,"date":"2021-10-19","day":2,"start_time":"17:30:00","status":1},{"unit_id":300,"unit_name":"恐龙世界","sort_num":1,"date":"2021-10-26","day":2,"start_time":"17:30:00","status":1},{"unit_id":301,"unit_name":"美丽星球在太空","sort_num":1,"date":"2021-11-02","day":2,"start_time":"17:30:00","status":1},{"unit_id":302,"unit_name":"奇怪的史前人像","sort_num":1,"date":"2021-11-09","day":2,"start_time":"17:30:00","status":1},{"unit_id":303,"unit_name":"日出","sort_num":1,"date":"2021-11-16","day":2,"start_time":"17:30:00","status":1},{"unit_id":304,"unit_name":"玩毛球的猫咪","sort_num":1,"date":"2021-11-23","day":2,"start_time":"17:30:00","status":1},{"unit_id":305,"unit_name":"仙人掌","sort_num":1,"date":"2021-11-30","day":2,"start_time":"17:30:00","status":1},{"unit_id":306,"unit_name":"香蕉小人","sort_num":1,"date":"2021-12-07","day":2,"start_time":"17:30:00","status":1},{"unit_id":307,"unit_name":"小蜜蜂的美丽新世界","sort_num":1,"date":"2021-12-14","day":2,"start_time":"17:30:00","status":1},{"unit_id":308,"unit_name":"萤火之光","sort_num":1,"date":"2021-12-21","day":2,"start_time":"17:30:00","status":1},{"unit_id":309,"unit_name":"长腿马和短腿马","sort_num":1,"date":"2021-12-28","day":2,"start_time":"17:30:00","status":1}]}
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
         * course_id : 71
         * course_name : 幼幼亲子班
         * icon : http://qiniu.54artist.com/5fed7421d639f1353.jpeg
         * time_detail : 每周二
         * order_id : 53
         * name : 谭老师
         * avatar : http://qiniu.54artist.com/5feae974db33d7868.jpg
         * unit_num : 48
         * unit_list : [{"unit_id":241,"unit_name":"神奇的豆芽","sort_num":1,"date":"2021-02-02","day":2,"start_time":"17:30:00","status":1},{"unit_id":242,"unit_name":"甜甜的糖葫芦","sort_num":1,"date":"2021-02-09","day":2,"start_time":"17:30:00","status":1},{"unit_id":243,"unit_name":"疯狂毛毛怪","sort_num":1,"date":"2021-02-16","day":2,"start_time":"17:30:00","status":1},{"unit_id":244,"unit_name":"大鲨鱼","sort_num":1,"date":"2021-02-23","day":2,"start_time":"17:30:00","status":1},{"unit_id":245,"unit_name":"爬高的毛毛虫","sort_num":1,"date":"2021-03-02","day":2,"start_time":"17:30:00","status":1},{"unit_id":246,"unit_name":"梦中的雨","sort_num":1,"date":"2021-03-09","day":2,"start_time":"17:30:00","status":1},{"unit_id":247,"unit_name":"卖菠萝","sort_num":1,"date":"2021-03-16","day":2,"start_time":"17:30:00","status":1},{"unit_id":248,"unit_name":"蚂蚁搬西瓜","sort_num":1,"date":"2021-03-23","day":2,"start_time":"17:30:00","status":1},{"unit_id":249,"unit_name":"火山爆发","sort_num":1,"date":"2021-03-30","day":2,"start_time":"17:30:00","status":1},{"unit_id":250,"unit_name":"紫藤花","sort_num":1,"date":"2021-04-06","day":2,"start_time":"17:30:00","status":1},{"unit_id":251,"unit_name":"奶牛哞哞","sort_num":1,"date":"2021-04-13","day":2,"start_time":"17:30:00","status":1},{"unit_id":252,"unit_name":"墨镜大侠","sort_num":1,"date":"2021-04-20","day":2,"start_time":"17:30:00","status":1},{"unit_id":253,"unit_name":"好吃懒做的贼鸥","sort_num":1,"date":"2021-04-27","day":2,"start_time":"17:30:00","status":1},{"unit_id":254,"unit_name":"帝王蟹","sort_num":1,"date":"2021-05-04","day":2,"start_time":"17:30:00","status":1},{"unit_id":255,"unit_name":"卷卷蚊香","sort_num":1,"date":"2021-05-11","day":2,"start_time":"17:30:00","status":1},{"unit_id":256,"unit_name":"流淌的冰淇淋","sort_num":1,"date":"2021-05-18","day":2,"start_time":"17:30:00","status":1},{"unit_id":257,"unit_name":"雾凇","sort_num":1,"date":"2021-05-25","day":2,"start_time":"17:30:00","status":1},{"unit_id":258,"unit_name":"铃兰","sort_num":1,"date":"2021-06-01","day":2,"start_time":"17:30:00","status":1},{"unit_id":259,"unit_name":"小蝌蚪找妈妈","sort_num":1,"date":"2021-06-08","day":2,"start_time":"17:30:00","status":1},{"unit_id":260,"unit_name":"我爱刷牙","sort_num":1,"date":"2021-06-15","day":2,"start_time":"17:30:00","status":1},{"unit_id":261,"unit_name":"兔子宝宝蹦蹦跳","sort_num":1,"date":"2021-06-22","day":2,"start_time":"17:30:00","status":1},{"unit_id":262,"unit_name":"调皮的小毛驴","sort_num":1,"date":"2021-06-29","day":2,"start_time":"17:30:00","status":1},{"unit_id":263,"unit_name":"红眼睛绿眼睛","sort_num":1,"date":"2021-07-06","day":2,"start_time":"17:30:00","status":1},{"unit_id":264,"unit_name":"海象","sort_num":1,"date":"2021-07-13","day":2,"start_time":"17:30:00","status":1},{"unit_id":265,"unit_name":"巨嘴鸟","sort_num":1,"date":"2021-07-20","day":2,"start_time":"17:30:00","status":1},{"unit_id":266,"unit_name":"白桦树的春夏秋冬","sort_num":1,"date":"2021-07-27","day":2,"start_time":"17:30:00","status":1},{"unit_id":288,"unit_name":"甜甜的火龙果","sort_num":1,"date":"2021-08-03","day":2,"start_time":"17:30:00","status":1},{"unit_id":289,"unit_name":"彩色房屋","sort_num":1,"date":"2021-08-10","day":2,"start_time":"17:30:00","status":1},{"unit_id":290,"unit_name":"大象甩鼻子","sort_num":1,"date":"2021-08-17","day":2,"start_time":"17:30:00","status":1},{"unit_id":291,"unit_name":"山魈","sort_num":1,"date":"2021-08-24","day":2,"start_time":"17:30:00","status":1},{"unit_id":292,"unit_name":"小猫钓鱼","sort_num":1,"date":"2021-08-31","day":2,"start_time":"17:30:00","status":1},{"unit_id":293,"unit_name":"豌豆宝宝","sort_num":1,"date":"2021-09-07","day":2,"start_time":"17:30:00","status":1},{"unit_id":294,"unit_name":"水仙花","sort_num":1,"date":"2021-09-14","day":2,"start_time":"17:30:00","status":1},{"unit_id":295,"unit_name":"背着房子去旅行","sort_num":1,"date":"2021-09-21","day":2,"start_time":"17:30:00","status":1},{"unit_id":296,"unit_name":"大白鹅","sort_num":1,"date":"2021-09-28","day":2,"start_time":"17:30:00","status":1},{"unit_id":297,"unit_name":"飞奔吧！足球","sort_num":1,"date":"2021-10-05","day":2,"start_time":"17:30:00","status":1},{"unit_id":298,"unit_name":"荷叶","sort_num":1,"date":"2021-10-12","day":2,"start_time":"17:30:00","status":1},{"unit_id":299,"unit_name":"会跳舞的菊花","sort_num":1,"date":"2021-10-19","day":2,"start_time":"17:30:00","status":1},{"unit_id":300,"unit_name":"恐龙世界","sort_num":1,"date":"2021-10-26","day":2,"start_time":"17:30:00","status":1},{"unit_id":301,"unit_name":"美丽星球在太空","sort_num":1,"date":"2021-11-02","day":2,"start_time":"17:30:00","status":1},{"unit_id":302,"unit_name":"奇怪的史前人像","sort_num":1,"date":"2021-11-09","day":2,"start_time":"17:30:00","status":1},{"unit_id":303,"unit_name":"日出","sort_num":1,"date":"2021-11-16","day":2,"start_time":"17:30:00","status":1},{"unit_id":304,"unit_name":"玩毛球的猫咪","sort_num":1,"date":"2021-11-23","day":2,"start_time":"17:30:00","status":1},{"unit_id":305,"unit_name":"仙人掌","sort_num":1,"date":"2021-11-30","day":2,"start_time":"17:30:00","status":1},{"unit_id":306,"unit_name":"香蕉小人","sort_num":1,"date":"2021-12-07","day":2,"start_time":"17:30:00","status":1},{"unit_id":307,"unit_name":"小蜜蜂的美丽新世界","sort_num":1,"date":"2021-12-14","day":2,"start_time":"17:30:00","status":1},{"unit_id":308,"unit_name":"萤火之光","sort_num":1,"date":"2021-12-21","day":2,"start_time":"17:30:00","status":1},{"unit_id":309,"unit_name":"长腿马和短腿马","sort_num":1,"date":"2021-12-28","day":2,"start_time":"17:30:00","status":1}]
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
             * unit_id : 241
             * unit_name : 神奇的豆芽
             * sort_num : 1
             * date : 2021-02-02
             * day : 2
             * start_time : 17:30:00
             * status : 1
             */

            private int unit_id;
            private String unit_name;
            private int sort_num;
            private String date;
            private int day;
            private String start_time;
            private int status;

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
        }
    }
}
