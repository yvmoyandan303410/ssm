package com.bus.dao;

import com.bus.entity.Authority;
import com.bus.entity.Role;
import com.bus.entity.UN;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UNMapper {
    int insertUN(UN un);

    int insertUNs(Role role);

    int deleteUN(Integer id);

    int updateUN(UN un);

    List<UN> selectUNAll();

   /* List<UN> selectUNAll(UN un);
    int getTotalRecordAll();*/

    List<UN> selectUNByCondition(UN un);

    int getTotalRecordByCondition(UN un);

    List<UN> selectUNById(Integer id);

    List<Authority> selectchildren(Integer id);
    Authority selectparent(Integer id);
}
