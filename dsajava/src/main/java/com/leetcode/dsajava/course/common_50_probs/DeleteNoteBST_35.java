package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Tree;

public class DeleteNoteBST_35 {

    public Tree deleteNodeBst(Tree root, int num) {
        if (root == null) return null;
        else if (num < root.data) {
            root.left = deleteNodeBst(root.left, num);
        } else if (num > root.data) {
            root.right = deleteNodeBst(root.right, num);
        } else { // found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Tree successorNode = findMinNodeOnTheRight(root.right);
            root.data = successorNode.data;
            root.right = deleteNodeBst(root.right, successorNode.data);
        }
        return root;
    }

    private Tree findMinNodeOnTheRight(Tree root) {
        Tree temp = root;
        while (temp.left != null) temp = temp.left;
        return temp;
    }
}
