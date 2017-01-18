package com.socket.file;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by admin on 2017/1/9.
 */
public class client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8886);
        OutputStream out = socket.getOutputStream();
        File file = new File("app/one.jpg");
        if (!file.isFile()) {
            System.out.println("不是文件");
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] buff = new byte[fis.available()];
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(buff);
        out.write(buff);
        socket.shutdownOutput();
        socket.close();
    }
}
