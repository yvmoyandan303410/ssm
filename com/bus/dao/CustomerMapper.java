package com.bus.dao;

import com.bus.entity.Authority;
import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;
import com.bus.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface CustomerMapper {

    //    //查询客户
    Customer selectCustomerById(Integer id);

    //修改客户
    int updateCustomer(Customer customer);

    //删除客户
    int deleteCustomer(Integer id);

    //添加客户
    int insertCustomer(Customer customer);

    //根据客户id找员工id
    int selectUidByCid(Integer id);

    //分页查询显示所有客户
    List<Customer> selectCustomerByPage(Customer customer);

    //获得总记录数
    int getTotalRecord(Customer customer);


    //分页查询显示客户
    List<Customer> selectAllCustomer(Customer customer);

    //获得总记录数
    int getTotalRecord2(Customer customer);

}
