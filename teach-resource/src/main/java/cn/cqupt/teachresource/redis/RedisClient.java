package cn.cqupt.teachresource.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {
    private JedisPool pool = null;

    public RedisClient(String ip, int prot) {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
            // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(5);
            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWaitMillis(1000 * 100);
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(false);
            // pool = new JedisPool(config, "192.168.0.121", 6379, 100000);
            // 测试环境的redis有密码
            pool = new JedisPool(config, ip, prot, 5000);
        }
    }
    public RedisClient(String ip, int prot, String password) {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
            // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(5);
            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWaitMillis(1000 * 100);
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(false);
            // pool = new JedisPool(config, "192.168.0.121", 6379, 100000);
            if ("".equals(password)) {
                password = null;
            }
            pool = new JedisPool(config, ip, prot, 5000, password);
        }
    }

    /**
     *
     * @param ip 服务器地址
     * @param prot 端口号
     * @param database 选着redis的第几个库， 默认的第0g， redis默认具有16个库，  不建议选着这个方法
     */
    public RedisClient(String ip, int prot, int database) {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
            // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(5);
            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWaitMillis(1000 * 100);
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(false);
            // pool = new JedisPool(config, "192.168.0.121", 6379, 100000);
            pool = new JedisPool(config, ip, prot, 5000, null, database);
        }
    }

    /**
     * <p>
     * 通过配置对象 ip 端口 构建连接池
     * </p>
     *
     * @param config 配置对象
     * @param ip     ip
     * @param prot   端口
     */
    public RedisClient(JedisPoolConfig config, String ip, int prot) {
        if (pool == null) {
            pool = new JedisPool(config, ip, prot, 5000);
        }
    }

    /**
     * <p>
     * 通过配置对象 ip 端口 超时时间 构建连接池
     * </p>
     *
     * @param config  配置对象
     * @param ip      ip
     * @param prot    端口
     * @param timeout 超时时间
     */
    public RedisClient(JedisPoolConfig config, String ip, int prot, int timeout) {
        if (pool == null) {
            pool = new JedisPool(config, ip, prot, timeout);
        }
    }

    /**
     * <p>
     * 通过连接池对象 构建一个连接池
     * </p>
     *
     * @param pool 连接池对象
     */
    public RedisClient(JedisPool pool) {
        if (this.pool == null) {
            this.pool = pool;
        }
    }

    /**
     * <p>
     * 通过key获取储存在redis中的value
     * </p>
     * <p>
     * 并释放连接
     * </p>
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } /*finally {
            returnResource(pool, jedis);
        }*/
        return value;
    }

    public void  set(String key, String value) {
        Jedis jedis = null;
        jedis = pool.getResource();
        jedis.set(key, value);
    }
}
