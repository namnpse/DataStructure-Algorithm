package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

public class BinaryTreeMaximumPathSum_124 {

    int min = -1001;
    int max = min;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null)    return min;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int maxWithTop = Math.max(
                root.val,
                Math.max(
                        root.val + leftSum,
                        root.val + rightSum
                )
        );
        int maxNoTop = Math.max(
                maxWithTop,
                root.val + leftSum + rightSum
        );
        max = Math.max(max, maxNoTop);
        return maxWithTop;
    }
}
