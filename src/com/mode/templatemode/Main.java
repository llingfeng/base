package com.mode.templatemode;

/**
 * Created by admin on 2016/12/12.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("开始泡茶");
        RefreshBeverage tea = new Tea();
        tea.prepareBeverageTemplate();
        System.out.println("茶已泡好");
        System.out.println("**************************");
        System.out.println("开始泡咖啡");
        RefreshBeverage coffer = new Coffer();
        coffer.prepareBeverageTemplate();
        System.out.println("咖啡已泡好");
    }
}
