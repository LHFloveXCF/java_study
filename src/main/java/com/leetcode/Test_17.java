package com.leetcode;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java_study
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *  电话号码的字母组合
 */
public class Test_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (StringUtils.isEmpty(digits)) {
            return result;
        }

        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> list = map.computeIfAbsent('2', e -> new ArrayList<>());
        list.add('a');
        list.add('b');
        list.add('c');
        List<Character> list3 = map.computeIfAbsent('3', e -> new ArrayList<>());
        list3.add('d');
        list3.add('e');
        list3.add('f');
        List<Character> list4 = map.computeIfAbsent('4', e -> new ArrayList<>());
        list4.add('g');
        list4.add('h');
        list4.add('i');
        List<Character> list5 = map.computeIfAbsent('5', e -> new ArrayList<>());
        list5.add('j');
        list5.add('k');
        list5.add('l');
        List<Character> list6 = map.computeIfAbsent('6', e -> new ArrayList<>());
        list6.add('m');
        list6.add('n');
        list6.add('o');
        List<Character> list7 = map.computeIfAbsent('7', e -> new ArrayList<>());
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        List<Character> list8 = map.computeIfAbsent('8', e -> new ArrayList<>());
        list8.add('t');
        list8.add('u');
        list8.add('v');
        List<Character> list9 = map.computeIfAbsent('9', e -> new ArrayList<>());
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');

        char[] chars = digits.toCharArray();
        int length = chars.length;
        append(result, map, chars, length,0, new StringBuilder());

        return result;
    }

    private void append(List<String> result, Map<Character, List<Character>> map, char[] chars, int length, int index, StringBuilder sb) {
        if (index >= length) {
            result.add(sb.toString());
            return;
        }
        List<Character> list = map.get(chars[index]);
        for (Character character : list) {
            sb.append(character);
            append(result, map, chars, length, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test_17().letterCombinations("23"));
    }
}
