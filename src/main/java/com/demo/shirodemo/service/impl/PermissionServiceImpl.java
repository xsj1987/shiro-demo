package com.demo.shirodemo.service.impl;

import com.demo.shirodemo.dao.PermissionMapper;
import com.demo.shirodemo.entity.Permission;
import com.demo.shirodemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPerssionByRoleId(Integer roleId) {
        return permissionMapper.selectPermissionByRoleId(roleId);
    }
}
