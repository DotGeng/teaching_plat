package cn.cqupt.teachresource.service;

import cn.cqupt.model.User;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.model.Teacher;

import java.util.List;

public interface TestService {
    public User getUseByPrimary();

    public PagingResponse getTeacherList(TeacherPagingData teacherPagingData);
}
