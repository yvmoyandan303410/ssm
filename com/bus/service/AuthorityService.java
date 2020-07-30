package com.bus.service;

import com.bus.entity.Authority;

import java.util.List;

public interface AuthorityService {
    int addAuthority(Authority authority);

    int addAuthoritys(List<Authority> list);

    int removeAuthority(Integer ID);

    int reviceAuthority(Authority authority);

    List<Authority> selectAuthorityAll(Authority authority);
    int getTotalRecordAll();

    Authority selectAuthorityID(Integer ID);

    List<Authority> findAllPer();
}
