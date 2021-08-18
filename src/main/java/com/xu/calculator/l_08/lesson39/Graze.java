package com.xu.calculator.l_08.lesson39;

/**
 * java_study
 */
public class Graze {
    private static String forceEatGrass(int grass) {
        if (grass < 5) {
            return grass == 0 || grass == 2 ? "后手" : "先手";
        }

        int want = 1;
        while (want <= grass) {
            if (forceEatGrass(grass - want).equals("后手")) {
                return "先手";
            } else {
                if (grass / 4 > want) {
                    want *= 4;
                } else
                    break;;
            }
        }
        return "后手";
    }

    private static String eatAwesome(int grass) {
        // 后先后先先
        if (grass % 5 == 0 || grass % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }

    public static void main(String[] args) {
        int count = 50;
        for (int i = 0; i < count; i++) {
            System.out.println("i: "+ i + eatAwesome(i));
        }
    }
}
