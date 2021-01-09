package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.NoticeBean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 14:07
 */
public interface NoticeContreanter {
    interface IVew extends IBaseView{
        void OnNoticeView(NoticeBean noticeBean);
    }
    interface IPreanter{
        void NoticeViewSuccess(String token);
    }
    interface IModel{
        void NoticeViewSuccess(String token,NoticeCoallack coallack);
        interface NoticeCoallack{
            void OnNoticeView(NoticeBean noticeBean);
        }
    }
}
