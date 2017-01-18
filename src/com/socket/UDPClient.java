package com.socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by admin on 2017/1/9.
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {
        //定义服务器地址，端口，数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8887;
        byte[] data = "用户名：admin,密码：123".getBytes();
        //创建数据报，包含发送的消息
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, port);
        //创建DatagramSocket
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);

        //接收消息
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket2);
        String data2 = new String(bytes,0,datagramPacket2.getLength());
        System.out.println("我是客户端，服务端说："+data2);
    }
}
