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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        StudyingMaterialExample.Criteria criteria = CriteriaUtils.getCriteria(example);
        if (studyingMaterialPagingData.getTitle() != null && studyingMaterialPagingData.getTitle() != "") {
            criteria.andTitleLike("%" + studyingMaterialPagingData.getTitle() + "%");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (studyingMaterialPagingData.getCreateTimeBegin() != null && studyingMaterialPagingData.getCreateTimeBegin() != "") {

            try {
                criteria.andCreateTimeGreaterThan(format.parse(studyingMaterialPagingData.getCreateTimeBegin()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if (studyingMaterialPagingData.getCreateTimeEnd() != null && studyingMaterialPagingData.getCreateTimeEnd() != "") {
            try {
                format.parse(studyingMaterialPagingData.getCreateTimeEnd());
                Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(studyingMaterialPagingData.getCreateTimeEnd());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, 1);
                date = cal.getTime();
                criteria.andCreateTimeLessThan(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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

    @Override
    public boolean addMedia(StudyingMaterial material) {
        if (studyingMaterialMapper.insert(material) > 0) {
            return true;
        }
        return false;
    }
}
