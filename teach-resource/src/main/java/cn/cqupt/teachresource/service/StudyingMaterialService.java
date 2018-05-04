package cn.cqupt.teachresource.service;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudyingMaterialPagingData;
import cn.cqupt.teachresource.model.StudyingMaterial;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
public interface StudyingMaterialService {
    PagingResponse getStudyingMaterialList(StudyingMaterialPagingData studyingMaterialPagingData);

    StudyingMaterial getStudyingMaterialBuId(Integer id);
}
