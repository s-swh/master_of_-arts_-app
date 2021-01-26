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
     * data : {"course_id":76,"course_name":"童童创想班A","icon":"http://qiniu.54artist.com/5fed7443a03915206.jpeg","time_detail":"每周二/三/四/五/六9:00上课","order_id":395,"name":"艺老师","avatar":"http://qiniu.54artist.com/5ff7c57b2b0109538.jpg","job_num":"njzr-01","unit_num":48,"unit_list":[{"unit_id":162,"unit_name":"瓶子里的收藏","sort_num":1,"date":"2021-01-26","day":2,"start_time":"09:00:00","status":6,"homework_id":44,"meeting_id":2161,"plaso_history_url":["600e7396f9021bfd48000a50","600eb8680288d0c34b001b29","600eba2f41574a475c000b86"]},{"unit_id":163,"unit_name":"能干的挖土机","sort_num":2,"date":"2021-01-27","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2162,"plaso_history_url":[]},{"unit_id":165,"unit_name":"搞怪","sort_num":3,"date":"2021-01-28","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2163,"plaso_history_url":[]},{"unit_id":166,"unit_name":"大嘴鸟","sort_num":4,"date":"2021-01-29","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2164,"plaso_history_url":[]},{"unit_id":168,"unit_name":"瓶花","sort_num":5,"date":"2021-01-30","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2165,"plaso_history_url":[]},{"unit_id":169,"unit_name":"运动鞋","sort_num":6,"date":"2021-02-02","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2166,"plaso_history_url":[]},{"unit_id":170,"unit_name":"桌上的静物","sort_num":7,"date":"2021-02-03","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2167,"plaso_history_url":[]},{"unit_id":171,"unit_name":"激流勇进","sort_num":8,"date":"2021-02-04","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2168,"plaso_history_url":[]},{"unit_id":172,"unit_name":"过马路的人（上）","sort_num":9,"date":"2021-02-05","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2169,"plaso_history_url":[]},{"unit_id":173,"unit_name":"过马路的人（下）","sort_num":10,"date":"2021-02-06","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2170,"plaso_history_url":[]},{"unit_id":174,"unit_name":"汪汪队","sort_num":11,"date":"2021-02-09","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2171,"plaso_history_url":[]},{"unit_id":175,"unit_name":"驱蚊大作战","sort_num":12,"date":"2021-02-10","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2172,"plaso_history_url":[]},{"unit_id":176,"unit_name":"农耕渔牧的生活","sort_num":13,"date":"2021-02-11","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2173,"plaso_history_url":[]},{"unit_id":177,"unit_name":"金鱼游啊游","sort_num":14,"date":"2021-02-12","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2174,"plaso_history_url":[]},{"unit_id":178,"unit_name":"开心的缆车之旅","sort_num":15,"date":"2021-02-13","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2175,"plaso_history_url":[]},{"unit_id":180,"unit_name":"捉龙虾","sort_num":16,"date":"2021-02-16","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2176,"plaso_history_url":[]},{"unit_id":181,"unit_name":"滑雪","sort_num":17,"date":"2021-02-17","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2177,"plaso_history_url":[]},{"unit_id":182,"unit_name":"零食写生","sort_num":18,"date":"2021-02-18","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2178,"plaso_history_url":[]},{"unit_id":183,"unit_name":"萨克斯","sort_num":19,"date":"2021-02-19","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2179,"plaso_history_url":[]},{"unit_id":184,"unit_name":"我的妈妈","sort_num":20,"date":"2021-02-20","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2180,"plaso_history_url":[]},{"unit_id":185,"unit_name":"奥莉薇不想当公主（上）","sort_num":21,"date":"2021-02-23","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2181,"plaso_history_url":[]},{"unit_id":186,"unit_name":"奥莉薇不想当公主（下）","sort_num":22,"date":"2021-02-24","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2182,"plaso_history_url":[]},{"unit_id":407,"unit_name":"热闹的菜市场（上）","sort_num":23,"date":"2021-02-25","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2183,"plaso_history_url":[]},{"unit_id":408,"unit_name":"热闹的菜市场（下）","sort_num":24,"date":"2021-02-26","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2184,"plaso_history_url":[]},{"unit_id":409,"unit_name":"开学之\u2014书包里的秘密","sort_num":25,"date":"2021-02-27","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2185,"plaso_history_url":[]},{"unit_id":410,"unit_name":"螳螂大战","sort_num":26,"date":"2021-03-02","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2186,"plaso_history_url":[]},{"unit_id":411,"unit_name":"切开的水果","sort_num":27,"date":"2021-03-03","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2187,"plaso_history_url":[]},{"unit_id":412,"unit_name":"恐龙化石","sort_num":28,"date":"2021-03-04","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2188,"plaso_history_url":[]},{"unit_id":413,"unit_name":"盛放的美人蕉","sort_num":29,"date":"2021-03-05","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2189,"plaso_history_url":[]},{"unit_id":414,"unit_name":"花样溜冰","sort_num":30,"date":"2021-03-06","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2190,"plaso_history_url":[]},{"unit_id":415,"unit_name":"欢乐的小树蛙","sort_num":31,"date":"2021-03-09","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2191,"plaso_history_url":[]},{"unit_id":416,"unit_name":"力大无穷的电钻","sort_num":32,"date":"2021-03-10","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2192,"plaso_history_url":[]},{"unit_id":417,"unit_name":"火车来啦（上）","sort_num":33,"date":"2021-03-11","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2193,"plaso_history_url":[]},{"unit_id":418,"unit_name":"火车来啦（下）","sort_num":34,"date":"2021-03-12","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2194,"plaso_history_url":[]},{"unit_id":419,"unit_name":"蜜蜂嗡嗡","sort_num":35,"date":"2021-03-13","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2195,"plaso_history_url":[]},{"unit_id":420,"unit_name":"我的杯子我做主","sort_num":36,"date":"2021-03-16","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2196,"plaso_history_url":[]},{"unit_id":421,"unit_name":"睡懒觉","sort_num":37,"date":"2021-03-17","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2197,"plaso_history_url":[]},{"unit_id":422,"unit_name":"丰盛的早餐","sort_num":38,"date":"2021-03-18","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2198,"plaso_history_url":[]},{"unit_id":423,"unit_name":"中国速度","sort_num":39,"date":"2021-03-19","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2199,"plaso_history_url":[]},{"unit_id":424,"unit_name":"有个性的架子鼓手","sort_num":40,"date":"2021-03-20","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2200,"plaso_history_url":[]},{"unit_id":425,"unit_name":"百变回收机器人（上）","sort_num":41,"date":"2021-03-23","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2201,"plaso_history_url":[]},{"unit_id":426,"unit_name":"百变回收机器人（下）","sort_num":42,"date":"2021-03-24","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2202,"plaso_history_url":[]},{"unit_id":427,"unit_name":"滑滑梯","sort_num":43,"date":"2021-03-25","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2203,"plaso_history_url":[]},{"unit_id":428,"unit_name":"猫头鹰的职业","sort_num":44,"date":"2021-03-26","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2204,"plaso_history_url":[]},{"unit_id":429,"unit_name":"精怪","sort_num":45,"date":"2021-03-27","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2205,"plaso_history_url":[]},{"unit_id":430,"unit_name":"餐桌上的蚂蚁","sort_num":46,"date":"2021-03-30","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2206,"plaso_history_url":[]},{"unit_id":431,"unit_name":"理发店的故事（上）","sort_num":47,"date":"2021-03-31","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2207,"plaso_history_url":[]},{"unit_id":432,"unit_name":"理发店的故事（下）","sort_num":48,"date":"2021-04-01","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2208,"plaso_history_url":[]}]}
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
         * course_id : 76
         * course_name : 童童创想班A
         * icon : http://qiniu.54artist.com/5fed7443a03915206.jpeg
         * time_detail : 每周二/三/四/五/六9:00上课
         * order_id : 395
         * name : 艺老师
         * avatar : http://qiniu.54artist.com/5ff7c57b2b0109538.jpg
         * job_num : njzr-01
         * unit_num : 48
         * unit_list : [{"unit_id":162,"unit_name":"瓶子里的收藏","sort_num":1,"date":"2021-01-26","day":2,"start_time":"09:00:00","status":6,"homework_id":44,"meeting_id":2161,"plaso_history_url":["600e7396f9021bfd48000a50","600eb8680288d0c34b001b29","600eba2f41574a475c000b86"]},{"unit_id":163,"unit_name":"能干的挖土机","sort_num":2,"date":"2021-01-27","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2162,"plaso_history_url":[]},{"unit_id":165,"unit_name":"搞怪","sort_num":3,"date":"2021-01-28","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2163,"plaso_history_url":[]},{"unit_id":166,"unit_name":"大嘴鸟","sort_num":4,"date":"2021-01-29","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2164,"plaso_history_url":[]},{"unit_id":168,"unit_name":"瓶花","sort_num":5,"date":"2021-01-30","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2165,"plaso_history_url":[]},{"unit_id":169,"unit_name":"运动鞋","sort_num":6,"date":"2021-02-02","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2166,"plaso_history_url":[]},{"unit_id":170,"unit_name":"桌上的静物","sort_num":7,"date":"2021-02-03","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2167,"plaso_history_url":[]},{"unit_id":171,"unit_name":"激流勇进","sort_num":8,"date":"2021-02-04","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2168,"plaso_history_url":[]},{"unit_id":172,"unit_name":"过马路的人（上）","sort_num":9,"date":"2021-02-05","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2169,"plaso_history_url":[]},{"unit_id":173,"unit_name":"过马路的人（下）","sort_num":10,"date":"2021-02-06","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2170,"plaso_history_url":[]},{"unit_id":174,"unit_name":"汪汪队","sort_num":11,"date":"2021-02-09","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2171,"plaso_history_url":[]},{"unit_id":175,"unit_name":"驱蚊大作战","sort_num":12,"date":"2021-02-10","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2172,"plaso_history_url":[]},{"unit_id":176,"unit_name":"农耕渔牧的生活","sort_num":13,"date":"2021-02-11","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2173,"plaso_history_url":[]},{"unit_id":177,"unit_name":"金鱼游啊游","sort_num":14,"date":"2021-02-12","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2174,"plaso_history_url":[]},{"unit_id":178,"unit_name":"开心的缆车之旅","sort_num":15,"date":"2021-02-13","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2175,"plaso_history_url":[]},{"unit_id":180,"unit_name":"捉龙虾","sort_num":16,"date":"2021-02-16","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2176,"plaso_history_url":[]},{"unit_id":181,"unit_name":"滑雪","sort_num":17,"date":"2021-02-17","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2177,"plaso_history_url":[]},{"unit_id":182,"unit_name":"零食写生","sort_num":18,"date":"2021-02-18","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2178,"plaso_history_url":[]},{"unit_id":183,"unit_name":"萨克斯","sort_num":19,"date":"2021-02-19","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2179,"plaso_history_url":[]},{"unit_id":184,"unit_name":"我的妈妈","sort_num":20,"date":"2021-02-20","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2180,"plaso_history_url":[]},{"unit_id":185,"unit_name":"奥莉薇不想当公主（上）","sort_num":21,"date":"2021-02-23","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2181,"plaso_history_url":[]},{"unit_id":186,"unit_name":"奥莉薇不想当公主（下）","sort_num":22,"date":"2021-02-24","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2182,"plaso_history_url":[]},{"unit_id":407,"unit_name":"热闹的菜市场（上）","sort_num":23,"date":"2021-02-25","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2183,"plaso_history_url":[]},{"unit_id":408,"unit_name":"热闹的菜市场（下）","sort_num":24,"date":"2021-02-26","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2184,"plaso_history_url":[]},{"unit_id":409,"unit_name":"开学之\u2014书包里的秘密","sort_num":25,"date":"2021-02-27","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2185,"plaso_history_url":[]},{"unit_id":410,"unit_name":"螳螂大战","sort_num":26,"date":"2021-03-02","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2186,"plaso_history_url":[]},{"unit_id":411,"unit_name":"切开的水果","sort_num":27,"date":"2021-03-03","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2187,"plaso_history_url":[]},{"unit_id":412,"unit_name":"恐龙化石","sort_num":28,"date":"2021-03-04","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2188,"plaso_history_url":[]},{"unit_id":413,"unit_name":"盛放的美人蕉","sort_num":29,"date":"2021-03-05","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2189,"plaso_history_url":[]},{"unit_id":414,"unit_name":"花样溜冰","sort_num":30,"date":"2021-03-06","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2190,"plaso_history_url":[]},{"unit_id":415,"unit_name":"欢乐的小树蛙","sort_num":31,"date":"2021-03-09","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2191,"plaso_history_url":[]},{"unit_id":416,"unit_name":"力大无穷的电钻","sort_num":32,"date":"2021-03-10","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2192,"plaso_history_url":[]},{"unit_id":417,"unit_name":"火车来啦（上）","sort_num":33,"date":"2021-03-11","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2193,"plaso_history_url":[]},{"unit_id":418,"unit_name":"火车来啦（下）","sort_num":34,"date":"2021-03-12","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2194,"plaso_history_url":[]},{"unit_id":419,"unit_name":"蜜蜂嗡嗡","sort_num":35,"date":"2021-03-13","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2195,"plaso_history_url":[]},{"unit_id":420,"unit_name":"我的杯子我做主","sort_num":36,"date":"2021-03-16","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2196,"plaso_history_url":[]},{"unit_id":421,"unit_name":"睡懒觉","sort_num":37,"date":"2021-03-17","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2197,"plaso_history_url":[]},{"unit_id":422,"unit_name":"丰盛的早餐","sort_num":38,"date":"2021-03-18","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2198,"plaso_history_url":[]},{"unit_id":423,"unit_name":"中国速度","sort_num":39,"date":"2021-03-19","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2199,"plaso_history_url":[]},{"unit_id":424,"unit_name":"有个性的架子鼓手","sort_num":40,"date":"2021-03-20","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2200,"plaso_history_url":[]},{"unit_id":425,"unit_name":"百变回收机器人（上）","sort_num":41,"date":"2021-03-23","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2201,"plaso_history_url":[]},{"unit_id":426,"unit_name":"百变回收机器人（下）","sort_num":42,"date":"2021-03-24","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2202,"plaso_history_url":[]},{"unit_id":427,"unit_name":"滑滑梯","sort_num":43,"date":"2021-03-25","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2203,"plaso_history_url":[]},{"unit_id":428,"unit_name":"猫头鹰的职业","sort_num":44,"date":"2021-03-26","day":5,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2204,"plaso_history_url":[]},{"unit_id":429,"unit_name":"精怪","sort_num":45,"date":"2021-03-27","day":6,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2205,"plaso_history_url":[]},{"unit_id":430,"unit_name":"餐桌上的蚂蚁","sort_num":46,"date":"2021-03-30","day":2,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2206,"plaso_history_url":[]},{"unit_id":431,"unit_name":"理发店的故事（上）","sort_num":47,"date":"2021-03-31","day":3,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2207,"plaso_history_url":[]},{"unit_id":432,"unit_name":"理发店的故事（下）","sort_num":48,"date":"2021-04-01","day":4,"start_time":"09:00:00","status":1,"homework_id":0,"meeting_id":2208,"plaso_history_url":[]}]
         */

        private int course_id;
        private String course_name;
        private String icon;
        private String time_detail;
        private int order_id;
        private String name;
        private String avatar;
        private String job_num;
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

        public String getJob_num() {
            return job_num;
        }

        public void setJob_num(String job_num) {
            this.job_num = job_num;
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
             * unit_id : 162
             * unit_name : 瓶子里的收藏
             * sort_num : 1
             * date : 2021-01-26
             * day : 2
             * start_time : 09:00:00
             * status : 6
             * homework_id : 44
             * meeting_id : 2161
             * plaso_history_url : ["600e7396f9021bfd48000a50","600eb8680288d0c34b001b29","600eba2f41574a475c000b86"]
             */

            private int unit_id;
            private String unit_name;
            private int sort_num;
            private String date;
            private int day;
            private String start_time;
            private int status;
            private int homework_id;
            private int meeting_id;
            private List<String> plaso_history_url;

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

            public int getMeeting_id() {
                return meeting_id;
            }

            public void setMeeting_id(int meeting_id) {
                this.meeting_id = meeting_id;
            }

            public List<String> getPlaso_history_url() {
                return plaso_history_url;
            }

            public void setPlaso_history_url(List<String> plaso_history_url) {
                this.plaso_history_url = plaso_history_url;
            }
        }
    }
}
