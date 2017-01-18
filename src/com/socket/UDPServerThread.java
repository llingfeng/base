package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by admin on 2017/1/9.
 */
public class UDPServerThread implements Runnable{
    private DatagramSocket datagramSocket = null;
    private DatagramPacket datagramPacket = null;

    public UDPServerThread(DatagramSocket datagramSocket,DatagramPacket datagramPacket) {
        this.datagramSocket = datagramSocket;
        this.datagramPacket = datagramPacket;
    }


    @Override
    public void run() {
        try {
            String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("我是服务器端，客户端说：" + data);

            //响应客户端的消息
            InetAddress address = datagramPacket.getAddress();
            int port = datagramPacket.getPort();
            byte[] bytes2 = "欢迎你".getBytes();
            DatagramPacket datagramPacket2 = new DatagramPacket(bytes2, bytes2.length, address, port);
            datagramSocket.send(datagramPacket2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
