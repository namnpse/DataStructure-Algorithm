package com.leetcode.dsajava.my_daily_leetcode_challenge.array;

import java.util.Arrays;

public class DuplicateZeroes_1089 {

    public static void main(String[] args) {
/*        Input: arr = [1,0,2,3,0,4,5,0]
        Output: [1,0,0,2,3,0,0,4]
        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]*/
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
//        int[] arr = {1, 9, 0, 0, 0, 4, 5, 0};
//        int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
//        int[] arr = {1, 5, 2, 0, 6, 8, 0, 6, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        if (arr.length < 2) return;
        int count = 0;
        int n = arr.length;
        int i = 0;
        for (; i < n; i++) {
            if (arr[i] == 0) count++;
            if(i + count >= n - 1)  break;
        }
//        System.out.println("count: " + count +" i: "+i);
        int j = n - 1;
        if (arr[i] == 0 && i + count > n - 1) {
            arr[j] = arr[i];
            j--;
            i--;
            count--;
        }
        for (; i >= 0 && count > 0; i--) {
            if (arr[i] == 0) {
                arr[j] = 0;
                arr[j-1] = 0;
                j -= 2;
                count--;
            } else {
                arr[i + count] = arr[i];
                j--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
