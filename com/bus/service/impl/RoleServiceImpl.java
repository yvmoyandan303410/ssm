package com.bus.service.impl;

import com.bus.dao.RoleMapper;
import com.bus.entity.Role;
import com.bus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int addRole(Role role) {
        int i = roleMapper.insertRole(role);
        return i;
    }

    @Override
    public int addRoleAndAuthority(Role role) {
        int i = roleMapper.giveRoleAndAuyhority(role);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int removeRole(Integer ID) {
        int i = roleMapper.deleteRole(ID);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int reviceRole(Role role) {
        int i = roleMapper.updateRole(role);
        return i;
    }

    @Override
    public List<Role> selectRoleAll() {
        List<Role> roles = roleMapper.selectRoleAll();
        return roles;
    }

    @Override
    public Role selectRoleID(Integer ID) {
        Role role = roleMapper.selectRoleById(ID);
        return role;
    }
}
