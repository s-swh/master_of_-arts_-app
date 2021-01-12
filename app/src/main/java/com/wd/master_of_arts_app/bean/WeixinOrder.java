package com.wd.master_of_arts_app.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/12 10:17
 */
public class WeixinOrder {
    /**
     * code : 1
     * msg : 成功
     * data : {"order_id":"250","order_num":"5ffd069e51c93479","title":"童童创想班B","price":"3840.00"}
     * payInfo : {"totalAmount":1,"msgType":"wx.appPreOrder","responseTimestamp":"2021-01-12 10:17:02","errCode":"SUCCESS","msgSrc":"WWW.TEST.COM","merName":"网银个人商户","mid":"898440165133308","msgId":"","appPayRequest":{"package":"Sign=WXPay","appid":"wxb7192893995d3c8b","sign":"D1A553ADBD509A12BC32A31A7B18C693","partnerid":"399477649","prepayid":"10c09baa4d6c4b3ea0c5346329e4356f","noncestr":"rWMgMnADbJsMoKHFLFoyKfBOEFNwudYp","timestamp":"20210112101702"},"tid":"00000001","merOrderId":"3194201807101655041975","targetSys":"WXPay","sign":"D8749E627DFE7DEF5E6FB004CCAF431E652A42EC51DFB1373447A66AA24C5C03"}
     */

    private int code;
    private String msg;
    private DataBean data;
    private PayInfoBean payInfo;

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

    public PayInfoBean getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayInfoBean payInfo) {
        this.payInfo = payInfo;
    }

    public static class DataBean {
        /**
         * order_id : 250
         * order_num : 5ffd069e51c93479
         * title : 童童创想班B
         * price : 3840.00
         */

        private String order_id;
        private String order_num;
        private String title;
        private String price;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public static class PayInfoBean {
        /**
         * totalAmount : 1
         * msgType : wx.appPreOrder
         * responseTimestamp : 2021-01-12 10:17:02
         * errCode : SUCCESS
         * msgSrc : WWW.TEST.COM
         * merName : 网银个人商户
         * mid : 898440165133308
         * msgId :
         * appPayRequest : {"package":"Sign=WXPay","appid":"wxb7192893995d3c8b","sign":"D1A553ADBD509A12BC32A31A7B18C693","partnerid":"399477649","prepayid":"10c09baa4d6c4b3ea0c5346329e4356f","noncestr":"rWMgMnADbJsMoKHFLFoyKfBOEFNwudYp","timestamp":"20210112101702"}
         * tid : 00000001
         * merOrderId : 3194201807101655041975
         * targetSys : WXPay
         * sign : D8749E627DFE7DEF5E6FB004CCAF431E652A42EC51DFB1373447A66AA24C5C03
         */

        private int totalAmount;
        private String msgType;
        private String responseTimestamp;
        private String errCode;
        private String msgSrc;
        private String merName;
        private String mid;
        private String msgId;
        private AppPayRequestBean appPayRequest;
        private String tid;
        private String merOrderId;
        private String targetSys;
        private String sign;

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public String getResponseTimestamp() {
            return responseTimestamp;
        }

        public void setResponseTimestamp(String responseTimestamp) {
            this.responseTimestamp = responseTimestamp;
        }

        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public String getMsgSrc() {
            return msgSrc;
        }

        public void setMsgSrc(String msgSrc) {
            this.msgSrc = msgSrc;
        }

        public String getMerName() {
            return merName;
        }

        public void setMerName(String merName) {
            this.merName = merName;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public AppPayRequestBean getAppPayRequest() {
            return appPayRequest;
        }

        public void setAppPayRequest(AppPayRequestBean appPayRequest) {
            this.appPayRequest = appPayRequest;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getMerOrderId() {
            return merOrderId;
        }

        public void setMerOrderId(String merOrderId) {
            this.merOrderId = merOrderId;
        }

        public String getTargetSys() {
            return targetSys;
        }

        public void setTargetSys(String targetSys) {
            this.targetSys = targetSys;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public static class AppPayRequestBean {
            /**
             * package : Sign=WXPay
             * appid : wxb7192893995d3c8b
             * sign : D1A553ADBD509A12BC32A31A7B18C693
             * partnerid : 399477649
             * prepayid : 10c09baa4d6c4b3ea0c5346329e4356f
             * noncestr : rWMgMnADbJsMoKHFLFoyKfBOEFNwudYp
             * timestamp : 20210112101702
             */

            @SerializedName("package")
            private String packageX;
            private String appid;
            private String sign;
            private String partnerid;
            private String prepayid;
            private String noncestr;
            private String timestamp;




            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }


        }
    }
}
