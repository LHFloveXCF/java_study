package com.xu.calculator.test.I_07;

/**
 * java_study
 * 基本数据类型的封装类：Integer,Long,Byte,Short，java为了提高效率设置了一个缓存，范围是【-128-127】
 * 超过了这个区间，才会去重新创建对象
 */
public class CSDN {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;
        Integer c = 500;
        Integer d = 500;

        Long f = 400L;
        Long g = 400L;

        Short h = 5;
        Short i = 5;

        Byte j = 4;
        Byte k = 4;
        // byte short int long double float char boolean

        System.out.println(j == k);
        System.out.println(h == i);
        System.out.println(f == g);
        System.out.println(a == b);
        System.out.println(c == d);
    }
}
