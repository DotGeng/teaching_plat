package cn.cqupt.teachfaced.service;

/**
 * Created by YukunGeng on 2018/4/18.
 */
public interface TeacherLoadService {
    public boolean teacherIsLoaded(String teacherName);

    public String teacherLoadAction(String teacherName, String password);

    public boolean teacherLogout(String teacherName);
}
