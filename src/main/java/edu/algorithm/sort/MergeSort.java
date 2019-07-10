package edu.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] array) {
        // Recursion stop condition
        int n = array.length;
        if (n <= 1)
            return;

        // Split original array into 2 subarrays
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // recursive call to sort both left and right subarrays
        sort(left);
        sort(right);

        // merge both sorted subarrays to single sorted array
        merge(array, left, right);
    }

    private void merge(int[] merged, int[] sorted1, int[] sorted2) {
        // sizes of sorted arrays
        int n1 = sorted1.length;
        int n2 = sorted2.length;

        // indexes for each array
        int mergedIdx = 0, i1 = 0, i2 = 0;

        // merge both sorted arrays to single one
        while (i1 < n1 && i2 < n2) {
            if (sorted1[i1] <= (sorted2[i2])) {
                merged[mergedIdx++] = sorted1[i1++];
            } else {
                merged[mergedIdx++] = sorted2[i2++];
            }
        }

        // merge the last elements from sorted arrays
        while (i1 < n1) {
            merged[mergedIdx++] = sorted1[i1++];
        }

        while (i2 < n2) {
            merged[mergedIdx++] = sorted2[i2++];
        }
    }
}
