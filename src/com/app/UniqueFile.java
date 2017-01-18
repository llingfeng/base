package com.app;

import java.io.*;
import java.util.*;

/**
 * Created by admin on 2016/11/11.
 * 压缩文件
 * 如：aabbccd变成a2b2c3d
 *
 */
public class UniqueFile {

    public static void main(String[] args) {
        try {
            copyFile(new File("demo//a.txt"), new File("demo//c.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File oldFile, File newFile) throws Exception {
        if (!oldFile.exists())
            throw new IllegalArgumentException(oldFile + "不存在");
        if (!oldFile.isFile())
            throw new IllegalArgumentException(oldFile + "不是一个文件");
        InputStreamReader in = new InputStreamReader(new FileInputStream(oldFile));
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(newFile));
        BufferedReader bufR = new BufferedReader(in);
        BufferedWriter brfW = new BufferedWriter(out);
        String temp = "";
        while ((temp = bufR.readLine()) != null) {
            List list = new ArrayList<>();
            String[] arr = temp.split(" ");
            for (String s : arr) {
                list.add(s);
            }
            list.add("");//增加一个元素与最后一个字符串比较
            if (list != null && list.size() > 0) {
                int num = 0;
                for (int i = 0; i < list.size(); i++) {
                    String beforeStr = "";
                    if (i != 0) {
                        beforeStr = list.get(i - 1).toString();
                    }
                    String indexStr = list.get(i).toString();
                    if(indexStr.equals(beforeStr) || i==0){
                        num++;
                    }else {
                        brfW.write(list.get(i - 1).toString() + num + " ");
                        brfW.flush();
                        num = 1;
                    }
                }
            }
            brfW.write("\r\n");
        }
        brfW.close();
        bufR.close();
        out.close();
        in.close();
    }
}
