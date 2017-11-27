package cn.cqupt.teachresource.redis;

import cn.cqupt.teachfaced.service.StudentLoadService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class RedisService {




    private volatile RedisClient redisClient;


    public RedisClient getRedisClient() {

        /*// 测试dubbo微服务接口
        System.out.println("开始调用");
        boolean bool = studentLoadService.studentIsLoaded("zhangsan");
        System.out.println("dubbo服务调用结果：" + bool);*/
        if(redisClient == null) {
            synchronized (RedisService.class) {
                if (redisClient == null) {
                    redisClient = new RedisClient("127.0.0.1",6379, "myRedis123");
                }
            }
        }
        return redisClient;
    }
}
