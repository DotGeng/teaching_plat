package cn.cqupt.teachresource.controller;


import cn.cqupt.model.User;
import cn.cqupt.teachresource.redis.RedisService;
import cn.cqupt.teachresource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    private TestService testService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/getUserById")
    public User getUserById() {
        return testService.getUseByPrimary();
    }

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/getRedisValue")
    public String getRedisValue() {
       /* RedisClient redisClient = redisService.getRedisClient();
        String res = redisClient.get("name");
        return res == null ? "缓存暂无数据" : res;*/
        return null;
    }

    @RequestMapping("/setValueToRedis")
    public String setValueToRedis() {
        //redisService.getRedisClient().set("name", "jerry");
        return "ok";
    }
}
