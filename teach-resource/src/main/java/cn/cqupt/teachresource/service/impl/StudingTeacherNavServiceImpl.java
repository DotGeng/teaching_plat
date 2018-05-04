package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.dao.StudingTeacherNavDao;
import cn.cqupt.teachresource.model.StudingTeacherNav;
import cn.cqupt.teachresource.service.StudingTeacherNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
@Service
public class StudingTeacherNavServiceImpl implements StudingTeacherNavService {

    @Autowired
    private StudingTeacherNavDao studingTeacherNavDao;

    @Override
    public List<StudingTeacherNav> getTeacherNavs(StudingTeacherNav studingTeacherNav) {
        if (studingTeacherNav.getId() == null) {
            studingTeacherNav.setId(0);
        }
        return studingTeacherNavDao.getTeacherNavs(studingTeacherNav);
    }
}
