package com.telphone;

/**
 * Created by admin on 2016/8/26.
 */
public class CellPhone extends TelPhone implements IPlayGame{
    @Override
    public void call() {
        System.out.println("键盘打电话");
    }

    @Override
    public void message() {
        System.out.println("键盘发信息");
    }

    @Override
    public void playGame() {

    }
}
