package com.stdum.classDao.classDaoimpl;
import com.stdum.classDao.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class classDaoimpl implements classDao {
    @Override
    public List<String> classSearchdao(String Week,String DS, String SEweek, String Session) {
        List<String> lu = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/course?serverTimezone=UTC";
        String user = "root";
        String pwd = "1234";
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
            lu = new ArrayList<>();
            statement = connection.createStatement();
            String sql = null;
            if (Integer.parseInt(SEweek)<10){
                sql = "SELECT class2.上课教室 FROM class2 WHERE class2.上课教室 NOT IN (SELECT 上课教室 FROM class WHERE 星期几='"+Week+"' AND (节次 LIKE "+Session+")AND (单双周 = '"+DS+"' OR 单双周 IS NULL) AND (起止周 REGEXP '[1-"+SEweek+"]-["+SEweek+"-9]' OR 起止周 REGEXP '[1-"+SEweek+"]-1[0-6]') AND 校区='1')";
            }else {
                sql = "SELECT class2.上课教室 FROM class2 WHERE class2.上课教室 NOT IN (SELECT 上课教室 FROM class WHERE 星期几='"+Week+"' AND (节次 LIKE "+Session+")AND (单双周 = '"+DS+"' OR 单双周 IS NULL) AND (起止周 REGEXP '[1-9]-1["+(Integer.parseInt(SEweek)-10)+"-6]' OR 起止周 REGEXP '1["+(Integer.parseInt(SEweek)-10)+"-6]-1[0-6]') AND 校区='1')";
            }
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                String u = new <List>String();
                u = resultSet.getString("上课教室");
                lu.add(u);
            }
        } catch (ClassNotFoundException var15) {
            var15.printStackTrace();
        } catch (SQLException var16) {
            var16.printStackTrace();
        } finally {
            System.out.println("-----------------");
            System.out.println(" 数据库数据成功获取");
            System.out.println("-----------------");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lu;
    }
}
