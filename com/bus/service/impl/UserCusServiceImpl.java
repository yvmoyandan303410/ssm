package com.bus.service.impl;

import com.bus.dao.UserCusMapper;
import com.bus.entity.Customer;
import com.bus.entity.Usercustmoer;
import com.bus.service.UserCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userCusService")
public class UserCusServiceImpl implements UserCusService {

    @Autowired
    private UserCusMapper userCusMapper;

    //添加客户和员工的关系
    @Override
    public int addUsCu(Customer customer) {
        return userCusMapper.inserUsCu(customer);
    }

    //删除客户和员工的关系
    @Override
    public int removeUsCu(Customer customer) {
        return userCusMapper.deleteUsCu(customer);
    }

}
