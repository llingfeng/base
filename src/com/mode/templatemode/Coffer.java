package com.mode.templatemode;

/**
 * Created by admin on 2016/12/12.
 */
public class Coffer extends RefreshBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("加入牛奶");
    }

    @Override
    protected void brew() {
        System.out.println("加入咖啡");
    }
}
