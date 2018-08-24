package com.hackerrank;

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeavesSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        // Return the absolute difference between the sum of values stored in the tree's non-leaf
        // nodes at even depth and the sum of values stored in the tree's green leaf nodes.
        // Recall that zero is an even number.
        return Math.abs(evenDepthNonLeavesSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        // Implement the logic responsible for visiting the tree's non-leaf nodes such
        // that the getResult method returns the correct result for the FancyVisitor.
        if(node.getDepth() % 2 == 0)
            evenDepthNonLeavesSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        // Implement the logic responsible for visiting the tree's leaf nodes such
        // that the getResult method returns the correct result for the FancyVisitor class.
        if(leaf.getColor().equals(Color.GREEN))
            greenLeavesSum += leaf.getValue();
    }
}