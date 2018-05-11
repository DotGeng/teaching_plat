package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachfaced.service.StudentLoadService;
import cn.cqupt.teachresource.BaseParam.MateriaProcessPragram;
import cn.cqupt.teachresource.BaseParam.MaterialProgressCustom;
import cn.cqupt.teachresource.BaseParam.MaterialProgressPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.dao.MaterialProgressDao;
import cn.cqupt.teachresource.mapper.StudentMapper;
import cn.cqupt.teachresource.mapper.StudyingMateriaProgressMapper;
import cn.cqupt.teachresource.mapper.StudyingMaterialMapper;
import cn.cqupt.teachresource.model.*;
import cn.cqupt.teachresource.service.MaterialProgressService;
import cn.cqupt.teachresource.util.CriteriaUtils;
import cn.cqupt.teachresource.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.*;

/**
 * Created by YukunGeng on 2018/5/6.
 */

@Component
public class MaterialProgressDaoImpl implements MaterialProgressDao {
    @Autowired
    private StudyingMateriaProgressMapper studyingMateriaProgressMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudyingMaterialMapper studyingMaterialMapper;

    @Override
    public void setMediaProgress(MateriaProcessPragram mediaProcess) {
        StudyingMateriaProgressExample example = new StudyingMateriaProgressExample();
        CriteriaUtils.getCriteria(example).andMediaIdEqualTo(mediaProcess.getMediaId());
        List<StudyingMateriaProgress> list = studyingMateriaProgressMapper.selectByExample(example);
        StudyingMateriaProgress progress = new StudyingMateriaProgress();
        progress.setMediaId(mediaProcess.getMediaId());
        progress.setStudentId(mediaProcess.getStudentId());
        progress.setProgress(mediaProcess.getProgress());
        StudentExample studentExample = new StudentExample();
        CriteriaUtils.getCriteria(studentExample).andStudentidEqualTo(mediaProcess.getStudentId());
        List<Student> students = studentMapper.selectByExample(studentExample);
        progress.setStudentNo(students.get(0).getStudentno());
        progress.setCreateTime(new Date());
        progress.setUpdateTime(new Date());
        if (list == null || list.size() == 0) {
            // 插入数据
            studyingMateriaProgressMapper.insert(progress);
        } else {
            //更新
            if (Double.parseDouble(list.get(0).getProgress()) < Double.parseDouble(mediaProcess.getProgress())) {
                studyingMateriaProgressMapper.updateByExampleSelective(progress, example);
            }
        }

    }

    @Override
    public PagingResponse getMaterialProgressList(MaterialProgressPagingData materialProgressPagingData) {
        StudyingMateriaProgressExample example = new StudyingMateriaProgressExample();
        CriteriaUtils.getCriteria(example);
        List<StudyingMateriaProgress> studyingMateriaProgresses = studyingMateriaProgressMapper.selectByExample(example);
        List<MaterialProgressCustom> materialProgressCustoms = new ArrayList<>(studyingMateriaProgresses.size());
        List<Integer> pocesIds = new ArrayList<>(studyingMateriaProgresses.size());
        for (StudyingMateriaProgress smp : studyingMateriaProgresses) {
            pocesIds.add(smp.getMediaId());
            MaterialProgressCustom custom = new MaterialProgressCustom();
            custom.setId(smp.getId());
            custom.setStudentNo(smp.getStudentNo());
            custom.setMediaId(smp.getMediaId());
            custom.setProgress(smp.getProgress());
            custom.setStudentId(smp.getStudentId());
            custom.setCreateTime(smp.getCreateTime());
            custom.setUpdateTime(smp.getUpdateTime());
            custom.setCreateTimeFormat(TimeUtils.convertTimeStap2Date(smp.getCreateTime()));
            custom.setUpdateTimeFormat(TimeUtils.convertTimeStap2Date(smp.getUpdateTime()));
            materialProgressCustoms.add(custom);
        }
        StudyingMaterialExample studyingMaterialExample = new StudyingMaterialExample();
        CriteriaUtils.getCriteria(studyingMaterialExample).andIdIn(pocesIds);
        List<StudyingMaterial> studyingMaterials = studyingMaterialMapper.selectByExample(studyingMaterialExample);
        fixMediaTitle(studyingMaterials, materialProgressCustoms);
        int total = studyingMateriaProgressMapper.countByExample(example);
        PagingResponse pr = new PagingResponse();
        pr.setRows(materialProgressCustoms);
        pr.setTotal(total);
        return pr;
    }

    private void fixMediaTitle(List<StudyingMaterial> studyingMaterials, List<MaterialProgressCustom> materialProgressCustoms) {
        Map<Integer, StudyingMaterial> map = new HashMap<>();
        for (StudyingMaterial sm : studyingMaterials) {
            map.put(sm.getId(), sm);

        }
        for (MaterialProgressCustom materialProgressCustom : materialProgressCustoms) {
            materialProgressCustom.setMediaTitle(map.get(materialProgressCustom.getMediaId()).getTitle());
        }
    }
}
