package com.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by admin on 2016/12/3.
 */
public class Random {

    public static void main(String[] args) throws IOException{
        File dir = new File("app");
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File("app","a.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        System.out.println(raf.getFilePointer());
        char s = 'A';
        raf.write(s);
        System.out.println(raf.getFilePointer());
        String str = "中国";
        byte[] bytes = str.getBytes("gbk");
        raf.write(bytes);
        System.out.println(raf.getFilePointer());
        raf.write('B');
        //读文件必须把指针移动文件头部
        //raf.seek(0);
        raf.seek(1);
        byte[] buff = new byte[(int) raf.length()];
        raf.read(buff,1,4);
        String s1 = new String(buff,"gbk");
        System.out.println(s1);
    }
}
