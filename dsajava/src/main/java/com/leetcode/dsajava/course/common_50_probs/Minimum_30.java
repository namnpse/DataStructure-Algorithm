package com.leetcode.dsajava.course.common_50_probs;

public class Minimum_30 {

    // Section 30:
    public int minimum(int[] arr) {
        // your code here
        int l = 0, r = arr.length - 1;
        if (arr[l] < arr[r]) return arr[l];  // arr is already sorted

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid + 1] < arr[mid]) return arr[mid + 1];
            else if (arr[mid - 1] > arr[mid]) return arr[mid];
            else if (arr[mid] > arr[r]) l = mid + 1;
            else r = mid - 1;
        }
        return arr[l]; // (l = r)
    }
}
