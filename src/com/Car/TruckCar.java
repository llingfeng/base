package com.Car;

/**
 * Created by admin on 2016/8/27.
 * 货车
 */
public class TruckCar extends Car{

    private double goodsCapacity;//货物容量

    public TruckCar(String name,float price,double goodsCapacity){
        this.name = name;
        this.price = price;
        this.goodsCapacity = goodsCapacity;
    }

    public double getGoodsCapacity() {
        return goodsCapacity;
    }

    public void setGoodsCapacity(double goodsCapacity) {
        this.goodsCapacity = goodsCapacity;
    }
}
