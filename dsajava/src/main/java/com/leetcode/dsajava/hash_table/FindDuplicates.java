package com.leetcode.dsajava.hash_table;

import java.util.ArrayList;
import java.util.HashMap;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3};
        ArrayList<Integer> res = findDuplicates(nums);
        for (Integer num : res) {
            System.out.print(num + " ");
        }

    }

    public static ArrayList<Integer> findDuplicates(int[] array) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : array) {
            Boolean value = map.get(num);
            if(value == null) {
                map.put(num, true);
                continue;
            }
            if(value) {
                res.add(num);
                map.put(num, false);
            }
        }
        return res;
    }

    // C2:
/*    public static ArrayList<Integer> findDuplicates(int[] nums) {

        // Create a new HashMap to store the count of occurrences
        // of each integer.
        Map<Integer, Integer> numCounts = new HashMap<>();

        // Loop through each integer in the input array and update
        // its count in the HashMap.
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        // Create a new ArrayList to store the duplicate integers.
        List<Integer> duplicates = new ArrayList<>();

        // Loop through each entry in the HashMap and check if the
        // count of occurrences is greater than 1.
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        // Return the ArrayList of duplicate integers.
        return duplicates;
    }*/

}
