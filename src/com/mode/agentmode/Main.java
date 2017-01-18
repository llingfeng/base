package com.mode.agentmode;

/**
 * Created by admin on 2016/12/10.
 */
public class Main {

    public static void main(String[] args){
        Car car = new Car();
        CarLogAgent carLogAgent = new CarLogAgent(car);
        CarTimeAgent carTimeAgent =  new CarTimeAgent(carLogAgent);
        carTimeAgent.move();
    }
}
