package com.socket.sockapp.service;

import com.socket.sockapp.entity.User;
import com.socket.sockapp.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 2017/1/10.
 */
public class UserService {
    private Connection conn = null;

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean addUser(User user){
        String sql = "INSERT into user(user_name, user_password) VALUES (?,?)";
        conn = DBUtil.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getUserPassword());
            int num = preparedStatement.executeUpdate();
            if(num > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 确认用户是否存在
     * @return
     */
    public boolean confirmUser(User user){
        String sql = "SELECT * from user WHERE user_name = ? and user_password = ?";
        try {
            conn = DBUtil.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getUserPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
