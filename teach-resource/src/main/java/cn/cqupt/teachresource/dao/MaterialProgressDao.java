package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.MateriaProcessPragram;
import cn.cqupt.teachresource.BaseParam.MaterialProgressPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;

/**
 * Created by YukunGeng on 2018/5/6.
 */
public interface MaterialProgressDao {
    void setMediaProgress(MateriaProcessPragram materiaProcessPragram);
    PagingResponse getMaterialProgressList(MaterialProgressPagingData materialProgressPagingData);
}
