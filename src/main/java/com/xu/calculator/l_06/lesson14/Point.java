package com.xu.calculator.l_06.lesson14;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 */
public class Point {
    public int value;
    public int in;
    public int out;
    public List<Point> next;
    public List<EdgeLine> edge;

    public Point(int value) {
        this.value = value;
        next = new ArrayList<>();
        edge = new ArrayList<>();
        in = 0;
        out = 0;
    }
}
