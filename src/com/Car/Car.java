package com.Car;

/**
 * Created by admin on 2016/8/27.
 */
public abstract class Car {

    public String name;//车的类型
    public float price;//租金(元/天)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
