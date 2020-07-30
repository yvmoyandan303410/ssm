package com.bus.entity;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;

@Data
@ToString
public class CustomerVisit {
    private Integer id;
    private Customer customer;
    private Integer cusId;
    private User user;
    private Integer userId;
    private String content;
    private String data;
    private HashMap<String ,Integer> map;

    private String empoleename;
    private Integer empoleeid;

    public CustomerVisit() {
    }

    public CustomerVisit(Integer id, String content, String data) {
        this.id = id;
        this.content = content;
        this.data = data;
    }

    public CustomerVisit(Customer customer, User user, String content, String data) {
        this.customer = customer;
        this.user = user;
        this.content = content;
        this.data = data;
    }


}
