package com.stdum;

/*
 *@Author Yan
 *@Create 2019-06-28 20:29
 */

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.Test;

import javax.management.j2ee.Management;
import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Resultset rs = null;
        String Driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(Driver);
            String url = "jdbc:mysql://jdbc:mysql://rm-m5em1s66r6g6h9hh3zo.mysql.rds.aliyuncs.com:3306/management?serverTimezone=UTC";
            String user = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            if(conn != null){
                System.out.println("连接成功");
            }
            String sql = "select * from user";
            rs = (Resultset) ps.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
