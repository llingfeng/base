package com.imooc.db;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by admin on 2016/9/6.
 */
public class DBCPUtil {

    public static DataSource DS;
    public static final String configFile = "dbcp.properties";

    public static Connection getConnection(){
        Connection conn = null;
        if(DS != null){
            try {
                conn = DS.getConnection();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
        return conn;
    }

    public DBCPUtil(){
        /*initDS();*/
        initDS("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/imooc","root","sys",10,50,20,5,1000);
    }

    public static void initDS(){
        Properties pops = new Properties();
        try {
            pops.load(Objects.class.getResourceAsStream(configFile));
            DS = BasicDataSourceFactory.createDataSource(pops);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initDS(String driverClassName,String connURL,String username,String password,int initialSize,int maxActive,int maxIdle,int minIdle,int maxWait){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(connURL);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(initialSize);
        ds.setMaxActive(maxActive);
        ds.setMaxIdle(maxIdle);
        ds.setMinIdle(minIdle);
        ds.setMaxWait(maxWait);
        DS = ds;
    }

}
