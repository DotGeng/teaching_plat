package cn.cqupt.teachresource.Dao.Impl;

import cn.cqupt.mapper.UserMapper;
import cn.cqupt.mapper.UserMapperCustom;
import cn.cqupt.model.User;
import cn.cqupt.teachresource.Dao.TestDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TestDaoImpl implements TestDao {
    @Autowired
    private UserMapperCustom mapperCustom;
    @Override
    public User getUseByPrimary() {
        return mapperCustom.selectByPrimaryKey(1);
    }
}
