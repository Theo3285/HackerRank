package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.valueOf;

public class TreeBuilder {
    private final int count;
    private List<Integer> values = new ArrayList<>();
    private List<Color> colors = new ArrayList<>();
    private List<EdgeKeyPair> edges = new ArrayList<>();

    public TreeBuilder(int count) {
        this.count = count;
    }

    public static TreeBuilder some(int count) {
        return new TreeBuilder(count);
    }

    public TreeBuilder with(String values) {
        List<String> inputs = Arrays.asList(values.split(" "));
        for (String i : inputs) {
            this.values.add(Integer.valueOf(i));
        }
        return this;
    }

    public TreeBuilder paintedIn(String colors) {
        List<String> inputs = Arrays.asList(colors.split(" "));
        for (String input : inputs) {
            if ("0".equals(input)) {
                this.colors.add(Color.RED);
            } else if ("1".equals(input)) {
                this.colors.add(Color.GREEN);
            }
        }
        return this;
    }

    public TreeBuilder and(List<String> edges) {
        for (String input : edges) {
            List<String> keyValuePair = Arrays.asList(input.split(" "));
            EdgeKeyPair edge = new EdgeKeyPair(valueOf(keyValuePair.get(0)), Integer.valueOf(keyValuePair.get(1)));
            this.edges.add(edge);
        }
        return this;
    }

    public Tree build() {
        TreeNode root = new TreeNode(values.get(0), colors.get(0), 0);
        int index = 1;
        TreeNode currentTreeNode = root;
        for (EdgeKeyPair edge : edges) {
            if(isTreeNode(edge)){
                TreeNode newTreeNode = new TreeNode(values.get(index), colors.get(index), edge.getValue());
                currentTreeNode.addChild(newTreeNode);
                currentTreeNode = newTreeNode;
            } else {
                currentTreeNode.addChild(new TreeLeaf(values.get(index), colors.get(index), edge.getValue()));
            }
            index++;
        }
        return root;
    }

    private boolean isTreeNode(EdgeKeyPair edgeKeyPair) {
        int valueToExplore = edgeKeyPair.getValue();
        for (EdgeKeyPair edge : edges) {
            if (isNode(valueToExplore, edge)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNode(int valueToExplore, EdgeKeyPair edge) {
        return edge.getKey() == valueToExplore;
    }

    static class EdgeKeyPair {
        int key;
        int value;

        public EdgeKeyPair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
