package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;

public class SubsetsThatSumUpToK_33 {

    // Section 33: subsets that sum up to K
    // C1: backtrack
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

    // C2: dp
    // Time: O(nk), Space: O(nk)
    public static int subsetsThatSumUpToK2(int[] arr, int k) {
        Map<String, Integer> memoization = new HashMap<>();
        return subsetsThatSumUpToK2(arr, k, 0, 0, memoization);
    }

    private static int subsetsThatSumUpToK2(int[] arr, int k, int i, int sum, Map<String, Integer> memoization) {
        String key = i + " " + sum;
        if (memoization.get(key) != null) return memoization.get(key);
        if (sum == k) return 1;
        else if (sum > k || i >= arr.length) return 0;
        else {
            int subsets = subsetsThatSumUpToK2(arr, k, i + 1, sum + arr[i], memoization)
                    + subsetsThatSumUpToK2(arr, k, i + 1, sum, memoization);
            memoization.put(key, subsets);
            return subsets;
        }
    }
}
