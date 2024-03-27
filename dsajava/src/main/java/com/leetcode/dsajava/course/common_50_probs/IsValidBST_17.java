package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.my_daily_leetcode_challenge.tree.TreeNode;

public class IsValidBST_17 {

    // Section 17: validate binary search tree
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
}
