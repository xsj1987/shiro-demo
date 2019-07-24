package com.demo.shirodemo.service;

import com.demo.shirodemo.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> selectUserByName(String userName);
}
