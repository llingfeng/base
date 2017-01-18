package com.io;

/**
 * Created by admin on 2016/10/31.
 * 十进制与各进制的相互转换
 */
public class Convert1 {

    public static void main(String[] args){
        //十进制转其他进制
        System.out.println(Integer.toBinaryString(255));//十进制转二进制
        System.out.println(Integer.toHexString(101));//十进制转十六进制
        System.out.println(Integer.toOctalString(101));//十进制转八进制

        //其他进制转十进制
        System.out.println(Integer.parseInt("1100101",2));//二进制转十进制
        System.out.println(Integer.parseInt("23",8));//八进制转十进制
        System.out.println(Integer.parseInt("ff",16));//十六进制转十进制

    }
}
