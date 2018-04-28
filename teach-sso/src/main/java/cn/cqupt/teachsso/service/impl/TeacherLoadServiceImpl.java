package cn.cqupt.teachsso.service.impl;

import cn.cqupt.teachfaced.service.TeacherLoadService;
import cn.cqupt.teachsso.dao.TeacherDao;
import cn.cqupt.teachsso.model.Teacher;
import cn.cqupt.teachsso.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IDUtils;
import util.JsonUtils;

/**
 * Created by YukunGeng on 2018/4/18.
 */
@Service("teacherLoadService")
public class TeacherLoadServiceImpl implements TeacherLoadService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public boolean teacherIsLoaded(String teacherName) {
        String json = redisService.get(teacherName);
        if (json != null) {
            redisService.expire(teacherName, 15 * 60);
            return true;
        }
        return false;
    }

    @Override
    public String teacherLoadAction(String teacherName, String password) {
        // 先从数据库中获取数据，获取数据成功后，在加载内存中
        Teacher teahcer = teacherDao.getTeacherByTeacherName(teacherName);
        if (teahcer != null) {
            // 登录成功，缓存至redis中
            String userJson = JsonUtils.objectToJson(teahcer);
            // 缓存时间设置为15分钟
            String token = IDUtils.genTeacherToken(teacherName);
            redisService.set(token, userJson, 15 * 60);
            return token;
        }
        return null;
    }

    @Override
    public boolean teacherLogout(String teacherToken) {
        return redisService.del(teacherToken);
    }
    // 还有一个超级管理员的单点登录
}
