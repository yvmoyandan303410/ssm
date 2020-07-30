package com.bus.service.impl;

import com.bus.dao.CusVisitMapper;
import com.bus.dao.UserMapper;
import com.bus.entity.Authority;
import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;
import com.bus.entity.User;
import com.bus.service.CusVisitService;
import com.bus.service.UserService;
import com.bus.utl.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cusVisitService")
public class CusVisitServiceImpl implements CusVisitService {

   @Autowired
   private CusVisitMapper cusVisitMapper;

    @Override
    public List<CustomerVisit> findAllCusVi(CustomerVisit customervisit) {

        return cusVisitMapper.selectAllCusVi(customervisit);
    }

    @Override
    public int getTotalRecord(CustomerVisit customervisit) {
        return cusVisitMapper.getTotalRecord(customervisit);
    }

    @Override
    public int editCusVi(CustomerVisit customervisit) {
        return cusVisitMapper.updateCusVi(customervisit);
    }

    @Override
    public int removeCusVi(Integer id) {
        return cusVisitMapper.deleteCusVi(id);
    }

    @Override
    public int addCusVi(CustomerVisit customervisit) {
        return cusVisitMapper.insertCusVi(customervisit);
    }

    @Override
    public CustomerVisit findViById(Integer id) {
        return cusVisitMapper.selectViById(id);
    }

    @Override
    public List<CustomerVisit> findAllVi(CustomerVisit customervisit) {
        return cusVisitMapper.selectAllVi(customervisit);
    }

    @Override
    public int getTotalRecord2(CustomerVisit customervisit) {
        return cusVisitMapper.getTotalRecord2(customervisit);
    }

    @Override
    public List<Customer> selectCusByUserName(String name) {

        return cusVisitMapper.selectCusByUserName(name);
    }
}
