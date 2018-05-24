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
        return "login-eui";
    }

    @RequestMapping("/static/resource/teacher/index")
    public String getIndexForTeacher() {
        return "teacherIndex";
    }

    @RequestMapping("/static/resource/manager/index")
    public String getIndexForManager() {
        return "managerIndex";
    }

    @RequestMapping("/article/manager")
    public String getArticleAddForTeacher() {
        return "teacher_article_manger";
    }


    @RequestMapping("/static/test")
    public String mytest() {
        return "test";
    }

    @RequestMapping("/static/accountInfo")
    public String accountInfo() {
        return "account_manager";
    }

    @RequestMapping("/static/visitors")
    public String visitors() {
        return "visitor_account";
    }

    @RequestMapping("/static/database/backup")
    public String databaseBackup() {
        return "database-backup";
    }

    @RequestMapping("/static/database/restore")
    public String databaseRestore() {
        return "database-restore";
    }

    @RequestMapping("/static/experiment/index")
    public String getIndexExperimentIndex() {
        return "experiment_report_index";
    }

    @RequestMapping("/static/report_manager")
    public String getReportsManager() {
        return "report_manager";
    }

    // 为了限制js能请求到，设置一层结构
    @RequestMapping("/test/ueditor")
    public String getTestEditor() {
        return "index";
    }
}
