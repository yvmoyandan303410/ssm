package com.bus.dao;

import com.bus.entity.Role;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface RoleMapper {

    int insertRole(Role role);

    int giveRoleAndAuyhority(Role role);

    int deleteRole(Integer id);

    int updateRole(Role role);

    List<Role> selectRoleAll();

    Role selectRoleById(Integer id);
}
