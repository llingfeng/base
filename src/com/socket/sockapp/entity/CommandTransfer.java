package com.socket.sockapp.entity;

import java.io.Serializable;

/**
 * Created by admin on 2017/1/10.
 */
public class CommandTransfer implements Serializable{
    private String cmd;//请求命令名称
    private Object TransferData;//传输数据
    private boolean flag;//执行情况
    private String result;//返回执行结果

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Object getTransferData() {
        return TransferData;
    }

    public void setTransferData(Object transferData) {
        TransferData = transferData;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
