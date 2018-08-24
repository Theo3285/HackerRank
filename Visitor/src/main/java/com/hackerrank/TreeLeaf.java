package com.hackerrank;

import java.util.List;

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }

    @Override
    public boolean isNode() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<Tree> all() {
        return null;
    }
}
