package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Tree;

import java.util.Stack;

public class LowestCommonAncestor_29 {

    // Section 29: lowest common ancestor
    // C1:
    public static Tree lowestCommonAncestor(Tree root, int num1, int num2) {
        // your code here
        Stack<Tree> stack1 = new Stack<>();
        Stack<Tree> stack2 = new Stack<>();
        findPathToNode(root, num1, stack1);
        findPathToNode(root, num2, stack2);

        while (stack1.size() != stack2.size()) {
            if (stack1.size() > stack2.size()) {
                stack1.pop();
            } else stack2.pop();
        }
        while (!stack1.isEmpty()) { // stack1 and stack2 have the same size and pop together -> need to check stack1.isEmpty()
            if (stack1.peek() == stack2.peek()) return stack1.peek(); // or stack2.peek(), same
            stack1.pop();
            stack2.pop();
        }
        return root;
    }

    private static boolean findPathToNode(Tree root, int num, Stack<Tree> path) {
        if (root == null) return false;
        path.add(root);
        if (root.data == num) return true;
        boolean hasPathInLeft = findPathToNode(root.left, num, path);
        boolean hasPathInRight = findPathToNode(root.right, num, path);
        if (hasPathInLeft || hasPathInRight) return true;
        path.pop();
        return false;
    }

    // C2:
    public static Tree lowestCommonAncestor2(Tree root, int num1, int num2) {
        if (root == null) return null;
        if (root.data == num1 || root.data == num2) return root;
        Tree leftLCA = lowestCommonAncestor(root.left, num1, num2);
        Tree rightLCA = lowestCommonAncestor(root.right, num1, num2);
        if (leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
