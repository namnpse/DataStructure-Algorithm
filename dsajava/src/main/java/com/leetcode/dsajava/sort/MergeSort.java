package com.leetcode.dsajava.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] a1, int[] a2) {
        int m = a1.length;
        int n = a2.length;
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if(a1[i] < a2[j]) {
                res[k++] = a1[i];
                i++;
            }else {
                res[k++] = a2[j];
                j++;
            }
        }

        while (i < m) res[k++] = a1[i++];
        while (j < n) res[k++] = a2[j++];
        return res;
    }

    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] a1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] a2 = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(a1, a2);
    }

    public static void main(String[] args) {
        /*int[] array1 = {1, 3, 7, 8};
        int[] array2 = {2, 4, 5, 6};

        System.out.println(Arrays.toString(merge(array1, array2)));

        *//*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8]

         */
        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

    }
}
