package com.wd.master_of_arts_app.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author 时文豪
 * @description:  微信
 * @date :2021/1/12 14:55
 */
public class QuZhiFuWeChat {

    /**
     * code : 1
     * msg : 成功
     * payInfo : {"totalAmount":1,"msgType":"wx.appPreOrder","responseTimestamp":"2021-01-20 11:49:56","errCode":"SUCCESS","msgSrc":"WWW.NJYIDAJIA.COM","merName":"南京艺大家桃李网络科技有限公司","mid":"898325148161573","msgId":"","appPayRequest":{"miniuser":"gh_744d2ebca056","package":"Sign=WXPay","minipath":"pages/appPay/index","appid":"wxb7192893995d3c8b","sign":"F06A6087431DA17FC8C901E38F08C9FE","partnerid":"426131619","prepayid":"3ce238cc60044cdd816a025c10300e4d","noncestr":"sPwYxfDKyDlLHWzJzKaERvmLNCNnzWSr","timestamp":"20210120114956"},"tid":"A0348396","merOrderId":"11BB16111145967958","targetSys":"WXPay","sign":"DC03F173B5365BDBE98154FBA6F8D235BE362F3AD70E4E1DA4B4A3112C0CA0E7"}
     */

    private int code;
    private String msg;
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

    public PayInfoBean getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayInfoBean payInfo) {
        this.payInfo = payInfo;
    }

    public static class PayInfoBean {
        /**
         * totalAmount : 1
         * msgType : wx.appPreOrder
         * responseTimestamp : 2021-01-20 11:49:56
         * errCode : SUCCESS
         * msgSrc : WWW.NJYIDAJIA.COM
         * merName : 南京艺大家桃李网络科技有限公司
         * mid : 898325148161573
         * msgId :
         * appPayRequest : {"miniuser":"gh_744d2ebca056","package":"Sign=WXPay","minipath":"pages/appPay/index","appid":"wxb7192893995d3c8b","sign":"F06A6087431DA17FC8C901E38F08C9FE","partnerid":"426131619","prepayid":"3ce238cc60044cdd816a025c10300e4d","noncestr":"sPwYxfDKyDlLHWzJzKaERvmLNCNnzWSr","timestamp":"20210120114956"}
         * tid : A0348396
         * merOrderId : 11BB16111145967958
         * targetSys : WXPay
         * sign : DC03F173B5365BDBE98154FBA6F8D235BE362F3AD70E4E1DA4B4A3112C0CA0E7
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
             * miniuser : gh_744d2ebca056
             * package : Sign=WXPay
             * minipath : pages/appPay/index
             * appid : wxb7192893995d3c8b
             * sign : F06A6087431DA17FC8C901E38F08C9FE
             * partnerid : 426131619
             * prepayid : 3ce238cc60044cdd816a025c10300e4d
             * noncestr : sPwYxfDKyDlLHWzJzKaERvmLNCNnzWSr
             * timestamp : 20210120114956
             */

            private String miniuser;
            @SerializedName("package")
            private String packageX;
            private String minipath;
            private String appid;
            private String sign;
            private String partnerid;
            private String prepayid;
            private String noncestr;
            private String timestamp;

            public String getMiniuser() {
                return miniuser;
            }

            public void setMiniuser(String miniuser) {
                this.miniuser = miniuser;
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
