package com.wd.master_of_arts_app.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 10:29
 */
public class CustomTabEntityDemo implements CustomTabEntity {
    private String tab;
    private int SelectedIcon;
    private int TabUnselectedIcon;

    public CustomTabEntityDemo(String tab, int selectedIcon, int tabUnselectedIcon) {
        this.tab = tab;
        SelectedIcon = selectedIcon;
        TabUnselectedIcon = tabUnselectedIcon;
    }

    @Override
    public String getTabTitle() {
        return tab;
    }

    @Override
    public int getTabSelectedIcon() {
        return SelectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return TabUnselectedIcon;
    }
}
