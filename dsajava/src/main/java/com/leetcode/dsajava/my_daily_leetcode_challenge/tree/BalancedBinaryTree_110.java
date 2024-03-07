package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

public class BalancedBinaryTree_110 {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int height(TreeNode treeNode) {
        if(treeNode == null)    return -1;
        int leftHeight = height(treeNode.left);
        int rightHeight = height(treeNode.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
