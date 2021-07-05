package com.xu.calculator.l_06.lesson14;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * java_study
 * 宽度优先遍历
 * BFS
 */
public class GraphLevelTraversal {
    /**
     * 给定一个节点，根据宽度优先去遍历
     * @param root
     */
    public static void levelTraversal(Point root) {
        if (null == root) {
            return;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(root);
        HashSet<Point> set = new HashSet<>();
        set.add(root);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            System.out.println(point.value);
            for (Point next : point.next) {
                if (set.contains(next)) {
                    continue;
                }
                queue.add(next);
                set.add(next);
            }
        }
    }

}
