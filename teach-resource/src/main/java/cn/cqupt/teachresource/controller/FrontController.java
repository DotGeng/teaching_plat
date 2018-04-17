package cn.cqupt.teachresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YukunGeng on 2018/4/18.
 */
@Controller
public class FrontController {
    @RequestMapping("/student/login/page")
    public String getStudentLoginPage() {
        return "/login";
    }
}
