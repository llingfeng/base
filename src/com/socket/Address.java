package com.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by admin on 2017/1/9.
 */
public class Address {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());//主机名
        System.out.println(address.getHostAddress());//主机地址
        byte[] bytes = address.getAddress();
        System.out.println(Arrays.toString(bytes));
    }
}
