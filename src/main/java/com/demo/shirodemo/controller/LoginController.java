package com.demo.shirodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping("/index")
    @ResponseBody
    public String login(){
        return "login";
    }
}
