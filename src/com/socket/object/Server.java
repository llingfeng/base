package com.socket.object;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 2017/1/10.
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8887);
        System.out.println("服务器正在启动...");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        User user = (User) ois.readObject();
        System.out.println("用户名："+user.getName());

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(user);

        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    }
}
