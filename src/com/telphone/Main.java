package com.telphone;

/**
 * Created by admin on 2016/8/26.
 */
public class Main {
    public  static void main(String[] args){
        TelPhone telPhone1 = new CellPhone();
        TelPhone telPhone2 = new SmartPhone();
        telPhone1.call();
        telPhone1.message();
        telPhone2.call();
        telPhone2.message();

        IPlayGame playGame1 = new SmartPhone();
        IPlayGame playGame2 = new Psp();
        playGame1.playGame();
        playGame2.playGame();

        IPlayGame playGame3 = new IPlayGame() {
            @Override
            public void playGame() {
                System.out.println("匿名内部类玩游戏1");
            }
        };
        playGame3.playGame();
        new IPlayGame(){

            @Override
            public void playGame() {
                System.out.println("匿名内部类玩游戏2");
            }
        }.playGame();
    }
}
