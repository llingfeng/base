package com.socket.sockapp.main;

import com.socket.sockapp.entity.CommandTransfer;
import com.socket.sockapp.entity.TranFile;
import com.socket.sockapp.entity.User;
import com.socket.sockapp.service.FileService;
import com.socket.sockapp.service.UserService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by admin on 2017/1/10.
 */
public class ServerThread extends Thread {
    private Socket socket = null;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    private UserService userService = null;
    private FileService fileService = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            CommandTransfer commandTransfer = (CommandTransfer) ois.readObject();
            commandTransfer = execute(commandTransfer);
            oos.writeObject(commandTransfer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.shutdownInput();
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理请求
     * @return
     */
    public CommandTransfer execute(CommandTransfer commandTransfer){
        userService = new UserService();
        fileService = new FileService();
        String cmd = commandTransfer.getCmd();
        if("register".equals(cmd)){
            User user = (User) commandTransfer.getTransferData();
            boolean flag = userService.addUser(user);
            commandTransfer.setFlag(flag);
            if(flag){
                commandTransfer.setResult("注册成功");
            }else {
                commandTransfer.setResult("注册失败");
            }
        }else if("login".equals(cmd)){
            User user = (User) commandTransfer.getTransferData();
            boolean flag = userService.confirmUser(user);
            commandTransfer.setFlag(flag);
            if(flag){
                commandTransfer.setResult("登录成功");
            }else {
                commandTransfer.setResult("用户名或密码错误");
            }
        }else if("upload".equals(cmd)){
            TranFile transferData = (TranFile) commandTransfer.getTransferData();
            boolean flag = fileService.addFile(transferData);
            commandTransfer.setFlag(flag);
            if(flag){
                commandTransfer.setResult("上传成功");
            }else {
                commandTransfer.setResult("上传失败");
            }
        }else {
            commandTransfer = null;
        }
        return commandTransfer;
    }
}
