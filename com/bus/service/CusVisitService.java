package com.bus.service;

import com.bus.entity.Authority;
import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;
import com.bus.entity.User;
import com.bus.utl.Page;

import java.util.List;

public interface CusVisitService {
    //显示所有拜访记录
    List<CustomerVisit> findAllCusVi(CustomerVisit customervisit);

    //获得总记录数
    int getTotalRecord(CustomerVisit customervisit);

    //修改拜访记录
    int editCusVi(CustomerVisit customervisit);

    //删除拜访记录
    int removeCusVi(Integer id);

    //添加拜访记录
    int addCusVi(CustomerVisit customervisit);

    //根据id查访客记录
    CustomerVisit findViById(Integer id);

    //拜访记录
    List<CustomerVisit> findAllVi(CustomerVisit customervisit);

    //总记录数
    int getTotalRecord2(CustomerVisit customervisit);

    //查找员工对应的客户
    List<Customer> selectCusByUserName(String name);
}
