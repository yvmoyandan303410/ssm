package com.bus.dao;

import com.bus.entity.Authority;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface AuthorityMapper {
    int insertAuthority(Authority authority);

    int deleteAuthority(Integer id);

    int updateAuthority(Authority authority);

    List<Authority> selectAuthorityAll(Authority authority);
    int getTotalRecordAll();

    Authority selectAuthorityById(Integer id);

    int insertAuthoritys(List<Authority> list);

   /* List<Authority> selectAuthorityByCondition(Authority authority);

    int getTotalRecordByCondition(Authority authority);*/

    List<Authority> selectAllPer();
}
