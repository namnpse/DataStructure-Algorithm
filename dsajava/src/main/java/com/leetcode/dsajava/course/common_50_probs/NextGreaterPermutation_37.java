package com.leetcode.dsajava.course.common_50_probs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextGreaterPermutation_37 {

    public static void main(String[] args) {

    }

    // By always getting the next permutation:
    // Time complexity: O(n.n!)
    // Space complexity: O(n.n!)
    static ArrayList<Integer> getNextGreaterPermutation(ArrayList<Integer> arr) {
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) i--;
        if (i == -1) return arr;
        int j = arr.size() - 1;
        while (arr.get(j) <= arr.get(i)) j--;
        Collections.swap(arr, i, j);
        int left = i + 1;
        int right = arr.size() - 1;
        while (left < right) {
            Collections.swap(arr, left++, right--);
        }
        return arr;
    }

    static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> arr) {
        if (arr.size() < 2) return new ArrayList<ArrayList<Integer>>(Arrays.asList(arr));
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        permutations.add((ArrayList<Integer>) arr.clone());
        ArrayList<Integer> greatestPermutation = (ArrayList<Integer>) arr.clone();
        Collections.reverse(greatestPermutation);
        while (!arr.equals(greatestPermutation)) {
            arr = getNextGreaterPermutation(arr);
            permutations.add((ArrayList<Integer>) arr.clone());
        }
        return permutations;
    }
}
