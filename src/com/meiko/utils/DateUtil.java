package com.meiko.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Meiko
 * @date 2019/5/7
 */
public class DateUtil {
    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return dateFormat.format(date);
    }
}
