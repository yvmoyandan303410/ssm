package com.bus.entity;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;

@Data
@ToString
public class UN {
    private Integer unionId;
    //private Integer authorityId;
    private Authority authority;
    // Integer roleId;
    private Role role;

    private HashMap<String ,Integer> map;

    public UN() {
    }

    public UN(Integer unionId, Authority authority, Role role) {
        this.unionId = unionId;
        this.authority = authority;
        this.role = role;
    }

    public UN(Authority authority, Role role) {
        this.authority = authority;
        this.role = role;
    }

    public UN(Integer unionId, Authority authority, Role role, HashMap<String, Integer> map) {
        this.unionId = unionId;
        this.authority = authority;
        this.role = role;
        this.map = map;
    }
}
