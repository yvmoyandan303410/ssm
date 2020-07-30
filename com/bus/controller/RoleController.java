package com.bus.controller;

import com.bus.entity.Authority;
import com.bus.entity.Customer;
import com.bus.entity.Role;
import com.bus.service.AuthorityService;
import com.bus.service.RoleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("showRole")
    @ResponseBody
    public JSONArray showRole(){
        JSONArray jsonArray = new JSONArray();
        List<Role> roles = roleService.selectRoleAll();
        jsonArray.addAll(roles);
        return jsonArray;
    }

    @RequestMapping("addRole")
    public String addRole(String roleName, HttpServletRequest request){
        int i = roleService.addRole(new Role(roleName));

        return "redirect:../roleshow";

    }
    @RequestMapping("readyEdit")
    @ResponseBody
    public Role readyEdit(Integer roleId, HttpServletRequest request){
        Role role = roleService.selectRoleID(roleId);

        return role;
    }
    @RequestMapping("revice")
    @ResponseBody
    public Integer revice(Role role, HttpServletRequest request){

        int i = roleService.reviceRole(new Role(role.getRoleId(), role.getRoleName()));
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    @RequestMapping("doDelete")
    @ResponseBody
    public Integer doDelete(Integer roleId, HttpServletRequest request){
        int i=roleService.removeRole(roleId);
        if (i == 0) {
            return 0;
        }
        return 1;
    }

}
