package cn.cqupt.teachsso.service.impl;

import cn.cqupt.teachfaced.service.StudentLoadService;
import cn.cqupt.teachsso.dao.StudentDao;
import cn.cqupt.teachsso.dao.TeacherDao;
import cn.cqupt.teachsso.model.Student;
import cn.cqupt.teachsso.model.Teacher;
import cn.cqupt.teachsso.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IDUtils;
import util.JsonUtils;


@Service("studentLoadService")
public class StudentLoadServiceImpl implements StudentLoadService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public boolean studentIsLoaded(String studentToken) {
        String json = redisService.get(studentToken);
        if (json != null) {
            redisService.expire(studentToken, 15 * 60);
            return true;
        }
        return false;
    }

    @Override
    public String studentLoadAction(String userNo, String password) {
        // 先从数据库中获取数据，获取数据成功后，在加载内存中
        Student student = studentDao.getStudentByStudentNo(userNo);
        if (student != null) {
            // 登录成功，缓存至redis中
            String userJson = JsonUtils.objectToJson(student);
            // 缓存时间设置为15分钟
            String token = IDUtils.genStudentToken(userNo);
            redisService.set(token, userJson, 15 * 60);
            return token;
        }
        return null;
    }

    @Override
    public boolean studentLogout(String studentToken) {
        return redisService.del(studentToken);
    }

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
