package cn.cqupt.teachresource.util;

import cn.cqupt.teachresource.model.ArticleExample;
import cn.cqupt.teachresource.model.TeacherNavExample;
import cn.cqupt.teachresource.model.VisitorRecordExample;

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
}
