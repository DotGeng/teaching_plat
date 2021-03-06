package cn.cqupt.teachresource.service;

import cn.cqupt.model.User;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.model.Teacher;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/18.
 */
public interface TeacherService {
    public User getUseByPrimary();

    public String teacherLoginAction(Teacher teacher);

    boolean updateTeacherAccount(Teacher teacher);

    boolean addingTeacher(Teacher teacher);

    PagingResponse getTeacherList(TeacherPagingData teacherPagingData);

    Teacher getTeacherById(Integer id);

    boolean editingTeacher(Teacher teacher);

    Integer deletingTeachers(List<Integer> ids);
}
