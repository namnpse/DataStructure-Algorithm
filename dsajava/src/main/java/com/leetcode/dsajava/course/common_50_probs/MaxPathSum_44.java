package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Tree;

public class MaxPathSum_44 {

    public static void main(String[] args) {

    }

    // Section 44: Maximum path sum
    static int min = -1000 + 1; // tree.val in range (-1000, 1000)

    public static int maxPathSum(Tree root) {
        // your code here
        int[] max = new int[]{min};
        dfs(root, max);
        System.out.println("max: " + max[0]);
        return max[0];
    }

    private static int dfs(Tree root, int[] max) {
        if (root == null) return min;
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        int maxWithTop = Math.max(
                root.data,
                Math.max(
                        root.data + left,
                        root.data + right
                )
        );
        int maxNoTop = Math.max(
                maxWithTop,
                root.data + left + right
        );
        max[0] = Math.max(max[0], maxNoTop);
        return maxWithTop;
    }
}
