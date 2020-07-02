package com.ydgk.crowd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHandler {
    @RequestMapping("/test/aaa/bbb/ccc.html")
    public String doTest() {
        return "target";
    }
    @RequestMapping("/admin/to/login/page.html")
     public String doTestAdminLogin(){
        return "pages/admin-login";
    }
}
