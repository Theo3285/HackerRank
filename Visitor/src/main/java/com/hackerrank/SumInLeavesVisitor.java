package com.hackerrank;

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        // Return the sum of the values in the tree's leaves only.
        return result;
    }

    public void visitNode(TreeNode node) {
        // Implement the logic responsible for visiting the tree's non-leaf nodes such
        // that the getResult method returns the correct result for the SumInLeavesVisitor.
    }

    public void visitLeaf(TreeLeaf leaf) {
        // Implement the logic responsible for visiting the tree's leaf nodes such
        // that the getResult method returns the correct result for the SumInLeavesVisitor class.
        result += leaf.getValue();
    }
}