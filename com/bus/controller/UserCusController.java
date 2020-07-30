package com.bus.controller;

import com.bus.entity.Usercustmoer;
import com.bus.service.UserCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("admin/userCus")
public class UserCusController {
    @Autowired
    private UserCusService userCusService;


    /*@RequestMapping("show")
     public String show(HttpServletRequest request, Model model, HttpServletResponse response){
        List<Usercustmoer> usercustmoers = userCusService.
        //System.out.println("usercustmoers = " + usercustmoers);

        //model.addAttribute("list",usercustmoers);

        //return "CustomerUser/showUn";
    }*/


   /* @RequestMapping("update")
    @ResponseBody
    public String update(HttpServletRequest request){
        int employId = Integer.parseInt(request.getParameter("employId"));
        System.out.println("employId = " + employId);
        String employPassword = request.getParameter("employPassword");
        System.out.println("employPassword = " + employPassword);

        int i = userService.deleteEmploy(new User(employId, employPassword));
        System.out.println("i = " + i);
        return "i";
    }

    @RequestMapping("edit")
    @ResponseBody
    public User edit(Integer employId){
        *//*int employId = Integer.parseInt(request.getParameter("employId"));*//*
        System.out.println("employId = " + employId);
        User user = userService.selectEditByEmployId(employId);
        System.out.println("user = " + user);
        //JSONObject json = JSONObject.fromObject(user);
        return user;
    }
    @RequestMapping("del")
    @ResponseBody
    public Integer del(HttpServletRequest request){
        int employId = Integer.parseInt(request.getParameter("employId"));
        System.out.println("employId = " + employId);

        int i = userService.delEmploy(employId);
        return i;
    }
    @RequestMapping("add")
    @ResponseBody
    public Integer add(HttpServletRequest request){
        String employName2 = request.getParameter("employName2");
        System.out.println("employName2 = " + employName2);
        String employPassword2 = request.getParameter("employPassword2");
        System.out.println("employPassword2 = " + employPassword2);
        int i = userService.insertEmploy(new User(employName2,employPassword2));
        return i;
    }

    @RequestMapping("showCustomer")
    public String showCustomer( Model model){
        List<Customer> customerList = userService.selectCustomers();

        model.addAttribute("list",customerList);

        return "Customer/showCustomers";
    }
    @RequestMapping("showCustomerVisit")
    public String showCustomerVisit( Model model){
        List<CustomerVisit> customerVisits = userService.selectCustomerVisit();

        model.addAttribute("list",customerVisits);

        return "Customer/showCustomerVisit";
    }*/

}
