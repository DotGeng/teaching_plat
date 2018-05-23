package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.ArticleResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.dao.ArticleDao;
import cn.cqupt.teachresource.mapper.ArticleMapper;
import cn.cqupt.teachresource.model.Article;
import cn.cqupt.teachresource.model.ArticleExample;
import cn.cqupt.teachresource.util.ArticleUtils;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by YukunGeng on 2018/4/23.
 */
@Component
public class ArticleDaoImpl implements ArticleDao {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PagingResponse getArticleList(TeacherPagingData teacherPagingData) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = CriteriaUtils.getCriteria(example);
        if (teacherPagingData.getArticleName() != null && teacherPagingData.getArticleName() != "") {
            criteria.andArticleNameLike("%" + teacherPagingData.getArticleName() + "%");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (teacherPagingData.getCreateTimeBegin() != null && teacherPagingData.getCreateTimeBegin() != "") {
            try {
                criteria.andCreateTimeGreaterThan(format.parse(teacherPagingData.getCreateTimeBegin()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (teacherPagingData.getCreateTimeEnd() != null && teacherPagingData.getCreateTimeEnd() != "") {
            try {
                format.parse(teacherPagingData.getCreateTimeEnd());
                Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(teacherPagingData.getCreateTimeEnd());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, 1);
                date = cal.getTime();
                criteria.andCreateTimeLessThan(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<Article> artiles = articleMapper.selectByExample(example);
        List<Article> articles2 = new ArrayList<>();
        if (artiles != null && artiles.size() > 0) {
            for (Article artile : artiles) {
                ArticleResponse articleResponse = new ArticleResponse();
                ArticleUtils.convertArticle2Format(artile, articleResponse);
                articles2.add(articleResponse);
            }
        }
        int sum = articleMapper.countByExample(example);
        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setTotal(sum);
        pagingResponse.setRows(articles2);
        return pagingResponse;
    }

    @Override
    public boolean addFile(Article article) {
        articleMapper.insert(article);
        return true;
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateArticleById(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
        return true;
    }

    @Override
    public Integer deleteArticles(List<Integer> ids) {
        ArticleExample example = new ArticleExample();
        CriteriaUtils.getCriteria(example).andIdIn(ids);
        return articleMapper.deleteByExample(example);
    }
}
