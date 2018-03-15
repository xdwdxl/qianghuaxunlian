package com.test.utils;

import java.sql.*;

public class JdbcUtil {
    public static Connection getConnect() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://192.168.1.120:3306/demo?useUnicode=true&characterEncoding=utf-8";
            String user = "root";
            String passWord = "root";
            connection = DriverManager.getConnection(url, user, passWord);
            if (null != connection) {
                System.out.println("数据库连接成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

        return connection;
    }

    public static void close(Statement stmt, Connection conn) {
        try {
            stmt.close();
            conn.close();
            System.out.print("关闭成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("关闭成功");
    }

}
