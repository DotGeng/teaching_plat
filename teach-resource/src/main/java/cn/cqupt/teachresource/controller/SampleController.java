package cn.cqupt.teachresource.controller;

import cn.cqupt.model.User;
import cn.cqupt.teachresource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    private TestService testService;

    @RequestMapping("/getUserById")
    public User getUserById() {
        return testService.getUseByPrimary();
    }
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
