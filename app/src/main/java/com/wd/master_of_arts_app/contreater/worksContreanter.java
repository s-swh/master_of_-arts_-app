package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.ListOfWorks;

/**
 * @author 时文豪
 * @description:  作品契约类
 * @date :2020/12/25 13:45
 */
public interface worksContreanter {
    interface IVew extends IBaseView{
        void OnWorks(ListOfWorks listOfWorks);
    }
    interface IPreanter{
        void OnWorksSuccess(String token,String is_comment,int p,int per);
    }
    interface IModel{
        void OnWorksSuccess(String token,String is_comment,int p,int per,OnWorksCoallack onWorksCoallack);
        interface OnWorksCoallack{
            void OnWorks(ListOfWorks listOfWorks);
        }
    }
}
