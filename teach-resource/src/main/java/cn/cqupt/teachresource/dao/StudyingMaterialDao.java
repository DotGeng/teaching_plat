package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudyingMaterialPagingData;
import cn.cqupt.teachresource.model.StudyingMaterial;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
public interface StudyingMaterialDao {
    public PagingResponse getStudyingMaterialList(StudyingMaterialPagingData studyingMaterialPagingData);

    StudyingMaterial getStudyingMaterialById(Integer id);

    public boolean deleteMedia(List<Integer> ids);

    boolean editingMedia(StudyingMaterial studyingMaterial);
}
