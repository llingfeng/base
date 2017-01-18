package com.mode.agentmode.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by admin on 2016/12/10.
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long beginTiming = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        method.invoke(target);
        System.out.println("汽车结束行驶");
        long endTiming = System.currentTimeMillis();
        System.out.println("汽车行驶的时间为："+(endTiming-beginTiming)+"毫秒");
        return null;
    }
}
