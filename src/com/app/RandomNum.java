package com.app;

import java.util.Random;

/**
 * Created by admin on 2016/10/30.
 * 随机字符串
 */
public class RandomNum {

    private static final String str = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890";

    public static void main(String[] args){
        RandomNum randomNum = new RandomNum();
        Random random = new Random();
        for(int i=0;i<10;i++){
            int num;
            do{
                num = random.nextInt(11);
            }while (num != 10);
            String str = randomNum.getStr(num);
            System.out.println(str);
        }
    }

    /**
     * 随机字符串
     * @param num
     * @return
     */
    public String getStr(int num){
        int strLen = str.length();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<num;i++){
            stringBuilder.append(str.charAt(random.nextInt(strLen)));
        }
        return stringBuilder.toString();
    }
}
