package com.thread.Army;

/**
 * Created by admin on 2016/12/7.
 */
//舞台
public class Stage extends Thread{
    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋唐末年，隋军与农民起义军杀的昏天暗地...");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋朝军队");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军队");

        //启动线程，开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣，半路杀出个程咬金");

        Thread mrCheng = new KeyPerson();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想的结束战争，人民安居乐业");

        //军队停止战斗
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //历史大戏留给关键人物
        mrCheng.start();

        //万众瞩目，所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，人民安居乐业，成先生实现了积极的人生理想，为人民做出了贡献");
        System.out.println("隋唐演义结束，谢谢大家观看");
    }

    public static void main(String[] args){
        new Stage().start();
    }
}
