package com.bus.dao;


import com.bus.entity.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface UserCusMapper {
    //添加客户和员工的关系
    int inserUsCu(Customer customer);

    //删除客户和员工的关系
    int deleteUsCu(Customer customer);

}
