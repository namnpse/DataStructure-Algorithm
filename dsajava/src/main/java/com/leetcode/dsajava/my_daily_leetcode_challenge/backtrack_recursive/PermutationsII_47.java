package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII_47 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList)); // add a copy
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && used[i - 1])) continue; // avoid duplicate
            used[i] = true;
            tempList.add(nums[i]); // try
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1); // rollback
        }
    }
}
