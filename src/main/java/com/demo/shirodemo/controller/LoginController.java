package com.demo.shirodemo.controller;

import com.demo.shirodemo.entity.Permission;
import com.demo.shirodemo.entity.Role;
import com.demo.shirodemo.entity.Users;
import com.demo.shirodemo.service.PermissionService;
import com.demo.shirodemo.service.RoleService;
import com.demo.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/index")
    @ResponseBody
    public String login(){
        System.out.println("开始执行Login方法，准备登录");
        String userName = "admin";
        Users user = userService.getUserByName(userName);
        System.out.println(user);
        List<Role> roleList = roleService.selectUserByName(userName);
        roleList.forEach((role)->{
            System.out.println(role);
        });
        List<Permission> permissionList = permissionService.getPerssionByRoleId(100);
        permissionList.forEach((permission) -> {
            System.out.println(permission);
        });
        return "login";
    }
}
