package com.test.service;

import com.test.entity.User;

public interface UserService {
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
