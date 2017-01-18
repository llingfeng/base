package com.poker;

/**
 * Created by admin on 2016/8/30.
 */
public class Poker {
    private String point;
    private String color;

    @Override
    public String toString() {
        return color+point;
    }

    public Poker(){

    }

    public Poker(String color,String point){
        this.point = point;
        this.color = color;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
