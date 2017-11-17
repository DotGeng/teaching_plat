package cn.cqupt.teachresource.service.impl;

import cn.cqupt.model.User;
import cn.cqupt.teachresource.Dao.TestDao;
import cn.cqupt.teachresource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public User getUseByPrimary() {
        return testDao.getUseByPrimary();
    }
}
