package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/5 13:48
 */
public class LiveBoradCast {
    /**
     * code : 1
     * msg : 成功
     * data : {"live_url":"appType=liveclassSDK&userType=listener&meetingType=private&mediaType=video&meetingId=120&cloudDisk=true&loginName=10&topic=%E7%93%B6%E8%8A%B1&recordTime=&appId=ydjwx&validBegin=1609825685&validTime=3600&beginTime=1609825685&signature=70492194CBE066AA5195D2C5E321E5AEBA0B47B7"}
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
         * live_url : appType=liveclassSDK&userType=listener&meetingType=private&mediaType=video&meetingId=120&cloudDisk=true&loginName=10&topic=%E7%93%B6%E8%8A%B1&recordTime=&appId=ydjwx&validBegin=1609825685&validTime=3600&beginTime=1609825685&signature=70492194CBE066AA5195D2C5E321E5AEBA0B47B7
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
