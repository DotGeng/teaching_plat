package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudentPagingData;
import cn.cqupt.teachresource.model.Student;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/8.
 */
public interface StudentDao {
    PagingResponse getStudents(StudentPagingData studentPagingData);

    Student getStudentById(Integer id);

    boolean updateStudent(Student student);

    boolean deletingStudentById(Integer id);

    boolean deletingStudentsByIds(List<Integer> ids);

    boolean addingStudent(Student student);
}
