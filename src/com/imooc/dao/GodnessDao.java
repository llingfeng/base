package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.modal.Godness;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/31.
 */
public class GodnessDao {

    /**
     * 新增
     * @param godness
     * @throws Exception
     */
    public void addGodness(Godness godness) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO imooc_godness(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel) VALUES (?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,godness.getUserName());
        pstmt.setInt(2,godness.getSex());
        pstmt.setInt(3,godness.getAge());
        pstmt.setDate(4,new Date(godness.getBirthday().getTime()));
        pstmt.setString(5,godness.getEmail());
        pstmt.setString(6,godness.getMobile());
        pstmt.setString(7,godness.getCreateUser());
        pstmt.setString(8,godness.getUpdateUser());
        pstmt.setInt(9,godness.getIsDel());
        pstmt.execute();
    }

    /**
     * 查询
     * @return
     * @throws Exception
     */
    public List<Godness> queryGodness()throws Exception{
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from imooc_godness");
        List<Godness> godnessList = new ArrayList<Godness>();
        while(rs.next()){
            Godness godness = new Godness();
            godness.setId(rs.getInt("id"));
            godness.setUserName(rs.getString("user_name"));
            godnessList.add(godness);
        }
        return godnessList;
    }

    /**
     * 存储过程无参查询
     * @return
     * @throws Exception
     */
    public List<Godness> queryGodnessProcedure()throws Exception{
        Connection conn = DBUtil.getConnection();
        //获得callableStatement对象
        CallableStatement cs = conn.prepareCall("call sp_select_nofilter()");
        //执行存储过程
        cs.execute();
        //处理返回结果:结果集，出参
        ResultSet rs =  cs.getResultSet();
        List<Godness> godnessList = new ArrayList<Godness>();
        while(rs.next()){
            Godness godness = new Godness();
            godness.setId(rs.getInt("id"));
            godness.setUserName(rs.getString("user_name"));
            godnessList.add(godness);
        }
        return godnessList;
    }

    /**
     * 存储过程有参查询
     * @return
     */
    public List<Godness> queryGodnessProcedureParam(String username) throws Exception{
        Connection conn = DBUtil.getConnection();
        CallableStatement cs = conn.prepareCall("call sp_select_filter(?)");
        cs.setString(1,username);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        List<Godness> godnessList = new ArrayList<Godness>();
        while(rs.next()){
            Godness godness = new Godness();
            godness.setId(rs.getInt("id"));
            godness.setUserName(rs.getString("user_name"));
            godnessList.add(godness);
        }
        return godnessList;
    }

    /**
     * 存储过程出参
     * @return
     * @throws Exception
     */
    public Integer queryGodnessCount() throws Exception{
        Integer count = 0;
        Connection conn = DBUtil.getConnection();
        CallableStatement cs = conn.prepareCall("call sp_select_count(?)");
        cs.registerOutParameter(1,Types.INTEGER);
        cs.execute();
        count = cs.getInt(1);
        return count;
    }

    /**
     * 有参查询
     * @param mapList
     * @return
     * @throws Exception
     */
    public List<Godness> queryGodnessByParams(List<Map<String,Object>> mapList) throws Exception{
        Connection conn = DBUtil.getConnection();
        StringBuilder sql = new StringBuilder("select * from imooc_godness where 1=1 ");
        if(mapList!=null && mapList.size()>0){
            for (Map<String, Object> map : mapList) {
                sql.append("and "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
            }
        }
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        List<Godness> godnessList = new ArrayList<Godness>();
        while(rs.next()){
            Godness godness = new Godness();
            godness.setId(rs.getInt("id"));
            godness.setUserName(rs.getString("user_name"));
            godnessList.add(godness);
        }
        return godnessList;
    }

}
