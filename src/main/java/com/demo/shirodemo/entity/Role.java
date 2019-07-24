package com.demo.shirodemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {

    private Integer id;
    private String code;
    private String roleName;
    private Integer status;
}
