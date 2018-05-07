package cn.cqupt.teachresource.util;

import cn.cqupt.teachresource.model.*;

/**
 * Created by YukunGeng on 2018/4/20.
 */
public class CriteriaUtils {
    public static TeacherNavExample.Criteria getCriterai(TeacherNavExample example) {
        return example.createCriteria();
    }

    public static ArticleExample.Criteria getCriteria(ArticleExample example) {
        return example.createCriteria();
    }

    public static VisitorRecordExample.Criteria getCriteria(VisitorRecordExample example) {
        return example.createCriteria();
    }

    public static ManagerNavExample.Criteria getCriteria(ManagerNavExample example) {
        return example.createCriteria();
    }

    public static StudingTeacherNavExample.Criteria getCriteria(StudingTeacherNavExample example) {
        return example.createCriteria();
    }

    public static StudyingMaterialExample.Criteria getCriteria(StudyingMaterialExample example) {
        return example.createCriteria();
    }

    public static StudyingMateriaProgressExample.Criteria getCriteria(StudyingMateriaProgressExample example) {
        return example.createCriteria();
    }
}
