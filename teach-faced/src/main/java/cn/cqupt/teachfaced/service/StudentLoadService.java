package cn.cqupt.teachfaced.service;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentLoadService {
    public boolean studentIsLoaded(String userNo);

    public String studentLoadAction(String userNo, String password);

    public boolean studentLogout(String userNo);

    public boolean teacherIsLoaded(String teacherName);

    public String teacherLoadAction(String teacherName, String password);

    public boolean teacherLogout(String teacherName);
}
