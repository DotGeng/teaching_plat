package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudyingMaterialPagingData;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.TeacherVo;
import cn.cqupt.teachresource.model.StudingTeacherNav;
import cn.cqupt.teachresource.model.StudyingMaterial;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.StudingTeacherNavService;
import cn.cqupt.teachresource.service.StudyingMaterialService;
import cn.cqupt.teachresource.service.TeacherService;
import cn.cqupt.teachresource.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
@RestController
public class StudingTeacherController extends BaseController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private VisitorRecordService visitorRecordService;
    @Autowired
    private StudingTeacherNavService studingTeacherNavService;
    @Autowired
    private StudyingMaterialService studyingMaterialService;

    @RequestMapping(value = "/studing/teacher/login", method = RequestMethod.POST)
    public ResponseStatus studingTacherLogin(TeacherVo teacherVo, HttpServletRequest hsRequest, HttpServletResponse hsResponse) {
        String token = teacherService.teacherLoginAction(teacherVo);
        CookieUtils.setCookie(hsRequest, hsResponse, "TOKEN", token);
        // 记录登录信息
        String ip = hsRequest.getRemoteAddr();
        visitorRecordService.addVisitorInfo(ip, teacherVo.getTeachername(), teacherVo.getTeacherrole());
        return success(token, "ok", "");
    }

    @RequestMapping(value = "/studingteacher/nav/create", method = RequestMethod.POST)
    public List<StudingTeacherNav> getStudingTeacherNav(StudingTeacherNav studingTeacherNav) {
        return studingTeacherNavService.getTeacherNavs(studingTeacherNav);
    }

    @RequestMapping(value = "/studying_material/list", method = RequestMethod.POST)
    public PagingResponse getStudyingMaterialList(StudyingMaterialPagingData studyingMaterialPagingData) {
        return studyingMaterialService.getStudyingMaterialList(studyingMaterialPagingData);
    }

    @RequestMapping(value = "/studying_material/specific", method = RequestMethod.POST)
    public ResponseStatus getStudyingMaterialById(Integer id) {
        StudyingMaterial studyingMaterial = studyingMaterialService.getStudyingMaterialBuId(id);
        return success("ok", studyingMaterial);
    }
}
