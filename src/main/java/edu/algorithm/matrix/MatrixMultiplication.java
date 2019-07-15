package edu.algorithm.matrix;

public class MatrixMultiplication {

    public int[][] multiplication(int[][] A, int[][] B) {
        if (A[0].length != B.length) {
            throw new IllegalArgumentException("Can't multiply matrix if A.n != B.m");
        }

        int[][] C = new int[A.length][B.length];

        int n = A[0].length;
        int m = B.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = sum + A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }
}
