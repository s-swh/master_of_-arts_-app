package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MoreComm;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 8:57
 */
public interface MoreContreanter {
    interface IView extends IBaseView{
        void OnMore(MoreComm moreComm);
    }
    interface IPreanter{
        void OnMoreSuccess(int course_id,int p,int per);
    }
    interface IModel{
        void OnMoreSuccess(int course_id,int p,int per,MoreCoallack coallack);
        interface MoreCoallack{
            void OnMore(MoreComm moreComm);
        }
    }
}
