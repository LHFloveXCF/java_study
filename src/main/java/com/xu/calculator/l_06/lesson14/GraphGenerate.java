package com.xu.calculator.l_06.lesson14;

/**
 * java_study
 * 图表生成器
 */
public class GraphGenerate {
    /**
     * 给定一个 N * 3的矩阵，让你生成一个图
     * 【from, to, weight】
     * .....
     * @param matrix
     * @return
     */
    public static Graph generateGraph(int[][] matrix) {
        if (null == matrix) {
            return null;
        }
        Graph graph = new Graph();
        for (int  i = 0; i<matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int weight = matrix[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Point(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(from, new Point(to));
            }
            Point fromPoint = graph.nodes.get(from);
            Point toPoint = graph.nodes.get(to);
            EdgeLine edgeLine = new EdgeLine(weight, from, to);
            fromPoint.next.add(toPoint);
            fromPoint.in++;
            fromPoint.out++;
            fromPoint.edge.add(edgeLine);
            graph.edge.add(edgeLine);
        }
        return graph;
    }
}
