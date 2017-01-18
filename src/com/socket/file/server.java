package com.socket.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 2017/1/9.
 */
public class server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8886);
        System.out.println("服务端即将开启");
        Socket socket = serverSocket.accept();
        //字节流
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("app/good.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int len = 0;
        while ((len = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(len);
            bufferedOutputStream.flush();
        }
        socket.shutdownInput();
        fileOutputStream.close();
        inputStream.close();
    }
}
