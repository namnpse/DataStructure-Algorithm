package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

import java.util.Arrays;

public class NextPermutation_31 {

    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0){ // already sorted, greatest permutation, return first permutation
            reverseArray(0, nums);
            return;
        }
        int j = n - 1;
        while (nums[j] <= nums[i]) j--; // from right -> left, find a bigger one than nums[i]
        swap(i, j, nums);
        reverseArray(i+1, nums);
    }

    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void reverseArray(int i, int[] nums) { // reverse array from index i
        int l = i;
        int r = nums.length - 1;
        while (l < r) {
            swap(l, r, nums);
            l++; r--;
        }
    }
}
