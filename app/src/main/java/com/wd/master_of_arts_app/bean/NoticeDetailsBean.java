package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 15:41
 */
public class NoticeDetailsBean {
    /**
     * code : 1
     * msg : 成功
     * data : {"noticeMsg":{"id":1,"n_key":1,"n_value":"","title":"全体通知","content":"快来上课哦 要迟到了","create_time":"2021-01-03 15:55:52"}}
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
         * noticeMsg : {"id":1,"n_key":1,"n_value":"","title":"全体通知","content":"快来上课哦 要迟到了","create_time":"2021-01-03 15:55:52"}
         */

        private NoticeMsgBean noticeMsg;

        public NoticeMsgBean getNoticeMsg() {
            return noticeMsg;
        }

        public void setNoticeMsg(NoticeMsgBean noticeMsg) {
            this.noticeMsg = noticeMsg;
        }

        public static class NoticeMsgBean {
            /**
             * id : 1
             * n_key : 1
             * n_value :
             * title : 全体通知
             * content : 快来上课哦 要迟到了
             * create_time : 2021-01-03 15:55:52
             */

            private int id;
            private int n_key;
            private String n_value;
            private String title;
            private String content;
            private String create_time;

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
        }
    }
}
