package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 2017/1/9.
 */
public class Server {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        //创建ServerSocket,绑定端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器端即将启动，等待客户端的连接");
        Socket socket = null;
        while (true){
            //监听ServerSocket，等待客户端的连接（阻塞）
            socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
            count++;
            System.out.println("访问次数："+count);
        }
    }
}
