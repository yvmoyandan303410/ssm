package com.bus.service;

import com.bus.entity.Authority;
import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;
import com.bus.entity.User;
import com.bus.utl.Page;

import java.util.List;

public interface CustomerService {

    /*员工工作*/

    //查询客户
    Customer findCustomerById(Integer id);

    //修改客户
    int editCustomer(Customer customer);

    //删除客户
    int removeCustomer(Integer id);

    //添加客户
    int addCustomer(Customer customer);

    //根据客户id找员工id
    int findUidByCid(Integer id);

    //分页查询显示所有顾客
    List<Customer> findCustomerByPage(Customer customer);

    //获得总记录数
    int getTotalRecord(Customer customer);

    //分页查询显示顾客
    List<Customer> findAllCustomer(Customer customer);

    //总记录数
    int getTotalRecord2(Customer customer);

}
