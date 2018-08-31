package com.xuwenxing.bbtv.util;

import java.util.Calendar;
import java.util.Date;


public class DateUtil {
    public static Date getEndDate(Date now) {
        if(now!=null){
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            return c.getTime();
        }
        return null;
    }
    /**
     * 两个时间的间隔秒
     *
     * @return
     */
    public static long secondsBetween(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }
}
