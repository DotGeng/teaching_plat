package cn.cqupt.teachfaced.service;


public interface StudentLoadService {
    public boolean studentIsLoaded(String userNo);

    public boolean studentLoadAction(String userNo, String password);

    public boolean studentLogout(String userNo);
}
