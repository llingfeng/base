package com.imooc.modal;

import java.util.Date;

/**
 * Created by admin on 2016/9/5.
 */
public class AccountInfo {
    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", createTime=" + createTime +
                '}';
    }

    private int id;
    private String account;
    private double amount;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
