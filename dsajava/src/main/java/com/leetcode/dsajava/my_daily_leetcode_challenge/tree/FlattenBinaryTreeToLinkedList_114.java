package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

public class FlattenBinaryTreeToLinkedList_114 {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode rightTree = root.right;
        root.right = root.left;
        TreeNode temp = root;
        while (temp.right != null) temp = temp.right;
        temp.right = rightTree;
    }
}
