package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.model.User;


import cn.cqupt.teachresource.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TestDaoImpl implements TestDao {
   /* @Autowired
    private UserMapperCustom mapper;

    @Override
    public User getUseByPrimary() {
        return mapper.selectByPrimaryKey(1);
    }*/

    @Override
    public User getUseByPrimary() {
        return null;
    }
}
