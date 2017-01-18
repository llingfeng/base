package com.mode.singletonmode;

/**
 * Created by admin on 2016/12/8.
 */
public class Main {

    public static void main(String args[]){
        MySingleton mySingleton1 = Mode1.newInstance();
        MySingleton mySingleton2 = Mode1.newInstance();
        System.out.println(mySingleton1==mySingleton2);//true
        MySingleton mySingleton3 = Mode2.newInstance();
        MySingleton mySingleton4 = Mode2.newInstance();
        System.out.println(mySingleton3==mySingleton4);//true
        MySingleton mySingleton5 = Mode3.newInstance();
        MySingleton mySingleton6 = Mode3.newInstance();
        System.out.println(mySingleton5==mySingleton6);//true
    }
}
