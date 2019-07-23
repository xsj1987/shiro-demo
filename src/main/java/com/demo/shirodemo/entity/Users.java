package com.demo.shirodemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {

    private static final long serialVersionUID = 641999993873523744L;

    private String uId;
    private String userName;
    private String salt;
    private Integer status;
    private String password;

}
