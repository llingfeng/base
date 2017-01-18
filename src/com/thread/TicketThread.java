package com.thread;

/**
 * Created by admin on 2016/12/7.
 */
public class TicketThread implements Runnable {
    private int ticketSum = 10;

    @Override
    public void run() {
        while (ticketSum > 0) {
            sale();
        }
    }

    public synchronized void sale(){
        if(ticketSum>0){
            ticketSum--;
            System.out.println(Thread.currentThread().getName() + "卖出了一张票，还剩" + ticketSum + "张票");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        Thread t1 = new Thread(ticketThread, "窗口一");
        Thread t2 = new Thread(ticketThread, "窗口二");
        Thread t3 = new Thread(ticketThread, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
