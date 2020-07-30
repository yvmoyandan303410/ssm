package com.bus.controller;

import com.bus.entity.Authority;
import com.bus.entity.Role;
import com.bus.entity.User;
import com.bus.service.AuthorityService;
import com.bus.service.UserService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userName,String password, HttpSession session, HttpServletRequest request , Model model){
        System.out.println("userName = ===================" );

        String msg = null;
        Subject sub = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            session.setAttribute("userName",userName);
            //3-2：认证
            sub.login(token);
            //查看认证状态
            System.out.println(sub.isAuthenticated());
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            msg = "账号错误";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            msg = "密码错误";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "其他错误";
        }
        if (null != msg) {
            session.setAttribute("msg", msg);
            return "redirect:log";
        }
        session.setAttribute("userName",userName);
        List<Authority> allPer = authorityService.findAllPer();
        model.addAttribute("allPer",allPer);
        return "main";
    }

    @RequestMapping("/index")
    public String main(){

        return "main";
    }
    @RequestMapping("/right")
    public String right(HttpSession session){

        return "index";
    }
    @RequestMapping("/log")
    public String log(HttpSession session){

        return "login";
    }


    //查找角色
    @ResponseBody
    @RequestMapping("showRole")
    public JSONObject showRole(){
        JSONObject result = new JSONObject();
        List<Role> roles = userService.selectRole();
        result.put("list",roles);
        return result;
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(User user,HttpServletRequest request){

        String salt = "skeye";
        String password = new Md5Hash(user.getUserPassword(), salt, 2).toString();
        user.setUserPassword(password);
        int i = userService.addEmploee(user);

        return "log";
    }
}
