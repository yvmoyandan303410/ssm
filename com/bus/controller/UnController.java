package com.bus.controller;

import com.bus.entity.Authority;
import com.bus.entity.Role;
import com.bus.entity.UN;
import com.bus.service.AuthorityService;
import com.bus.service.RoleService;
import com.bus.service.UNService;
import com.bus.utl.BootstrapPage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("un")
public class UnController {

    @Autowired
    private UNService unService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("showUn")
    @ResponseBody
    public JSONArray showUn(){
        JSONArray jsonArray = new JSONArray();
        List<UN> unList = unService.selectUNAll();
        System.out.println("unList = " + unList);
        jsonArray.addAll(unList);
        return jsonArray;
    }
/* public Object showUser(UN un, Integer limit, Integer offset){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);
        un.setMap(map);

        List<UN> unList = unService.selectUNAll(un);
        BootstrapPage<UN> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(unService.getTotalRecordAll());
        bootstrapPage.setRows(unList);
        return bootstrapPage;
    }*/
    @RequestMapping("ready")
    @ResponseBody
    public JSONObject getBorth(){
        JSONObject result = new JSONObject();
        //List<Authority> authoritys = authorityService.selectAuthorityAll();
        //System.out.println("authoritys = " + authoritys);
        List<Authority> allPer = authorityService.findAllPer();
        System.out.println("allPer = " + allPer);
        List<Role> roles = roleService.selectRoleAll();
        result.put("authorityList",allPer);
        result.put("roleList",roles);
        return result;
    }

    @RequestMapping("selectAuthority")
    @ResponseBody
    public JSONArray selectAuthority(Integer roleID){
        JSONArray jsonArray = new JSONArray();
        List<UN> unList = unService.selectUNsID(roleID);
        System.out.println("unList = " + unList);
        System.out.println("unList = " + unList.size());
        jsonArray.addAll(unList);
        return jsonArray;
    }
    @RequestMapping("selectchildren")
    @ResponseBody
    public JSONArray selectchildren(Integer id){
        JSONArray jsonArray = new JSONArray();
        List<Authority> selectchildren = unService.selectchildren(id);
        System.out.println("unList = " + selectchildren);
        System.out.println("unList = " + selectchildren.size());
        jsonArray.addAll(selectchildren);
        return jsonArray;
    }
    @RequestMapping("selectparent")
    @ResponseBody
        public Authority selectparent(Integer id){
        Authority selectparent = unService.selectparent(id);
        System.out.println("selectparent = " + selectparent);
        return selectparent;
    }

    @RequestMapping("authAndRole")
    @ResponseBody
    public Integer authAndRole(Integer roleID,String[] check){
        int i1 = unService.removeUNs(roleID);

        System.out.println("i1 = " + i1);
        System.out.println("checks = " + check);

        ArrayList<Authority> arrayList = new ArrayList<>();
        for (int i = 0;i<check.length;i++){
            System.out.println("checks[i]==="+check[i]);
            Integer a = Integer.parseInt(check[i]);
            arrayList.add(new Authority(a));

        }
        int i = unService.addUNMore(new Role(roleID,arrayList));
        System.out.println(i);
        if (i==0) {
           return 0;
        }else if (i1==0){
            return 0;
        }else if (i1==1){
            return 1;
        }
        return 1;
    }

}
