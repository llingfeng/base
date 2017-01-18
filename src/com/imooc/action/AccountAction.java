package com.imooc.action;

import com.imooc.dao.AccountInfoDao;
import com.imooc.modal.AccountInfo;

import java.util.List;

/**
 * Created by admin on 2016/9/6.
 */
public class AccountAction {

    public static void main(String[] args) throws Exception{
        AccountInfoDao dao = new AccountInfoDao();
        List<AccountInfo> accountInfoList = dao.queryAccountInfo();
        for (AccountInfo accountInfo : accountInfoList) {
            System.out.println(accountInfo);
        }
    }
}
