package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.MateriaProcessPragram;
import cn.cqupt.teachresource.dao.MaterialProgressDao;
import cn.cqupt.teachresource.mapper.StudyingMateriaProgressMapper;
import cn.cqupt.teachresource.model.StudyingMateriaProgress;
import cn.cqupt.teachresource.model.StudyingMateriaProgressExample;
import cn.cqupt.teachresource.service.MaterialProgressService;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/6.
 */

@Component
public class MaterialProgressDaoImpl implements MaterialProgressDao {
    @Autowired
    private StudyingMateriaProgressMapper studyingMateriaProgressMapper;

    @Override
    public void setMediaProgress(MateriaProcessPragram mediaProcess) {
        StudyingMateriaProgressExample example = new StudyingMateriaProgressExample();
        CriteriaUtils.getCriteria(example).andMediaIdEqualTo(mediaProcess.getMediaId());
        List<StudyingMateriaProgress> list = studyingMateriaProgressMapper.selectByExample(example);
        StudyingMateriaProgress progress = new StudyingMateriaProgress();
        progress.setMediaId(mediaProcess.getMediaId());
        progress.setStudentId(mediaProcess.getStudentId());
        progress.setProgress(mediaProcess.getProgress());
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

}
