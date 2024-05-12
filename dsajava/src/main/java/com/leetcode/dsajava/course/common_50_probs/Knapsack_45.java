package com.leetcode.dsajava.course.common_50_probs;

import java.util.HashMap;
import java.util.Map;

public class Knapsack_45 {

    public static void main(String[] args) {

    }

    // Section 45
    // C1:
    // Time: O(2^n), Space: O(n)
    public int knapsack(int[] values, int[] weights, int maxWeight) {
        Map<String, Integer> memoiz = new HashMap<>();
        return knapsack(values, weights, maxWeight, 0, memoiz);
    }

    // C2: using memorization
    // Time: O(n*maxWeight), Space: O(n*maxWeight)
    public int knapsack(int[] values, int[] weights, int maxWeight, int i, Map<String, Integer> memoiz) {

        if (i == values.length) return 0;
        String key = maxWeight +
                " "
                + (i + 1);
        if (memoiz.get(key) != null) return memoiz.get(key);
        if (weights[i] > maxWeight) { // exceed remain weight
            int value = knapsack(values, weights, maxWeight, i + 1, memoiz);
            memoiz.put(key, value);
            return value;
        }
        int max = Math.max(
                        values[i] + knapsack(values, weights, maxWeight - weights[i], i + 1, memoiz),
                        knapsack(values, weights, maxWeight, i + 1, memoiz)
                );
        memoiz.put(key, max);
        return max;
    }
}
