package com.bus.controller;

import com.bus.entity.Authority;
import com.bus.entity.User;
import com.bus.service.AuthorityService;

import com.bus.utl.BootstrapPage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("authority")
public class AuthorityController {

      @Autowired
      private AuthorityService authorityService;

      @RequestMapping("showAuthority")
      @ResponseBody
      public Object showUser(Authority authority, Integer limit, Integer offset){
          HashMap<String,Integer> map = new HashMap<>();
          map.put("currentPage", offset);
          map.put("pageSize",limit);
          authority.setMap(map);
          List<Authority> list = authorityService.selectAuthorityAll(authority);
          //因为使用table插件来分页，所以传回的数据应该符合table插件的使用格式
          BootstrapPage<Authority> bootstrapPage = new BootstrapPage<>();
          bootstrapPage.setTotal(authorityService.getTotalRecordAll());
          bootstrapPage.setRows(list);
          return bootstrapPage;
      }
     /* private JSONArray showAuthority(){
          System.out.println("------------");
          JSONArray jsonArray = new JSONArray();
          List<Authority> authorities = authorityService.selectAuthorityAll();
          jsonArray.addAll(authorities);
          return jsonArray;
      }*/

    @RequestMapping("addAuthority")
    public String addAuthority(Authority authority, HttpServletRequest request){
        int i = authorityService.addAuthority(authority);
        return "redirect:../showlevel";
    }
    @RequestMapping("readyEdit")
    @ResponseBody
    public Authority readyEdit(Integer id, HttpServletRequest request){
        Authority authority = authorityService.selectAuthorityID(id);

        return authority;
    }
    @RequestMapping("revice")
    @ResponseBody
    public Integer revice(Authority authority, HttpServletRequest request){

        int i = authorityService.reviceAuthority(authority);
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    @RequestMapping("doDelete")
    @ResponseBody
    public Integer doDelete(Integer id, HttpServletRequest request){
        int i = authorityService.removeAuthority(id);
        if (i == 0) {
            return 0;
        }
        return 1;
    }


}
