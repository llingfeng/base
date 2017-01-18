package com.socket.sockapp.main;

import com.socket.sockapp.entity.CommandTransfer;
import com.socket.sockapp.entity.TranFile;
import com.socket.sockapp.entity.User;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by admin on 2017/1/10.
 */
public class SocketClient {
    Scanner input = new Scanner(System.in);
    private Socket socket = null;//客户端socket
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public void showMainMenu() {
        System.out.println("=====欢迎使用上传文件系统=====");
        System.out.println("=====1.登录\t2.注册\t3.退出=====");
        System.out.println("请选择：");
        int choose = 0;
        try {
            choose = input.nextInt();
        } catch (Exception e) {}
        switch (choose) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("感谢你对本系统的支持");
                System.exit(0);
            default:
                System.out.println("输入有误");
                System.exit(0);
        }
    }

    /**
     * 登录
     */
    public void login() {
        CommandTransfer commandTransfer = new CommandTransfer();
        commandTransfer.setCmd("login");
        int count = 0;//计算
        boolean flag = false;
        while (true){
            User user = new User();
            System.out.print("用户名：");
            user.setUserName(input.next());
            System.out.print("密码：");
            user.setUserPassword(input.next());
            commandTransfer.setTransferData(user);
            //发送消息
            try {
                socket = new Socket("localhost",8888);
                sendData(commandTransfer);
                CommandTransfer transfer = getData();
                flag = transfer.isFlag();
                if(flag){
                    break;
                }else {
                    count++;
                    System.out.println(transfer.getResult());
                    if(count >= 3){
                        System.out.println("输错"+count+"次");
                        String choose = "";
                        while (true){
                            System.out.println("1.返回主界面\t2.继续");
                            choose = input.next();
                            if("1".equals(choose.trim()) || "2".equals(choose.trim())){
                                break;
                            }else {
                                System.out.println("输入有误");
                            }
                        }
                        if("1".equals(choose.trim())){
                            showMainMenu();
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(flag){
            uploadFile();
        }
    }

    /**
     * 注册
     */
    public void register() {

    }

    /**
     * 上传文件（格式为文件绝对路径）
     */
    public void uploadFile() {
        while (true){
            System.out.println("请输入上传文件的路径");
            String path = input.next();
            File file = new File(path);
            if(!file.exists()){
                System.out.println("改文件不存在");
                continue;
            }
            if(!file.isFile()){
                System.out.println("不是文件");
                continue;
            }
            try {
                socket = new Socket("localhost",8888);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[fileInputStream.available()];
                BufferedInputStream bis = new BufferedInputStream(fileInputStream);
                bis.read(bytes);
                TranFile tranFile = new TranFile();
                tranFile.setContent(bytes);
                tranFile.setName(path.substring(path.lastIndexOf("/")+1));
                CommandTransfer commandTransfer =new CommandTransfer();
                commandTransfer.setCmd("upload");
                commandTransfer.setTransferData(tranFile);
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
                oos.writeObject(commandTransfer);
                socket.shutdownOutput();
                CommandTransfer uploadResult = (CommandTransfer)ois.readObject();
                socket.shutdownInput();
                System.out.println(uploadResult.getResult());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 发送消息
     * @param commandTransfer
     */
    public void sendData(CommandTransfer commandTransfer){
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(commandTransfer);
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得响应消息
     * @return
     * @throws ClassNotFoundException
     */
    public CommandTransfer getData() throws ClassNotFoundException {
        CommandTransfer commandTransfer = new CommandTransfer();
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            commandTransfer = (CommandTransfer) ois.readObject();
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandTransfer;
    }

    /**
     * 关闭资源
     */
    public void closeAll(){
        try {
            if(socket != null){
                socket.shutdownInput();
                socket.shutdownOutput();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
