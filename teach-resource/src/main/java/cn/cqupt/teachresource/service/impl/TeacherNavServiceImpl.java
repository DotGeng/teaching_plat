package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.dao.TeacherNavDao;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.TeacherNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/20.
 */
@Service
public class TeacherNavServiceImpl implements TeacherNavService {
    @Autowired
    private TeacherNavDao teacherNavDao;

    @Override
    public List<TeacherNav> getTeacherNavs(TeacherNav teacherNav) {
        if (teacherNav.getId() == null) {
            teacherNav.setId(0);
        }
        List<TeacherNav> teacherNavs = teacherNavDao.getTeacherNavDaoByNid(teacherNav);
        return teacherNavs;
    }
}
