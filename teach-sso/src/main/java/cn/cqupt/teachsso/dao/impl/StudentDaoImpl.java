package cn.cqupt.teachsso.dao.impl;

import cn.cqupt.teachsso.dao.StudentDao;
import cn.cqupt.teachsso.mapper.StudentMapper;
import cn.cqupt.teachsso.model.Student;
import cn.cqupt.teachsso.model.StudentExample;
import cn.cqupt.teachsso.util.CriteriaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentByStudentNo(String studentNo) {
        StudentExample studentExample = new StudentExample();
        CriteriaUtil.getStudentCriteria(studentExample).andStudentNoEqualTo(studentNo);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        if (studentList != null && studentList.size() > 0) {
            return studentList.get(0);
        }
        return null;
    }

    @Override
    public Student getStuidentByNoAndPaswd(String studentNo, String password) {
        StudentExample studentExample = new StudentExample();
        CriteriaUtil.getStudentCriteria(studentExample).andStudentNoEqualTo(studentNo).andStudentPswdEqualTo(password);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        if (studentList != null && studentList.size() > 0) {
            return studentList.get(0);
        }
        return null;
    }
}
