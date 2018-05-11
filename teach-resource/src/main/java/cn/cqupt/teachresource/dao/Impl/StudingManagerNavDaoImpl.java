package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.dao.StudingManagerNavDao;
import cn.cqupt.teachresource.mapper.StudingManagerNavMapper;
import cn.cqupt.teachresource.model.StudingManagerNav;
import cn.cqupt.teachresource.model.StudingManagerNavExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/8.
 */
@Component
public class StudingManagerNavDaoImpl implements StudingManagerNavDao {
    @Autowired
    private StudingManagerNavMapper studingManagerNavMapper;

    @Override
    public List<StudingManagerNav> getStudingManagerNav(StudingManagerNav studingManagerNav) {
        StudingManagerNavExample example = new StudingManagerNavExample();
        CriteriaUtils.getCriteria(example).andNidEqualTo(studingManagerNav.getId());
        return studingManagerNavMapper.selectByExample(example);
    }
}
