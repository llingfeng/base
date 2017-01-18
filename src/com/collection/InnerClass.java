package com.collection;

/**
 * Created by admin on 2016/10/30.
 */
public class InnerClass {
    private String str = "abc";
    private static String staticStr = "ccc";

    //成员内部类
    public class Inner{
        String str2 = str+"123";//成员内部类可以直接用外部类的变量
        public void test(){
            System.out.print(str2);
        }
    }

    //静态内部类
    public static class StaticInner{
        String str3 = new InnerClass().str;//静态内部类不能直接使用外部类的非静态变量
        String  staticStr = InnerClass.staticStr;//同名的静态内部类访问外部类
    }

    public void show(){
        //方法内部类，由于方法内部类不能在外部类的方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符
        class MInner {
            int score = 83;
            public int getScore() {
                return score + 10;
            }
        }
    }

    public static void main(String[] args){
        InnerClass demo4 = new InnerClass();
        Inner inner = demo4.new Inner();//访问成员内部类
        inner.test();
        StaticInner staticInner = new StaticInner();//可以直接访问静态内部类
    }
}
