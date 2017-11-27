package cn.cqupt.teachsso.util;

import cn.cqupt.teachsso.model.StudentExample;
import cn.cqupt.teachsso.model.TeacherExample;

/**
 * 封装起来的作用是为以后统一加条件
 */
public class CriteriaUtil {
    public static StudentExample.Criteria getStudentCriteria(StudentExample studentExample) {
        StudentExample.Criteria criteria = studentExample.createCriteria();
        return criteria;
    }

    public static TeacherExample.Criteria getTeacherCriteria(TeacherExample teacherExample) {
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        return criteria;
    }
}
