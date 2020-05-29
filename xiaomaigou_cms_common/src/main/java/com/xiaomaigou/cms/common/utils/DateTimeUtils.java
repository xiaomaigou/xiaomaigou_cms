package com.xiaomaigou.cms.common.utils;

import com.xiaomaigou.cms.common.constant.CommonConstant;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/29 23:39
 */
public class DateTimeUtils {
    /**
     * 毫秒格式化时间
     */
    public static final DateTimeFormatter MILLISECOND = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    /**
     * 获取当前标准格式化日期时间
     *
     * @return 当前标准格式化日期时间
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     *
     * @param date 标准格式化日期时间
     * @return 标准格式化日期时间
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(CommonConstant.DEFAULT_DATE_TIME_FORMAT)).format(date);
    }

    /**
     * 格式化的毫秒时间
     */
    public static String getMillisecond() {
        return LocalDateTime.now().format(MILLISECOND);
    }

}
