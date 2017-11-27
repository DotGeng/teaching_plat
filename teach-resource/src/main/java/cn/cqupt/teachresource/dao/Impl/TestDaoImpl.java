package cn.cqupt.teachresource.Dao.Impl;


import cn.cqupt.model.User;
import cn.cqupt.teachresource.Dao.TestDao;


import cn.cqupt.teachresource.mapper.UserMapper;
import cn.cqupt.teachresource.mapper.UserMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TestDaoImpl implements TestDao {
    @Autowired
    private UserMapperCustom mapper;
    @Override
    public User getUseByPrimary() {
        return mapper.selectByPrimaryKey(1);
    }
}
