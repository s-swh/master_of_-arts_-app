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
     * data : {"list":{"total":2,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":2,"n_key":1,"n_value":"","title":"上课通知","content":"来","create_time":"2021-01-03 16:15:00","is_read":"N"},{"id":1,"n_key":1,"n_value":"","title":"全体通知","content":"快来上课哦 要迟到了","create_time":"2021-01-03 15:55:52","is_read":"N"}]}}
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
         * list : {"total":2,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":2,"n_key":1,"n_value":"","title":"上课通知","content":"来","create_time":"2021-01-03 16:15:00","is_read":"N"},{"id":1,"n_key":1,"n_value":"","title":"全体通知","content":"快来上课哦 要迟到了","create_time":"2021-01-03 15:55:52","is_read":"N"}]}
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
             * data : [{"id":2,"n_key":1,"n_value":"","title":"上课通知","content":"来","create_time":"2021-01-03 16:15:00","is_read":"N"},{"id":1,"n_key":1,"n_value":"","title":"全体通知","content":"快来上课哦 要迟到了","create_time":"2021-01-03 15:55:52","is_read":"N"}]
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
                 * id : 2
                 * n_key : 1
                 * n_value :
                 * title : 上课通知
                 * content : 来
                 * create_time : 2021-01-03 16:15:00
                 * is_read : N
                 */

                private int id;
                private int n_key;
                private String n_value;
                private String title;
                private String content;
                private String create_time;
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
