package com.example.demo.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class DateTimeUtils {

    // defult timedate 2099-01-01 00:00:00
    private static final String defaultRoleGrantExpireDate = "2099-01-01 00:00:00";

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat formatterDay = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat formatterDayString = new SimpleDateFormat("yyyyMMdd");

    private static final SimpleDateFormat formatterNoSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * get current date
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * get current date format（yyyy-MM-dd） pattern can be ："yyyy-MM-dd" "HH:mm:ss"
     * "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * get current date format （yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * get current date format（yyyy-MM-dd） pattern can be："yyyy-MM-dd" "HH:mm:ss"
     * "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    public static String dateToSting(Date date) {
        if (date == null)
            return null;
        return formatter.format(date);
    }

    public static String timestampToSting(Timestamp timestamp) {
        if (timestamp == null)
            return null;
        return formatter.format(timestamp);
    }

    public static String timestampToDaySting(Timestamp timestamp) {
        if (timestamp == null)
            return null;
        return formatterDay.format(timestamp);
    }

    public static String dateToDaySting(Date date) {
        if (date == null)
            return null;
        return formatterDay.format(date);
    }

    public static String noSecondDateToSting(Date date) {
        if (date == null)
            return null;
        return formatterNoSecond.format(date);
    }

    public static String noSecondTimestampToSting(Timestamp timestamp) {
        if (timestamp == null)
            return null;
        return formatterNoSecond.format(timestamp);
    }

    public static Date stringToDate(String dateString) throws Exception {
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new Exception("yyyy-MM-dd");
        }
    }

    public static Timestamp stringToTimestamp(String dateString) throws Exception {
        Date date = stringToDate(dateString);
        return dateToTimestamp(date);
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static Timestamp getNowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getDefaultRoleGrantTime() throws Exception {
        return stringToTimestamp(defaultRoleGrantExpireDate);
    }

    public static String getNowDateString() {
        return formatter.format(getNowDate());
    }

    public static Date timestampToDate(Timestamp timestamp) {
        if (timestamp == null)
            return null;
        return new Date(timestamp.getTime());
    }

    public static Timestamp dateToTimestamp(Date date) {
        if (date == null)
            return null;
        return new Timestamp(date.getTime());
    }

    public static Timestamp TimestampAddDays(Timestamp timestamp, Integer day) {
        if (day < 0)
            return timestamp;
        return new Timestamp(timestamp.getTime() + (day * 24 * 60 * 60 * 1000));
    }

    public static Timestamp TimestampAddMins(Timestamp timestamp, Integer min) {
        if (min < 0)
            return timestamp;
        return new Timestamp(timestamp.getTime() + (min * 60 * 1000));
    }

    public static Timestamp TimestampDaysAgo(Timestamp timestamp, Integer day) {
        if (day < 0)
            return timestamp;
        return new Timestamp(timestamp.getTime() - (day * 24 * 60 * 60 * 1000));
    }

    public static Integer TimeBetweenStartAndEnd(Date start, Date end) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        long startTime = calendar.getTimeInMillis();
        calendar.setTime(end);
        long endTime = calendar.getTimeInMillis();
        long betweenDays = (startTime - endTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweenDays));
    }

    public static String getNowDayForMonthString() {
        return formatterDayString.format(getNowDate());
    }
}
