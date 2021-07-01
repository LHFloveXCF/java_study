package com.xu.calculator.l_06.lesson07;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 */
public class MaxLineRepeat_v1 {

    public static void main(String[] args) {
        int len = 5;
        List<Line> result = generateList(len);
        result.forEach(line -> System.out.println(ToStringBuilder.reflectionToString(line)));
        System.out.println(searchMax(result));
    }

    public static List<Line> generateList(int len) {
        List<Line> result = new ArrayList<>();
        int range = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < len; i++) {
            int start = (int) (Math.random() * range) + 1;
            int end;
            do {
                end = (int) (Math.random() * range) + 1;
            } while (end == start);
            Line line = new Line(start, end);
            result.add(line);
        }
        return result;
    }

    /**
     * 查找线段最大重合数
     *
     * @param list
     * @return
     */
    public static int searchMax(List<Line> list) {
        if (null == list) {
            return -1;
        }
        if (list.size() < 2) {
            return 0;
        }
        int[] bound = findBound(list);
        int maxRepeat = 0;
        for (int i = bound[0]; i <= bound[1]; i++) {
            int curPointRepeat = 0;
            double middle = i + 0.5;
            for (Line line : list) {
                if (line.start < middle && line.end > middle)
                    curPointRepeat++;
            }
            maxRepeat = Math.max(maxRepeat, curPointRepeat);
        }
        return maxRepeat;
    }

    /**
     * 找到线段组的左右边界
     *
     * @param list
     * @return
     */
    public static int[] findBound(List<Line> list) {
        Line line = list.get(0);
        int minStart = line.start;
        int maxEnd = line.end;
        for (int i = 1; i < list.size(); i++) {
            Line cur_line = list.get(i);
            if (minStart > cur_line.start) {
                minStart = cur_line.start;
            }
            if (maxEnd < cur_line.end) {
                maxEnd = cur_line.end;
            }
        }
        return new int[]{minStart, maxEnd};
    }

    public static class Line implements Comparable<Line> {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }
}
