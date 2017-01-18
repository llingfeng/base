package com.mode.strategymode;

/**
 * Created by admin on 2016/12/8.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("测试鸭子程序开始");
        Duck duck1 = new MallardDuck();
        duck1.display();
        duck1.quack();
        duck1.fly();
        System.out.println("测试鸭子结束");
    }
}
