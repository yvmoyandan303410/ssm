package com.bus.controller;

import com.bus.entity.Customer;
import com.bus.entity.User;
import com.bus.service.CusVisitService;
import com.bus.service.CustomerService;
import com.bus.service.UserCusService;
import com.bus.service.UserService;
import com.bus.utl.BootstrapPage;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CusController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserCusService userCusService;
    @Autowired
    private CusVisitService cusVisitService;

     /*经理工作*/
    @RequestMapping("showCus")
    @ResponseBody
    public Object showCus(Customer customer,HttpSession session, Integer limit, Integer offset){
        System.out.println("customer = " + customer);
        customer.setEmpoleename((String)session.getAttribute("userName"));
        System.out.println("customer ======= " + customer);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);

        customer.setMap(map);
        List<Customer> page = customerService.findCustomerByPage(customer);
        System.out.println("page = " + page);
        BootstrapPage<Customer> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(customerService.getTotalRecord(customer));
        bootstrapPage.setRows(page);
        return bootstrapPage;
    }


    @RequestMapping("updateCus")
    @ResponseBody
    public Integer update(Customer customer){
        int i = customerService.editCustomer(customer);
        return i;
    }

    @RequestMapping("editCus")
    @ResponseBody
    public Customer edit(Integer id){
        Customer customerById = customerService.findCustomerById(id);
        return customerById;
    }
    @RequestMapping("delCus")
    @ResponseBody
    public Integer del(Integer id, HttpSession session){
        String  userName = (String)session.getAttribute("userName");
        Customer customer = new Customer();
        customer.setEmpoleename(userName);
        customer.setId(id);
        userCusService.removeUsCu(customer);
        return customerService.removeCustomer(id);

    }
    @RequestMapping("add")
    public String add(Customer customer,HttpServletRequest request){
        customerService.addCustomer(customer);
        System.out.println(customer.getId());

        int usernameById = userService.findUsernameById(customer.getEmpoleename());
        customer.setEmpoleeid(usernameById);
        userCusService.addUsCu(customer);

        return "redirect:../customershow";
    }
    @ResponseBody
    @RequestMapping("showAllCustomer")
    public Object showAllCustomer(Customer customer,String name, Integer limit, Integer offset){
        System.out.println("name==="+name);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("currentPage", offset);
        map.put("pageSize",limit);
        if (name != null){
            customer.setUser(new User(name));
        }
        customer.setMap(map);
        List<Customer> page = customerService.findAllCustomer(customer);
        BootstrapPage<Customer> bootstrapPage = new BootstrapPage<>();
        bootstrapPage.setTotal(customerService.getTotalRecord2(customer));
        bootstrapPage.setRows(page);
        return bootstrapPage;
    }

    @ResponseBody
    @RequestMapping("changeCus")
    public Integer changeCus(Integer id,Integer cuid,HttpSession session){
        System.out.println("id = " + id);
        System.out.println("cuid="+  cuid);
        //根据客户id找员工id   在找到员工
        User user = userService.findUserById(customerService.findUidByCid(cuid));
        Customer customer = new Customer();
        customer.setEmpoleename(user.getUserName());
        customer.setId(cuid);
        int i1 = userCusService.removeUsCu(customer);
        customer.setEmpoleeid(id);
        int i = userCusService.addUsCu(customer);
        if(i == 1){
            return i;
        }
        return 0;
    }
    @ResponseBody
    @RequestMapping("showUser")
    public JSONObject showUs(){
        JSONObject result = new JSONObject();
        //查找所有员工
        List<User> page = userService.findUser();
        result.put("list",page);
        return result;
    }
}
