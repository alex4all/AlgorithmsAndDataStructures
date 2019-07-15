package edu.problems;

public class MaxSubArrayProblemLinear {

    public MaxSubArrayProblem.Segment process(int[] array) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            maxEndingHere += array[i];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                begin = i + 1;
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        return new MaxSubArrayProblem.Segment(begin, end, maxSoFar);
    }
}
