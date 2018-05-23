package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.ArticleResponse;
import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.model.Article;
import cn.cqupt.teachresource.service.ArticleService;
import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.IDUtils;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by YukunGeng on 2018/4/23.
 */
@RestController
public class ArticileController extends BaseController {
    @Value("${spring.web.upload-path}")
    private String location;
    @Autowired
    private ArticleService articleService;

    // 文件上传
    @RequestMapping(value = "/file/uploading", method = RequestMethod.POST)
    public ResponseStatus uploadFile(@RequestParam(value = "file") MultipartFile file) {
        System.out.println("调用upload");
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String fileTail = fileName.substring(fileName.lastIndexOf(".") + 1);
        String filePath = location + "myfile/";
        String url = "";
        String proName = IDUtils.genFileName();
        fileName = proName + "." + fileTail;
        try {
            url = articleService.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // 处理异常，可以打印出日志，供排错，为了简单起见，这里不做处理。
        }
        return success("ok", url);
    }

    // 文件删除
    @RequestMapping(value = "/file/deleting", method = RequestMethod.GET)
    public ResponseStatus deleteFile(String fileName) {
        String filePath = location + "myfile/";
        if (articleService.deleteFile(filePath, fileName)) {
            return success("ok", "");
        }
        return error("error");
    }

    // 把文章信息写入到数据库中
    @RequestMapping(value = "/article/info/adding", method = RequestMethod.POST)
    public ResponseStatus fileInfoAdding(Article article) {
        if (articleService.fileAdding(article)) {
            return success("ok", "");
        }
        return error("error");
    }

    @RequestMapping(value = "/id/article", method = RequestMethod.POST)
    public ResponseStatus getArticleById(Integer id) {
        return success("ok", articleService.getArticleByid(id));
    }

    @RequestMapping(value = "/article/info/editing", method = RequestMethod.POST)
    public ResponseStatus updateArticle(Article article) {
        if (articleService.editArticleInfo(article)) {
            return success("ok", "");
        }
        return error("");
    }

    @RequestMapping(value = "/article/info/deleting", method = RequestMethod.POST)
    public ResponseStatus deleteArticle(String ids) {
        String[] arr = ids.split(",");
        List<Integer> idsInt = new ArrayList<>();
        for (String str : arr) {
            idsInt.add(Integer.parseInt(str));
        }
        int count = articleService.deleteArticles(idsInt);
        return success("ok", count);
    }

    @RequestMapping(value = "/article/list", method = RequestMethod.POST)
    public PagingResponse getArticleList(TeacherPagingData pageData) {
        return articleService.getArticles(pageData);
    }

}
