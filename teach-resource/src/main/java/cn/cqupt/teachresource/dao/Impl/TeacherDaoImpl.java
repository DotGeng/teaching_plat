package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.dao.TeacherDao;
import cn.cqupt.teachresource.mapper.TeacherMapper;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.model.TeacherExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/7.
 */
@Component
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public boolean updataTeacherAccount(Teacher teacher) {
        if (teacherMapper.updateByPrimaryKeySelective(teacher) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addingTeacher(Teacher teacher) {
        int count = teacherMapper.insert(teacher);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public PagingResponse getTeachers(TeacherPagingData teacherPagingData) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = CriteriaUtils.getCriteria(example);
        if (teacherPagingData.getTeachername() != null && !"".equals(teacherPagingData.getTeachername())) {
            criteria.andTeachernameEqualTo(teacherPagingData.getTeachername());
        }
        PagingResponse pr = new PagingResponse();
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        int count = teacherMapper.countByExample(example);
        pr.setRows(teachers);
        pr.setTotal(count);
        return pr;
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean editingTeacher(Teacher teacher) {
        int count = teacherMapper.updateByPrimaryKeySelective(teacher);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Integer deletingTeachers(List<Integer> ids) {
        TeacherExample example = new TeacherExample();
        CriteriaUtils.getCriteria(example).andTeacheridIn(ids);

        return teacherMapper.deleteByExample(example);
    }
}
