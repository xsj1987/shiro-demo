package com.demo.shirodemo.service.impl;

import com.demo.shirodemo.dao.UserMapper;
import com.demo.shirodemo.entity.Users;
import com.demo.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users getUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }
}
