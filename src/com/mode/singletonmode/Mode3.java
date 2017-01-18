package com.mode.singletonmode;

/**
 * Created by admin on 2016/12/8.
 */
//懒汉模式线程安全版
public class Mode3 {

    private static MySingleton mySingleton;

    private Mode3() {
    }

    public static MySingleton newInstance() {
        if (mySingleton == null) {
            synchronized (MySingleton.class){
                if(mySingleton == null){
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }
}
