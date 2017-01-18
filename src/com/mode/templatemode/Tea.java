package com.mode.templatemode;

/**
 * Created by admin on 2016/12/12.
 */
public class Tea extends RefreshBeverage {
    @Override
    protected boolean isAddCondiments() {
        return false;
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入柠檬");
    }

    @Override
    protected void brew() {
        System.out.println("加入茶叶，泡制5分钟");
    }
}
