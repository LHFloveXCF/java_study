package com.xu.calculator.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * java_study
 * https://leetcode-cn.com/problems/min-stack/
 */
public class Test_155 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    public static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
                help.push(val);
            } else {
                Integer min = help.peek();
                min = Math.min(min, val);
                help.push(min);
                stack.push(val);
            }
        }

        public void pop() {
            stack.pop();
            help.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return help.peek();
        }
    }


    // 会越界
    public static class MinStack3{
        Stack<Integer> stack = new Stack<>();
        int min;
        /** initialize your data structure here. */
        public MinStack3() {
            min = 0;
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                min = val;
                stack.push(0);
            } else {
                stack.push(val - min);
                min = Math.min(min, val);
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (pop < 0) {
                min = min - pop;
            }
        }

        public int top() {
            return stack.peek() + min;
        }

        public int getMin() {
            return min;
        }
    }


    // wrong method
    public class MinStack2 {
        int[] elements;
        int elementsCount;
        int size;
        int min;

        public MinStack2() {
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
