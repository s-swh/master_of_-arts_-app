package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 14:02
 */
public class NoticeBean {

    /**
     * code : 1
     * msg : 成功
     * data : {"list":{"total":2,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":7,"n_key":7,"n_value":"","title":"过年啦","content":"<p>十多个粉丝的房间看对方<\/p>","create_time":"2021-01-16 10:21:49","des":"","is_read":"Y"},{"id":6,"n_key":7,"n_value":"","title":"春节放假","content":"<p><span style=\";font-size:24px;font-family:SimSun;color:rgb(0,0,0)\">关 于 2021 年 春 节 放 假 安 排 的 通 知 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">各事业部、各部门： <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">依据国家有关规定并结合本单位实际情况，集团决定春节放 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">假安排如下：2021 年2 月11 日-2021 年2 月17 日为春节七天假 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">期，2021 年2 月9 日、2021 年2 月10 日、2021 年2 月18 日三 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">天调休，共计 10 天假期，2 月19 日（初八）上班。中高风险地 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">区员工无特殊情况尽量不要返乡或出游。如出行，要全程做好个 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">人防护工作，返回后主动配合管控要求，按规定隔离、核酸检测合 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">格后才能正常上班、外出。特殊工作及值班由各部门自行安排。请大 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">家安排好各自工作，并注意节前卫生打扫、防火防盗。 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">特此通知，请遵照执行。 <\/span><\/p>","create_time":"2021-01-13 15:54:01","des":"","is_read":"Y"}]}}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * list : {"total":2,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":7,"n_key":7,"n_value":"","title":"过年啦","content":"<p>十多个粉丝的房间看对方<\/p>","create_time":"2021-01-16 10:21:49","des":"","is_read":"Y"},{"id":6,"n_key":7,"n_value":"","title":"春节放假","content":"<p><span style=\";font-size:24px;font-family:SimSun;color:rgb(0,0,0)\">关 于 2021 年 春 节 放 假 安 排 的 通 知 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">各事业部、各部门： <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">依据国家有关规定并结合本单位实际情况，集团决定春节放 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">假安排如下：2021 年2 月11 日-2021 年2 月17 日为春节七天假 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">期，2021 年2 月9 日、2021 年2 月10 日、2021 年2 月18 日三 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">天调休，共计 10 天假期，2 月19 日（初八）上班。中高风险地 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">区员工无特殊情况尽量不要返乡或出游。如出行，要全程做好个 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">人防护工作，返回后主动配合管控要求，按规定隔离、核酸检测合 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">格后才能正常上班、外出。特殊工作及值班由各部门自行安排。请大 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">家安排好各自工作，并注意节前卫生打扫、防火防盗。 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">特此通知，请遵照执行。 <\/span><\/p>","create_time":"2021-01-13 15:54:01","des":"","is_read":"Y"}]}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total : 2
             * per_page : 10
             * current_page : 1
             * last_page : 1
             * data : [{"id":7,"n_key":7,"n_value":"","title":"过年啦","content":"<p>十多个粉丝的房间看对方<\/p>","create_time":"2021-01-16 10:21:49","des":"","is_read":"Y"},{"id":6,"n_key":7,"n_value":"","title":"春节放假","content":"<p><span style=\";font-size:24px;font-family:SimSun;color:rgb(0,0,0)\">关 于 2021 年 春 节 放 假 安 排 的 通 知 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">各事业部、各部门： <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">依据国家有关规定并结合本单位实际情况，集团决定春节放 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">假安排如下：2021 年2 月11 日-2021 年2 月17 日为春节七天假 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">期，2021 年2 月9 日、2021 年2 月10 日、2021 年2 月18 日三 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">天调休，共计 10 天假期，2 月19 日（初八）上班。中高风险地 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">区员工无特殊情况尽量不要返乡或出游。如出行，要全程做好个 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">人防护工作，返回后主动配合管控要求，按规定隔离、核酸检测合 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">格后才能正常上班、外出。特殊工作及值班由各部门自行安排。请大 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">家安排好各自工作，并注意节前卫生打扫、防火防盗。 <\/span><span style=\";font-size:20px;font-family:SimSun;color:rgb(0,0,7)\">特此通知，请遵照执行。 <\/span><\/p>","create_time":"2021-01-13 15:54:01","des":"","is_read":"Y"}]
             */

            private int total;
            private int per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * id : 7
                 * n_key : 7
                 * n_value :
                 * title : 过年啦
                 * content : <p>十多个粉丝的房间看对方</p>
                 * create_time : 2021-01-16 10:21:49
                 * des :
                 * is_read : Y
                 */

                private int id;
                private int n_key;
                private String n_value;
                private String title;
                private String content;
                private String create_time;
                private String des;
                private String is_read;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getN_key() {
                    return n_key;
                }

                public void setN_key(int n_key) {
                    this.n_key = n_key;
                }

                public String getN_value() {
                    return n_value;
                }

                public void setN_value(String n_value) {
                    this.n_value = n_value;
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

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                public String getIs_read() {
                    return is_read;
                }

                public void setIs_read(String is_read) {
                    this.is_read = is_read;
                }
            }
        }
    }
}
