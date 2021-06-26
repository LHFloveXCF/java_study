package com.xu.calculator.l_06;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 */
public class Triangle_01 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> now = new ArrayList<>();
            if (i == 0) {
                now.add(1);
            } else {
                List<Integer> last = result.get(i - 1);
                for (int j=0; j<=i; j++) {
                    if (j == 0) {
                        now.add(last.get(j));
                    } else if (j < i) {
                        now.add(last.get(j - 1) + last.get(j));
                    } else {
                        now.add(last.get(j - 1));
                    }
                }
            }
            result.add(now);
        }
        return result;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
