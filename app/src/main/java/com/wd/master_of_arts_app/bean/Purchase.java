package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/26 16:28
 */
public class Purchase {

    /**
     * code : 1
     * msg : 成功
     * data : {"order_id":"241","order_num":"5ffc1b91e1399714","title":"蒙蒙童画班","price":"3840.00"}
     * payInfo : {"msgType":"trade.precreate","connectSys":"ALIPAY","msgSrc":"WWW.TEST.COM","delegatedFlag":"N","merName":"全渠道","mid":"898310148160568","msgId":"","appPayRequest":{"msgType":"trade.precreate","qrCode":"https://qr.alipay.com/bax09843olenltf2jjnk20dd"},"settleRefId":"00875302381N","tid":"00000001","totalAmount":1,"qrCode":"https://qr.alipay.com/bax09843olenltf2jjnk20dd","targetMid":"2015061000120322","responseTimestamp":"2021-01-11 17:34:10","errCode":"SUCCESS","targetStatus":"10000","seqId":"00875302381N","merOrderId":"3194201807101655048781","status":"NEW_ORDER","targetSys":"Alipay 2.0","sign":"C6C6C9E567C0D67C7218D5ABBD32F71E1A9BCD44BD81B994EE8896933BA8FE5F"}
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
         * order_id : 241
         * order_num : 5ffc1b91e1399714
         * title : 蒙蒙童画班
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
         * msgType : trade.precreate
         * connectSys : ALIPAY
         * msgSrc : WWW.TEST.COM
         * delegatedFlag : N
         * merName : 全渠道
         * mid : 898310148160568
         * msgId :
         * appPayRequest : {"msgType":"trade.precreate","qrCode":"https://qr.alipay.com/bax09843olenltf2jjnk20dd"}
         * settleRefId : 00875302381N
         * tid : 00000001
         * totalAmount : 1
         * qrCode : https://qr.alipay.com/bax09843olenltf2jjnk20dd
         * targetMid : 2015061000120322
         * responseTimestamp : 2021-01-11 17:34:10
         * errCode : SUCCESS
         * targetStatus : 10000
         * seqId : 00875302381N
         * merOrderId : 3194201807101655048781
         * status : NEW_ORDER
         * targetSys : Alipay 2.0
         * sign : C6C6C9E567C0D67C7218D5ABBD32F71E1A9BCD44BD81B994EE8896933BA8FE5F
         */

        private String msgType;
        private String connectSys;
        private String msgSrc;
        private String delegatedFlag;
        private String merName;
        private String mid;
        private String msgId;
        private AppPayRequestBean appPayRequest;
        private String settleRefId;
        private String tid;
        private int totalAmount;
        private String qrCode;
        private String targetMid;
        private String responseTimestamp;
        private String errCode;
        private String targetStatus;
        private String seqId;
        private String merOrderId;
        private String status;
        private String targetSys;
        private String sign;

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public String getConnectSys() {
            return connectSys;
        }

        public void setConnectSys(String connectSys) {
            this.connectSys = connectSys;
        }

        public String getMsgSrc() {
            return msgSrc;
        }

        public void setMsgSrc(String msgSrc) {
            this.msgSrc = msgSrc;
        }

        public String getDelegatedFlag() {
            return delegatedFlag;
        }

        public void setDelegatedFlag(String delegatedFlag) {
            this.delegatedFlag = delegatedFlag;
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

        public String getSettleRefId() {
            return settleRefId;
        }

        public void setSettleRefId(String settleRefId) {
            this.settleRefId = settleRefId;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getTargetMid() {
            return targetMid;
        }

        public void setTargetMid(String targetMid) {
            this.targetMid = targetMid;
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

        public String getTargetStatus() {
            return targetStatus;
        }

        public void setTargetStatus(String targetStatus) {
            this.targetStatus = targetStatus;
        }

        public String getSeqId() {
            return seqId;
        }

        public void setSeqId(String seqId) {
            this.seqId = seqId;
        }

        public String getMerOrderId() {
            return merOrderId;
        }

        public void setMerOrderId(String merOrderId) {
            this.merOrderId = merOrderId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
             * msgType : trade.precreate
             * qrCode : https://qr.alipay.com/bax09843olenltf2jjnk20dd
             */

            private String msgType;
            private String qrCode;

            public String getMsgType() {
                return msgType;
            }

            public void setMsgType(String msgType) {
                this.msgType = msgType;
            }

            public String getQrCode() {
                return qrCode;
            }

            public void setQrCode(String qrCode) {
                this.qrCode = qrCode;
            }
        }
    }
}
