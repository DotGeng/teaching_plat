package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.*;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.TeacherVo;
import cn.cqupt.teachresource.model.StudingTeacherNav;
import cn.cqupt.teachresource.model.StudyingMaterial;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    @Autowired
    private MaterialProgressService materialProgressService;

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

    @RequestMapping(value = "/studying_material/process/setting", method = RequestMethod.POST)
    public ResponseStatus setStudyingMaterialProcess(MateriaProcessPragram materiaProcessPragram) {
        materialProgressService.setMediaProcess(materiaProcessPragram);
        return success("ok", "");
    }

    @RequestMapping(value = "/material/info/editing", method = RequestMethod.POST)
    public ResponseStatus editStudyingMaterial(MateriaProcessPragram materiaProcessPragram) {
        // 修改操作

        return success("ok", "");
    }

    @RequestMapping(value = "/studying_material/deleting", method = RequestMethod.POST)
    public ResponseStatus setStudyingMaterialProcess(String ids) {
        String[] arr = ids.split(",");
        List<Integer> idsInt = new ArrayList<>();
        for (String str : arr) {
            idsInt.add(Integer.parseInt(str));
        }
        if (studyingMaterialService.deleteMedia(idsInt)) {
            return success("ok", "");
        } else {
            return error("error");
        }
    }


    @RequestMapping(value = "/id/media/editing", method = RequestMethod.POST)
    public ResponseStatus editingStudyingMaterial(StudingMaterialFormat studingMaterialFormat) {
        if (studyingMaterialService.editingMedia(studingMaterialFormat)) {
            return success("ok", "");
        }
        return error("error");
    }

    @RequestMapping(value = "/media/info/adding", method = RequestMethod.POST)
    public ResponseStatus addStudyingMaterial(StudyingMaterial studingMaterial) {
        if (studyingMaterialService.addMedia(studingMaterial)) {
            return success("ok", "");
        }
        return error("error");
    }

    @RequestMapping(value = "/media/progress/list", method = RequestMethod.POST)
    public PagingResponse getMediaProgressList(MaterialProgressPagingData materialProgressPagingData) {
        PagingResponse pr = materialProgressService.getMaterialProgressList(materialProgressPagingData);
        return pr;
    }
}
