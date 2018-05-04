package cn.cqupt.teachresource.service.impl;

import cn.cqupt.model.User;
import cn.cqupt.teachfaced.service.TeacherLoadService;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YukunGeng on 2018/4/18.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherLoadService teacherLoadService;

    @Override
    public User getUseByPrimary() {
        return null;
    }

    @Override
    public String teacherLoginAction(Teacher teacher) {
        String token = teacherLoadService.teacherLoadAction(teacher.getTeachername(), teacher.getTeacherpw(), teacher.getTeacherrole().toString());

        return token;
    }
}
