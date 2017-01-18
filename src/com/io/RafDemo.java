package com.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by admin on 2016/11/1.
 * RandomAccessFile基础知识
 */
public class RafDemo {

    public static void main(String[] args) throws IOException{
        File filePackage = new File("demo");
        if(!filePackage.exists())
            filePackage.mkdir();
        File file = new File(filePackage,"a.txt");
        if(!file.exists())
            file.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        int num = 99999;
        raf.write(num >>> 24);
        raf.write(num >>> 16);
        raf.write(num >>> 8);
        raf.write(num);
        System.out.println(raf.length());
//        raf.writeInt(123);

        String s = "中";
        byte[] bytes = s.getBytes("utf-8");
        raf.write(bytes);

        //读取文件
        raf.seek(0);//指针先移动到文件开头
        byte[] bytes2 = new byte[(int) raf.length()];
        raf.read(bytes2);
        System.out.print(Arrays.toString(bytes2));
        System.out.println();
        //十六进制输出
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) +" ");
        }
    }
}
