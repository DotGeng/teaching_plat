package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudentPagingData;
import cn.cqupt.teachresource.dao.StudentDao;
import cn.cqupt.teachresource.mapper.StudentMapper;
import cn.cqupt.teachresource.model.Student;
import cn.cqupt.teachresource.model.StudentExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/8.
 */
@Component
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PagingResponse getStudents(StudentPagingData studentPagingData) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = CriteriaUtils.getCriteria(example);
        if (studentPagingData.getStudentno() != null) {
            criteria.andStudentnoLike("%" + studentPagingData.getStudentno() + "%");
        }
        List<Student> students = studentMapper.selectByExample(example);
        int count = studentMapper.countByExample(example);
        PagingResponse pr = new PagingResponse();
        pr.setTotal(count);
        pr.setRows(students);
        return pr;
    }

    @Override
    public Student getStudentById(Integer id) {
        StudentExample example = new StudentExample();
        CriteriaUtils.getCriteria(example).andStudentidEqualTo(id);
        List<Student> students = studentMapper.selectByExample(example);
        if (students != null && students.size() > 0) {
            return students.get(0);
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student student) {
        StudentExample example = new StudentExample();
        CriteriaUtils.getCriteria(example).andStudentidEqualTo(student.getStudentid());
        if (studentMapper.updateByExampleSelective(student, example) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deletingStudentById(Integer id) {
        StudentExample example = new StudentExample();
        CriteriaUtils.getCriteria(example).andStudentidEqualTo(id);
        studentMapper.deleteByExample(example);
        return true;
    }

    @Override
    public boolean deletingStudentsByIds(List<Integer> ids) {
        StudentExample example = new StudentExample();
        CriteriaUtils.getCriteria(example).andStudentidIn(ids);
        studentMapper.deleteByExample(example);
        return true;
    }

    @Override
    public boolean addingStudent(Student student) {
        int count = studentMapper.insertSelective(student);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
