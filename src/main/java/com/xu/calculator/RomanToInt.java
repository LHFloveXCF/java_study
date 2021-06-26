package com.xu.calculator;

/**
 * java_study
 */
public class RomanToInt {
    public static int romanToInt(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if (romanToInt(s.charAt(i)) == -1) {
//                return -1;
//            }
//        }
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int now = romanToInt(s.charAt(i));
            if (i < s.length() - 1) {
                int next = romanToInt(s.charAt(i + 1));
                if (now == 1) {
                    if (next == 5 || next == 10) {
                        total += (next - now);
                        i++;
                        continue;
                    }
                } else if (now == 10) {
                    if (next == 50 || next == 100) {
                        total += (next - now);
                        i++;
                        continue;
                    }
                } else if (now == 100) {
                    if (next == 500 || next == 1000) {
                        total += (next - now);
                        i++;
                        continue;
                    }
                } else {
                    total += now;
                    continue;
                }
            }
            total += now;
        }
        return total;
    }

    public static int romanToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

    public static void main(String[] args) {
        int roman = romanToInt("DCXXI");
        System.out.println(roman);
    }
}
