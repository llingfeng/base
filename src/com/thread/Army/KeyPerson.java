package com.thread.Army;

/**
 * Created by admin on 2016/12/7.
 */
//关键人物
public class KeyPerson extends Thread {
    @Override
    public void run() {
        System.out.println("关键人物闪亮登场");
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "向隋军发起了" + (i+1) + "次进攻");
        }
        System.out.println("关键人物结束战斗");
    }
}
