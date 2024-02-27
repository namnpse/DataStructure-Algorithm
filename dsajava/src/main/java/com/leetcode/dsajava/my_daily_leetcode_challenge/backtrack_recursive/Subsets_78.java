package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        List<List<Integer>> res = subsets(nums);

        for (List<Integer> l: res) {
            for (Integer i : l) {
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void subsets(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsets(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

/*    the output if we didn't use sort will be :
    1
    2
    2 1
    3
    3 1
    3 2
    3 2 1

    but if we used sort it will be :
    1
    1 2
    1 2 3
    1 3
    2
    2 3
    3
    */
}
