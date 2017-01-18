package com.Exception;

/**
 * Created by admin on 2016/8/29.
 */
public class Test {

    public static void main(String[] args){
        Test test = new Test();
        try {
            test.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test1() throws DrunkException{
        throw new DrunkException("别喝酒");
    }

    public void test2(){
        try {
            test1();
        } catch (Exception e) {
            RuntimeException newDrunk = new RuntimeException("司机一滴酒，家人两滴泪～～");
            newDrunk.initCause(e);
            throw newDrunk;
        }
    }
}
