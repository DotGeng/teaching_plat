package cn.cqupt.teachresource.service;

import cn.cqupt.teachresource.BaseParam.MateriaProcessPragram;
import cn.cqupt.teachresource.BaseParam.MaterialProgressPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/6.
 */
public interface MaterialProgressService {
    public void setMediaProcess(MateriaProcessPragram mediaProcess);

    public PagingResponse getMaterialProgressList(MaterialProgressPagingData materialProgressPagingData);
}
