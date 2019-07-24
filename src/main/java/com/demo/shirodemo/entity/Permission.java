package com.demo.shirodemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = 7943712796699900131L;

    private Integer id;
    private String code;
    private String name;
    private String path;
    private String method;

}
