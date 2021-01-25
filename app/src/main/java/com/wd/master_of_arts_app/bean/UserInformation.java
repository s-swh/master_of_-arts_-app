package com.wd.master_of_arts_app.bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/19 16:08
 */
public class UserInformation {


    /**
     * code : 1
     * msg : 成功
     * data : {"user_msg":{"uid":27,"group_id":1,"group_name":"普通会员","username":"13921903472","phone":"13921903472","email":" ","balance":"0.00","point":0,"exp":0,"expiration_date":"","auth_code":"271817","is_share_vip":"N","is_complete_info":"N","referrer_id":0,"star":0,"r_nickname":""},"user_detail":{"id":27,"user_id":27,"nickname":"13921903472","avatar":"","truename":"","sex":1,"height":"","weight":" ","blood":0,"birthday":null,"qq":" ","weixin":" ","province":"","city":"","county":"","detail_address":" ","signature":" ","age":0}}
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
         * user_msg : {"uid":27,"group_id":1,"group_name":"普通会员","username":"13921903472","phone":"13921903472","email":" ","balance":"0.00","point":0,"exp":0,"expiration_date":"","auth_code":"271817","is_share_vip":"N","is_complete_info":"N","referrer_id":0,"star":0,"r_nickname":""}
         * user_detail : {"id":27,"user_id":27,"nickname":"13921903472","avatar":"","truename":"","sex":1,"height":"","weight":" ","blood":0,"birthday":null,"qq":" ","weixin":" ","province":"","city":"","county":"","detail_address":" ","signature":" ","age":0}
         */

        private UserMsgBean user_msg;
        private UserDetailBean user_detail;

        public UserMsgBean getUser_msg() {
            return user_msg;
        }

        public void setUser_msg(UserMsgBean user_msg) {
            this.user_msg = user_msg;
        }

        public UserDetailBean getUser_detail() {
            return user_detail;
        }

        public void setUser_detail(UserDetailBean user_detail) {
            this.user_detail = user_detail;
        }

        public static class UserMsgBean {
            /**
             * uid : 27
             * group_id : 1
             * group_name : 普通会员
             * username : 13921903472
             * phone : 13921903472
             * email :
             * balance : 0.00
             * point : 0
             * exp : 0
             * expiration_date :
             * auth_code : 271817
             * is_share_vip : N
             * is_complete_info : N
             * referrer_id : 0
             * star : 0
             * r_nickname :
             */

            private int uid;
            private int group_id;
            private String group_name;
            private String username;
            private String phone;
            private String email;
            private String balance;
            private int point;
            private int exp;
            private String expiration_date;
            private String auth_code;
            private String is_share_vip;
            private String is_complete_info;
            private int referrer_id;
            private int star;
            private String r_nickname;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getGroup_id() {
                return group_id;
            }

            public void setGroup_id(int group_id) {
                this.group_id = group_id;
            }

            public String getGroup_name() {
                return group_name;
            }

            public void setGroup_name(String group_name) {
                this.group_name = group_name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public int getPoint() {
                return point;
            }

            public void setPoint(int point) {
                this.point = point;
            }

            public int getExp() {
                return exp;
            }

            public void setExp(int exp) {
                this.exp = exp;
            }

            public String getExpiration_date() {
                return expiration_date;
            }

            public void setExpiration_date(String expiration_date) {
                this.expiration_date = expiration_date;
            }

            public String getAuth_code() {
                return auth_code;
            }

            public void setAuth_code(String auth_code) {
                this.auth_code = auth_code;
            }

            public String getIs_share_vip() {
                return is_share_vip;
            }

            public void setIs_share_vip(String is_share_vip) {
                this.is_share_vip = is_share_vip;
            }

            public String getIs_complete_info() {
                return is_complete_info;
            }

            public void setIs_complete_info(String is_complete_info) {
                this.is_complete_info = is_complete_info;
            }

            public int getReferrer_id() {
                return referrer_id;
            }

            public void setReferrer_id(int referrer_id) {
                this.referrer_id = referrer_id;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public String getR_nickname() {
                return r_nickname;
            }

            public void setR_nickname(String r_nickname) {
                this.r_nickname = r_nickname;
            }
        }

        public static class UserDetailBean {
            /**
             * id : 27
             * user_id : 27
             * nickname : 13921903472
             * avatar :
             * truename :
             * sex : 1
             * height :
             * weight :
             * blood : 0
             * birthday : null
             * qq :
             * weixin :
             * province :
             * city :
             * county :
             * detail_address :
             * signature :
             * age : 0
             */

            private int id;
            private int user_id;
            private String nickname;
            private String avatar;
            private String truename;
            private int sex;
            private String height;
            private String weight;
            private int blood;
            private String birthday;
            private String qq;
            private String weixin;
            private String province;
            private String city;
            private String county;
            private String detail_address;
            private String signature;
            private int age;

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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getTruename() {
                return truename;
            }

            public void setTruename(String truename) {
                this.truename = truename;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public int getBlood() {
                return blood;
            }

            public void setBlood(int blood) {
                this.blood = blood;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
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

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
    }
}
