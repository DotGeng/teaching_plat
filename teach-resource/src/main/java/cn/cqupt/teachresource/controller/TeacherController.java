package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.RoleParam;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.TeacherVo;
import cn.cqupt.teachresource.model.Teacher;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.redis.RedisService;
import cn.cqupt.teachresource.service.ArticleService;
import cn.cqupt.teachresource.service.TeacherNavService;
import cn.cqupt.teachresource.service.TeacherService;
import cn.cqupt.teachresource.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.CookieUtils;
import util.JsonUtils;

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
    @Autowired
    private RedisService redisService;
    @Autowired
    private VisitorRecordService visitorRecordService;

    @RequestMapping(value = "/teacher/session/create", method = RequestMethod.POST)
    public ResponseStatus teacherLoginAction(TeacherVo teacherVo, HttpServletRequest hsRequest, HttpServletResponse hsResponse) {
        String token = teacherService.teacherLoginAction(teacherVo);
        CookieUtils.setCookie(hsRequest, hsResponse, "TOKEN", token);
        // 记录登录信息
        String ip = hsRequest.getRemoteAddr();
        visitorRecordService.addVisitorInfo(ip, teacherVo.getTeachername(), teacherVo.getTeacherrole());
        return success(token, "ok", "");
    }

    /**
     * 根据token得到teacher信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/token/teacher", method = RequestMethod.GET)
    public ResponseStatus getTeacherByToken(HttpServletRequest hsRequest, HttpServletResponse hsResponse) {
        String token = CookieUtils.getCookieValue(hsRequest, "TOKEN");
        String teacherJson = redisService.get(token);
        Teacher teacher = JsonUtils.jsonToPojo(teacherJson, Teacher.class);
        return success("ok", teacher);
    }

    @RequestMapping(value = "/teacher/nav/create", method = RequestMethod.POST)
    public List<TeacherNav> getTeacherNav(TeacherNav teacherNav) {
        return teacherNavService.getTeacherNavs(teacherNav);
    }

    @RequestMapping(value = "/static/resource/teacher/article/list", method = RequestMethod.POST)
    public PagingResponse getArticleList(TeacherPagingData pageData) {
        return articleService.getArticles(pageData);
    }

}
