package com.wd.master_of_arts_app.bean;

import java.util.List;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/18 15:27
 */
public class CourseList {
    /**
     * code : 1
     * msg : 成功
     * data : {"list":{"total":10,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":224,"course_id":79,"course_name":"童童创想班B","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":null,"unit_count":48},{"id":223,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":215,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","unit_count":25},{"id":213,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"谭老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","time_detail":"每周一、二上课","unit_count":25},{"id":221,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","unit_count":25},{"id":218,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":216,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":214,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25},{"id":220,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25},{"id":217,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25}]}}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * list : {"total":10,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":224,"course_id":79,"course_name":"童童创想班B","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":null,"unit_count":48},{"id":223,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":215,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","unit_count":25},{"id":213,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"谭老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","time_detail":"每周一、二上课","unit_count":25},{"id":221,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","unit_count":25},{"id":218,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":216,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":214,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25},{"id":220,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25},{"id":217,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25}]}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total : 10
             * per_page : 10
             * current_page : 1
             * last_page : 1
             * data : [{"id":224,"course_id":79,"course_name":"童童创想班B","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":null,"unit_count":48},{"id":223,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":215,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","unit_count":25},{"id":213,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"谭老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/f5a447bc3a2f824516f8e971323f9362.png","time_detail":"每周一、二上课","unit_count":25},{"id":221,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"孙老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png","time_detail":"每周一、二上课","unit_count":25},{"id":218,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":216,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"艺老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/d2473b036d4f0e7d1bde1552e9e29556.jpg","time_detail":"每周一、二上课","unit_count":25},{"id":214,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25},{"id":220,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25},{"id":217,"course_id":76,"course_name":"童童创想班A","old_price":"5800","price":"5000.00","teacher_name":"殷老师","teacher_avatar":"http://test.54artist.com/public/upload/teacher/20201218/b082ae8d248078bc9a78924fff2b60a9.png","time_detail":"每周一、二上课","unit_count":25}]
             */

            private int total;
            private int per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * id : 224
                 * course_id : 79
                 * course_name : 童童创想班B
                 * old_price : 5800
                 * price : 5000.00
                 * teacher_name : 孙老师
                 * teacher_avatar : http://test.54artist.com/public/upload/teacher/20201218/787c815f70acbcdc6256826c21d6b109.png
                 * time_detail : null
                 * unit_count : 48
                 */

                private int id;
                private int course_id;
                private String course_name;
                private String old_price;
                private String price;
                private String teacher_name;
                private String teacher_avatar;
                private Object time_detail;
                private int unit_count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getCourse_id() {
                    return course_id;
                }

                public void setCourse_id(int course_id) {
                    this.course_id = course_id;
                }

                public String getCourse_name() {
                    return course_name;
                }

                public void setCourse_name(String course_name) {
                    this.course_name = course_name;
                }

                public String getOld_price() {
                    return old_price;
                }

                public void setOld_price(String old_price) {
                    this.old_price = old_price;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
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

                public Object getTime_detail() {
                    return time_detail;
                }

                public void setTime_detail(Object time_detail) {
                    this.time_detail = time_detail;
                }

                public int getUnit_count() {
                    return unit_count;
                }

                public void setUnit_count(int unit_count) {
                    this.unit_count = unit_count;
                }
            }
        }
    }
}
