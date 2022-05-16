package com.vika.way.pre.algorithm.leetcode.midium.S301_400;

import javafx.util.Pair;

import java.util.*;

public class S399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Double r = dfsQuery(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
            result[i] = r != null ? r : -1.0;
        }
        return result;
    }

    public Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double value = values[i];
            if (!graph.containsKey(x)) {
                graph.put(x, new HashMap<>());
            }
            graph.get(x).put(y, value);
            if (!graph.containsKey(y)) {
                graph.put(y, new HashMap<>());
            }
            graph.get(y).put(x, 1 / value);
        }
        return graph;
    }

    public Double dfsQuery(Map<String, Map<String, Double>> graph, String a, String b, Set<String> visited) {
        if (!graph.containsKey(a)) {
            return null;
        }
        Map<String, Double> adjMap = graph.get(a);
        if (adjMap.containsKey(b)) {
            return graph.get(a).get(b);
        }
        visited.add(a);
        for (String adj : adjMap.keySet()) {
            if (visited.contains(adj)) {
                continue;
            }
            Double r = dfsQuery(graph, adj, b, visited);
            if (r != null) {
                return adjMap.get(adj) * r;
            }
        }
        visited.remove(a);
        return null;
    }

    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Double r = bfsQuery(graph, queries.get(i).get(0), queries.get(i).get(1));
            result[i] = r != null ? r : -1.0;
        }
        return result;
    }

    public Double bfsQuery(Map<String, Map<String, Double>> graph, String a, String b) {
        if (!graph.containsKey(a)) {
            return null;
        }
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.add(new Pair<>(a, 1.0));
        Set<String> visited = new HashSet<>();
        visited.add(a);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Double> pair = queue.poll();
                if (b.equals(pair.getKey())) {
                    return pair.getValue();
                }
                Map<String, Double> adjMap = graph.get(pair.getKey());
                for (String adj : adjMap.keySet()) {
                    if (visited.contains(adj)) {
                        continue;
                    }
                    queue.add(new Pair<>(adj, pair.getValue() * adjMap.get(adj)));
                    visited.add(adj);
                }
            }
        }
        return null;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        Map<String, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (String node : graph.keySet()) {
            indexMap.put(node, index++);
        }
        Double[][] floydValues = floyd(graph, indexMap);
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (indexMap.containsKey(x) && indexMap.containsKey(y)) {
                Double f = floydValues[indexMap.get(x)][indexMap.get(y)];
                result[i] = f != null ? f : -1.0;
            } else {
                result[i] = -1.0;
            }
        }
        return result;
    }

    public Double[][] floyd(Map<String, Map<String, Double>> graph, Map<String, Integer> indexMap) {
        int n = graph.size();
        Double[][] values = new Double[n][n];
        for (String a : graph.keySet()) {
            for (String b : graph.get(a).keySet()) {
                values[indexMap.get(a)][indexMap.get(b)] = graph.get(a).get(b);
            }
        }
        for (int i = 0; i < n; i++) {
            values[i][i] = 1.0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (values[i][j] == null && values[i][k] != null && values[k][j] != null) {
                        values[i][j] = values[i][k] * values[k][j];
                    }
                }
            }
        }
        return values;
    }

    public static void main(String[] args) {
        S399EvaluateDivision solution = new S399EvaluateDivision();
        List<List<String>> listList = new ArrayList<>();
        listList.add(Arrays.asList("a", "b"));
        listList.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        double[] result = solution.calcEquation2(listList, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
