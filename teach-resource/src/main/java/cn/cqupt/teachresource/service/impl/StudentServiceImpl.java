package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudentPagingData;
import cn.cqupt.teachresource.dao.StudentDao;
import cn.cqupt.teachresource.model.Student;
import cn.cqupt.teachresource.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/8.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public PagingResponse getStudent(StudentPagingData studentPagingData) {
        PageHelper.startPage(studentPagingData.getPage(), studentPagingData.getRows());
        //PageHelper.orderBy("modify_time desc");
        return studentDao.getStudents(studentPagingData);
    }

    @Override
    public Student getStudentById(Integer id) {

        return studentDao.getStudentById(id);
    }

    @Override
    public boolean updateStudentInfo(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deletingStudentById(Integer id) {
        return studentDao.deletingStudentById(id);
    }

    @Override
    public boolean deletingStudentsByIds(List<Integer> ids) {

        return studentDao.deletingStudentsByIds(ids);
    }

    @Override
    public boolean addStudent(Student student) {

        return studentDao.addingStudent(student);
    }
}
