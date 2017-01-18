package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by admin on 2017/1/9.
 */
public class UDPServer {
    private static int count;

    public static void main(String[] args) throws IOException {
        //创建服务器端DatagramSocket,指定接口
        DatagramSocket datagramSocket = new DatagramSocket(8887);
        System.out.println("我是服务器端，即将启动");
        byte[] bytes = new byte[1024];
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            UDPServerThread udpServerThread = new UDPServerThread(datagramSocket, datagramPacket);
            Thread thread = new Thread(udpServerThread);
            thread.start();
            count++;
            System.out.println("登录次数：" + count);
        }
    }
}
