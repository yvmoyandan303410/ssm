package com.bus.dao;

import com.bus.entity.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface UserMapper {

    User selectByUsername(String name);

    //显示所有员工
    List<User> selectUser();

    //添加员工
    int insertEmploee(User user);

    //分页查询显示所有员工
    List<User> selectUserByPage(User user);

    //获得总记录数
    int getTotalRecord(User user);

    //查询员工
    User selectUserById(Integer id);

    //修改员工
    int updateUser(User users);

    //删除员工
    int deleteUser(Integer id);

    //修改密码
    int updatePassword(User users);

    //通过用户名找id
    int selectById(String username);


    //根据用户名查角色
     List<String> findRoleByUserName(String userName);

    //根据用户名查找权限名
     List<String> findAuthorityByUserName(String userName);

    //查询所有角色
    List<Role> selectRole();

    //查询所有user
    List<User> selectAllUser(User user);
    int getTotalRecordAll();


}
