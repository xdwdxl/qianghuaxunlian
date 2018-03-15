package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.entity.User;
import com.test.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public User login(User user) {
        String password = user.getPassword();
        user.setPassword(password);
        return userDao.login(user);

    }

    public void resign() {

    }
}
