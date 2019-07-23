package com.demo.shirodemo.dao;

import com.demo.shirodemo.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    Users selectUserByName(@Param("userName") String userName);

}
