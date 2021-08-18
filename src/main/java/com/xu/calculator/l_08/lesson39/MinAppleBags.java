package com.xu.calculator.l_08.lesson39;

/**
 * java_study
 */
public class MinAppleBags {

    private static int forceSolution(int apple) {
        if (apple <= 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple >> 3;
        int rest = apple - (bag8 << 3);
        while (bag8 >= 0) {
            if (rest % 6 == 0) {
                return bag8 + rest / 6;
            } else {
                rest += 8;
                bag8--;
            }
        }
        return -1;
    }

    private static int minBagAwesome(int apple) {
        if (apple <= 0) {
            return -1;
        }

        if (apple < 18) {
            return forceSolution(apple);
        }
        int rest = apple - 18;
        return rest % 2 == 0 ? (rest / 8) + 3 : -1;
    }

    public static void main(String[] args) {
//        System.out.println(forceSolution(1));
//        System.out.println(forceSolution(8));
//        System.out.println(forceSolution(14));
        for (int i=0; i<200; i++) {
            System.out.println("apple " + i + " : " + minBagAwesome(i));
        }
    }
}
