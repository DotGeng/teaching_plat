package cn.cqupt.teachresource.service.impl;

import cn.cqupt.model.User;
import cn.cqupt.teachfaced.service.StudentLoadService;
import cn.cqupt.teachresource.Dao.TestDao;
import cn.cqupt.teachresource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Autowired
    private StudentLoadService studentLoadService;

    @Override
    public User getUseByPrimary() {
        System.out.println("开始调用");
        boolean bool = studentLoadService.studentIsLoaded("1");
        System.out.println("dubbo服务调用结果：" + bool);
        return testDao.getUseByPrimary();
    }
}
