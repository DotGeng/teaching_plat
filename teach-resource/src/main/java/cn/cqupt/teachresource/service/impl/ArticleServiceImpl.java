package cn.cqupt.teachresource.service.impl;


import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.dao.ArticleDao;
import cn.cqupt.teachresource.model.Article;
import cn.cqupt.teachresource.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;


/**
 * Created by YukunGeng on 2018/4/23.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Value("${server.port}")
    private String port;
    @Autowired
    private ArticleDao articleDao;

    @Override
    public PagingResponse getArticles(TeacherPagingData pagedate) {
        //String orderBy = "modify_time" + " desc";//按照排序字段 倒序 排序
        PageHelper.startPage(pagedate.getPage(), pagedate.getRows());
        PageHelper.orderBy("modify_time desc");
        PagingResponse pagingResponse = articleDao.getArticleList(pagedate);
        return pagingResponse;
    }

    @Override
    public String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 把图片的可访问的url写入数据库
        String pictureURL = "http://localhost:" + port + "/myfile/" + fileName;
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
        return pictureURL;
    }

    @Override
    public boolean deleteFile(String filePath, String fileName) {
        File file = new File(filePath + fileName);
        if (file.isFile() && file.exists()) {
            Boolean succeedDelete = file.delete();
            if (succeedDelete) {
                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean fileAdding(Article article) {
        if (article == null) {
            return false;
        }
        article.setCreateTime(new Date());
        article.setModifyTime(new Date());
        if (articleDao.addFile(article)) {
            return true;
        }
        return false;
    }

    @Override
    public Article getArticleByid(Integer id) {
        Article article = articleDao.getArticleById(id);
        return article;
    }

    @Override
    public boolean editArticleInfo(Article article) {
        return articleDao.updateArticleById(article);
    }

    @Override
    public Integer deleteArticles(List<Integer> ids) {
        return articleDao.deleteArticles(ids);
    }
}
