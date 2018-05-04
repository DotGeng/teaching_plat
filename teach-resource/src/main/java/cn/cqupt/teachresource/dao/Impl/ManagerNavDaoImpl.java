package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.dao.ManagerNavDao;
import cn.cqupt.teachresource.mapper.ManagerNavMapper;
import cn.cqupt.teachresource.model.ManagerNav;
import cn.cqupt.teachresource.model.ManagerNavExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/2.
 */
@Component
public class ManagerNavDaoImpl implements ManagerNavDao {
    @Autowired
    private ManagerNavMapper managerNavMapper;

    @Override
    public List<ManagerNav> getManagerNav(ManagerNav managerNav) {
        ManagerNavExample example = new ManagerNavExample();
        CriteriaUtils.getCriteria(example).andNidEqualTo(managerNav.getId());
        List<ManagerNav> managerNavs = managerNavMapper.selectByExample(example);
        return managerNavs;
    }
}
