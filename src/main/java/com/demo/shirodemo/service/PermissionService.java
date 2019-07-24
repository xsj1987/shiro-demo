package com.demo.shirodemo.service;

import com.demo.shirodemo.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getPerssionByRoleId(Integer roleId);
}
