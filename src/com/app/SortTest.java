package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2016/8/30.
 * sort排序
 */
public class SortTest {

    public static void main(String[] args){
        SortTest test = new SortTest();
        test.sort3();
    }

    public void sort1(){
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            int num = 0;
            do{
                num = random.nextInt(100);
            }while (num != 0);
            integerList.add(num);
        }
        System.out.println("--------------排序前----------------");
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
        Collections.sort(integerList);
        System.out.println("--------------排序后----------------");
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }

    public void sort2(){
        List<String> strList = new ArrayList<>();
        strList.add("microsoft");
        strList.add("google");
        strList.add("lenove");
        System.out.println("--------------排序前----------------");
        for (String s : strList) {
            System.out.println(s);
        }
        Collections.sort(strList);
        System.out.println("--------------排序后----------------");
        for (String s : strList) {
            System.out.println(s);
        }
    }

    //生产随机数
    public String getRandomString(int num){
        Random random = new Random();
        String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<num;i++){
            newStr.append(str.charAt(random.nextInt(str.length())));
        }
        return newStr.toString();
    }

    public void sort3(){
        Random random = new Random();
        List<String> strList = new ArrayList<>();
        for(int i=0;i<10;i++){
            String str = "";
            do{
                str = getRandomString(random.nextInt(10)+1);
            }while (strList.contains(str));
            strList.add(str);
        }
        System.out.println("-----------排序前--------------");
        for (String s : strList) {
            System.out.println(s);
        }
        Collections.sort(strList);
        System.out.println("-----------排序后--------------");
        for (String s : strList) {
            System.out.println(s);
        }
    }

}
