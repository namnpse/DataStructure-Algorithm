package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

import java.util.Arrays;

public class FindPeekElement_162 {

    public static void main(String[] args) {

    }

    public static int findPeakElement(int[] nums) {
        return -1;
    }

    // C1: O(N)
    public static int findPeak(int[] arr) {
        //your code here
        int n = arr.length;
        if (n == 1) return 0;
        for (int i = 0; i <= n - 1; i++) {
            if (isGreaterLeft(i, arr, n) && isGreaterRight(i, arr, n)) return i;
        }
        System.out.println(Arrays.toString(arr));
        return -1;
    }

    private static boolean isGreaterLeft(int index, int[] arr, int n) {
        if (index == 0) return true;
        return arr[index - 1] <= arr[index];
    }

    private static boolean isGreaterRight(int index, int[] arr, int n) {
        if (index == n - 1) return true;
        return arr[index] >= arr[index + 1];
    }

    // C2: O(logN)
    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if(n == 2) return nums[0] > nums[1] ? 0 : 1;
        int left = 0;
        int right = n - 1;
        int mid;
        while(left < right) {
            mid = (left + right)/2;
            if(nums[mid] < nums[mid+1]) {
                left = mid + 1; // because nums[mid] < nums[mid+1] -> mid is not peek, so start from mid + 1
            }else {
                right = mid; // nums[mid] >= nums[mid+1] -> mid could be peak -> so end at mid
            }
        }
        // left meets right (left == right), that means there is only 1 element -> that's the peak
        return left; // left == right, either return left or right is ok
    }
}
