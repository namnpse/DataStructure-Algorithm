package com.leetcode.dsajava.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairs {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.putIfAbsent(arr1[i], i);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(target - arr2[i])) {
                res.add(new int[]{target - arr2[i], arr2[i]});
            }
        }
        return res;
    }
}
