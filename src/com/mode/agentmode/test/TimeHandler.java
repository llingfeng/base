package com.mode.agentmode.test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 2016/12/11.
 */
public class TimeHandler implements InvocationHandlerDemo {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object object, Method method) {
        try {
            long beginTiming = System.currentTimeMillis();
            System.out.println("汽车开始行驶");
            method.invoke(target);
            System.out.println("汽车结束行驶");
            long endTiming = System.currentTimeMillis();
            System.out.println("汽车行驶的时间为："+(endTiming-beginTiming)+"毫秒");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
