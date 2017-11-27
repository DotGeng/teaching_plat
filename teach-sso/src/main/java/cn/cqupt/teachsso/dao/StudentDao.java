package cn.cqupt.teachsso.dao;

import cn.cqupt.teachsso.model.Student;

public interface StudentDao {
    public Student getStudentByStudentNo(String studentNo);
    public Student getStuidentByNoAndPaswd(String studentNo, String password);
}
