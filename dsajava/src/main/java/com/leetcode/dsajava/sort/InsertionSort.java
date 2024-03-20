package com.leetcode.dsajava.sort;

import com.leetcode.dsajava.array.ArrayUtil;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] myArray = {4, 2, 6, 5, 1, 3};

        insertionSort(myArray);

        System.out.println( Arrays.toString(myArray) );
        ArrayUtil.print(myArray);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */
    }


    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    ArrayUtil.swap(arr, j, j-1);
                    System.out.println("i: "+ i + " " + j);
                    System.out.println( Arrays.toString(arr) );
                }
            }
        }
    }
}
