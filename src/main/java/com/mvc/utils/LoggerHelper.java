package com.mvc.utils;

import org.slf4j.LoggerFactory;

public class LoggerHelper {
    /**
     * 添加错误日志记录
     *
     * @param errorinfo
     */
    public static void error(String errorinfo) {
        LoggerFactory.getLogger("errorLogger").error(errorinfo);
    }
    /**
     * 判断对象是否为null
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /**
     * 判断对象是否为非null 非空
     *
     * @param obj
     * @return
     */
    public static boolean isNotNullAndEmpty(Object obj) {
        return obj != null && obj.toString().trim().length() > 0;
    }

}
