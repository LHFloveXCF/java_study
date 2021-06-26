package com.xu.calculator.l_06;

import org.apache.commons.lang3.builder.ToStringBuilder;
import sun.applet.Main;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * java_study
 */
public class ReverseNode {
    class Node{
        int num;
        Node next;
        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Map<Long, Long> map = new HashMap<>();
        map.put(1L, 123L);


        map.merge(1L, 0L, (e, f) -> Instant.now().toEpochMilli());
        System.out.println(ToStringBuilder.reflectionToString(map.get(1)));
    }
}
