package com.leetcode.dsajava.course.common_50_probs;

public class SubsetsThatSumUpToK_33 {

    // Section 33: subsets that sum up to K
    // Time: O(2^n), Space: O(n)
    public static int subsetsThatSumUpToK(int[] arr, int k) {
        return subsetsThatSumUpToK(arr, k, 0, 0);
    }

    private static int subsetsThatSumUpToK(int[] arr, int k, int i, int sum) {
        if (sum == k) return 1;
        else if (sum > k || i >= arr.length) return 0;
        else {
            return subsetsThatSumUpToK(arr, k, i + 1, sum + arr[i])
                    + subsetsThatSumUpToK(arr, k, i + 1, sum);
        }
    }
}
