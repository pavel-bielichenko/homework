package com.ofg.loans.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by pavel on 23.04.16.
 */
public class TimeFormatUtil {

    public static Long formatFromDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date fromDate = cal.getTime();
        return fromDate.getTime();
    }

    public static Long formatToDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 6);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date toDate = cal.getTime();
        return toDate.getTime();
    }
}
