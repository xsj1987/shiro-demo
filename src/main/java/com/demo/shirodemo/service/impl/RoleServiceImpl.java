package com.demo.shirodemo.service.impl;

import com.demo.shirodemo.dao.RoleMapper;
import com.demo.shirodemo.entity.Role;
import com.demo.shirodemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectUserByName(String userName) {
        return roleMapper.selectRoleByUserName(userName);
    }
}
