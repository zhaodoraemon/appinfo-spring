package com.controller.backend;

import com.service.Impl.BackendUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/jsp/backend")
@Controller public class BackendLogin {
    @Autowired
    private BackendUserServiceImpl b;


    @RequestMapping("/login.do")
    public String managerlogin(String username, String password, Model model, HttpServletRequest request) {
        System.out.println("----------"+username);
        if (b.selectByPrimaryKey(username) != null) {
            if (password.equals(b.selectByPrimaryKey(username).getUserpassword())) {
                request.getSession().setAttribute("usersession",b.selectByPrimaryKey(username));
                return "/backend/main";
            } else {
                model.addAttribute("loginFlag", "用户名或密码错误");
                // 登录失败，转发到登录页面
                return "/backend/backendlogin";
            }

        }
        else {
            model.addAttribute("loginFlag", "用户名或密码错误");
            // 登录失败，转发到登录页面
            return "/backend/backendlogin";
        }

    }

    @RequestMapping("/logout.do")
    public String backendlogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/run";
    }

}