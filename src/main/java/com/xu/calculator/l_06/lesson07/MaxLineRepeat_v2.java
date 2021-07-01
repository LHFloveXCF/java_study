package com.xu.calculator.l_06.lesson07;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * java_study
 * 最大线段重合问题 version 2.0
 */
public class MaxLineRepeat_v2 {

    public static void main(String[] args) {
        findMax();
    }

    public static void findMax() {
        List<MaxLineRepeat_v1.Line> result = MaxLineRepeat_v1.generateList(10);
        Collections.sort(result);
        result.forEach(line -> System.out.println(ToStringBuilder.reflectionToString(line)));
        int max = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(result.get(0).end);
        for (int i=1; i<result.size(); i++) {
            while (!queue.isEmpty()) {
                if (result.get(i).start >= queue.peek()) {
                    queue.poll();
                } else {
                    break;
                }
            }
            queue.add(result.get(i).end);
            max = Math.max(max, queue.size());
        }
        System.out.println(max);
    }

}
