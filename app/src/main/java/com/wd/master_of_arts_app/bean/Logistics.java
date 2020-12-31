package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/30 9:34
 */
public class Logistics {

    /**
     * code : 1
     * msg : 成功
     * data : {"logisticsMsg":{"company":"申通","com":"sto","no":"773074720163585","status":"1","status_detail":null,"list":[{"datetime":"2020-12-21 21:11:27","remark":"【广东省商品部一部】的收件员【刘红冰】已收件","zone":""},{"datetime":"2020-12-22 08:04:02","remark":"快件已到达【广东增城转运中心】扫描员是【装车狂扫45】","zone":""},{"datetime":"2020-12-22 08:11:50","remark":"快件由【广东增城转运中心】发往【江苏南京转运中心】","zone":""},{"datetime":"2020-12-22 21:08:45","remark":"快件已到达【广东增城转运中心】扫描员是【装车狂扫46】","zone":""},{"datetime":"2020-12-22 21:22:34","remark":"快件由【广东增城转运中心】发往【江苏南京转运中心】","zone":""},{"datetime":"2020-12-24 04:27:41","remark":"快件已到达【江苏南京转运中心】扫描员是【祁小群】","zone":""},{"datetime":"2020-12-24 04:41:29","remark":"快件由【江苏南京转运中心】发往【江苏南京孝陵卫公司】","zone":""},{"datetime":"2020-12-24 09:22:49","remark":"快件已到达【江苏南京小卫街营业部】扫描员是【卞发源】","zone":""},{"datetime":"2020-12-24 09:30:07","remark":"【江苏南京小卫街营业部】的派件员【卞发源】正在为您派件，如有疑问请联系派件员，联系电话【18852306195】","zone":""},{"datetime":"2020-12-24 12:41:04","remark":"已签收，签收人是【其他第三方代签】,如有疑问请联系:18852306195,风里来，雨里去，汗也撒泪也流，申通小哥一刻不停留。不求服务惊天下，但求好评动我心，给个好评呗！！","zone":""}]}}
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
         * logisticsMsg : {"company":"申通","com":"sto","no":"773074720163585","status":"1","status_detail":null,"list":[{"datetime":"2020-12-21 21:11:27","remark":"【广东省商品部一部】的收件员【刘红冰】已收件","zone":""},{"datetime":"2020-12-22 08:04:02","remark":"快件已到达【广东增城转运中心】扫描员是【装车狂扫45】","zone":""},{"datetime":"2020-12-22 08:11:50","remark":"快件由【广东增城转运中心】发往【江苏南京转运中心】","zone":""},{"datetime":"2020-12-22 21:08:45","remark":"快件已到达【广东增城转运中心】扫描员是【装车狂扫46】","zone":""},{"datetime":"2020-12-22 21:22:34","remark":"快件由【广东增城转运中心】发往【江苏南京转运中心】","zone":""},{"datetime":"2020-12-24 04:27:41","remark":"快件已到达【江苏南京转运中心】扫描员是【祁小群】","zone":""},{"datetime":"2020-12-24 04:41:29","remark":"快件由【江苏南京转运中心】发往【江苏南京孝陵卫公司】","zone":""},{"datetime":"2020-12-24 09:22:49","remark":"快件已到达【江苏南京小卫街营业部】扫描员是【卞发源】","zone":""},{"datetime":"2020-12-24 09:30:07","remark":"【江苏南京小卫街营业部】的派件员【卞发源】正在为您派件，如有疑问请联系派件员，联系电话【18852306195】","zone":""},{"datetime":"2020-12-24 12:41:04","remark":"已签收，签收人是【其他第三方代签】,如有疑问请联系:18852306195,风里来，雨里去，汗也撒泪也流，申通小哥一刻不停留。不求服务惊天下，但求好评动我心，给个好评呗！！","zone":""}]}
         */

        private LogisticsMsgBean logisticsMsg;

        public LogisticsMsgBean getLogisticsMsg() {
            return logisticsMsg;
        }

        public void setLogisticsMsg(LogisticsMsgBean logisticsMsg) {
            this.logisticsMsg = logisticsMsg;
        }

        public static class LogisticsMsgBean {
            /**
             * company : 申通
             * com : sto
             * no : 773074720163585
             * status : 1
             * status_detail : null
             * list : [{"datetime":"2020-12-21 21:11:27","remark":"【广东省商品部一部】的收件员【刘红冰】已收件","zone":""},{"datetime":"2020-12-22 08:04:02","remark":"快件已到达【广东增城转运中心】扫描员是【装车狂扫45】","zone":""},{"datetime":"2020-12-22 08:11:50","remark":"快件由【广东增城转运中心】发往【江苏南京转运中心】","zone":""},{"datetime":"2020-12-22 21:08:45","remark":"快件已到达【广东增城转运中心】扫描员是【装车狂扫46】","zone":""},{"datetime":"2020-12-22 21:22:34","remark":"快件由【广东增城转运中心】发往【江苏南京转运中心】","zone":""},{"datetime":"2020-12-24 04:27:41","remark":"快件已到达【江苏南京转运中心】扫描员是【祁小群】","zone":""},{"datetime":"2020-12-24 04:41:29","remark":"快件由【江苏南京转运中心】发往【江苏南京孝陵卫公司】","zone":""},{"datetime":"2020-12-24 09:22:49","remark":"快件已到达【江苏南京小卫街营业部】扫描员是【卞发源】","zone":""},{"datetime":"2020-12-24 09:30:07","remark":"【江苏南京小卫街营业部】的派件员【卞发源】正在为您派件，如有疑问请联系派件员，联系电话【18852306195】","zone":""},{"datetime":"2020-12-24 12:41:04","remark":"已签收，签收人是【其他第三方代签】,如有疑问请联系:18852306195,风里来，雨里去，汗也撒泪也流，申通小哥一刻不停留。不求服务惊天下，但求好评动我心，给个好评呗！！","zone":""}]
             */

            private String company;
            private String com;
            private String no;
            private String status;
            private Object status_detail;
            private List<ListBean> list;

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getCom() {
                return com;
            }

            public void setCom(String com) {
                this.com = com;
            }

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getStatus_detail() {
                return status_detail;
            }

            public void setStatus_detail(Object status_detail) {
                this.status_detail = status_detail;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * datetime : 2020-12-21 21:11:27
                 * remark : 【广东省商品部一部】的收件员【刘红冰】已收件
                 * zone :
                 */

                private String datetime;
                private String remark;
                private String zone;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getZone() {
                    return zone;
                }

                public void setZone(String zone) {
                    this.zone = zone;
                }
            }
        }
    }
}
