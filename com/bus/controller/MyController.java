package com.bus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/addemploy")
    public String addEmploee(){
        return "emploee/addEmploee";
    }

    @RequestMapping("/showemploy")
    public String showEmploees(){
        return "emploee/showAllEmploee";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(){
        return "emploee/updatePassword";
    }

    @RequestMapping("/customershow")
    public String showCustomer(){
        return "customer/showAllCustomer";
    }

    @RequestMapping("/customeradd")
    public String addCustomer(){
        return "customer/addCustomer";
    }

    @RequestMapping("/showCu")
    public String showCu(){
        return "customer/showCu";
    }

    @RequestMapping("/showVisit")
    public String showVisi(){
        return "customervisit/showAllVi";
    }

    @RequestMapping("/showVi")
    public String showVi(){
        return "customervisit/showVi";
    }

    @RequestMapping("/visitadd")
    public String visitadd(){
        return "customervisit/addVisit";
    }

    @RequestMapping("/chaall")
    public String chaall(){
        return "customer/changCus";
    }

    @RequestMapping("/showlevel")
    public String showLevel(){  return "UN/showAllAuthorityAjax"; }

    @RequestMapping("/addlevel")
    public String addlevel(){
        return "UN/addAuthority";
    }

    @RequestMapping("/roleshow")
    public String roleshow(){ return "UN/showAllRoleAjax"; }

    @RequestMapping("/roleadd")
    public String roleadd(){
        return "UN/addRole";
    }

    @RequestMapping("/usershow")
    public String usershow(){
        return "UN/showAllUserAjax";
    }

    @RequestMapping("/divideAuthority")
    public String divideAuthority(){
        return "UN/unionAuthorityModifty";
    }

    @RequestMapping("/showAuthandRol")
    public String showAuthority(){
        return "UN/showAllUnAjax";
    }

}
