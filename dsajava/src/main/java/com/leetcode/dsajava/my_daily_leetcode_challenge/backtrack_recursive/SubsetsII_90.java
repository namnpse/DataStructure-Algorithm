package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

    public static void main(String[] args) {
        int[] nums = {3,3,2,1};
        List<List<Integer>> res = subsetsWithDup(nums);

        for (List<Integer> l: res) {
            for (Integer i : l) {
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1])   continue; // skip duplicate
            temp.add(nums[i]);
            backtrack(list, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
