package cn.cqupt.teachsso.dao.impl;

import cn.cqupt.teachsso.dao.TeacherDao;
import cn.cqupt.teachsso.mapper.TeacherMapper;
import cn.cqupt.teachsso.model.Teacher;
import cn.cqupt.teachsso.model.TeacherExample;
import cn.cqupt.teachsso.util.CriteriaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByTeacherName(String teacherName) {
        TeacherExample example = new TeacherExample();
        CriteriaUtil.getTeacherCriteria(example).andTeachernameEqualTo(teacherName);
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers != null && teachers.size() > 0) {
            return teachers.get(0);
        }
        return null;
    }
}
