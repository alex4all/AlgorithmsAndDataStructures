package edu.algorithm.sort;

public class InsertionSort {

    public void sort(int[] array) {
        // starting from second element
        for (int i = 1; i < array.length; i++) {
            // cache element
            int key = array[i];
            // position of last element in sorted part of array
            int j = i - 1;

            // going through sorted part of array to find out position to insert new value
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // insert value
            array[j + 1] = key;
        }
    }
}
