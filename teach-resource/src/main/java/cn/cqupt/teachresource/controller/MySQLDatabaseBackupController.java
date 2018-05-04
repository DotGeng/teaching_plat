package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YukunGeng on 2018/5/3.
 */
@RestController
public class MySQLDatabaseBackupController extends BaseController {
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.databasename}")
    private String databasename;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value = "/db/backup", method = RequestMethod.POST)
    public ResponseStatus backUpDb(String savePath) throws Exception {
        // 这是本地备份，所以直接这样写就行
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String fileName = "mysqldatabase" + sdf.format(new Date());
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            Process process = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\" + "mysqldump.exe -h" + "127.0.0.1" + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databasename);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            line = bufferedReader.readLine();
            while (line != null) {
                printWriter.println(line);
                line = bufferedReader.readLine();
            }
            printWriter.flush();
            if (process.waitFor() == 0) {//0 表示线程正常终止。
                return success("ok", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return error("error");
    }

    @RequestMapping(value = "/db/restore", method = RequestMethod.POST)
    public ResponseStatus dbRestore(MultipartFile file) throws Exception {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url, userName, password);
        ScriptRunner runner = new ScriptRunner(conn);
        //Resources.setCharset(Charset.forName("utf-8")); //设置字符集,不然中文乱码插入错误
        runner.setLogWriter(null);//设置是否输出日志
        runner.runScript(new BufferedReader(new InputStreamReader(file.getInputStream())));
        runner.closeConnection();
        conn.close();
        return success("ok", "");
    }
}
