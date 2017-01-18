package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by admin on 2016/8/31.
 */
public class Demo {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
    public static final String NAME = "root";
    public static final String PASSWORD = "sys";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection connection = DriverManager.getConnection(URL,NAME,PASSWORD);
        //3.通过数据的连接操作数据库
        Statement stmt = connection.createStatement();

        ResultSet resultSet = stmt.executeQuery("SELECT * from imooc_godness;");

        while (resultSet.next()){
            System.out.println(resultSet.getString("user_name"));
        }

    }

}
