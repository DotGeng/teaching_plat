package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.dao.StudingManagerNavDao;
import cn.cqupt.teachresource.service.StudingManagerNavService;
import cn.cqupt.teachresource.model.StudingManagerNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/8.
 */
@Service
public class StudingManagerNavServiceImpl implements StudingManagerNavService {
    @Autowired
    private StudingManagerNavDao studingManagerNavDao;

    @Override
    public List<StudingManagerNav> getStudingManagerNav(StudingManagerNav studingManagerNav) {
        if (studingManagerNav.getId() == null) {
            studingManagerNav.setId(0);
        }
        return studingManagerNavDao.getStudingManagerNav(studingManagerNav);
    }
}
