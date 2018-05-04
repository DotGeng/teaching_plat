package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.model.ManagerNav;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.ArticleService;
import cn.cqupt.teachresource.service.ManagerNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/manager/nav/create", method = RequestMethod.POST)
    public List<ManagerNav> getManagerNav(ManagerNav managerNav) {
        return managerNavService.getManagerNavs(managerNav);
    }

    @RequestMapping(value = "/static/resource/manager/article/list", method = RequestMethod.POST)
    public PagingResponse getArticleList(TeacherPagingData pageData) {
        return articleService.getArticles(pageData);
    }

}
