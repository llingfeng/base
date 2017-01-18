package com.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2016/12/3.
 */
public class IOUtilTestMain {

    public static void main(String[] args) throws IOException{
        IOUtil.printHex("app//a.txt");
        System.out.println();
        IOUtil.printHexByteByte("app//a.txt");
        File fileA = new File("app//a.txt");
        File fileB = new File("app//b.txt");
        File fileC = new File("app//c.txt");
        File fileD = new File("app//d.txt");
        File fileE = new File("app//e.txt");
        File fileF = new File("app//f.txt");
        File fileG = new File("app//g.txt");
        IOUtil.copyFile(fileA,fileB);
        IOUtil.copyFileByBuffer(fileB,fileC);
        IOUtil.copyFileByByte(fileC,fileD);
        IOUtil.copyByChar(fileD,fileE);
        IOUtil.copyFileByChar2(fileE,fileF);
        IOUtil.copyFileByString(fileF,fileG);
    }
}
