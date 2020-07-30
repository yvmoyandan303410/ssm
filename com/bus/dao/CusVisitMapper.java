package com.bus.dao;

import com.bus.entity.Authority;
import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;
import com.bus.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface CusVisitMapper {

    //显示所有拜访记录
    List<CustomerVisit> selectAllCusVi(CustomerVisit customervisit);

    //获得总记录数
    int getTotalRecord(CustomerVisit customervisit);

    //修改拜访记录
    int updateCusVi(CustomerVisit customervisit);

    //删除拜访记录
    int deleteCusVi(Integer id);

    //添加拜访记录
    int insertCusVi(CustomerVisit customervisit);

    //根据id查访客记录
    CustomerVisit selectViById(Integer id);

    //拜访记录
    List<CustomerVisit> selectAllVi(CustomerVisit customervisit);

    //总记录数
    int getTotalRecord2(CustomerVisit customervisit);

    //查找员工对应的客户
    List<Customer> selectCusByUserName(String name);

}
