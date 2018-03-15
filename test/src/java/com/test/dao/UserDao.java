package com.test.dao;

import com.test.entity.User;

public interface UserDao {
    /**
     * 登录
     * @return User
     */
    User login(User user);
    /**
     * 注册
     */
    void resign();
}
