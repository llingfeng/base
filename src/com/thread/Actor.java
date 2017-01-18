package com.thread;

/**
 * Created by admin on 2016/12/7.
 */
public class Actor extends Thread {

    @Override
    public void run() {
        int count = 0;
        boolean keepRunning = true;
        System.out.println(getName() + "是一个演员");
        while (keepRunning) {
            System.out.println(getName() + "登台演出" + (++count));
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count == 100) {
                keepRunning = false;
            }
        }
        System.out.println(getName() + "结束演出了!");
    }

    public static void main(String args[]) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();
        Thread actress = new Thread(new Actress(),"Ms.Runable");
        actress.start();
    }
}

class Actress implements Runnable{

    @Override
    public void run() {
        int count = 0;
        boolean keepRunning = true;
        System.out.println(Thread.currentThread().getName() + "是一个演员");
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "登台演出" + (++count));
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count == 100) {
                keepRunning = false;
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束演出了!");
    }
}
