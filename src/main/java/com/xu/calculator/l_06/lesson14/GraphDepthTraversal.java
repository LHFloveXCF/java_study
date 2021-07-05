package com.xu.calculator.l_06.lesson14;

import java.util.HashSet;
import java.util.Stack;

/**
 * java_study
 * 深度优先遍历
 * DFS
 */
public class GraphDepthTraversal {
    public static void depthTraversal (Point root) {
        if (null == root) {
            return;
        }

        Stack<Point> stack = new Stack<>();
        stack.push(root);
        HashSet<Point> set = new HashSet<>();
        set.add(root);
        System.out.println(root.value);
        while (!stack.isEmpty()) {
            Point cur = stack.pop();
            for (Point point : cur.next) {
                if (set.contains(point)) {
                    continue;
                }
                set.add(point);
                stack.push(point);
                stack.push(cur);
                System.out.println(point.value);
                break;
            }
        }
    }
}
