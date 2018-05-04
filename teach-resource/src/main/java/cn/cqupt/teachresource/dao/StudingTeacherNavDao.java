package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.model.StudingTeacherNav;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
public interface StudingTeacherNavDao {
    public List<StudingTeacherNav> getTeacherNavs(StudingTeacherNav studingTeacherNav);
}
