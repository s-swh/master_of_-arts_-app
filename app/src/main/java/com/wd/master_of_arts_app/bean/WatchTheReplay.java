package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/11 11:59
 */
public class WatchTheReplay {
    /**
     * code : 1
     * msg : 成功
     * data : {"live_url":"https://wwwr.plaso.cn/static/sdk/styleupime/5.00/?appType=player&meetingId=956&recordId=5ffac3cac16e2aa253000fd2&appId=ydjwx&validBegin=1610337043&validTime=3600&beginTime=1610337043&signature=33DC88ED7FE584644726D15A2F59E66762CE3CBF"}
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
         * live_url : https://wwwr.plaso.cn/static/sdk/styleupime/5.00/?appType=player&meetingId=956&recordId=5ffac3cac16e2aa253000fd2&appId=ydjwx&validBegin=1610337043&validTime=3600&beginTime=1610337043&signature=33DC88ED7FE584644726D15A2F59E66762CE3CBF
         */

        private String live_url;


        public String getLive_url() {
            return live_url;
        }

        public void setLive_url(String live_url) {
            this.live_url = live_url;
        }
    }
}
