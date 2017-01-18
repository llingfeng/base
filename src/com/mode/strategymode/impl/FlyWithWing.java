package com.mode.strategymode.impl;

import com.mode.strategymode.FlyStrategy;

/**
 * Created by admin on 2016/12/8.
 */
public class FlyWithWing implements FlyStrategy{
    @Override
    public void performFly() {
        System.out.println("用翅膀飞行...");
    }
}
