package com.bus.service.impl;

import com.bus.dao.CustomerMapper;
import com.bus.entity.Customer;
import com.bus.entity.User;
import com.bus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer findCustomerById(Integer id) {
        Customer customer = customerMapper.selectCustomerById(id);
        return customer;
    }

    @Override
    public int editCustomer(Customer customer) {
        int i = customerMapper.updateCustomer(customer);
        return i;
    }

    @Override
    public int removeCustomer(Integer id) {
        return customerMapper.deleteCustomer(id);
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }

    @Override
    public int findUidByCid(Integer id) {
        return customerMapper.selectUidByCid(id);
    }

    //分页查询显示所有客户
   @Override
   public List<Customer> findCustomerByPage(Customer customer) {

        return customerMapper.selectCustomerByPage(customer);
   }
    //获得总记录数
    @Override
    public int getTotalRecord(Customer customer) {

        return customerMapper.getTotalRecord(customer);
    }

    //显示客户
    @Override
    public List<Customer> findAllCustomer(Customer customer) {
        return customerMapper.selectAllCustomer(customer);
    }

    //总记录数
    @Override
    public int getTotalRecord2(Customer customer) {
        return customerMapper.getTotalRecord2(customer);
    }

}
