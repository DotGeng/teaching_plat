package cn.cqupt.teachsso.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private static RedisClient redisClient;

    static {
        redisClient = new RedisClient("192.168.1.102", 6379);
    }

    public String get(String key) {
        String value = redisClient.get(key);
        return value;
    }

    /**
     * 设置不带有过期时间的缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        // 没有设置过期时间
        if (redisClient.set(key, value) != null) {
            return true;
        }
        return false;
    }

    /**
     * 设置带有过期时间的缓存
     *
     * @param key
     * @param value
     * @param period
     * @return
     */
    public boolean set(String key, String value, Integer period) {
        if (redisClient.set(key, value, period) != null) {
            return true;
        }
        return false;
    }

    public boolean del(String key) {
        return redisClient.del(key);
    }

    public boolean expire(String key, Integer period) {
        redisClient.expire(key, period);
        return true;
    }
}
