package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

import static com.leetcode.dsajava.array.ArrayUtil.asList;
import static com.leetcode.dsajava.array.ArrayUtil.reverse;
import static com.leetcode.dsajava.array.ArrayUtil.swap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations_46 {

    public static void main(String[] args) {

    }

    private static List<Integer> nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) { // already sorted, is the greatest permutation
            return asList(nums);
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(i+1, nums); // reverse from ith index

        return asList(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> permutations = new ArrayList<>();
        if (n < 2) {
            permutations.add(asList(nums));
            return permutations;
        }
        Arrays.sort(nums);
//        Collections.sort(asList(nums));
        permutations.add(asList(nums.clone()));

        int total = factorial(n);
        while (permutations.size() < total) {
            permutations.add(nextPermutation(nums));
        }
        return permutations;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // C2: backtrack
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    private static void backtrack(List<List<Integer>> permutations, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num); // try
            backtrack(permutations, tempList, nums);
            tempList.remove(tempList.size() - 1); // rollback
        }
    }
}
