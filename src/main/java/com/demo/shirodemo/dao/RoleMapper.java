package com.demo.shirodemo.dao;

import com.demo.shirodemo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> selectRoleByUserName(@Param("userName") String userName);

}
