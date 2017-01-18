package com.mode.factorymode;

/**
 * Created by admin on 2016/12/8.
 */
public class Main {

    public static void main(String[] args){
        /*HairInterface leftHair = new LeftHair();
        leftHair.draw();
        HairInterface rightHair = new RightHair();
        rightHair.draw();*/
        HairFactory hairFactory = new HairFactory();
//        hairFactory.getHair("left").draw();
//        hairFactory.getHairByClass("com.mode.factorymode.RightHair").draw();
        hairFactory.getHairByName("left").draw();
    }
}
