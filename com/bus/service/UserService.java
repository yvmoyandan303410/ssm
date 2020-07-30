package com.bus.service;

import com.bus.entity.*;
import com.bus.utl.Page;

import java.util.List;

public interface UserService {
    //显示员工
    List<User> findUser();

    //添加员工
    int addEmploee(User users);

    //分页查询显示所有员工
    List<User> findUserByPage(User users);

    //获得总记录数
    int getTotalRecord(User users);

    //查询员工
    User findUserById(Integer id);

    //修改员工
    int editUser(User users);

    //删除员工
    int removeUser(Integer id);

    //修改密码
    int editPassword(User users);

    //根据用户名找id
    int findUsernameById(String username);

    //根据用户名查角色
    public List<String> findRoleByUserName(String userName);

    //根据用户名查找权限名
    public List<String> findAuthorityByUserName(String userName);

    //认证登录
    User selectByUsername(String name);

    //查询所有角色
    List<Role> selectRole();

    //查询所有user
    List<User> selectAllUser(User user);

    int getTotalRecordAll();
}
