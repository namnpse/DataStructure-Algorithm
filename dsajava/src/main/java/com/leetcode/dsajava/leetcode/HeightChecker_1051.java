package com.leetcode.dsajava.leetcode;

import java.util.Arrays;

public class HeightChecker_1051 {

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int res = heightChecker(heights);
        System.out.println("RES: "+res);
    }

    public static int heightChecker(int[] heights) {
//        heights:  [1,1,4,2,1,3]
//        expected: [1,1,1,2,3,4]
        int res = 0;
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]) res++;
        }
        return res;
    }
}
