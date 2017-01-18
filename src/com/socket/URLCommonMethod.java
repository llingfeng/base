package com.socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 2017/1/9.
 */
public class URLCommonMethod {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        //获取字节流
        InputStream inputStream = url.openStream();
        //字节流转化成字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        //添加缓存，增加效率
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        while (s != null) {
            System.out.println(s);
            s = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
