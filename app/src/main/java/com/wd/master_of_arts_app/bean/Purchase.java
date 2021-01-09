package com.wd.master_of_arts_app.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/26 16:28
 */
public class Purchase {

    /**
     * code : 1
     * msg : 成功
     * data : {"order_id":"108","order_num":"5ff93483ecd72822","title":"童童创想班A","price":"3840.00"}
     * payInfo : {"totalAmount":1,"msgType":"trade.appPreOrder","responseTimestamp":"2021-01-09 12:43:48","errCode":"SUCCESS","msgSrc":"WWW.TEST.COM","merName":"全渠道","mid":"898310148160568","msgId":"","appPayRequest":{"miniuser":"2019010762862511","msgType":"trade.appPreOrder","package":"Sign=ALI","minipath":"pages/appPay/test/test","appScheme":"iOS:qmfpppay;Android:qmfpppay","sign":"7B24F50825F02617A02FCF6E1ED66676","prepayid":"f0421e192b37402db0953a5dde34ee11","noncestr":"kgzEFwBaeueTNKLRjYtvROlxsbYCkmCy","timestamp":"20210109124348"},"tid":"00000001","merOrderId":"3194201807101655049819","targetSys":"Alipay 2.0","sign":"2879CFEAD02B9F35507C32CB6439E3332049BD360FD933D38CF392A4375AF217"}
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
         * order_id : 108
         * order_num : 5ff93483ecd72822
         * title : 童童创想班A
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
         * msgType : trade.appPreOrder
         * responseTimestamp : 2021-01-09 12:43:48
         * errCode : SUCCESS
         * msgSrc : WWW.TEST.COM
         * merName : 全渠道
         * mid : 898310148160568
         * msgId :
         * appPayRequest : {"miniuser":"2019010762862511","msgType":"trade.appPreOrder","package":"Sign=ALI","minipath":"pages/appPay/test/test","appScheme":"iOS:qmfpppay;Android:qmfpppay","sign":"7B24F50825F02617A02FCF6E1ED66676","prepayid":"f0421e192b37402db0953a5dde34ee11","noncestr":"kgzEFwBaeueTNKLRjYtvROlxsbYCkmCy","timestamp":"20210109124348"}
         * tid : 00000001
         * merOrderId : 3194201807101655049819
         * targetSys : Alipay 2.0
         * sign : 2879CFEAD02B9F35507C32CB6439E3332049BD360FD933D38CF392A4375AF217
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
             * miniuser : 2019010762862511
             * msgType : trade.appPreOrder
             * package : Sign=ALI
             * minipath : pages/appPay/test/test
             * appScheme : iOS:qmfpppay;Android:qmfpppay
             * sign : 7B24F50825F02617A02FCF6E1ED66676
             * prepayid : f0421e192b37402db0953a5dde34ee11
             * noncestr : kgzEFwBaeueTNKLRjYtvROlxsbYCkmCy
             * timestamp : 20210109124348
             */

            private String miniuser;
            private String msgType;
            private String package1;
            private String packageX;
            private String minipath;
            private String appScheme;
            private String sign;
            private String prepayid;
            private String noncestr;
            private String timestamp;

            public String getPackage1() {
                return package1;
            }

            public void setPackage1(String package1) {
                this.package1 = package1;
            }

            public AppPayRequestBean(String package1) {
                this.package1 = package1;
            }

            public String getMiniuser() {
                return miniuser;
            }

            public void setMiniuser(String miniuser) {
                this.miniuser = miniuser;
            }

            public String getMsgType() {
                return msgType;
            }

            public void setMsgType(String msgType) {
                this.msgType = msgType;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getMinipath() {
                return minipath;
            }

            public void setMinipath(String minipath) {
                this.minipath = minipath;
            }

            public String getAppScheme() {
                return appScheme;
            }

            public void setAppScheme(String appScheme) {
                this.appScheme = appScheme;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
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
