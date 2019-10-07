package com.sujie.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 */
public class DateUtils {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param begin 开始时间
     * @param end   结束时间
     * @return 返回日期集合
     */
    public static List<String> getBetweenDates(Date begin, Date end) {
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(begin);
        while (begin.getTime() <= end.getTime()) {
            result.add(SDF.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            begin = tempStart.getTime();
        }
        return result;
    }

}
