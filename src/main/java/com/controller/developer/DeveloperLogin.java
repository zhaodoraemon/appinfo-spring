package com.controller.developer;

import com.service.Impl.DevUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/jsp/developer")
public class DeveloperLogin {
    @Autowired
    @Qualifier("dev")
    DevUserServiceImpl b;

    @RequestMapping("/login.do")
    public String devlogin(String devCode, String devPassword, Model model, HttpServletRequest request){
        if (b.selectByPrimaryKey(devCode) != null) {
            if (devPassword.equals(b.selectByPrimaryKey(devCode).getDevpassword())) {
                request.getSession().setAttribute("devUserSession",b.selectByPrimaryKey(devCode).getDevname());
                return "/developer/main";
            } else {
                model.addAttribute("loginFlag", "用户名或密码错误");
                // 登录失败，转发到登录页面
                return "/developer/devlogin";
            }

        }
        else {
            model.addAttribute("loginFlag", "用户名或密码错误");
            // 登录失败，转发到登录页面
            return "/developer/devlogin";
        }
    }
    @RequestMapping("/logout.do")
    public String backendlogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/run";
    }
}
