package org.example.proxy;

import java.util.regex.Pattern;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/7 22:17
 */
public class RegexTest {

    public static void main(String[] args) {
        String str = "class org.example.demo.service.impl.QueryServiceImpl";
        String regexStr1 = "class org.example.demo.service..*Service.*";
        String regexStr3 = "class org\\.example\\.demo\\.service\\..*Service.*";
        boolean result1 = Pattern.compile(regexStr1).matcher(str).matches();
        boolean result3 = Pattern.compile(regexStr3).matcher(str).matches();
        System.out.println(result1);
        System.out.println(result3);
    }
}
