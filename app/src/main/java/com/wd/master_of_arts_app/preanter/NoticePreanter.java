package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.bean.NoticeDetailsBean;
import com.wd.master_of_arts_app.contreater.NoticeContreanter;
import com.wd.master_of_arts_app.model.MoticeModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 14:10
 */
public class NoticePreanter extends BasePreantert implements NoticeContreanter.IPreanter {

    private MoticeModel moticeModel;

    public NoticePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        moticeModel = new MoticeModel();
    }

    @Override
    public void NoticeViewSuccess(String token) {
        moticeModel.NoticeViewSuccess(token, new NoticeContreanter.IModel.NoticeCoallack() {
            @Override
            public void OnNoticeView(NoticeBean noticeBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof NoticeContreanter.IVew){
                    NoticeContreanter.IVew view= (NoticeContreanter.IVew) iBaseView;
                    view.OnNoticeView(noticeBean);
                }
            }
        });
    }

    @Override
    public void OnNoticeSuccess(String token, int notice_id) {
        moticeModel.OnNoticeSuccess(token, notice_id, new NoticeContreanter.IModel.NoticeBeanCoallack() {
            @Override
            public void OnNoticeBean(NoticeDetailsBean noticeDetailsBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof NoticeContreanter.IVew){
                    NoticeContreanter.IVew vew= (NoticeContreanter.IVew) iBaseView;
                    vew.OnNoticeBean(noticeDetailsBean);
                }
            }
        });
    }

    @Override
    public void OnNoticeNumberSuccess(String token) {
        moticeModel.NoticeViewSuccess(token, new NoticeContreanter.IModel.NoticeCoallack() {
            @Override
            public void OnNoticeView(NoticeBean noticeBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof NoticeContreanter.IVew){
                    NoticeContreanter.IVew vew= (NoticeContreanter.IVew) iBaseView;
                    vew.OnNoticeView(noticeBean);
                }
            }
        });
    }
}
