package com.xu.calculator.l_06.lesson18;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 * 打印一个字符串的全部子序列
 */
public class SubStr {
    private static List<String> subStr1(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();
        String path = "";
        process(chars,0, ans, path);
        return ans;
    }

    private static void process(char[] chars, int index, List<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        process(chars, index + 1, ans, path);
        process(chars, index + 1, ans, path + String.valueOf(chars[index]));
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> result = subStr1(str);
        if (null != result) {
            result.forEach(System.out :: println);
        }
    }
}
