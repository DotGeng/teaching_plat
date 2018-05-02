package cn.cqupt.teachresource.service;


import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.model.Article;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/23.
 */
public interface ArticleService {
    public PagingResponse getArticles(TeacherPagingData teacherPagingData);

    public String uploadFile(byte[] file, String filePath, String fileName) throws Exception;

    boolean deleteFile(String filePath, String fileName);

    boolean fileAdding(Article article);

    Article getArticleByid(Integer id);

    boolean editArticleInfo(Article article);

    Integer deleteArticles(List<Integer> ids);

}
