package com.mode.templatemode;

/**
 * Created by admin on 2016/12/12.
 */
public abstract class RefreshBeverage {

    /**
     * 准备模板
     */
    public final void prepareBeverageTemplate(){
        //把水煮沸
        boilWater();
        //泡饮料
        brew();
        //把饮料倒入杯中
        pourInCup();
        //加调味品
        if(isAddCondiments()){
            addCondiments();
        }
    }

    protected boolean isAddCondiments(){
        return true;
    };

    protected abstract void addCondiments() ;

    private void pourInCup() {
        System.out.println("倒入杯中");
    }

    protected abstract void brew() ;

    private void boilWater() {
        System.out.println("把水煮沸");
    }
}
