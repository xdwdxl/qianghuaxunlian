package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public User login(User user) {
        conn = JdbcUtil.getConnect();
        String sql = "select*from user where username = ? and password = ? ";
        User user1 = new User();
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user1.setId(resultSet.getInt(1));
                user1.setUsername(resultSet.getString(2));
                user1.setPassword(resultSet.getString(3));
            }
            return user1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void resign() {

    }
}
