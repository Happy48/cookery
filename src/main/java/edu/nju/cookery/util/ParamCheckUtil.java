package edu.nju.cookery.util;

/**
 * 通用的请求参数检查工具
 */
public class ParamCheckUtil {

    /**
     * 判断字符串是否为空
     * @param str 需要判断的字符串
     * @return true字符串为空串 false是字符串合法
     */
    public static boolean judgeEmpty(String str){
        return str==null||"".equals(str);
    }
}
