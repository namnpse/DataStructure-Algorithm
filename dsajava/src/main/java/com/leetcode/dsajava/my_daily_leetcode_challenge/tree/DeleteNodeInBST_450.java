package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

public class DeleteNodeInBST_450 {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return null;
        else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // found
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode successorNode = findMinNodeOnTheRight(root.right);
            root.val = successorNode.val;
            root.right = deleteNode(root.right, successorNode.val);
        }
        return root;
    }

    private TreeNode findMinNodeOnTheRight(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null) temp = temp.left;
        return temp;
    }
}
