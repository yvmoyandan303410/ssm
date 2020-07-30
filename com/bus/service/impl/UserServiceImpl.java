package com.bus.service.impl;

import com.bus.dao.UserMapper;
import com.bus.entity.*;
import com.bus.service.UserService;
import com.bus.utl.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findUser() {
        return userMapper.selectUser();
    }

    @Override
    public int addEmploee(User users) {
        return userMapper.insertEmploee(users);
    }

    @Override
    public List<User> findUserByPage(User users) {
        return userMapper.selectUserByPage(users);
    }

    @Override
    public int getTotalRecord(User users) {
        return userMapper.getTotalRecord(users);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int editUser(User users) {
        return userMapper.updateUser(users);
    }

    @Override
    public int removeUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int editPassword(User users) {
        return userMapper.updatePassword(users);
    }

    @Override
    public int findUsernameById(String username) {
        return userMapper.selectById(username);
    }

    @Override
    public List<String> findAuthorityByUserName(String userName) {
        List<String> authorityByUserName = userMapper.findAuthorityByUserName(userName);
        return authorityByUserName;
    }

    @Override
    public List<String> findRoleByUserName(String userName) {
        List<String> roleByUserName = userMapper.findRoleByUserName(userName);
        return roleByUserName;
    }

    @Override
    public User selectByUsername(String name) {
        return userMapper.selectByUsername(name);
    }

    @Override
    public List<Role> selectRole() {

        return userMapper.selectRole();
    }

    @Override
    public List<User> selectAllUser(User user) {
        return userMapper.selectAllUser(user);
    }

    @Override
    public int getTotalRecordAll() {
        return userMapper.getTotalRecordAll();
    }

}
