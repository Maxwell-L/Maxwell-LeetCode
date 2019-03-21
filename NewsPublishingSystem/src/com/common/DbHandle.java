package com.common;

import java.sql.*;
import java.lang.*;

public class DbHandle {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void getConnection(){
        final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/news?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        final String LOGIN = "root";
        final String PASSWORD = "Maxwell1006";
        try{
            Class.forName(DRIVERNAME);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }catch(Exception e){
            System.out.println("执行getConnection()方法错误：");
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql){
        try{
            if(conn == null){
                getConnection();
            }
            if(st == null){
                st = conn.createStatement();
            }
            rs = st.executeQuery(sql);
        }catch(Exception e){
            System.out.println("执行executeQuery(String sql)方法错误：" + sql);
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String sql){
        int ret;
        try{
            if(conn == null){
                getConnection();
            }
            if(st == null){
                st = conn.createStatement();
            }
            ret = st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("执行executeUpdate(sql)方法错误：" + sql);
            e.printStackTrace();
            ret = -1;
        }
        return ret;
    }

    public void close(){
        try{
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(Exception e){
            System.out.println("执行close()方法错误：");
            e.printStackTrace();
        }
    }
}
