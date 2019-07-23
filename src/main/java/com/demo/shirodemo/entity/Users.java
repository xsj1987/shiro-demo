package com.demo.shirodemo.entity;

import lombok.Data;

import java.io.Serializable;

public class Users implements Serializable {

    private static final long serialVersionUID = 641999993873523744L;

    private String uId;
    private String userName;
    private String salt;
    private Integer status;
    private String password;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {
    }

    public Users(String uId, String userName, String salt, Integer status, String password) {
        this.uId = uId;
        this.userName = userName;
        this.salt = salt;
        this.status = status;
        this.password = password;
    }
}
