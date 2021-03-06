package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by YukunGeng on 2018/5/4.
 */
@Controller
public class StudingPlatFontController {
    @RequestMapping("/static/studingplat/login/page")
    public String getStudingPlatLoginPage() {
        return "/studing-login";
    }

    @RequestMapping("/static/studingplat/teacher/index")
    public String getStudingPlatTeacherIndex() {
        return "/studing-teacher-index";
    }

    @RequestMapping("/static/studingplat/teacher/studying-material-manager")
    public String getStudyingMaterialManager() {
        return "/studying-material-manager";
    }

    /**
     * 跳转到音频详情页
     *
     * @return
     */
    @RequestMapping(value = "/static/studying_material/audio/detail")
    public String getstudyingMaterialDetail() {
        return "/media_audio_detail";
    }

    /**
     * 跳转到视频详情页面
     *
     * @return
     */
    @RequestMapping(value = "/static/studying_material/video/detail")
    public String getstudyingMaterialVideoDetail() {
        return "/media_video_detail";
    }

    @RequestMapping(value = "/static/studying_material/file/detail")
    public String getstudyingMaterialFileDetail() {
        return "/media_file_detail";
    }

    /**
     * 学生学习进度详情页
     *
     * @return
     */
    @RequestMapping(value = "/static/studying_progress/list")
    public String getStudyingProgressList() {
        return "/studing_progress_list";
    }
    /**
     * 学习平台超级管理员登录
     */
    @RequestMapping(value = "/static/studingplat/manager/index")
    public String getStudingpaltManagerIndex() {
        return "/studing_manager_index";
    }
    @RequestMapping(value = "/static/students/manager")
    public String getStudentsManagerList() {
        return "/student_manager";
    }
    @RequestMapping(value = "/static/teacher/manager")
    public String getTeacherManagerList() {
        return "/teacher_manager";
    }
}
