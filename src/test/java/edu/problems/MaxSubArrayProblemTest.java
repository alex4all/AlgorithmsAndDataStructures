package edu.problems;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MaxSubArrayProblemTest {

    private static final int[] ARRAY = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    private static final int[] ARRAY2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    @Test
    public void divideAndConquer() {
        MaxSubArrayProblem problem = new MaxSubArrayProblem();
        MaxSubArrayProblem.Segment result = problem.process(ARRAY);
        assertTrue(result.begin == 7);
        assertTrue(result.end == 10);
        assertTrue(result.sum == 43);
    }

    @Test
    public void divideAndConquer2() {
        MaxSubArrayProblem problem = new MaxSubArrayProblem();
        MaxSubArrayProblem.Segment result = problem.process(ARRAY2);
        assertTrue(result.begin == 3);
        assertTrue(result.end == 6);
        assertTrue(result.sum == 6);
    }

    @Test
    public void linearTime() {
        MaxSubArrayProblemLinear problem = new MaxSubArrayProblemLinear();
        MaxSubArrayProblem.Segment result = problem.process(ARRAY);
        assertTrue(result.begin == 7);
        assertTrue(result.end == 10);
        assertTrue(result.sum == 43);
    }

    @Test
    public void linearTime2() {
        MaxSubArrayProblemLinear problem = new MaxSubArrayProblemLinear();
        MaxSubArrayProblem.Segment result = problem.process(ARRAY2);
        assertTrue(result.begin == 3);
        assertTrue(result.end == 6);
        assertTrue(result.sum == 6);
    }
}
