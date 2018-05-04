package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachfaced.service.StudentLoadService;
import cn.cqupt.teachresource.dao.StudingTeacherNavDao;
import cn.cqupt.teachresource.mapper.StudingTeacherNavMapper;
import cn.cqupt.teachresource.model.StudingTeacherNav;
import cn.cqupt.teachresource.model.StudingTeacherNavExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
@Component
public class StudingTeacherNavDaoImpl implements StudingTeacherNavDao {
    @Autowired
    private StudingTeacherNavMapper studingTeacherNavMapper;

    @Override
    public List<StudingTeacherNav> getTeacherNavs(StudingTeacherNav studingTeacherNav) {
        StudingTeacherNavExample example = new StudingTeacherNavExample();
        CriteriaUtils.getCriteria(example).andNidEqualTo(studingTeacherNav.getId());
        return studingTeacherNavMapper.selectByExample(example);
    }
}
