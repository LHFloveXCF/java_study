package com.xu.calculator.l_06.lesson18;

import java.util.Stack;

/**
 * java_study
 */
public class ReverseStack {
    // wrong method
    private static void f1(Stack<Integer> stack) {
        if (null == stack || stack.size() == 1) {
            return;
        }
        for (int i = 0; i < stack.size(); i++) {
            Integer pop = stack.pop();
            stack.push(pop);
        }
    }

    // 申请一个新的栈
    private static Stack<Integer> f2(Stack<Integer> stack) {
        if (null == stack || stack.size() == 1) {
            return stack;
        }
        Stack<Integer> result = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result.push(stack.pop());
        }
        return result;
    }

    /**
     * 申请一个新栈，然后递归实现
     * @param stack
     */
    private static void f3(Stack<Integer> stack) {
        if (null == stack || stack.size() == 1) {
            return;
        }
        Stack<Integer> help = new Stack<>();

    }

    // 不用额外的空间，只用递归来实现
    private static void f4(Stack<Integer> stack) {
        if (null == stack || stack.size() == 1) {
            return;
        }
        process(stack);
    }

    /**
     * 思路：获取栈底元素，并从栈中移除，然后上面的元素下沉，直至栈空，然后以此压栈；
     * @param stack
     */
    private static void process(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveStackBottom(stack);
        process(stack);
        stack.push(last);
    }

    private static int getAndRemoveStackBottom(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
           int last = getAndRemoveStackBottom(stack);
           stack.push(result);
           return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.toString());
        System.out.println("reverse ------");
//        f1(stack);
//        Stack<Integer> result = f2(stack);
//        System.out.println(result.toString());
        f4(stack);
        System.out.println(stack.toString());
    }
}
