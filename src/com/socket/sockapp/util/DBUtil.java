package com.socket.sockapp.util;

import java.sql.*;

/**
 * Created by admin on 2017/1/10.
 */
public class DBUtil {

    public static Connection getConn(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/socketdb?characterEncoding=utf8";
        String user = "root";
        String password = "sys";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(ResultSet resultSet, PreparedStatement pstmt,Connection conn){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
