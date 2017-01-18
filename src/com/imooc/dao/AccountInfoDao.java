package com.imooc.dao;

import com.imooc.db.DBCPUtil;
import com.imooc.modal.AccountInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/6.
 */
public class AccountInfoDao {

    public List<AccountInfo> queryAccountInfo()throws Exception{
        DBCPUtil dbcpUtil = new DBCPUtil();
        Connection conn = dbcpUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from account_info");
        List<AccountInfo> accountInfoList = new ArrayList<AccountInfo>();
        while(rs.next()){
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setId(rs.getInt("id"));
            accountInfo.setAccount(rs.getString("account"));
            accountInfoList.add(accountInfo);
        }
        return accountInfoList;
    }
}
