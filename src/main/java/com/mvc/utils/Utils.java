package com.mvc.utils;


import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * Created by yeguoxing on 2018/1/23.
 */
public class Utils {


    /**
     * 获取异常栈详情
     * @param e
     * @return
     */
    public static String getExceptionTrace(Exception e) {
        String print = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintWriter wrt = new PrintWriter(bout);
        e.printStackTrace(wrt);
        wrt.close();
        print = bout.toString();
        return print;
    }

    /**
     * 判断是否为null
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj){
        return obj != null;
    }
}
