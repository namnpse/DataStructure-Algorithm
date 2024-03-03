package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] productLeft = new int[n];
        int[] productRight = new int[n];

        productLeft[0] = 1;
        for (int i = 1; i < n; i++) {
            productLeft[i] = productLeft[i-1] * nums[i-1];
        }
        productRight[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            productRight[i] = productRight[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = productLeft[i] * productRight[i];
        }

        return output;
    }
}
