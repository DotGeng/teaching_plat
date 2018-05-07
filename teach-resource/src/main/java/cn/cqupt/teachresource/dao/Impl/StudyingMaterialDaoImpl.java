package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.StudingMaterialFormat;
import cn.cqupt.teachresource.BaseParam.StudyingMaterialPagingData;
import cn.cqupt.teachresource.dao.StudyingMaterialDao;
import cn.cqupt.teachresource.mapper.StudyingMaterialMapper;
import cn.cqupt.teachresource.model.StudyingMateriaProgress;
import cn.cqupt.teachresource.model.StudyingMaterial;
import cn.cqupt.teachresource.model.StudyingMaterialExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import cn.cqupt.teachresource.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YukunGeng on 2018/5/4.
 */
@Component
public class StudyingMaterialDaoImpl implements StudyingMaterialDao {
    @Autowired
    private StudyingMaterialMapper studyingMaterialMapper;

    @Override
    public PagingResponse getStudyingMaterialList(StudyingMaterialPagingData studyingMaterialPagingData) {
        StudyingMaterialExample example = new StudyingMaterialExample();
        CriteriaUtils.getCriteria(example);
        List<StudyingMaterial> studyingMaterials = studyingMaterialMapper.selectByExample(example);
        List<StudyingMaterial> studyingMaterials2 = new ArrayList<>();
        for (StudyingMaterial material : studyingMaterials) {
            StudingMaterialFormat sf = new StudingMaterialFormat();
            sf.setId(material.getId());
            sf.setTitle(material.getTitle());
            sf.setType(material.getType());
            sf.setUrl(material.getUrl());
            sf.setMediaId(material.getId());
            sf.setMaterialDesc(material.getMaterialDesc());
            if (material.getType() == 0) {
                sf.setRoleFormat("文章");
            } else if (material.getType() == 1) {
                sf.setRoleFormat("音频");
            } else if (material.getType() == 2) {
                sf.setRoleFormat("视频");
            }
            sf.setCreateTimeFormat(TimeUtils.convertTimeStap2Date(material.getCreateTime()));
            sf.setUpdateTimeFormat(TimeUtils.convertTimeStap2Date(material.getUpdateTime()));
            studyingMaterials2.add(sf);
        }
        int count = studyingMaterialMapper.countByExample(example);
        PagingResponse pr = new PagingResponse();
        pr.setRows(studyingMaterials2);
        pr.setTotal(count);
        return pr;
    }

    @Override
    public StudyingMaterial getStudyingMaterialById(Integer id) {
        return studyingMaterialMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteMedia(List<Integer> ids) {
        StudyingMaterialExample example = new StudyingMaterialExample();
        CriteriaUtils.getCriteria(example).andIdIn(ids);
        if (studyingMaterialMapper.deleteByExample(example) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean editingMedia(StudyingMaterial studyingMaterial) {
        StudyingMaterialExample example = new StudyingMaterialExample();
        CriteriaUtils.getCriteria(example).andIdEqualTo(studyingMaterial.getId());
        int res = studyingMaterialMapper.updateByExampleSelective(studyingMaterial, example);
        if (res > 0) {
            return true;
        }
        return false;
    }
}
