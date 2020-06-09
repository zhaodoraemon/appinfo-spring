package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contorller {
    @RequestMapping("run")
    public String run(){
        System.out.println("进入入口");
        return "index";
    }
}
