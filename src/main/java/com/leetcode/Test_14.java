package com.leetcode;

/**
 * java_study
 * https://leetcode-cn.com/problems/longest-common-prefix/\
 * 最长公共前缀
 */
public class Test_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        char[] first = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        out: for (int i = 0; i < first.length; i++) {
            char basic = first[i];
            for (int j=1; j<strs.length; j++) {
                char[] resource = strs[j].toCharArray();
                if (i >= resource.length || basic - 'a' != resource[i] - 'a') {
                    break out;
                }
            }
            sb.append(basic);
        }
        return sb.toString();
    }
}
