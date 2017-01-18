package com.socket.sockapp.service;

import com.socket.sockapp.entity.TranFile;
import com.socket.sockapp.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 2017/1/10.
 */
public class FileService {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

    /**
     * 插入文件
     * @param file
     * @return
     */
    public boolean addFile(TranFile file){
        String sql = "INSERT into tran_file(name, content) VALUES (?,?)";
        conn = DBUtil.getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,file.getName());
            pstmt.setBytes(2,file.getContent());
            int num = pstmt.executeUpdate();
            if(num>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,pstmt,conn);
        }
        return false;
    }
}
