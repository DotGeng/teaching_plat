package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.MaterialProgressPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.model.StudingManagerNav;
import cn.cqupt.teachresource.service.StudingManagerNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/8.
 */
@RestController
public class StudingManagerController {
    @Autowired
    private StudingManagerNavService studingManagerNavService;

    @RequestMapping(value = "/studingmanager/nav/create", method = RequestMethod.POST)
    public List<StudingManagerNav> getStudingManagerNav(StudingManagerNav studingManagerNav) {
        return studingManagerNavService.getStudingManagerNav(studingManagerNav);
    }
}
