package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/29 14:34
 */
public class CourseOrderBean {

    /**
     * code : 1
     * msg : 成功
     * data : {"orderMsg":{"province":"北京市","city":"北京市","county":"东城区","address":"123123","consignee":"123","contact_number":"13612312838","logistics":null,"express_number":null,"order_num":"5fe58bc97b665372","create_time":"2020-12-25 14:50:49","allprice":"5000.00","pay_price":"0.00","pay_time":null,"title":"童童创想班A","course_time_id":213,"course_id":76,"status":1,"pay_method":"","course_detail":{"course_name":"童童创想班A","icon":"http://test.54artist.com/public/upload/http://test.54artist.com/public/upload/course/20201229/e5c8a7149ca9e6fdf82004e07af44706.jpg","is_send":"Y","mark":[{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}],"service":[{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}],"teacher_name":"谭老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","time_detail":"每周一、二上课","first_class_time":"20:00:00","first_class_date":"2020-12-05"}}}
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
         * orderMsg : {"province":"北京市","city":"北京市","county":"东城区","address":"123123","consignee":"123","contact_number":"13612312838","logistics":null,"express_number":null,"order_num":"5fe58bc97b665372","create_time":"2020-12-25 14:50:49","allprice":"5000.00","pay_price":"0.00","pay_time":null,"title":"童童创想班A","course_time_id":213,"course_id":76,"status":1,"pay_method":"","course_detail":{"course_name":"童童创想班A","icon":"http://test.54artist.com/public/upload/http://test.54artist.com/public/upload/course/20201229/e5c8a7149ca9e6fdf82004e07af44706.jpg","is_send":"Y","mark":[{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}],"service":[{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}],"teacher_name":"谭老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","time_detail":"每周一、二上课","first_class_time":"20:00:00","first_class_date":"2020-12-05"}}
         */

        private OrderMsgBean orderMsg;

        public OrderMsgBean getOrderMsg() {
            return orderMsg;
        }

        public void setOrderMsg(OrderMsgBean orderMsg) {
            this.orderMsg = orderMsg;
        }

        public static class OrderMsgBean {
            /**
             * province : 北京市
             * city : 北京市
             * county : 东城区
             * address : 123123
             * consignee : 123
             * contact_number : 13612312838
             * logistics : null
             * express_number : null
             * order_num : 5fe58bc97b665372
             * create_time : 2020-12-25 14:50:49
             * allprice : 5000.00
             * pay_price : 0.00
             * pay_time : null
             * title : 童童创想班A
             * course_time_id : 213
             * course_id : 76
             * status : 1
             * pay_method : 
             * course_detail : {"course_name":"童童创想班A","icon":"http://test.54artist.com/public/upload/http://test.54artist.com/public/upload/course/20201229/e5c8a7149ca9e6fdf82004e07af44706.jpg","is_send":"Y","mark":[{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}],"service":[{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}],"teacher_name":"谭老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","time_detail":"每周一、二上课","first_class_time":"20:00:00","first_class_date":"2020-12-05"}
             */

            private String province;
            private String city;
            private String county;
            private String address;
            private String consignee;
            private String contact_number;
            private String logistics;
            private String express_number;
            private String order_num;
            private String create_time;
            private String allprice;
            private String pay_price;
            private String pay_time;
            private String title;
            private int course_time_id;
            private int course_id;
            private int status;
            private String pay_method;
            private CourseDetailBean course_detail;

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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getLogistics() {
                return logistics;
            }

            public void setLogistics(String logistics) {
                this.logistics = logistics;
            }

            public String getExpress_number() {
                return express_number;
            }

            public void setExpress_number(String express_number) {
                this.express_number = express_number;
            }

            public String getOrder_num() {
                return order_num;
            }

