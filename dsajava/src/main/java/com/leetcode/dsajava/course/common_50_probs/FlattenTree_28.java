package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Tree;

public class FlattenTree_28 {

    public static void main(String[] args) {

    }

    // Section 28:
    // C1:
    // Time: O(n^2), Space: O(h)
    public static void flattenTree(Tree root) {
        // your code here
        if (root == null) return;
        flattenTree(root.left);
        flattenTree(root.right);
        Tree rightTree = root.right;
        root.right = root.left;
        root.left = null;

        Tree temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = rightTree;
    }

    // C2: Time: O(n), Space: O(h)
    static Tree head = null;

    public static void flattenTree2(Tree root) {
        if (root == null) return;
        flattenTree(root.right);
        flattenTree(root.left);
        root.left = null;
        root.right = head;
        head = root;
    }
}
