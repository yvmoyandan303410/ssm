package com.bus.service;


import com.bus.entity.Customer;
import com.bus.entity.Usercustmoer;


import java.util.List;

public interface UserCusService {
    //添加客户和员工的关系
    int addUsCu(Customer customer);

    //删除客户和员工的关系
    int removeUsCu(Customer customer);

}
