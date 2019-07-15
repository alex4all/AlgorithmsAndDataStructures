package edu.algorithm.sort;

/**
 * Not recommended implementation of MergeSort..
 */
public class MergeSort2 {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
    }

    private void merge(int[] array, int begin, int mid, int end) {
        int n1 = mid - begin + 1;
        int n2 = end - mid;

        int[] left = new int[n1 + 1];
        System.arraycopy(array, begin, left, 0, mid - begin + 1);
        left[n1] = Integer.MAX_VALUE;

        int[] right = new int[n2 + 1];
        System.arraycopy(array, mid + 1, right, 0, end - mid);
        right[n2] = Integer.MAX_VALUE;

        // subarray indexes
        int l = 0, r = 0;
        for (int i = begin; i <= end; i++) {
            if (left[l] < right[r])
                array[i] = left[l++];
            else
                array[i] = right[r++];
        }
    }
}
