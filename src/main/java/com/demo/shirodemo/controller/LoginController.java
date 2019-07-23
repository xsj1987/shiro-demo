package com.demo.shirodemo.controller;

import com.demo.shirodemo.entity.Users;
import com.demo.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public String login(){
        String userName = "admin";
        Users user = userService.getUserByName(userName);
        return "login";
    }
}
