package edu.algorithm.matrix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MatrixMultiplicationTest {

    private static final int[][] A = {{1, 2, 3}, {4, 5, 6}};
    private static final int[][] B = {{7, 8}, {9, 10}, {11, 12}};

    private static final int[][] C = {{58, 64}, {139, 154}};

    @Test
    public void defMatrixAlgorithm() {
        MatrixMultiplication instance = new MatrixMultiplication();
        int[][] result = instance.multiplication(A, B);
        assertTrue(result[0][0] == C[0][0]);
        assertTrue(result[0][1] == C[0][1]);
        assertTrue(result[1][0] == C[1][0]);
        assertTrue(result[1][1] == C[1][1]);
    }
}
