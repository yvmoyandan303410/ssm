package com.bus.service;

import com.bus.entity.Role;

import java.util.List;

public interface RoleService {
    int addRole(Role role);

    int addRoleAndAuthority(Role role);

    int removeRole(Integer ID);

    int reviceRole(Role role);

    List<Role> selectRoleAll();

    Role selectRoleID(Integer ID);
}
