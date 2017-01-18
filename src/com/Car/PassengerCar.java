package com.Car;

/**
 * Created by admin on 2016/8/27.
 * 客车
 */
public class PassengerCar extends Car{
    private int peopleCapacity;//载人容量

    public PassengerCar(String name,float price,int peopleCapacity){
        this.name = name;
        this.price = price;
        this.peopleCapacity = peopleCapacity;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }
}
