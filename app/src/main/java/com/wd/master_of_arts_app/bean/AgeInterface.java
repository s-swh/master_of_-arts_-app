package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/19 9:26
 */
public class AgeInterface {

    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"id":1,"name":"3-4：幼幼亲子班","start_age":3,"end_age":4,"short_name":"3-4"},{"id":2,"name":"5-6：蒙蒙童画班","start_age":5,"end_age":6,"short_name":"5-6"},{"id":3,"name":"7-9：童童创想班","start_age":7,"end_age":9,"short_name":"7-9"},{"id":4,"name":"7-9：墨墨国画班","start_age":7,"end_age":9,"short_name":"7-9"},{"id":5,"name":"9-11：青苗大师班（写生）","start_age":9,"end_age":11,"short_name":"9-11"},{"id":6,"name":"11-13：金犊大师班（思维）","start_age":11,"end_age":13,"short_name":"11-13"},{"id":7,"name":"11-15：结构之美-几何形体","start_age":11,"end_age":15,"short_name":"11-15"},{"id":8,"name":"11-15：静微之美-静物写生","start_age":11,"end_age":15,"short_name":"11-15"},{"id":9,"name":"11-15：灰度之美-石膏头像","start_age":11,"end_age":15,"short_name":"11-15"},{"id":10,"name":"11-15：动静之美-人物速写","start_age":11,"end_age":15,"short_name":"11-15"},{"id":11,"name":"11-15：色彩之美-色彩写生","start_age":11,"end_age":15,"short_name":"11-15"}]}
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
             * id : 1
             * name : 3-4：幼幼亲子班
             * start_age : 3
             * end_age : 4
             * short_name : 3-4
             */

            private int id;
            private String name;
            private int start_age;
            private int end_age;
            private String short_name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getStart_age() {
                return start_age;
            }

            public void setStart_age(int start_age) {
                this.start_age = start_age;
            }

            public int getEnd_age() {
                return end_age;
            }

            public void setEnd_age(int end_age) {
                this.end_age = end_age;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }
        }
    }
}
