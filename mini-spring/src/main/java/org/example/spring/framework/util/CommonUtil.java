package org.example.spring.framework.util;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/27 22:55
 */
public class CommonUtil {

    /**
     * 将字符串首字母转为小写
     *
     * @param str
     * @return
     */
    public static String toLowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        // 通过修改ASCII 编码表中对应的码值进行转换
        // 大小写码值相差32
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
