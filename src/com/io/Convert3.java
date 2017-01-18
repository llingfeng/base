package com.io;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/1/11.
 */
public class Convert3 {

    public static void main(String[] args) {
        String str = "你好";
        strToBinary(str);
        binaryToStr("11100100 10111101 10100000 11100101 10100101 10111101");
    }

    /**
     * 字符串转二进制
     *
     * @param str
     */
    public static void strToBinary(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(Integer.toBinaryString(bytes[i] & 0xff));
        }
    }

    /**
     * 二进制转字符串
     * @param binary
     */
    public static void binaryToStr(String binary){
        List<String> stringList = new ArrayList<>();
        while (!"".equals(binary.trim())){
            String bin = binary.substring(0,8);
            stringList.add(bin);
            binary = binary.substring(8).trim();
        }
        byte[] a = new byte[stringList.size()];
        for(int i=0;i<stringList.size();i++){
            a[i] = (byte) Integer.parseInt(stringList.get(i),2);
        }
        String s = null;
        try {
            s = new String(a,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}

