package com.stdum;

import java.sql.*;

public class test {
    public static void main(String[] args) {
            String driver = "com.mysql.jdbc.Driver";
            Connection conn = null;
            PreparedStatement ps =null;
            ResultSet rs = null;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course?serverTimezone=UTC", "root", "1234");
                Statement st = conn.createStatement();
                String sql = "SELECT Allclassrooms FROM class2 WHERE NOT EXISTS (SELECT DISTINCT Week,Session,SEWeek,Classroom FROM class WHERE Week='星期一' AND Session LIKE '_3,4_' AND (Classroom LIKE '11%' OR Classroom LIKE '12%') AND SEWeek REGEXP '[1-7]-1[0-6]' AND class.Classroom = Allclassrooms) ORDER BY Allclassrooms";
               // System.out.println("SELECT Allclassrooms FROM class2 WHERE NOT EXISTS (SELECT DISTINCT Week,Session,SEWeek,Classroom FROM class WHERE Week='星期一' AND Session LIKE '_3,4_' AND (Classroom LIKE '11%' OR Classroom LIKE '12%') AND SEWeek REGEXP '[1-7]-1[0-6]' AND class.Classroom = Allclassrooms) ORDER BY Allclassrooms");
                ResultSet resultSet = st.executeQuery(sql);
                System.out.println("-----------------");
                System.out.println("执行结果如下所示:");
                System.out.println("-----------------");
                System.out.println("空教室");
                System.out.println("-----------------");
                String nn = null;
                while (rs.next()){
                    nn = rs.getString("Allclassrooms");
                    System.out.println(nn);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }