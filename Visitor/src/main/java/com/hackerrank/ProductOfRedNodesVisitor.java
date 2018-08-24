package com.hackerrank;

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        // Return the product of values stored in all red nodes, including leaves, computed modulo 10^9 + 7.
        // Note that the product of zero values is equal to 1.
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        // Implement the logic responsible for visiting the tree's non-leaf nodes such
        // that the getResult method returns the correct result for the ProductOfRedNodesVisitor.
        if(node.getColor().equals(Color.RED)) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        // Implement the logic responsible for visiting the tree's leaf nodes such
        // that the getResult method returns the correct result for the ProductOfRedNodesVisitor class.
        if(leaf.getColor().equals(Color.RED)) {
            result = (result * leaf.getValue()) % M;
        }
    }
}