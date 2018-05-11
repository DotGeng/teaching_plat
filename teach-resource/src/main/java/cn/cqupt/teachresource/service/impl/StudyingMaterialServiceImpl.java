package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudingMaterialFormat;
import cn.cqupt.teachresource.BaseParam.StudyingMaterialPagingData;
import cn.cqupt.teachresource.dao.StudyingMaterialDao;
import cn.cqupt.teachresource.model.StudyingMaterial;
import cn.cqupt.teachresource.service.StudyingMaterialService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
@Service
public class StudyingMaterialServiceImpl implements StudyingMaterialService {
    @Autowired
    private StudyingMaterialDao studyingMaterialDao;

    @Override
    public PagingResponse getStudyingMaterialList(StudyingMaterialPagingData studyingMaterialPagingData) {
        PageHelper.startPage(studyingMaterialPagingData.getPage(), studyingMaterialPagingData.getRows());
        PageHelper.orderBy("update_time desc");
        return studyingMaterialDao.getStudyingMaterialList(studyingMaterialPagingData);
    }

    @Override
    public StudyingMaterial getStudyingMaterialBuId(Integer id) {

        return studyingMaterialDao.getStudyingMaterialById(id);
    }

    @Override
    public boolean deleteMedia(List<Integer> ids) {
        return studyingMaterialDao.deleteMedia(ids);
    }

    @Override
    @Transactional
    public boolean editingMedia(StudingMaterialFormat studyingMaterialFormat) {
        StudyingMaterial studyingMaterial = new StudyingMaterial();
        studyingMaterial.setId(studyingMaterialFormat.getId());
        studyingMaterial.setMaterialDesc(studyingMaterialFormat.getMaterialDesc());
        studyingMaterial.setTitle(studyingMaterialFormat.getTitle());
        studyingMaterial.setUrl(studyingMaterialFormat.getUrl());
        studyingMaterial.setType(studyingMaterialFormat.getType());
        studyingMaterial.setUpdateTime(new Date());
        return studyingMaterialDao.editingMedia(studyingMaterial);
    }

    @Override
    public boolean addMedia(StudyingMaterial studyingMaterial) {
        studyingMaterial.setCreateTime(new Date());
        studyingMaterial.setUpdateTime(new Date());
        if (studyingMaterial.getUrl() == null) {
            studyingMaterial.setUrl("");
        }
        return studyingMaterialDao.addMedia(studyingMaterial);
    }
}
