package com.app;

/**
 * Created by admin on 2016/8/25.
 * 电话对象
 */
public class TelPhone {
    private float screen,cpu,mem;
    final public int price;

    public TelPhone(){
        System.out.print("调用了一个无参的构造方法");
        price = 123123;
    }

    public TelPhone(float newScreen,float newCpu,float newMem){
        if(newScreen < 3.5f){
            System.out.println("你输入的参数有问题，自动赋值3.5");
            newScreen = 3.5f;
        }
        price = 12321;
        this.screen = newScreen;
        this.cpu = newCpu;
        this.mem = newMem;
        System.out.println("调用了一个有参的构造方法");
    }

    public float getScreen(){
        return screen;
    }

    public void setScreen(float screen){
        this.screen = screen;
    }
}
