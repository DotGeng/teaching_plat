package cn.cqupt.teachresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YukunGeng on 2018/4/18.
 */
//不登录既可以看到的内容
@Controller
public class FrontController {
    @RequestMapping("/static/login/page")
    public String getLoginPage() {
        /*return "/login";*/
        return "/login-eui";
    }

    @RequestMapping("/static/resource/teacher/index")
    public String getIndexForTeacher() {
        return "/teacherIndex";
    }

    @RequestMapping("/static/resource/teacher/article/manager")
    public String getArticleAddForTeacher() {
        return "/teacher_article_manger";
    }

    @RequestMapping("/static/test")
    public String mytest() {
        return "/test";
    }
}
