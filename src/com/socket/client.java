package com.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by admin on 2017/1/9.
 */
public class client {

    public static void main(String[] args) throws IOException {
        //创建socket,执行目标服务器地址和端口
        Socket socket = new Socket("127.0.0.1", 8888);
        //获取输出流往服务器发送消息
        OutputStream outputStream = socket.getOutputStream();
        //将输出流包装为打印流
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("用户名：admin;密码：123");
        printWriter.flush();//调用flush方法将缓存输出
        socket.shutdownOutput();//关闭输出流

        //接收服务器端的请求
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = null;
        if((data = bufferedReader.readLine()) != null){
            System.out.println("我是客户端："+data);
        }
        socket.shutdownInput();;
        //关闭资源
        socket.close();
    }
}
