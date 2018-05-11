package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.BaseParam.MateriaProcessPragram;
import cn.cqupt.teachresource.BaseParam.MaterialProgressPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.dao.MaterialProgressDao;
import cn.cqupt.teachresource.service.MaterialProgressService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/6.
 */
@Service
public class MaterialProgressServiceImpl implements MaterialProgressService {
    @Autowired
    private MaterialProgressDao materialProgressDao;

    @Override
    @Transactional
    public void setMediaProcess(MateriaProcessPragram mediaProcess) {
        materialProgressDao.setMediaProgress(mediaProcess);
    }

    @Override
    public PagingResponse getMaterialProgressList(MaterialProgressPagingData pagedate) {
        PageHelper.startPage(pagedate.getPage(), pagedate.getRows());
        PageHelper.orderBy("update_time desc");
        return materialProgressDao.getMaterialProgressList(pagedate);
    }
}
