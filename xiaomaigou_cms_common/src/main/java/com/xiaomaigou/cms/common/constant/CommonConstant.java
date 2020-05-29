package com.xiaomaigou.cms.common.constant;

import java.io.Serializable;

/**
 * 公共常量
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/29 23:35
 */
public class CommonConstant implements Serializable {

    private static final Long serialVersionUID = 1L;

    public static final String EMPTY_STRING = "";

    /**
     * 默认时间格式
     */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认时区
     */
    public static final String DEFAULT_TIME_ZONE = "GMT+8";

    public static final String APPLICATION_JSON = "application/json;charset=UTF-8";

    public static final String ENCODING_UTF_8 = "UTF-8";
}
