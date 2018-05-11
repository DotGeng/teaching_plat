package cn.cqupt.teachresource.service.impl;

import cn.cqupt.model.User;
import cn.cqupt.teachfaced.service.StudentLoadService;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.dao.TestDao;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public PagingResponse getTeacherList(TeacherPagingData teacherPagingData) {

        return null;
    }
}
