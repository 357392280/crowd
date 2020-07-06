package com.ydgk.crowd.controller;

import com.ydgk.crowd.entity.Admin;

import com.ydgk.crowd.service.api.AdminService;
import com.ydgk.crowd.ssm.constant.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

@Autowired
    private AdminService adminService;
   @RequestMapping("/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userpswd") String userpswd,
                          HttpSession session ){
//        调用service执行登录程序

       // Admin admin= adminService.getAdminByLoginAcct(loginAcct,userpswd);
       Admin admin=adminService.getAdminByLoginAcct(loginAcct,userpswd);
//        将执行登录的返回结果返回到session中

        session.setAttribute(CrowdConstant.ATTR_NAME_ADMIN_INFO,admin);

        return "redirect:/admin/to/main.html";
    }
}
