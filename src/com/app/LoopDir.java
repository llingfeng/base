package com.app;

import java.io.File;

/**
 * Created by admin on 2016/11/1.
 * 遍历文件夹
 */
public class LoopDir {

    public static void listDirectory(File file){
        if(!file.exists())
            System.out.println("该目录不存在");
        if(!file.isDirectory())
            System.out.println(file.getName()+"不是目录");
        File[] fileList = file.listFiles();
        if(fileList != null && fileList.length>0){
            for (File file2 : fileList) {
                if(file2.isDirectory()){
                    listDirectory(file2);
                }else {
                    System.out.println(file2);
                }
            }
        }
    }

    public static void main(String[] args){
        listDirectory(new File("E:\\360downloads"));
    }
}
