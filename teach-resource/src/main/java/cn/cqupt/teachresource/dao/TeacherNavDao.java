package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.model.TeacherNav;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/20.
 */
public interface TeacherNavDao {
    public List<TeacherNav> getTeacherNavDaoByNid(TeacherNav teacherNav);
}
