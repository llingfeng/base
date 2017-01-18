package com.mode.singletonmode;

/**
 * Created by admin on 2016/12/8.
 */
//饿汉模式,线程安全
public class Mode1 {
    //静态修饰符，类加载时实例化singleton对象
    private static MySingleton singleton = new MySingleton();

    //私有化修饰符，不让别的对象实例化
    private Mode1() {
    }

    //封装
    public static MySingleton newInstance(){
        return singleton;
    }
    ;
}
