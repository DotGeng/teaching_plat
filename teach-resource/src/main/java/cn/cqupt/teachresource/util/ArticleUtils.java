package cn.cqupt.teachresource.util;

import cn.cqupt.teachresource.BaseParam.ArticleResponse;
import cn.cqupt.teachresource.model.Article;

import java.text.SimpleDateFormat;

/**
 * Created by YukunGeng on 2018/4/28.
 */
public class ArticleUtils {
    public static Article convertArticle2Format(Article article, ArticleResponse articleResponse) {
        articleResponse.setId(article.getId());
        articleResponse.setArticleName(article.getArticleName());
        articleResponse.setArticleDscrp(article.getArticleDscrp());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        articleResponse.setCreateTimeFormat(format.format(article.getCreateTime()));
        articleResponse.setUpdateTimeFormat(format.format(article.getModifyTime()));
        return articleResponse;
    }
}
