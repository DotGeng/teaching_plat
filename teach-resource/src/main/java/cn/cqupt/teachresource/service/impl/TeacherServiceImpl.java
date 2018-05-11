package cn.cqupt.teachresource.service.impl;

import cn.cqupt.model.User;
import cn.cqupt.teachfaced.service.TeacherLoadService;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.dao.TeacherDao;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.service.TeacherService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/18.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherLoadService teacherLoadService;

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public User getUseByPrimary() {
        return null;
    }

    @Override
    public String teacherLoginAction(Teacher teacher) {
        String token = teacherLoadService.teacherLoadAction(teacher.getTeachername(), teacher.getTeacherpw(), teacher.getTeacherrole().toString());

        return token;
    }

    @Override
    public boolean updateTeacherAccount(Teacher teacher) {
        return teacherDao.updataTeacherAccount(teacher);
    }

    @Override
    public boolean addingTeacher(Teacher teacher) {
        return teacherDao.addingTeacher(teacher);
    }

    @Override
    public PagingResponse getTeacherList(TeacherPagingData teacherPagingData) {
        PageHelper.startPage(teacherPagingData.getPage(), teacherPagingData.getRows());
        return teacherDao.getTeachers(teacherPagingData);
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public boolean editingTeacher(Teacher teacher) {
        return teacherDao.editingTeacher(teacher);
    }

    @Override
    public Integer deletingTeachers(List<Integer> ids) {
        return teacherDao.deletingTeachers(ids);
    }
}
