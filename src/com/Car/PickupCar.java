package com.Car;

/**
 * Created by admin on 2016/8/27.
 * 皮卡
 */
public class PickupCar extends Car{
    private int peopleCapacity;//载人容量
    private double goodsCapacity;//货物容量

    public PickupCar(String name,float price,int peopleCapacity,double goodsCapacity){
        this.name = name;
        this.price = price;
        this.peopleCapacity = peopleCapacity;
        this.goodsCapacity = goodsCapacity;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public double getGoodsCapacity() {
        return goodsCapacity;
    }

    public void setGoodsCapacity(double goodsCapacity) {
        this.goodsCapacity = goodsCapacity;
    }
}
