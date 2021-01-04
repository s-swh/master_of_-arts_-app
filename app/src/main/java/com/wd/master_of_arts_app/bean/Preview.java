package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/4 15:29
 */
public class Preview {
    /**
     * code : 1
     * msg : 成功
     * data : {"unit_name":"瓶子里的收藏","pre_content":"<p>预习内容<\/p><p><img src=\"https://t7.baidu.com/it/u=2701208059,2978966657&fm=193&f=GIF\"/><\/p>"}
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
         * unit_name : 瓶子里的收藏
         * pre_content : <p>预习内容</p><p><img src="https://t7.baidu.com/it/u=2701208059,2978966657&fm=193&f=GIF"/></p>
         */

        private String unit_name;
        private String pre_content;

        public String getUnit_name() {
            return unit_name;
        }

        public void setUnit_name(String unit_name) {
            this.unit_name = unit_name;
        }

        public String getPre_content() {
            return pre_content;
        }

        public void setPre_content(String pre_content) {
            this.pre_content = pre_content;
        }
    }
}
