package com.socket.sockapp.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 2017/1/10.
 */
public class StartServer {

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            System.out.println("服务即将启动，等待客户端连接");
            while (true){
                socket = serverSocket.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
