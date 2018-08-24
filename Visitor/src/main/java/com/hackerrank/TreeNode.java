package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public boolean isNode() {
        return true;
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public int size() {
        return children.size();
    }

    @Override
    public List<Tree> all() {
        return children;
    }
}
