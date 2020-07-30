package com.bus.controller;

import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;
import com.bus.entity.Role;
import com.bus.entity.User;
import com.bus.service.CustomerService;
import com.bus.service.UserService;
import com.bus.utl.BootstrapPage;
import com.bus.utl.Page;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;


     /*经理工作*/
     @ResponseBody
     @RequestMapping("showUs")
     public JSONObject showUs(Integer id){
         JSONObject result = new JSONObject();
         //查找所有员工
         List<User> page = userService.findUser();
         //根据id选择客户
         Customer cu = customerService.findCustomerById(id);
         //根据客户id找员工id
         cu.setEmpoleeid(customerService.findUidByCid(id));

         result.put("list",page);
         result.put("cu",cu);

         return result;
     }

    @ResponseBody
    @RequestMapping("showUserEm")
    public Object showUsers(User users,Integer limit,Integer offset){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);

        users.setMap(map);

        List<User> page = userService.findUserByPage(users);
        //因为使用table插件来分页，所以传回的数据应该符合table插件的使用格式
        BootstrapPage<User> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(userService.getTotalRecord(users));
        bootstrapPage.setRows(page);
        return bootstrapPage;
    }

    @RequestMapping("update")
    @ResponseBody
    public Integer update(User users){
        System.out.println("users = " + users);
        int result = 0;
        User user = userService.findUserById(users.getUserId());
        System.out.println("user = " + user);
        if (user.getUserPassword().equals(users.getUserPassword()) ){
            result = userService.editUser(users);
        }else{
            String salt = "skeye";
            String password = new Md5Hash(users.getUserPassword(), salt, 2).toString();
            users.setUserPassword(password);
            result = userService.editUser(users);
        }
        if(result != 0){
            return 1;
        }
        return 0;
    }

    @RequestMapping("edit")
    @ResponseBody
    public User edit(Integer id){
        User userById = userService.findUserById(id);
        return userById;
    }
    @RequestMapping("del")
    @ResponseBody
    public Integer del(Integer id){
        int result = userService.removeUser(id);
        if(result != 0){
            return 1;
        }
        return 0;
    }
    @RequestMapping("add")
    public String add(User users,HttpServletRequest request){
        System.out.println("users = " + users);
        String salt = "skeye";
        String password = new Md5Hash(users.getUserPassword(), salt, 2).toString();
        users.setUserPassword(password);
        users.setRoleId(5);
        userService.addEmploee(users);

        return "redirect:../showemploy";
    }


    @RequestMapping("updatePassword")
    @ResponseBody
    public String updatePassword(User user,HttpServletRequest request){

        System.out.println("userName="+user.getUserName());
        System.out.println("userPassword = " + user.getUserPassword());
        String salt = "skeye";
        String password = new Md5Hash(user.getUserPassword(), salt, 2).toString();
        user.setUserPassword(password);
        System.out.println("修改加密后的密码"+password);
        int i = userService.editPassword(user);
        System.out.println("i = " + i);
         if (i == 1){
             Subject subject = SecurityUtils.getSubject();
             subject.logout();
             return "ok";
         }
        return "error";
    }


    @RequestMapping("showUser")
    @ResponseBody
    public Object showUser(User users,Integer limit,Integer offset){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);
        users.setMap(map);
        List<User> page = userService.selectAllUser(users);
        //因为使用table插件来分页，所以传回的数据应该符合table插件的使用格式
        BootstrapPage<User> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(userService.getTotalRecordAll());
        bootstrapPage.setRows(page);
        return bootstrapPage;
    }
    /*public JSONArray showUser(){
        System.out.println("userService = -----------");
        JSONArray jsonArray = new JSONArray();
        List<User> userList = userService.selectAllUser();
        System.out.println("userList = " + userList);
        jsonArray.addAll(userList);
        return jsonArray;
    }*/
}
