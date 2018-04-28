package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.dao.TeacherNavDao;
import cn.cqupt.teachresource.mapper.TeacherNavMapper;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.model.TeacherNavExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/20.
 */
@Component
public class TeacherNavDaoImpl implements TeacherNavDao {
    @Autowired
    private TeacherNavMapper teacherNavMapper;
    @Override
    public List<TeacherNav> getTeacherNavDaoByNid(TeacherNav teacherNav) {
        TeacherNavExample example = new TeacherNavExample();
        CriteriaUtils.getCriterai(example).andNidEqualTo(teacherNav.getId());
        List<TeacherNav> teacherNavs = teacherNavMapper.selectByExample(example);
        return teacherNavs;
    }
}