            public void setOrder_num(String order_num) {
                this.order_num = order_num;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getAllprice() {
                return allprice;
            }

            public void setAllprice(String allprice) {
                this.allprice = allprice;
            }

            public String getPay_price() {
                return pay_price;
            }

            public void setPay_price(String pay_price) {
                this.pay_price = pay_price;
            }

            public String getPay_time() {
                return pay_time;
            }

            public void setPay_time(String pay_time) {
                this.pay_time = pay_time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCourse_time_id() {
                return course_time_id;
            }

            public void setCourse_time_id(int course_time_id) {
                this.course_time_id = course_time_id;
            }

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getPay_method() {
                return pay_method;
            }

            public void setPay_method(String pay_method) {
                this.pay_method = pay_method;
            }

            public CourseDetailBean getCourse_detail() {
                return course_detail;
            }

            public void setCourse_detail(CourseDetailBean course_detail) {
                this.course_detail = course_detail;
            }

            public static class CourseDetailBean {
                /**
                 * course_name : 童童创想班A
                 * icon : http://test.54artist.com/public/upload/http://test.54artist.com/public/upload/course/20201229/e5c8a7149ca9e6fdf82004e07af44706.jpg
                 * is_send : Y
                 * mark : [{"id":2,"mark":"配套学习资料","description":"根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄","icon":"http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png"}]
                 * service : [{"id":1,"service":"直播授课","description":"直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png"},{"id":2,"service":"小班教学","description":"每班人数不超过六人，自主研发高效绘画课程，高品质小班在线教学，老师与学生面对面直接互动、交流，让孩子爱上绘画。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/d68261dbd18608cea9c89844552f4d87.png"},{"id":3,"service":"配套学习资料","description":"高品质自主研发学习资料，全面配套直播课学习及课堂巩固。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/72e61b6401eb93cf7c4958cdabdb1d1b.png"},{"id":4,"service":"学习报告","description":"直播课学习效果如何？完成作业即可得到老师点评，用大数据全面剖析，给出针对性提升建议。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/54a2ba9a12e8b19273e93f5873cf5758.png"},{"id":5,"service":"随时看回放","description":"每讲直播课程结束后 30 分钟后，即可生成回放，只要课程在有效期内，您就可以通过手机 App 随时多次观看视频回放，课程有效期为课程结束一年内。","icon":"http://test.54artist.com/public/upload/course/mark/20200919/1e8bd7423eef10f863ea98468836d087.png"}]
                 * teacher_name : 谭老师
                 * teacher_avatar : http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png
                 * time_detail : 每周一、二上课
                 * first_class_time : 20:00:00
                 * first_class_date : 2020-12-05
                 */

                private String course_name;
                private String icon;
                private String is_send;
                private String teacher_name;
                private String teacher_avatar;
                private String time_detail;
                private String first_class_time;
                private String first_class_date;
                private List<MarkBean> mark;
                private List<ServiceBean> service;

                public String getCourse_name() {
                    return course_name;
                }

                public void setCourse_name(String course_name) {
                    this.course_name = course_name;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getIs_send() {
                    return is_send;
                }

                public void setIs_send(String is_send) {
                    this.is_send = is_send;
                }

                public String getTeacher_name() {
                    return teacher_name;
                }

                public void setTeacher_name(String teacher_name) {
                    this.teacher_name = teacher_name;
                }

                public String getTeacher_avatar() {
                    return teacher_avatar;
                }

                public void setTeacher_avatar(String teacher_avatar) {
                    this.teacher_avatar = teacher_avatar;
                }

                public String getTime_detail() {
                    return time_detail;
                }

                public void setTime_detail(String time_detail) {
                    this.time_detail = time_detail;
                }

                public String getFirst_class_time() {
                    return first_class_time;
                }

                public void setFirst_class_time(String first_class_time) {
                    this.first_class_time = first_class_time;
                }

                public String getFirst_class_date() {
                    return first_class_date;
                }

                public void setFirst_class_date(String first_class_date) {
                    this.first_class_date = first_class_date;
                }

                public List<MarkBean> getMark() {
                    return mark;
                }

                public void setMark(List<MarkBean> mark) {
                    this.mark = mark;
                }

                public List<ServiceBean> getService() {
                    return service;
                }

                public void setService(List<ServiceBean> service) {
                    this.service = service;
                }

                public static class MarkBean {
                    /**
                     * id : 2
                     * mark : 配套学习资料
                     * description : 根据课程内容配套画材用品、纸质版学习资料，画材用品、纸质版学习资料全国免费邮寄
                     * icon : http://test.54artist.com/public/upload/course/mark/20200919/6c477e3558925941c7313942ac9f5507.png
                     */

                    private int id;
                    private String mark;
                    private String description;
                    private String icon;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getMark() {
                        return mark;
                    }

                    public void setMark(String mark) {
                        this.mark = mark;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }
                }

                public static class ServiceBean {
                    /**
                     * id : 1
                     * service : 直播授课
                     * description : 直播课上边讲课边进行板书与示范。画板和画材可随时给学生直播技能操作演示，随时互动随时反馈，给学生更好的学习体验。
                     * icon : http://test.54artist.com/public/upload/course/mark/20200919/23fa0072a22896b1a7d891b935e0a4ff.png
                     */

                    private int id;
                    private String service;
                    private String description;
                    private String icon;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getService() {
                        return service;
                    }

                    public void setService(String service) {
                        this.service = service;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }
                }
            }
        }
    }
}
