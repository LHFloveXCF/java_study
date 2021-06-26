package com.xu.calculator.l_06;

/**
 * java_study
 */
public class StrStr2 {
    public int strStr(String haystack, String needle) {
        if ("".equalsIgnoreCase(haystack) && !"".equalsIgnoreCase(needle)) {
            return -1;
        }
        if ("".equalsIgnoreCase(haystack) && "".equalsIgnoreCase(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
