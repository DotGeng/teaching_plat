package cn.cqupt.teachresource.service;

import cn.cqupt.model.User;
import cn.cqupt.teachresource.model.Teacher;

/**
 * Created by YukunGeng on 2018/4/18.
 */
public interface TeacherService {
    public User getUseByPrimary();

    public String teacherLoginAction(Teacher teacher);
}
