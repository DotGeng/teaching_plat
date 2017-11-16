package cn.cqupt.teachresource.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private volatile RedisClient redisClient;

    public RedisClient getRedisClient() {

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
