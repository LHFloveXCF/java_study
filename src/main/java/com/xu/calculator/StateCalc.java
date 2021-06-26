package com.xu.calculator;

/**
 * java_study
 */
public class StateCalc {
    public static void main(String[] args) {

        int a = 5 , b =3;

        int state = 270057476;
        int state2 = 0;

        for (int i=1; i<=32; i++) {
            if ((state & (1 << i)) > 0) {
                System.out.println(i);
            }
        }
        System.out.println("-------------------------");
        for (int i=1; i<=8; i++) {
            if ((state2 & (1 << i)) > 0) {
                System.out.println(i);
            }
        }
    }
}
