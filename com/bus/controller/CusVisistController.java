package com.bus.controller;

import com.bus.entity.Customer;
import com.bus.entity.CustomerVisit;

import com.bus.entity.User;
import com.bus.service.CusVisitService;
import com.bus.service.UserCusService;
import com.bus.service.UserService;
import com.bus.utl.BootstrapPage;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("Visit")
public class CusVisistController {

    @Autowired
    private UserService userService;
    @Autowired
    private CusVisitService cusVisitService;

    @RequestMapping("showCustomerVisit")
    @ResponseBody
    public Object showCustomerVisit(HttpSession session, Integer limit, Integer offset){
        int userid = userService.findUsernameById((String) session.getAttribute("userName"));
        CustomerVisit customervisit = new CustomerVisit();
        customervisit.setEmpoleeid(userid);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);
        customervisit.setMap(map);

        List<CustomerVisit> page = cusVisitService.findAllCusVi(customervisit);
        BootstrapPage<CustomerVisit> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(cusVisitService.getTotalRecord(customervisit));
        bootstrapPage.setRows(page);
        return bootstrapPage;
    }

    @RequestMapping("updateCusVisit")
    @ResponseBody
    public Integer update(CustomerVisit customervisit){

        int i = cusVisitService.editCusVi(customervisit);
        return i;
    }

    @RequestMapping("editCusVisit")
    @ResponseBody
    public CustomerVisit edit(Integer id){
        System.out.println("id = " + id);
        CustomerVisit viById = cusVisitService.findViById(id);
        System.out.println("viById = " + viById);
        return viById;
    }
    @RequestMapping("delCusVisit")
    @ResponseBody
    public Integer del(Integer id){
        int i = cusVisitService.removeCusVi(id);
        return i;
    }

    @RequestMapping("addVisit")
    public String add(Integer cusId,CustomerVisit customervisit, HttpSession session){
        System.out.println("customervisit = " + customervisit);
        int userId = userService.findUsernameById((String) session.getAttribute("userName"));
        System.out.println("userId = " + userId);
        //customervisit.setEmpoleeid(userId);
        customervisit.setUserId(userId);
        customervisit.setCustomer(new Customer(cusId));
        cusVisitService.addCusVi(customervisit);
        return "redirect:../showVisit";

    }

    @RequestMapping("selectmust")
    @ResponseBody
    public JSONObject selectmust( HttpSession session){
        JSONObject result = new JSONObject();

        //查找员工对应的客户
        List<Customer> customerList = cusVisitService.selectCusByUserName((String) session.getAttribute("userName"));
        result.put("list",customerList);
        return result;
    }
    @ResponseBody
    @RequestMapping("showAllVi")
    public Object showAllVi( HttpSession session, Integer limit, Integer offset){
        CustomerVisit customervisit = new CustomerVisit();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);
        customervisit.setMap(map);

        List<CustomerVisit> page = cusVisitService.findAllVi(customervisit);
        //因为使用table插件来分页，所以传回的数据应该符合table插件的使用格式
        BootstrapPage<CustomerVisit> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(cusVisitService.getTotalRecord2(customervisit));
        bootstrapPage.setRows(page);
        return bootstrapPage;
    }
}
