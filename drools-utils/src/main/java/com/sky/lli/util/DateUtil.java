package com.sky.lli.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil implements Serializable {

    //日期格式
    private static final String YYYYMM = "yyyyMM";
    private static final String YYYY_MM = "yyyy-MM";
    private static final String YYYYMMDD = "yyyyMMdd";
    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 方法说明 : 将 Date 类型时间转换成 String 类型时间
     *
     * @param date   时间
     * @param format 格式
     *               Author lihao [lihao@sinosoft.com.cn]
     */
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 方法说明 : 将 String 类型时间转换成 Date 类型时间
     *
     * @param date   时间
     * @param format 格式
     *               Author lihao [lihao@sinosoft.com.cn]
     *               Date 2017/8/3
     */
    public static Date parseDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 方法说明 : 将 Date 类型时间转换成 String 类型时间，格式为yyyy-MM，例：返回2009-10
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static String getStringYMDate(Date date) {
        return formatDate(date, YYYY_MM);
    }

    /**
     * Date 2017/12/6
     * Author lihao [lihao@sinosoft.com.cn]
     * 方法说明: 将 Date 类型日期转换成  Integer 类型时间,格式为yyyyMM 例如:返回201712
     *
     * @param date 日期
     */
    public static Integer getIntegerYMDate(Date date) {
        return Integer.parseInt(formatDate(date, YYYYMM));
    }

    /**
     * Date 2017/12/6
     * Author lihao [lihao@sinosoft.com.cn]
     * 方法说明: 将 Date 类型日期转换成  Integer 类型时间,格式为yyyyMMdd 例如:返回20171201
     *
     * @param date 日期
     */
    public static Integer getIntegerYMDDate(Date date) {
        return Integer.parseInt(formatDate(date, YYYYMMDD));
    }

    /**
     * 方法说明 : 将 String 类型时间转换成 Date 类型时间，String 格式为 yyyy-MM-dd，例 2017-08-03
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getDate(String date) {
        if (null == date) {
            return null;
        }
        return parseDate(date, YYYY_MM_DD);
    }

    /**
     * 方法说明 : 将 Integer 类型时间转换成 Date 类型时间，Integer 格式为 yyyyMMdd，例 20170803
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getDateYMD(Integer date) {
        if (null == date) {
            return null;
        }
        return parseDate(date.toString(), YYYYMMDD);
    }

    /**
     * 方法说明 : 将 Integer 类型时间转换成 Date 类型时间，Integer 格式为 yyyyMM，例 201708
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getDateYM(Integer date) {
        if (null == date) {
            return null;
        }
        return parseDate(date.toString(), YYYYMM);
    }

    /**
     * 方法说明 : 获取传入时间所在月份的第一天所表示的时间
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getDateFirst(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 方法说明 : 获取传入时间所在月份的最后一天所表示的时间
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getDateLast(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 方法说明 : 获取传入时间中的指定字段值
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     *
     * @param date  时间对象
     * @param field 字段 Calendar.DAY_OF_MONTH 等
     */
    public static Integer getDateField(Date date, int field) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    /**
     * 方法说明 : 获取时间中的年份
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Integer getYear(Date date) {
        return getDateField(date, Calendar.YEAR);
    }

    /**
     * 方法说明 : 获取时间中的月份
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Integer getMonth(Date date) {
        return getDateField(date, Calendar.MONTH);
    }

    /**
     * 方法说明 : 获取时间中的日期
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Integer getDay(Date date) {
        return getDateField(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 方法说明 : 获取下月第一天所表示的时间
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getNextMonthFirstDate(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 方法说明 : 获取上月最后一天所表示的时间
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static Date getLastMonthLastDate(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 方法说明 : 传入时间，指定字段，增加相应值，返回得到的新时间对象
     *
     * @param date  时间对象
     * @param field 字段 Calendar.DAY_OF_MONTH 等
     * @param value 增加值
     *              Author lihao [lihao@sinosoft.com.cn]
     *              Date 2017/8/3
     */
    public static Date addDateField(Date date, int field, int value) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, value);
        return calendar.getTime();
    }

    /**
     * 方法说明 : 传入时间，增加指定年数，返回得到的新时间对象
     *
     * @param date  时间对象
     * @param years 增加值
     *              Author lihao [lihao@sinosoft.com.cn]
     *              Date 2017/8/3
     */
    public static Date addYear(Date date, int years) {
        return addDateField(date, Calendar.YEAR, years);
    }

    /**
     * 方法说明 : 传入时间，增加指定月数，返回得到的新时间对象
     *
     * @param date   时间对象
     * @param months 增加值
     *               Author lihao [lihao@sinosoft.com.cn]
     *               Date 2017/8/3
     */
    public static Date addMonth(Date date, int months) {
        return addDateField(date, Calendar.MONTH, months);
    }

    /**
     * 方法说明 : 传入时间，增加指定天数，返回得到的新时间对象
     *
     * @param date 时间对象
     * @param days 增加值
     *             Author lihao [lihao@sinosoft.com.cn]
     *             Date 2017/8/3
     */
    public static Date addDay(Date date, int days) {
        return addDateField(date, Calendar.DATE, days);
    }

    /**
     * 方法说明 : 比较两个时间是否相等，允许空值，两者都为空视为相等
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static boolean equals(Date date1, Date date2) {
        if (date1 == null) {
            return date2 == null;
        }
        return date1.compareTo(date2) == 0;
    }

    /**
     * 方法说明 : 判断 date1 是否在 date2 之后，空视为无穷大
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static boolean after(Date date1, Date date2) {
        if (date1 == null) {
            return date2 != null;
        }
        return date2 != null && date1.after(date2);
    }

    /**
     * 方法说明 : 判断 date1 是否在 date2 之前，空视为无穷大
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static boolean before(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        return date2 == null || date1.before(date2);
    }

    /**
     * 方法说明 : 计算两个日期之间的天数，无视时分秒及毫秒
     *
     * @param date1 开始时间，不可为空
     * @param date2 结束时间，不可为空
     *              Author lihao [lihao@sinosoft.com.cn]
     *              Date 2017/8/3
     */
    public int calDateSpace(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar1.clear(Calendar.MILLISECOND);
        calendar1.clear(Calendar.SECOND);
        calendar1.clear(Calendar.MINUTE);
        calendar1.clear(Calendar.HOUR_OF_DAY);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        calendar2.clear(Calendar.MILLISECOND);
        calendar2.clear(Calendar.SECOND);
        calendar2.clear(Calendar.MINUTE);
        calendar2.clear(Calendar.HOUR_OF_DAY);
        long time1 = calendar1.getTime().getTime();
        long time2 = calendar2.getTime().getTime();
        return Long.valueOf((time2 - time1) / (24 * 3600 * 1000)).intValue();
    }

    /**
     * 方法说明 : 计算两个日期之间的天数，不足1个月按0个月计算
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public int calMonthSpace(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        boolean flip = false; // 是否翻转记录两个日期，如果 date1 晚于 date2，反转记录，最终返回结果乘 -1
        if (date1.after(date2)) {
            calendar1.setTime(date2);
            calendar2.setTime(date1);
            flip = true;
        } else {
            calendar1.setTime(date1);
            calendar2.setTime(date2);
        }
        // 清除时分秒及毫秒，并将日期置为1号
        calendar1.clear(Calendar.MILLISECOND);
        calendar1.clear(Calendar.SECOND);
        calendar1.clear(Calendar.MINUTE);
        calendar1.clear(Calendar.HOUR_OF_DAY);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.clear(Calendar.MILLISECOND);
        calendar2.clear(Calendar.SECOND);
        calendar2.clear(Calendar.MINUTE);
        calendar2.clear(Calendar.HOUR_OF_DAY);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);

        int elapsed = 0; // 记录月数
        while (calendar1.before(calendar2)) {
            calendar1.add(Calendar.MONTH, 1);
            elapsed++;
        }
        return flip ? elapsed * -1 : elapsed;
    }

    /**
     * 方法说明 : 判断输入年份是否为闰年
     * <p>
     * Author lihao [lihao@sinosoft.com.cn]
     * Date 2017/8/3
     */
    public static boolean leapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

}
