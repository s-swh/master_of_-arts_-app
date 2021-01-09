package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.bean.NoticeDetailsBean;
import com.wd.master_of_arts_app.bean.NoticeNumBer;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 14:07
 */
public interface NoticeContreanter {
    interface IVew extends IBaseView{
        //通知
        void OnNoticeView(NoticeBean noticeBean);
        //通知详情
        void OnNoticeBean(NoticeDetailsBean noticeDetailsBean);
        //通知数量
        void OnNoticeNumber(NoticeNumBer noticeNumBer);
    }
    interface IPreanter{
        //通知
        void NoticeViewSuccess(String token);
        //通知详情
        void OnNoticeSuccess(String token,int notice_id);
        //通知数量
        void OnNoticeNumberSuccess(String token);
    }
    interface IModel{
        //通知
        void NoticeViewSuccess(String token,NoticeCoallack coallack);
        interface NoticeCoallack{
            void OnNoticeView(NoticeBean noticeBean);
        }
        //通知详情
        void OnNoticeSuccess(String token,int notice_id,NoticeBeanCoallack coallack);
        interface NoticeBeanCoallack{
            void OnNoticeBean(NoticeDetailsBean noticeDetailsBean);
        }
        //通知数量
        void OnNoticeNumberSuccess(String token,NoTiceNumberCoallack coallack);
        interface NoTiceNumberCoallack{
            void OnNoticeNumber(NoticeNumBer noticeNumBer);
        }
    }
}
