package com.mode.agentmode.test;

import com.mode.agentmode.Car;
import com.mode.agentmode.Moveable;

/**
 * Created by admin on 2016/12/10.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        InvocationHandlerDemo handlerDemo = new TimeHandler(car);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class,handlerDemo);
        m.move();
    }
}
