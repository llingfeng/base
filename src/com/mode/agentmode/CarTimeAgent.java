package com.mode.agentmode;

/**
 * Created by admin on 2016/12/10.
 */
public class CarTimeAgent implements Moveable{
    private Moveable moveable;

    public CarTimeAgent(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long beginTiming = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        moveable.move();
        System.out.println("汽车结束行驶");
        long endTiming = System.currentTimeMillis();
        System.out.println("汽车行驶的时间为："+(endTiming-beginTiming)+"毫秒");
    }
}
