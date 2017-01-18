package com.mode.agentmode;

/**
 * Created by admin on 2016/12/10.
 */
public class CarLogAgent implements Moveable {
    private Moveable moveable;

    public CarLogAgent(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("开始记录日志");
        moveable.move();
        System.out.println("记录日志结束");
    }
}
