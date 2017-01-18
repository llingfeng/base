package com.io;

import java.io.IOException;

/**
 * Created by admin on 2016/11/1.
 */
public class Convert2 {

    //int转byte[]
    public static byte[] convertToByte(int id) {
        byte[] bytes = new byte[4];
/*        bytes[0] = (byte) ((id >> 0 * 8) & 0xff);
        bytes[1] = (byte) ((id >> 1 * 8) & 0xff);
        bytes[2] = (byte) ((id >> 2 * 8) & 0xff);
        bytes[3] = (byte) ((id >> 3 * 8) & 0xff);*/
        for(int i=0;i<4;i++){
            bytes[i] = (byte) ((id >> 8*i) & 0xff);
        }
        return bytes;
    }

    //bytes转int
    public static int convertToInt(byte[] bytes) {
//        int rs0 = (bytes[0] & 0xff) << 0 * 8;
//        int rs1 = (bytes[1] & 0xff) << 1 * 8;
//        int rs2 = (bytes[2] & 0xff) << 2 * 8;
//        int rs3 = (bytes[3] & 0xff) << 3 * 8;
        int result = 0;
        for(int i=0;i<4;i++){
            result += (bytes[i] & 0xff) << 8*i;
        }
        return result;
    }

    public static void main(String args[]) throws IOException{
        byte[] bytes = convertToByte(8143);
        System.out.println(bytes[0] + "," + bytes[1] + "," + bytes[2] + "," + bytes[3]);
        int id = convertToInt(bytes);
        System.out.println(id);
        String str = "哈罗，沃德";
        //utf-8下中文占3个字节，英文占一个字节，gbk下中文占2个字节，英文占一个字节，java是双字节编码（utf-16be）,中文默认2个字节，英文默认2个字节
        byte[] bytes1 = str.getBytes("utf-8");
        String str2 = new String(bytes1);
        System.out.println(bytes1.length+"\n"+str2);
        String str3 = new String(new byte[]{bytes1[0],bytes1[1],bytes1[2]});
        System.out.println(str3);
        for (byte b : bytes1) {
            System.out.print(b+" ");
        }
        System.out.println();
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b)+" ");
        }
        System.out.println();
        //字节转16进制输出
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }
    }
}
