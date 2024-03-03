package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

public class FindMinimumInRotatedSortedArray_153 {

    public static void main(String[] args) {

    }

    // C1: O(n)
    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // C2: O(logn)
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right])
            return nums[left]; // base case, nums is already sorted, no rotated
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid + 1] < nums[mid]) return nums[mid + 1];
            else if (nums[mid - 1] > nums[mid]) return nums[mid - 1];
            else if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left]; // or nums[right] since left = right
    }
}
