package com.leetcode.dsajava.sort;

import com.leetcode.dsajava.array.ArrayUtil;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};

        bubbleSort(myArray);

//        System.out.println( Arrays.toString(myArray) );
        ArrayUtil.print(myArray);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */
    }


    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    ArrayUtil.swap(arr, i, j);
                }
            }
        }
    }
}
