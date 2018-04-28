package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.PagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.model.Article;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/23.
 */
public interface ArticleDao {
    PagingResponse getArticleList(PagingData pagingData);

    boolean addFile(Article article);

    Article getArticleById(Integer id);

    boolean updateArticleById(Article article);

    Integer deleteArticles(List<Integer> ids);
}
