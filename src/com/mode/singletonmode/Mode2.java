package com.mode.singletonmode;

/**
 * Created by admin on 2016/12/8.
 */
//懒汉模式，线程不安全
public class Mode2 {
    private static MySingleton mySingleton;

    private Mode2() {
    }

    public static MySingleton newInstance() {
        if (mySingleton == null) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}
