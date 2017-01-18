package com.mode.strategymode;

import com.mode.strategymode.impl.FlyWithWing;

/**
 * Created by admin on 2016/12/8.
 */
//绿毛鸭
public class MallardDuck extends Duck{

    public MallardDuck(){
        super();
        super.setFlyStrategy(new FlyWithWing());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色");
    }
}
