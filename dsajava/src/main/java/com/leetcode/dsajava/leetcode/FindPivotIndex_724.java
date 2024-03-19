package com.leetcode.dsajava.leetcode;

public class FindPivotIndex_724 {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println("RES: "+pivotIndex(nums));
    }

    // C1: O(n2)
/*    public static int pivotIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int sumLeft = 0;
            for (int l = 0; l < i; l++) {
                sumLeft+=nums[l];
            }
            int sumRight = 0;
            for (int r = i+1; r < nums.length; r++) {
                sumRight+= nums[r];
            }
            if(sumLeft == sumRight) return i;
        }
        return -1;
    }*/

    // C2: O(2n) = O(n)
    public static int pivotIndex(int[] nums) {

        int total = 0;
        for (int num : nums) total+=num;
        int sumLeft = 0;
        int sumRight;
        for (int i = 0; i < nums.length; i++) {
            sumLeft += (i > 0 ? nums[i-1] : 0);
            sumRight = total - nums[i] - sumLeft;
            if(sumLeft == sumRight) return i;
        }
        return -1;
    }
}
