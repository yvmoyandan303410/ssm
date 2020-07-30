package com.bus.service.impl;

import com.bus.dao.AuthorityMapper;
import com.bus.entity.Authority;
import com.bus.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int addAuthority(Authority authority) {
        System.out.println(authority);
        int i = authorityMapper.insertAuthority(authority);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int addAuthoritys(List<Authority> list) {
        int i = authorityMapper.insertAuthoritys(list);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int removeAuthority(Integer ID) {
        int i = authorityMapper.deleteAuthority(ID);
        return i;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false) //事务注解式配置
    public int reviceAuthority(Authority authority) {
        int i = authorityMapper.updateAuthority(authority);
        return i;
    }


    @Override
    public List<Authority> selectAuthorityAll(Authority authority) {
        List<Authority> authorities = authorityMapper.selectAuthorityAll(authority);
        return authorities;
    }
    @Override
    public int getTotalRecordAll() {
        return authorityMapper.getTotalRecordAll();
    }

    @Override
    public Authority selectAuthorityID(Integer ID) {
        Authority authority = authorityMapper.selectAuthorityById(ID);
        return authority;
    }

    @Override
    public List<Authority> findAllPer() {

        return authorityMapper.selectAllPer();
    }
}
