package cn.cqupt.teachresource.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YukunGeng on 2018/5/4.
 */
public class TimeUtils {

    public static String convertTimeStap2Date(Date timeStap) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(timeStap);
    }
}
