package com.leetcode;

/**
 * java_study
 */
public class Test_12 {

    public String intToRoman(int num) {
        String[][] roman = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(roman[3][num / 1000 % 10]);
        stringBuffer.append(roman[2][num / 100 % 10]);
        stringBuffer.append(roman[1][num / 10 % 10]);
        stringBuffer.append(roman[0][num % 10]);
        return stringBuffer.toString();
    }

    public String intToRoman1(int num) {
        String[][] roman = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };

        String result = "";
        result += roman[3][num / 1000 % 10];
        result += roman[2][num / 100 % 10];
        result += roman[1][num / 10 % 10];
        result += roman[0][num % 10];
        return result;
    }
}
