package com.mode.strategymode;

/**
 * Created by admin on 2016/12/8.
 */
public abstract class Duck {

    /**
     * 鸭子发出叫声
     * 通用行为，由超类实现
     */
    public void quack(){
        System.out.println("嘎嘎嘎");
    }

    /**
     * 鸭子外观
     * 外观各有不同，声明为abstract,由子类实现
     */
    public abstract void display();

    private FlyStrategy flyStrategy;

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    /**
     * 飞行方式
     */
    public void fly(){
        flyStrategy.performFly();
    }
}
