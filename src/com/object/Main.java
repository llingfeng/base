package com.object;

/**
 * Created by admin on 2016/8/26.
 */
public class Main {

    public static void main(String[] args){
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.setAge(12);
        dog2.setAge(12);
        if(dog1.equals(dog2))
            System.out.print("两个对象是相同的");
        else
            System.out.print("两个对象是不相同的");
    }

}
