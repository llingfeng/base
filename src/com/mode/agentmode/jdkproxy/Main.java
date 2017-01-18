package com.mode.agentmode.jdkproxy;

import com.mode.agentmode.Car;
import com.mode.agentmode.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by admin on 2016/12/10.
 */
public class Main {
    public static void main(String[] args){
        Car car = new Car();
        Class<?> cla = car.getClass();
        InvocationHandler handler = new TimeHandler(car);
        /**
         * loader类加载器
         * interfaces接口
         * handler
         */
        Moveable moveable = (Moveable) Proxy.newProxyInstance(cla.getClassLoader(), cla.getInterfaces(), handler);
        moveable.move();
    }
}
