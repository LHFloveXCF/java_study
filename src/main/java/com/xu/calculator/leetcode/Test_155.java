package com.xu.calculator.leetcode;

import java.util.Arrays;

/**
 * java_study
 * https://leetcode-cn.com/problems/min-stack/
 */
public class Test_155 {

    public class MinStack {
        int[] elements;
        int elementsCount;
        int size;
        int min;

        public MinStack() {
            size = 10;
            elementsCount = 0;
            elements = new int[size];
            min = 0;
        }

        public void push(int val) {
            if (elementsCount >= size) {
                size += 10;
            }
            elements = Arrays.copyOf(elements, size);
            if (elementsCount == 0) {
                elements[elementsCount] = 0;
            } else {
                int compare = val - min;
                elements[elementsCount] = compare;
            }
            elementsCount++;
            min = Math.min(val, min);
        }

        public void pop() {
            int val = elements[elementsCount - 1];
            if (val < 0) {
                min -= val;
            }
            elementsCount--;
        }

        public int top() {
            return elements[elementsCount - 1] + min;
        }

        public int getMin() {
            return min;
        }
    }

    public class MinStack1 {
        int[] elements;
        int elementsCount;
        int size;
        int min;
        int[] help;

        public MinStack1() {
            size = 10;
            min = 0;
            elementsCount = 0;
            elements = new int[size];
            help = new int[size];
        }

        public void push(int val) {
            min = Math.min(val, min);
            if (elementsCount >= size) {
                size += 10;
            }
            elements = Arrays.copyOf(elements, size);
            help = Arrays.copyOf(help, size);
            elements[elementsCount] = val;
            if (elementsCount != 0) {
                int top = help[elementsCount - 1];
                help[elementsCount] = Math.min(top, val);
            } else {
                help[elementsCount] = val;
            }
            elementsCount++;
        }

        public void pop() {
            elementsCount--;
        }

        public int top() {
            return elements[elementsCount - 1];
        }

        public int getMin() {
            return help[elementsCount - 1];
        }
    }
}
