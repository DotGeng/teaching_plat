package cn.cqupt.teachsso.service.impl;

import cn.cqupt.teachfaced.service.StudentLoadService;
import cn.cqupt.teachsso.dao.StudentDao;
import cn.cqupt.teachsso.model.Student;
import cn.cqupt.teachsso.redis.RedisService;
import cn.cqupt.teachsso.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("studentLoadService")
public class StudentLoadServiceImpl implements StudentLoadService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private StudentDao studentDao;
    @Override
    public boolean studentIsLoaded(String userNo) {
        if(redisService.get(userNo)!= null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean studentLoadAction(String userNo, String password) {
        // 先从数据库中获取数据，获取数据成功后，在加载内存中
        Student student = studentDao.getStudentByStudentNo(userNo);
        if(student != null) {
            // 登录成功，缓存至redis中
            String userJson = JsonUtils.objectToJson(student);
            // 缓存时间设置为15分钟
            redisService.set(userNo, userJson, 15 * 60);
            return true;
        }
        return false;
    }

    @Override
    public boolean studentLogout(String userNo) {
        return redisService.del(userNo);
    }




}
