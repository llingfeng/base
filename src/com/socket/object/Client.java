package com.socket.object;

import java.io.*;
import java.net.Socket;

/**
 * Created by admin on 2017/1/10.
 */
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8887);
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        User user = new User();
        user.setName("jack");
        user.setPassword("123");
        oos.writeObject(user);
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        user = (User) ois.readObject();
        System.out.println("密码:"+user.getPassword());
        socket.shutdownInput();

        socket.close();
    }

}
