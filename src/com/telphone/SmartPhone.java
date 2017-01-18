package com.telphone;

/**
 * Created by admin on 2016/8/26.
 */
public class SmartPhone extends TelPhone implements IPlayGame{
    @Override
    public void call() {
        System.out.println("语音打电话");
    }

    @Override
    public void message() {
        System.out.println("语音发信息");
    }

    @Override
    public void playGame() {
        System.out.println("手机玩游戏");
    }
}
