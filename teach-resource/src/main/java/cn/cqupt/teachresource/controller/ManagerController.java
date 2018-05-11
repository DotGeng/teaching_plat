package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudentPagingData;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.model.ManagerNav;
import cn.cqupt.teachresource.model.Student;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.ArticleService;
import cn.cqupt.teachresource.service.ManagerNavService;
import cn.cqupt.teachresource.service.StudentService;
import cn.cqupt.teachresource.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YukunGeng on 2018/5/2.
 */
@RestController
public class ManagerController extends BaseController {

    @Autowired
    private ManagerNavService managerNavService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/manager/nav/create", method = RequestMethod.POST)
    public List<ManagerNav> getManagerNav(ManagerNav managerNav) {
        return managerNavService.getManagerNavs(managerNav);
    }

    @RequestMapping(value = "/static/resource/manager/article/list", method = RequestMethod.POST)
    public PagingResponse getArticleList(TeacherPagingData pageData) {
        return articleService.getArticles(pageData);
    }

    /**
     * 分页获取学生列表
     *
     * @param studentPagingData
     * @return
     */
    @RequestMapping(value = "/static/student/list", method = RequestMethod.POST)
    public PagingResponse getStudentList(StudentPagingData studentPagingData) {
        return studentService.getStudent(studentPagingData);
    }

    @RequestMapping(value = "/id/student/specific", method = RequestMethod.POST)
    public ResponseStatus getStudentById(Student student) {
        Student s = studentService.getStudentById(student.getStudentid());
        return success("ok", s);
    }

    @RequestMapping(value = "/student/manager/edit", method = RequestMethod.POST)
    public ResponseStatus editStudent(Student student) {
        if (studentService.updateStudentInfo(student)) {
            return success("ok", "");
        } else {
            return error("error");
        }
    }

    @RequestMapping(value = "/students/manager/deleting", method = RequestMethod.POST)
    public ResponseStatus deletingStudent(String ids) {
        String[] arr = ids.split(",");
        List<Integer> idsInt = new ArrayList<>();
        for (String str : arr) {
            idsInt.add(Integer.parseInt(str));
        }
        if (studentService.deletingStudentsByIds(idsInt)) {
            return success("ok", "");
        }
        return error("error");
    }

    @RequestMapping(value = "/student/manager/adding", method = RequestMethod.POST)
    public ResponseStatus addingStudent(Student student) {
        if (studentService.addStudent(student)) {
            return success("", "");
        }
        return error("error");
    }

    @RequestMapping(value = "/teacher/manager/adding", method = RequestMethod.POST)
    public ResponseStatus addingTeacher(Teacher teacher) {
        if (teacherService.addingTeacher(teacher)) {
            return success("ok", "");
        } else {
            return error("error");
        }
    }

    @RequestMapping(value = "/teacher/editing")
    public ResponseStatus editingTeacher(Teacher teacher) {

        if (teacherService.editingTeacher(teacher)) {
            return success("ok", "");
        }
        return error("error");
    }

    @RequestMapping(value = "/id/teacher/special")
    public ResponseStatus getTeacher(Teacher teacher) {
        Teacher res = teacherService.getTeacherById(teacher.getTeacherid());
        return success("ok", res);
    }

    @RequestMapping(value = "/teacher/manager/list", method = RequestMethod.POST)
    public PagingResponse getTeacherList(TeacherPagingData teacherPagingData) {
        return teacherService.getTeacherList(teacherPagingData);
    }

    @RequestMapping(value = "/teacher/deleting", method = RequestMethod.POST)
    public ResponseStatus deletingTeachers(String ids) {
        String[] arr = ids.split(",");
        List<Integer> idsInt = new ArrayList<>();
        for (String str : arr) {
            idsInt.add(Integer.parseInt(str));
        }
        int count = teacherService.deletingTeachers(idsInt);
        return success("ok", count);
    }
}
