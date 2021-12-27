package com.leetcode;

import java.util.*;

/**
 * java_study
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号数
 */
public class Test_20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length % 2 != 0) {
            return false;
        }
        Map<Character, Character> right = new HashMap<>();
        right.put(')', '(');
        right.put('}', '{');
        right.put(']', '[');
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < length) {
            char ch = chars[index++];
            if (right.containsKey(ch)) {
                if (stack.isEmpty() || !right.get(ch).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // System.out.println(new Test_20().isValid("([)]"));
        System.out.println(new Test_20().isValid("()[]{}"));

    }
}
