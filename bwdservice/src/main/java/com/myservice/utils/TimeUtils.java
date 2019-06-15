package com.myservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    /**
     * 设置时间的增加与减少
     * @param date 需要修改的日期
     * @return 返回增加后的日期
     */
    public static Date timeAddOrSub(Date date, Integer year, Integer month, Integer day) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        if (year != null) {
            instance.add(Calendar.YEAR, year);
        }
        if (month != null) {
            instance.add(Calendar.MONTH, month);
        }
        if (day != null) {
            instance.add(Calendar.DAY_OF_YEAR, day);
        }
        return instance.getTime();
    }

    public static String timeConversion(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);

    }

}
