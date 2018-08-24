package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSolver {

    private final List<String> values;
    private final List<String> colors;
    private final List<EdgeKeyPair> edges = new ArrayList<>();

    public TreeSolver(int numberOfNodes, String valuesInput, String colorsInput, List<String> edgesInput) {
        values = Arrays.asList(valuesInput.split(" "));
        colors = Arrays.asList(colorsInput.split(" "));

        for (String node : edgesInput) {
            List<String> keyValuePair = Arrays.asList(node.split(" "));
            edges.add(new EdgeKeyPair(Integer.valueOf(keyValuePair.get(0)), keyValuePair.get(1)));
        }
    }

    public Tree build() {
        throw new UnsupportedOperationException();
    }

    private class EdgeKeyPair {
        int key;
        String value;

        public EdgeKeyPair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

}
