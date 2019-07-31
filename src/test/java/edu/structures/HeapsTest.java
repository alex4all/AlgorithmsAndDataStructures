package edu.structures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeapsTest {

    private static final int[][] INPUT = {
            {},
            {1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {5, 4, 6, 3, 7, 2, 8, 1, 9},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {-1, -2, -3, -4, -5, -6, -7, -8, -9, 0},
            {0, -1, -2, -3, -4, -5, -6, -7, -8, -9}};

    private static final int[][] EXPECTED_OUTPUT = {
            {},
            {1},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0},
            {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0}};

    @Test
    public void priorityQueueTest() {
        for (int i = 0; i < INPUT.length; i++) {
            PriorityQueue queue = new PriorityQueue(INPUT[i].length);
            for (int element : INPUT[i]) {
                queue.add(element);
            }
            for (int element : EXPECTED_OUTPUT[i]) {
                int actual = queue.pool();
                assertTrue(element == actual);
            }
        }
    }


}
