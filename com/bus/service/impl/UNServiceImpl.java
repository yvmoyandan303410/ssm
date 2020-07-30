package com.bus.service.impl;

import com.bus.dao.AuthorityMapper;
import com.bus.dao.RoleMapper;
import com.bus.dao.UNMapper;
import com.bus.entity.Authority;
import com.bus.entity.Role;
import com.bus.entity.UN;
import com.bus.service.UNService;
import com.bus.utl.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UNServiceImpl implements UNService {
    @Autowired
    private UNMapper unMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int addUNs(UN un) {
        int i = unMapper.insertUN(un);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int removeUNs(Integer ID) {
        int i = unMapper.deleteUN(ID);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int reviceUNs(UN un) {
        int i = unMapper.updateUN(un);
        return i;
    }

    @Override
    public List<UN> selectUNsID(Integer ID) {
        List<UN> authorityList = unMapper.selectUNById(ID);
        return authorityList;
    }

    @Override
    public Page<UN> selectUNsByCondition(Page<UN> page, UN u) {
        List<UN> unList = unMapper.selectUNByCondition(u);
        int totalRecord = unMapper.getTotalRecordByCondition(u);
        page.setList(unList);
        page.setTotalRecord(totalRecord);
        return page;
    }

    /*@Override
    public int addUNMore( Role role,List<Authority> authList) {
        int i = unMapper.insertUNs(role, authList);
        return i;
    }*/
    public int addUNMore( Role role) {
        int i = unMapper.insertUNs(role);
        return i;
    }

    @Override
    public List<UN> selectUNAll() {
        return unMapper.selectUNAll();
    }


   /* @Override
    public List<UN> selectUNAll(UN un) {
        return unMapper.selectUNAll(un);
    }
    @Override
    public int getTotalRecordAll() {
        return unMapper.getTotalRecordAll();
    }*/
   @Override
   public List<Authority> selectchildren(Integer id) {
       List<Authority> selectchildren = unMapper.selectchildren(id);
       return selectchildren;
   }

    @Override
    public Authority selectparent(Integer id) {
        return unMapper.selectparent(id);
    }
}
