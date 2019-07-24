package com.demo.shirodemo.dao;

import com.demo.shirodemo.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> selectPermissionByRoleId(@Param("roleId")Integer roleId);
}
