package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.dao.ManagerNavDao;
import cn.cqupt.teachresource.model.ManagerNav;
import cn.cqupt.teachresource.service.ManagerNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/2.
 */
@Service
public class ManagerNavServiceImpl implements ManagerNavService {
    @Autowired
    private ManagerNavDao managerNavDao;

    @Override
    public List<ManagerNav> getManagerNavs(ManagerNav managerNav) {
        if (managerNav.getId() == null) {
            managerNav.setId(0);
        }
        return managerNavDao.getManagerNav(managerNav);
    }
}
