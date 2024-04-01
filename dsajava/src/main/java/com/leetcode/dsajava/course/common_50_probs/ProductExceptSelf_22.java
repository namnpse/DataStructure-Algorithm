package com.leetcode.dsajava.course.common_50_probs;

public class ProductExceptSelf_22 {

    // Section 22: Product of an array except self
    public static int[] productExceptSelf(int[] arr) {
        // your code here
        int n = arr.length;
        int[] output = new int[n];
        int[] productLeft = new int[n];
        int[] productRight = new int[n];
        productLeft[0] = 1;
        for (int i = 1; i < n; i++) {
            productLeft[i] = productLeft[i - 1] * arr[i - 1];
        }
        productRight[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            productRight[i] = productRight[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = productLeft[i] * productRight[i];
        }

        return output;
    }
}
