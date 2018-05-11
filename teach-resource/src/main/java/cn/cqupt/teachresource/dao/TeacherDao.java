package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.model.Teacher;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/7.
 */
public interface TeacherDao {
    boolean updataTeacherAccount(Teacher teacher);

    boolean addingTeacher(Teacher teacher);

    PagingResponse getTeachers(TeacherPagingData teacherPagingData);

    Teacher getTeacherById(Integer id);

    boolean editingTeacher(Teacher teacher);

    Integer deletingTeachers(List<Integer> ids);
}
