package com.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by admin on 2017/1/9.
 */
public class ServerThread implements Runnable {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            //通过输入流获取客户端发送过来的请求信息
            inputStream = socket.getInputStream();
            //转换成字符流
            inputStreamReader = new InputStreamReader(inputStream);
            //添加缓存，提高效率
            bufferedReader = new BufferedReader(inputStreamReader);
            String data = null;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println("我是服务器,客户端说：" + data);
            }
            socket.shutdownInput();//关闭输入流

            //服务器端向客户端响应请求
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("我是服务器,你好，欢迎您");
            printWriter.flush();
            socket.shutdownOutput();//关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                if (printWriter != null)
                    printWriter.close();
                if (outputStream != null)
                    outputStream.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
