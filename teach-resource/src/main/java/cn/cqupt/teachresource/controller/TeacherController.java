package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.TeacherVo;
import cn.cqupt.teachresource.model.Article;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.ArticleService;
import cn.cqupt.teachresource.service.TeacherNavService;
import cn.cqupt.teachresource.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by YukunGeng on 2018/4/18.
 */
@RestController
public class TeacherController extends BaseController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherNavService teacherNavService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/teacher/session/create", method = RequestMethod.POST)
    public ResponseStatus teacherLoginAction(TeacherVo teacherVo, HttpServletRequest hsRequest, HttpServletResponse hsResponse) {
        String token = teacherService.teacherLoginAction(teacherVo);
        CookieUtils.setCookie(hsRequest, hsResponse, "TOKEN", token);
        // 记录登录信息
        String ip = hsRequest.getRemoteAddr();

        return success("ok", "");
    }

    @RequestMapping(value = "/teacher/nav/create", method = RequestMethod.POST)
    public List<TeacherNav> getTeacherNav(TeacherNav teacherNav) {
        return teacherNavService.getTeacherNavs(teacherNav);
    }

    @RequestMapping(value = "/static/resource/teacher/article/list", method = RequestMethod.POST)
    public PagingResponse getArticleList(PagingData pageData) {
        return articleService.getArticles(pageData);
    }

}
