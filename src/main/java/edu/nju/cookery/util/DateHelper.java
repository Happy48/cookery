package edu.nju.cookery.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期帮助类
 */
public class DateHelper {

    /**
     * 标准日期格式器
     */
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 标准日期-时间格式器
     */
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 标准年份-月份格式器
     */
    public static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");


    /**
     * 将数据库时间转化为年月的形式
     *
     * @param time 数据库时间
     * @return 年月格式字符串
     */
    public static String toMonthByTimeStamp(Timestamp time) {
        return time.toLocalDateTime().format(YEAR_MONTH_FORMATTER);
    }


    /**
     * 将数据库时间转化为年月日的形式
     *
     * @param time 数据库时间
     * @return 日期格式字符串
     */
    public static String toDateByTimeStamp(Timestamp time) {
        return time.toLocalDateTime().format(DATE_FORMATTER);
    }

    /**
     * 将数据库时间转化为年月日时分秒的形式
     *
     * @param time 数据库时间
     * @return 日期时间格式字符串
     */
    public static String toTimeByTimeStamp(Timestamp time) {
        return time.toLocalDateTime().format(DATE_TIME_FORMATTER);
    }

    /**
     * 将年月转化为数据库时间
     *
     * @param month 年月格式（yyyy-MM）字符串
     * @return 数据库时间
     */
    public static Timestamp toTimestampByMonth(String month) {
        month += "-01 00:00:00";
        return Timestamp.valueOf(month);
    }

    /**
     * 将日期转化为数据库时间
     *
     * @param date 日期格式（yyyy-MM-dd）字符串
     * @return 数据库时间
     */
    public static Timestamp toTimestampByDate(String date) {
        return Timestamp.valueOf(date + " 00:00:00");
    }

    /**
     * 获得当前的时间，格式为日期时间格式
     */
    public static String getToday() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * 获取当前月份，格式为yyyy-MM
     */
    public static String getTodayMonth() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DATE_TIME_FORMATTER).substring(0, 7);
    }

    /**
     * 获得当前的日期，格式为日期格式
     */
    public static String getTodayDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DATE_FORMATTER);
    }

    /**
     * 获得昨天的时间，格式为日期时间格式
     */
    public static String getYesterday() {
        Date date = Date.valueOf(getTodayDate());
        long i = date.getTime();
        i -= 1000;
        date = new Date(i);
        return date.toString() + " 23:59:59";
    }

    /**
     * 将年月入字符串转为Date
     */
    public static java.util.Date strToUtilDate(String strDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        java.util.Date date = formatter.parse(strDate,pos);
        return date;
    }

    /**
     * 将年月入字符串转为Date
     * @param strDate
     * @return
     */
    public static java.sql.Date strToSQLDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }

}
