package com.bus.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Role {
    private  Integer roleId;
    private String roleName;
    private String roleInfo;
    private Authority authority;
    //代表这个角色下有多少个权限
    private List<Authority> authorityList;
    public Role() {
    }
    public Role(Integer roleId) {
        this.roleId = roleId;
    }


    public Role(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;

    }

    public Role(Integer roleId, List<Authority> authorityList) {
        this.roleId = roleId;
        this.authorityList = authorityList;
    }

    public Role(Integer roleId, String roleName, Authority authority) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.authority = authority;
    }
    public Role(String roleName) {
        this.roleName = roleName;

    }
    public Role(Integer roleId, Authority authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    public Role(String roleName, List<Authority> authorityList) {
        this.roleName = roleName;
        this.authorityList = authorityList;
    }

    public Role(Authority authority) {
        this.authority = authority;
    }

    public Role(Integer roleId, String roleName, String roleInfo) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleInfo = roleInfo;
    }
}
