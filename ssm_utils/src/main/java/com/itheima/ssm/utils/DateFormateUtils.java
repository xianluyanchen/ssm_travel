package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormateUtils {

    public static String dateToString(Date date,String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateString = sdf.format(date);
        return dateString;
    }

    public static Date stringToDate(String dateString,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date dateDate = sdf.parse(dateString);
        return dateDate;

    }
}
