package com.mode.agentmode;


import java.util.Random;

/**
 * Created by admin on 2016/12/10.
 */
public class Car implements Moveable{
    @Override
    public void move() {
        System.out.println("汽车正在行驶...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
