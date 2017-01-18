package com.mode.strategymode;

import com.mode.strategymode.impl.FlyWithWing;

/**
 * Created by admin on 2016/12/8.
 */
//红脖鸭
public class RedheadDuck extends Duck{

    public RedheadDuck() {
        super();
        super.setFlyStrategy(new FlyWithWing());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是红色");
    }
}
