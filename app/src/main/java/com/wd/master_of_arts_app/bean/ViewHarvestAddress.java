package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/19 14:26
 */
public class ViewHarvestAddress {
    /**
     * code : 1
     * msg : 成功
     * data : {"list":[{"id":47,"user_id":54,"province":"河南省","city":"驻马店市","county":"新蔡县","detail_address":"龙口镇龙口村","company":"","consignee":"时文豪","contact_number":"18803652019","postcode":"","is_default":"Y"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 47
             * user_id : 54
             * province : 河南省
             * city : 驻马店市
             * county : 新蔡县
             * detail_address : 龙口镇龙口村
             * company :
             * consignee : 时文豪
             * contact_number : 18803652019
             * postcode :
             * is_default : Y
             */

            private int id;
            private int user_id;
            private String province;
            private String city;
            private String county;
            private String detail_address;
            private String company;
            private String consignee;
            private String contact_number;
            private String postcode;
            private String is_default;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCounty() {
                return county;
            }

            public void setCounty(String county) {
                this.county = county;
            }

            public String getDetail_address() {
                return detail_address;
            }

            public void setDetail_address(String detail_address) {
                this.detail_address = detail_address;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getContact_number() {
                return contact_number;
            }

            public void setContact_number(String contact_number) {
                this.contact_number = contact_number;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }
        }
    }
}
