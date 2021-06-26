package com.xu.calculator.l_06;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java_study
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public static int maxLen2(String string) {
        if (StringUtils.isEmpty(string)) {
            return 0;
        }
        int len = 1;
        Map<Character, List<Integer>> temp = new HashMap<>();
        for (int i=0; i<string.length(); i++) {
            List<Integer> list = temp.computeIfAbsent(string.charAt(i), k -> new ArrayList<>());
            list.add(i);
        }
        return len;
    }

    public static int maxLen(String string) {
        if (StringUtils.isEmpty(string)) {
            return 0;
        }
        int len = 1;
        for (int i=0; i<string.length(); i++) {
            List<Character> characterList = new ArrayList<>();
            for (int j=i; j<string.length(); j++) {
                if (characterList.contains(string.charAt(j))) {
                    len = Math.max(len, characterList.size());
                    break;
                }
                characterList.add(string.charAt(j));
            }
            len = Math.max(len, characterList.size());
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "pwwkew";

        System.out.println(maxLen(str));
    }
}
