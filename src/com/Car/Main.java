package com.Car;

import java.util.Scanner;

/**
 * Created by admin on 2016/8/27.
 */
public class Main {

    public static void main(String[] args){
        Car[] cars = {new PassengerCar("奥迪A4",500,4),new PassengerCar("马自达6",400,4),new TruckCar("松花江",1000,20),
                new TruckCar("雪铁龙",1000,20),new PickupCar("皮卡雪",200,2,10)};
        System.out.println("欢迎使用搭搭租车系统:");
        System.out.println("您是否要租车?(1-是,2-否)");
        String flag;
        Scanner input = new Scanner(System.in);
        do{
            flag = input.next();
            if(!(flag.equals("1")||flag.equals("2"))){
                System.out.println("输入不合法，请重新输入");
            }
        }while (!(flag.equals("1") || flag.equals("2")));
        if(flag.equals("2")){
            System.out.println("欢迎下次使用!");
        }else{
            System.out.println("您可租车的类型及其价目表:");
            System.out.println();
            System.out.println("序号\t汽车名称\t价格\t容量");
            for(int i=0;i<cars.length;i++){
                Car car = cars[i];
                int num = i+1;
                if(car instanceof PassengerCar){
                    PassengerCar passengerCar = (PassengerCar) car;
                    System.out.println(num+":\t"+passengerCar.getName()+"\t"+passengerCar.getPrice()+"元/天\t载客:"+passengerCar.getPeopleCapacity());
                }
                if(car instanceof TruckCar){
                    TruckCar truckCar = (TruckCar) car;
                    System.out.println(num+":\t"+truckCar.getName()+"\t"+truckCar.getPrice()+"元/天\t载物:"+truckCar.getGoodsCapacity());
                }
                if(car instanceof PickupCar){
                    PickupCar pickupCar = (PickupCar) car;
                    System.out.println(num+":\t"+pickupCar.getName()+"\t"+pickupCar.getPrice()+"元/天\t载客:"+pickupCar.getPeopleCapacity()+" 载物:"+pickupCar.getGoodsCapacity());
                }
            }
            System.out.println("请选择要租车的数量:");
            int num = input.nextInt();
            Car[] needCar = new Car[num];
            for(int i=0;i<num;i++){
                int order = i+1;
                System.out.print("请输入第"+order+"辆的序号:");
                int chooseNum = input.nextInt();
                needCar[i] = cars[chooseNum-1];
            }
            System.out.print("请输入要租的天数:");
            int days = input.nextInt();
            System.out.println("您租车的账单如下:");
            int totalPeople = 0;
            double totalGoods = 0;
            double totalPrice = 0;
            String peopleName = "",goodsName = "";
            for(int i=0;i<num;i++){
                Car car = needCar[i];
                totalPrice += car.getPrice();
                if(car instanceof PassengerCar){
                    PassengerCar passengerCar = (PassengerCar) car;
                    peopleName += passengerCar.getName()+" ";
                    totalPeople += passengerCar.getPeopleCapacity();
                }
                if(car instanceof PickupCar){
                    PickupCar pickupCar = (PickupCar) car;
                    peopleName += pickupCar.getName()+" ";
                    goodsName += pickupCar.getName()+" ";
                    totalPeople += pickupCar.getPeopleCapacity();
                    totalGoods += pickupCar.getGoodsCapacity();
                }
                if(car instanceof TruckCar){
                    TruckCar truckCar = (TruckCar) car;
                    goodsName += truckCar.getName()+" ";
                    totalGoods += truckCar.getGoodsCapacity();
                }
            }
            System.out.println("可载人的车:\n"+peopleName+"\t共载人:"+totalPeople);
            System.out.println("可载物的车:\n"+goodsName+"\t共载人:"+totalGoods);
            System.out.println("租车总价格:"+totalPrice*days);
        }
    }
}
