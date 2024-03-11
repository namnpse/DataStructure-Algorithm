package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

import java.util.Stack;

public class LowestCommonAncestorOfBinaryTree_236 {

    public static void main(String[] args) {

    }

    // C1:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        findPathToNode(root, p, stack1);
        findPathToNode(root, q, stack2);

        while (stack1.size() != stack2.size()) {
            if(stack1.size() > stack2.size()) stack1.pop();
            else stack2.pop();
        }
        while (!stack1.isEmpty()) {
            if(stack1.peek() == stack2.peek())    return stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return root;
    }

    private boolean findPathToNode(TreeNode root, TreeNode targetNode, Stack<TreeNode> path) {
        if(root == null)    return false;
        path.add(root);
        if(root == targetNode)  return true;
        boolean hasPathInLeft = findPathToNode(root.left, targetNode, path);
        boolean hasPathInRight = findPathToNode(root.right, targetNode, path);
        if(hasPathInLeft || hasPathInRight) return true;
        path.pop();
        return false;
    }

    // C2:
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;
        if(root.val == p.val || root.val == q.val)  return root;
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
