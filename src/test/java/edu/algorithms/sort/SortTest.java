package edu.algorithms.sort;

import edu.algorithm.sort.InsertionSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SortTest {

    private static final int[][] INPUT = {
            {},
            {1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {5, 4, 6, 3, 7, 2, 8, 1, 9},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {-1, -2, -3, -4, -5, -6, -7, -8, -9, 0},
            {0, -1, -2, -3, -4, -5, -6, -7, -8, -9}};

    private static final int[][] EXPECTED_OUTPUT = {
            {},
            {1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0},
            {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0}};

    @Test
    public void insertionSortTest() {
        InsertionSort insertionSort = new InsertionSort();
        for (int i = 0; i < INPUT.length; i++) {
            int[] array = INPUT[i];
            insertionSort.sort(array);
            assertTrue(Arrays.equals(array, EXPECTED_OUTPUT[i]));
        }
    }
}
