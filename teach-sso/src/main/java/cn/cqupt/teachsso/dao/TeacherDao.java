package cn.cqupt.teachsso.dao;

import cn.cqupt.teachsso.model.Teacher;

public interface TeacherDao {
    public Teacher getTeacherByTeacherName(String teacherName);
}
