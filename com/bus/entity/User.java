package com.bus.entity;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@Data
@ToString
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String  tel;
    private String  name;
    private String  email;
    private Integer roleId;
    private Role role;

    private HashMap<String ,Integer> map;

    private List<Customer> customerList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(Integer userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, Integer roleId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    public User(Integer userId, String userName, String userPassword,
                 String tel, String name, String email,
                 Integer roleId) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.tel = tel;
        this.name = name;
        this.email = email;
        this.roleId = roleId;
    }
}
