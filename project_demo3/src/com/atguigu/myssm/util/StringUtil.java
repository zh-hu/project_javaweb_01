package com.atguigu.myssm.util;

/**
 * @author zhanghu
 * @create 2022-02-14 18:05
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        return str ==null || "".equals(str);
    }
    public static boolean isNotEmpty(String str){
        return  !isEmpty(str);
    }
}
