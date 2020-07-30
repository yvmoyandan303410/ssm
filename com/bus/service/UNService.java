package com.bus.service;

import com.bus.entity.Authority;
import com.bus.entity.Role;
import com.bus.entity.UN;
import com.bus.utl.Page;

import java.util.List;

public interface UNService {
    int addUNs(UN un);

    int removeUNs(Integer ID);

    int reviceUNs(UN un);

    List<UN> selectUNsID(Integer ID);

    Page<UN> selectUNsByCondition(Page<UN> page, UN u);

    /*int addUNMore( Role role,List<Authority> authList);*/

    int addUNMore(Role role);

   /* List<UN> selectUNAll(UN un);
    int getTotalRecordAll();*/
    List<UN> selectUNAll();

    List<Authority> selectchildren(Integer id);
    Authority selectparent(Integer id);
}
