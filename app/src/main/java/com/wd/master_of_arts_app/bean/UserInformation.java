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
     * data : {"user_msg":{"uid":54,"group_id":1,"group_name":"普通会员","username":null,"phone":"18803652019","email":null,"balance":"0.00","point":0,"exp":0,"expiration_date":"","auth_code":"978256","is_share_vip":"N","is_complete_info":"N","referrer_id":null,"star":0,"r_nickname":""},"user_detail":{"id":54,"user_id":54,"nickname":null,"avatar":"http://test.54artist.com/public/upload/user/avatar/20201219/454be4a20f179bf28a59fc2a681b2884.jpg","truename":null,"sex":0,"height":null,"weight":null,"blood":0,"birthday":null,"qq":null,"weixin":null,"province":null,"city":null,"county":null,"detail_address":null,"signature":null}}
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
         * user_msg : {"uid":54,"group_id":1,"group_name":"普通会员","username":null,"phone":"18803652019","email":null,"balance":"0.00","point":0,"exp":0,"expiration_date":"","auth_code":"978256","is_share_vip":"N","is_complete_info":"N","referrer_id":null,"star":0,"r_nickname":""}
         * user_detail : {"id":54,"user_id":54,"nickname":null,"avatar":"http://test.54artist.com/public/upload/user/avatar/20201219/454be4a20f179bf28a59fc2a681b2884.jpg","truename":null,"sex":0,"height":null,"weight":null,"blood":0,"birthday":null,"qq":null,"weixin":null,"province":null,"city":null,"county":null,"detail_address":null,"signature":null}
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
             * uid : 54
             * group_id : 1
             * group_name : 普通会员
             * username : null
             * phone : 18803652019
             * email : null
             * balance : 0.00
             * point : 0
             * exp : 0
             * expiration_date :
             * auth_code : 978256
             * is_share_vip : N
             * is_complete_info : N
             * referrer_id : null
             * star : 0
             * r_nickname :
             */

            private int uid;
            private int group_id;
            private String group_name;
            private Object username;
            private String phone;
            private Object email;
            private String balance;
            private int point;
            private int exp;
            private String expiration_date;
            private String auth_code;
            private String is_share_vip;
            private String is_complete_info;
            private Object referrer_id;
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

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
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

            public Object getReferrer_id() {
                return referrer_id;
            }

            public void setReferrer_id(Object referrer_id) {
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
             * id : 54
             * user_id : 54
             * nickname : null
             * avatar : http://test.54artist.com/public/upload/user/avatar/20201219/454be4a20f179bf28a59fc2a681b2884.jpg
             * truename : null
             * sex : 0
             * height : null
             * weight : null
             * blood : 0
             * birthday : null
             * qq : null
             * weixin : null
             * province : null
             * city : null
             * county : null
             * detail_address : null
             * signature : null
             */

            private int id;
            private int user_id;
            private Object nickname;
            private String avatar;
            private Object truename;
            private int sex;
            private Object height;
            private Object weight;
            private int blood;
            private Object birthday;
            private Object qq;
            private Object weixin;
            private Object province;
            private Object city;
            private Object county;
            private Object detail_address;
            private Object signature;

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

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public Object getTruename() {
                return truename;
            }

            public void setTruename(Object truename) {
                this.truename = truename;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public Object getHeight() {
                return height;
            }

            public void setHeight(Object height) {
                this.height = height;
            }

            public Object getWeight() {
                return weight;
            }

            public void setWeight(Object weight) {
                this.weight = weight;
            }

            public int getBlood() {
                return blood;
            }

            public void setBlood(int blood) {
                this.blood = blood;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getWeixin() {
                return weixin;
            }

            public void setWeixin(Object weixin) {
                this.weixin = weixin;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getCounty() {
                return county;
            }

            public void setCounty(Object county) {
                this.county = county;
            }

            public Object getDetail_address() {
                return detail_address;
            }

            public void setDetail_address(Object detail_address) {
                this.detail_address = detail_address;
            }

            public Object getSignature() {
                return signature;
            }

            public void setSignature(Object signature) {
                this.signature = signature;
            }
        }
    }
}
