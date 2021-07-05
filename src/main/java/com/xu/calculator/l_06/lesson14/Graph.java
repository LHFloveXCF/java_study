package com.xu.calculator.l_06.lesson14;

import java.util.HashMap;
import java.util.HashSet;

/**
 * java_study
 */
public class Graph {
    public HashMap<Integer, Point> nodes;
    public HashSet<EdgeLine> edge;

    public Graph() {
        edge = new HashSet<>();
        nodes = new HashMap<>();
    }
}
